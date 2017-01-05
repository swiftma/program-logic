package shuo.laoma.file.c64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import shuo.laoma.file.c63.Student;

public class ExcelDemo {

	public static void saveAsExcel(List<Student> list) throws IOException {
	    Workbook wb = new HSSFWorkbook();
//	    Workbook wb = new XSSFWorkbook();
	    Sheet sheet = wb.createSheet();
	    for (int i = 0; i < list.size(); i++) {
	        Student student = list.get(i);
	        Row row = sheet.createRow(i);
	        row.createCell(0).setCellValue(student.getName());
	        row.createCell(1).setCellValue(student.getAge());
	        row.createCell(2).setCellValue(student.getScore());
	    }
	    OutputStream out = new FileOutputStream("data/c64/student.xls");
	    wb.write(out);
	    out.close();
	    wb.close();
	}
	
	public static List<Student> readAsExcel() throws Exception  {
	    Workbook wb = WorkbookFactory.create(new File("data/c64/student.xls"));
	    List<Student> list = new ArrayList<Student>();
	    for(Sheet sheet : wb){
	        for(Row row : sheet){
	            String name = row.getCell(0).getStringCellValue();
	            int age = (int)row.getCell(1).getNumericCellValue();
	            double score = row.getCell(2).getNumericCellValue();
	            list.add(new Student(name, age, score));
	        }
	    }    
	    wb.close();
	    return list;
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		List<Student> students = Arrays.asList(new Student[] {
				new Student("张三", 18, 80.9d), new Student("李四", 17, 67.5d) });
		saveAsExcel(students);
		System.out.println(readAsExcel());

	}

}
