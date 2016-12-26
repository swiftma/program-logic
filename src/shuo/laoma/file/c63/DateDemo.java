package shuo.laoma.file.c63;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DateDemo {

	static class MyDate {
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	    public Date date = new Date();
	}
	
	public static void save() throws IOException{
	    MyDate date = new MyDate();
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.writeValue(System.out, date);
	    
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		save();

	}

}
