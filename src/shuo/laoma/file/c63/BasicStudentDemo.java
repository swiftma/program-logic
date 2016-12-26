package shuo.laoma.file.c63;

import java.io.File;
import java.io.IOException;

import org.msgpack.jackson.dataformat.MessagePackFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class BasicStudentDemo {

	public static void writeAsJson() throws IOException{
		Student student = new Student("张三", 18, 80.9d);
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		String str = mapper.writeValueAsString(student);
		
		mapper.writeValue(new File("student.json"), student);
		
		System.out.println(str);
	}
	
	public static void readAsJson() throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		Student s = mapper.readValue(new File("student.json"), Student.class);
		System.out.println(s.toString());
	}
	
	public static void writeAsXml() throws IOException{
		Student student = new Student("张三", 18, 80.9d);
		ObjectMapper mapper = new XmlMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String str = mapper.writeValueAsString(student);
		mapper.writeValue(new File("student.xml"), student);
		System.out.println(str);
	}
	
	public static void readAsXml() throws IOException{
		ObjectMapper mapper = new XmlMapper();
		Student s = mapper.readValue(new File("student.xml"), Student.class);
		System.out.println(s.toString());
	}
	
	public static void writeAsMessagePack() throws IOException{
		Student student = new Student("张三", 18, 80.9d);
		ObjectMapper mapper = new ObjectMapper(new MessagePackFactory());
		byte[] bytes = mapper.writeValueAsBytes(student);
		mapper.writeValue(new File("student.bson"), student);
	}
	
	public static void readAsMessagePack() throws IOException{
		ObjectMapper mapper = new ObjectMapper(new MessagePackFactory());
		Student s = mapper.readValue(new File("student.bson"), Student.class);
		System.out.println(s.toString());
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		writeAsJson();
		readAsJson();
		writeAsXml();
		readAsXml();
		writeAsMessagePack();
		readAsMessagePack();
	}

}
