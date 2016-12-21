package shuo.laoma.file.c60;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class BasicDB {
	private static final int MAX_DATA_LENGTH = 1020;
	// 补白字节
	private static final byte[] ZERO_BYTES = new byte[MAX_DATA_LENGTH];
	// 数据文件后缀
	private static final String DATA_SUFFIX = ".data";
	// 元数据文件后缀，包括索引和空白空间数据
	private static final String META_SUFFIX = ".meta";

	// 索引信息，键->值在.data文件中的位置
	Map<String, Long> indexMap;
	// 空白空间，值为在.data文件中的位置
	Queue<Long> gaps;

	// 值数据文件
	RandomAccessFile db;
	// 元数据文件
	File metaFile;

	public BasicDB(String path, String name) throws IOException {
		File dataFile = new File(path + name + DATA_SUFFIX);
		metaFile = new File(path + name + META_SUFFIX);

		db = new RandomAccessFile(dataFile, "rw");

		if (metaFile.exists()) {
			loadMeta();
		} else {
			indexMap = new HashMap<>();
			gaps = new ArrayDeque<>();
		}
	}

	private void loadMeta() throws IOException {
		DataInputStream in = new DataInputStream(new BufferedInputStream(
				new FileInputStream(metaFile)));
		try {
			loadIndex(in);
			loadGaps(in);
		} finally {
			in.close();
		}
	}

	private void loadIndex(DataInputStream in) throws IOException {
		int size = in.readInt();
		indexMap = new HashMap<String, Long>((int) (size / 0.75f) + 1, 0.75f);
		for (int i = 0; i < size; i++) {
			String key = in.readUTF();
			long index = in.readLong();
			indexMap.put(key, index);
		}
	}

	private void saveIndex(DataOutputStream out) throws IOException {
		out.writeInt(indexMap.size());
		for (Map.Entry<String, Long> entry : indexMap.entrySet()) {
			out.writeUTF(entry.getKey());
			out.writeLong(entry.getValue());
		}
	}

	private void loadGaps(DataInputStream in) throws IOException {
		int size = in.readInt();
		gaps = new ArrayDeque<>(size);
		for (int i = 0; i < size; i++) {
			long index = in.readLong();
			gaps.add(index);
		}
	}

	private void saveGaps(DataOutputStream out) throws IOException {
		out.writeInt(gaps.size());
		for (Long pos : gaps) {
			out.writeLong(pos);
		}
	}

	private void saveMeta() throws IOException {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
				new FileOutputStream(metaFile)));
		try {
			saveIndex(out);
			saveGaps(out);
		} finally {
			out.close();
		}
	}

	private byte[] getData(long pos) throws IOException {
		db.seek(pos);
		int length = db.readInt();
		byte[] data = new byte[length];
		db.readFully(data);
		return data;
	}

	private void writeData(long pos, byte[] data) throws IOException {
		if (data.length > MAX_DATA_LENGTH) {
			throw new IllegalArgumentException("maximum allowed length is "
					+ MAX_DATA_LENGTH + ", data length is " + data.length);
		}
		db.seek(pos);
		db.writeInt(data.length);
		db.write(data);
		db.write(ZERO_BYTES, 0, MAX_DATA_LENGTH - data.length);
	}

	private long nextAvailablePos() throws IOException {
		if (!gaps.isEmpty()) {
			return gaps.poll();
		} else {
			return db.length();
		}
	}

	public void put(String key, byte[] value) throws IOException {
		Long index = indexMap.get(key);
		if (index == null) {
			index = nextAvailablePos();
			indexMap.put(key, index);
		}
		writeData(index, value);
	}

	public byte[] get(String key) throws IOException {
		Long index = indexMap.get(key);
		if (index != null) {
			return getData(index);
		}
		return null;
	}

	public void remove(String key) {
		Long index = indexMap.remove(key);
		if (index != null) {
			gaps.offer(index);
		}
	}

	public void flush() throws IOException {
		saveMeta();
		db.getFD().sync();
	}

	public void close() throws IOException {
		flush();
		db.close();
	}
}
