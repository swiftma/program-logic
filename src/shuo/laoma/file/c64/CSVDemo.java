package shuo.laoma.file.c64;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class CSVDemo {

	public static void parse() throws IOException{
		CSVFormat format = CSVFormat.newFormat(';')
		        .withQuote('"').withNullString("N/A")
		        .withIgnoreSurroundingSpaces(true);
		Reader reader = new FileReader("data/c64/student.csv");
		try{
		    for(CSVRecord record : format.parse(reader)){
		        int fieldNum = record.size();
		        for(int i=0; i<fieldNum; i++){
		            System.out.print(record.get(i)+" ");
		        }
		        System.out.println();
		    }
		}finally{
		    reader.close();
		}
	}
	
	public static void writeCSV() throws IOException{
		CSVPrinter out = new CSVPrinter(System.out,
		        CSVFormat.DEFAULT);
		out.printRecord("老马", 18, "看电影,看书,听音乐");
		out.printRecord("小马", 16, "乐高;赛车;");
		out.close();
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		parse();

		System.out.println("\n");
		writeCSV();
	}

}
