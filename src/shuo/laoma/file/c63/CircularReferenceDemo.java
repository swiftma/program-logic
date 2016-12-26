package shuo.laoma.file.c63;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class CircularReferenceDemo {

    static class Parent  {
        public String name;
        
        @JsonManagedReference
        public Child child;
    }

    static class Child {
        public String name;
        
        @JsonBackReference
        public Parent parent;
    }


    public static void test() throws IOException{
    	Parent parent = new Parent();
    	parent.name = "老马";
    	Child child = new Child();
    	child.name = "小马";
    	parent.child = child;
    	child.parent = parent;
    	
        ObjectMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String str = mapper.writeValueAsString(parent);
        System.out.println(str);

        Parent parent2 = mapper.readValue(str, Parent.class);
        System.out.println(parent2.child.parent.name);
    }

    
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		test();

	}

}
