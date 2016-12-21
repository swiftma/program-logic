package shuo.laoma.file.c57;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDemo {

	public static void writeStudents(List<Student> students) throws IOException {
		DataOutputStream output = new DataOutputStream(new FileOutputStream(
				"students.dat"));
		try {
			output.writeInt(students.size());
			for (Student s : students) {
				output.writeUTF(s.getName());
				output.writeInt(s.getAge());
				output.writeDouble(s.getScore());
			}
		} finally {
			output.close();
		}
	}

	public static List<Student> readStudents() throws IOException {
		DataInputStream input = new DataInputStream(new FileInputStream(
				"students.dat"));
		try {
			int size = input.readInt();
			List<Student> students = new ArrayList<Student>(size);
			for (int i = 0; i < size; i++) {
				Student s = new Student();
				s.setName(input.readUTF());
				s.setAge(input.readInt());
				s.setScore(input.readDouble());
				students.add(s);
			}
			return students;
		} finally {
			input.close();
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		List<Student> students = Arrays.asList(new Student[] {
				new Student("张三", 18, 80.9d), new Student("李四", 17, 67.5d) });

		writeStudents(students);

		List<Student> list = readStudents();
		System.out.println(list);

	}

}
