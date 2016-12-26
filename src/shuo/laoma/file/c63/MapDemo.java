package shuo.laoma.file.c63;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class MapDemo {

	public static void saveMap() throws IOException{
		Map<String, Student> map = new HashMap<String, Student>();
		map.put("zhangsan", new Student("张三", 18, 80.9d));
		map.put("lisi", new Student("李四", 17, 67.5d));
		ObjectMapper mapper = new XmlMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String str = mapper.writeValueAsString(map);
		mapper.writeValue(new File("students_map.xml"), map);
		System.out.println(str);
	}
	
	public static void readMap() throws IOException {
		ObjectMapper mapper = new XmlMapper();
		Map<String, Student> map = mapper.readValue(new File("students_map.xml"),
		        new TypeReference<Map<String, Student>>() {});
		System.out.println(map.toString());
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		saveMap();
		readMap();

	}

}
