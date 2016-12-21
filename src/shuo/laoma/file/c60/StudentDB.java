package shuo.laoma.file.c60;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Map;

import shuo.laoma.file.c57.Student;

public class StudentDB {

	private static byte[] toBytes(Student student) throws IOException {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		DataOutputStream dout = new DataOutputStream(bout);
		dout.writeUTF(student.getName());
		dout.writeInt(student.getAge());
		dout.writeDouble(student.getScore());
		return bout.toByteArray();
	}

	public static void saveStudents(Map<String, Student> students)
			throws IOException {
		BasicDB db = new BasicDB("./", "students");
		for (Map.Entry<String, Student> kv : students.entrySet()) {
			db.put(kv.getKey(), toBytes(kv.getValue()));
		}
		db.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
