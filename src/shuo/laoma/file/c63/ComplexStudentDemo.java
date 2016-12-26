package shuo.laoma.file.c63;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ComplexStudentDemo {

	public static void printAsJson() throws IOException{
		ComplexStudent student = new ComplexStudent("张三", 18);
		Map<String, Double> scoreMap = new HashMap<>();
		scoreMap.put("语文", 89d);
		scoreMap.put("数学", 83d);
		student.setScores(scoreMap);
		ContactInfo contactInfo = new ContactInfo();
		contactInfo.setPhone("18500308990");
		contactInfo.setEmail("zhangsan@sina.com");
		contactInfo.setAddress("中关村");
		student.setContactInfo(contactInfo);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		System.out.println(mapper.writeValueAsString(student));
	}
	
	public static void printAsXml() throws IOException{
		ComplexStudent student = new ComplexStudent("张三", 18);
		Map<String, Double> scoreMap = new HashMap<>();
		scoreMap.put("语文", 89d);
		scoreMap.put("数学", 83d);
		student.setScores(scoreMap);
		ContactInfo contactInfo = new ContactInfo();
		contactInfo.setPhone("18500308990");
		contactInfo.setEmail("zhangsan@sina.com");
		contactInfo.setAddress("中关村");
		student.setContactInfo(contactInfo);
		
		ObjectMapper mapper = new XmlMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		System.out.println(mapper.writeValueAsString(student));
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		printAsJson();
		printAsXml();

	}

}
