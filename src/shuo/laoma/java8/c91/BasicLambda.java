package shuo.laoma.java8.c91;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasicLambda {

	public static void main(String[] args) {
		File f = new File(".");
//		File[] files = f.listFiles((File dir, String name) -> {
//		    if (name.endsWith(".txt")) {
//		        return true;
//		    }
//		    return false;
//		});
//		
//		File[] files = f.listFiles((File dir, String name) -> {
//		    return name.endsWith(".txt");
//		});
//		
//		File[] files = f.listFiles((File dir, String name) -> name.endsWith(".txt"));
		
		File[] files = f.listFiles((dir, name) -> name.endsWith(".txt"));
		
		Arrays.sort(files, (f1, f2) -> f1.getName().compareTo(f2.getName()));
		
		ExecutorService executor = Executors.newFixedThreadPool(100);
		executor.submit(()->System.out.println("hello"));

	}

}
