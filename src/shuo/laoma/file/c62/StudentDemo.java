package shuo.laoma.file.c62;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import shuo.laoma.file.c57.Student;

public class StudentDemo {

	public static void writeStudents(List<Student> students) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("students.dat")));
		try {
			out.writeInt(students.size());
			for (Student s : students) {
				out.writeObject(s);
			}
		} finally {
			out.close();
		}
	}

	public static void writeStudents2(List<Student> students)
			throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("students.dat")));
		try {
			out.writeObject(students);
		} finally {
			out.close();
		}
	}

	public static List<Student> readStudents() throws IOException,
			ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream("students.dat")));
		try {
			int size = in.readInt();
			List<Student> list = new ArrayList<>(size);
			for (int i = 0; i < size; i++) {
				list.add((Student) in.readObject());
			}
			return list;
		} finally {
			in.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Student> readStudents2() throws IOException,
			ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream("students.dat")));
		try {
			return (List<Student>) in.readObject();
		} finally {
			in.close();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
