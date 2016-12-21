package shuo.laoma.file.c57;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BinaryFileUtils {

	public static void copy(InputStream input, OutputStream output)
			throws IOException {
		byte[] buf = new byte[4096];
		int bytesRead = 0;
		while ((bytesRead = input.read(buf)) != -1) {
			output.write(buf, 0, bytesRead);
		}
	}

	public static byte[] readFileToByteArray(String fileName)
			throws IOException {
		InputStream input = new FileInputStream(fileName);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			copy(input, output);
			return output.toByteArray();
		} finally {
			input.close();
		}
	}

	public static void writeByteArrayToFile(String fileName, byte[] data)
			throws IOException {
		OutputStream output = new FileOutputStream(fileName);
		try {
			output.write(data);
		} finally {
			output.close();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
