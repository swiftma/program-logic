package shuo.laoma.collection.c41;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("hello");
		set.add("world");
		set.addAll(Arrays.asList(new String[]{"hello","老马"}));

		for(String s : set){
		    System.out.print(s+" ");
		}
	}

}
