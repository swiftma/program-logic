package shuo.laoma.file.c63;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class RefSameObjDemo {

	@JsonIdentityInfo(
	        generator = ObjectIdGenerators.IntSequenceGenerator.class,
	        property="id")
	static class Common {
	    public String name;
	}

	static class A {
	    public Common first;
	    public Common second;
	}
	
	public static void test() throws IOException{
		Common c = new Common();
		c.name= "common";
		A a = new A();
		a.first = a.second = c;
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String str = mapper.writeValueAsString(a);
		System.out.println(str);
		
		A a2 = mapper.readValue(str, A.class);
		if(a2.first == a2.second){
		    System.out.println("reference same object");
		}else{
		    System.out.println("reference different objects");
		}
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		test();

	}

}
