package shuo.laoma.file.c63;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ListDemo {

	public static void writeStudents() throws IOException{
		List<Student> students = Arrays.asList(new Student[] {
		        new Student("张三", 18, 80.9d), new Student("李四", 17, 67.5d) });
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String str = mapper.writeValueAsString(students);
		mapper.writeValue(new File("students.json"), students);
		System.out.println(str);
	}
	
	public static void readStudents() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<Student> list = mapper.readValue(new File("students.json"),
		        new TypeReference<List<Student>>() {});
		System.out.println(list.toString());
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		writeStudents();
		readStudents();

	}

}
