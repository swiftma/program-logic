package shuo.laoma.file.c58;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TextFileUtils {

	public static void copy(final Reader input, final Writer output)
			throws IOException {
		char[] buf = new char[4096];
		int charsRead = 0;
		while ((charsRead = input.read(buf)) != -1) {
			output.write(buf, 0, charsRead);
		}
	}

	public static String readFileToString(final String fileName,
			final String encoding) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(fileName), encoding));
			StringWriter writer = new StringWriter();
			copy(reader, writer);
			return writer.toString();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	public static void writeStringToFile(final String fileName,
			final String data, final String encoding) throws IOException {
		Writer writer = null;
		try {
			writer = new OutputStreamWriter(new FileOutputStream(fileName),
					encoding);
			writer.write(data);
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	public static void writeLines(final String fileName, final String encoding,
			final Collection<?> lines) throws IOException {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileName, encoding);
			for (Object line : lines) {
				writer.println(line);
			}
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	public static List<String> readLines(final String fileName,
			final String encoding) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(fileName), encoding));
			List<String> list = new ArrayList<>();
			String line = reader.readLine();
			while (line != null) {
				list.add(line);
				line = reader.readLine();
			}
			return list;
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
