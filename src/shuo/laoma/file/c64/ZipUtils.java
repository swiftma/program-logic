package shuo.laoma.file.c64;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtils {

	public static void copy(InputStream input, OutputStream output)
			throws IOException {
		byte[] buf = new byte[4096];
		int bytesRead = 0;
		while ((bytesRead = input.read(buf)) != -1) {
			output.write(buf, 0, bytesRead);
		}
	}
	
	public static void gzip(String fileName) throws IOException {
		InputStream in = null;
		String gzipFileName = fileName + ".gz";
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(fileName));
			out = new GZIPOutputStream(new BufferedOutputStream(
					new FileOutputStream(gzipFileName)));
			copy(in, out);
		} finally {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
		}
	}
	
	public static void gunzip(String gzipFileName, String unzipFileName)
			throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new GZIPInputStream(new BufferedInputStream(
					new FileInputStream(gzipFileName)));
			out = new BufferedOutputStream(new FileOutputStream(
					unzipFileName));
			copy(in, out);
		} finally {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
		}
	}
	
	private static void addFileToZipOut(File file, ZipOutputStream out,
			String rootPath) throws IOException {
		String relativePath = file.getCanonicalPath().substring(
				rootPath.length());
		if (file.isFile()) {
			out.putNextEntry(new ZipEntry(relativePath));
			InputStream in = new BufferedInputStream(new FileInputStream(file));
			try {
				copy(in, out);
			} finally {
				in.close();
			}
		} else {
			out.putNextEntry(new ZipEntry(relativePath + File.separator));
			for (File f : file.listFiles()) {
				addFileToZipOut(f, out, rootPath);
			}
		}
	}

	public static void zip(File inFile, File zipFile) throws IOException {
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(
				new FileOutputStream(zipFile)));
		try {
			if (!inFile.exists()) {
				throw new FileNotFoundException(inFile.getAbsolutePath());
			}
			inFile = inFile.getCanonicalFile();
			String rootPath = inFile.getParent();
			if (!rootPath.endsWith(File.separator)) {
				rootPath += File.separator;
			}
			addFileToZipOut(inFile, out, rootPath);
		} finally {
			out.close();
		}
	}
	
	private static void extractZipEntry(ZipEntry entry, ZipInputStream zin,
			String destDir) throws IOException {
		if (!entry.isDirectory()) {
			File parent = new File(destDir + entry.getName()).getParentFile();
			if (!parent.exists()) {
				parent.mkdirs();
			}
			OutputStream entryOut = new BufferedOutputStream(
					new FileOutputStream(destDir + entry.getName()));
			try {
				copy(zin, entryOut);
			} finally {
				entryOut.close();
			}
		} else {
			new File(destDir + entry.getName()).mkdirs();
		}
	}
	
	public static void unzip(File zipFile, String destDir) throws IOException {
		ZipInputStream zin = new ZipInputStream(new BufferedInputStream(
				new FileInputStream(zipFile)));
		if (!destDir.endsWith(File.separator)) {
			destDir += File.separator;
		}
		try {
			ZipEntry entry = zin.getNextEntry();
			while (entry != null) {
				extractZipEntry(entry, zin, destDir);
				entry = zin.getNextEntry();
			}
		} finally {
			zin.close();
		}
	}

}
