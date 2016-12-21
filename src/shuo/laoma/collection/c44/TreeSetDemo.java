package shuo.laoma.collection.c44;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void basic(){
		SortedSet<String> set = new TreeSet<String>();
		set.addAll(Arrays.asList(new String[]{
		    "c", "a", "b", "d","f"    
		}));

		System.out.println(set.first()); //a
		System.out.println(set.last()); //f
		System.out.println(set.headSet("b"));//[a]
		System.out.println(set.tailSet("d"));//[d, f]
		System.out.println(set.subSet("b", "e")); //[b, c, d]
		set.subSet("b", "e").clear(); //会从原set中删除
		System.out.println(set); //[a, f]
	}
	
	public static void navigate(){
		NavigableSet<String> set = new TreeSet<String>();
		set.addAll(Arrays.asList(new String[]{
		    "c", "a", "b", "d","f"    
		}));
		System.out.println(set.floor("a")); //a
		System.out.println(set.lower("b")); //a
		System.out.println(set.ceiling("d"));//d
		System.out.println(set.higher("c"));//d
		System.out.println(set.subSet("b", true, "d", true)); //[b, c, d]
		System.out.println(set.pollFirst()); //a
		System.out.println(set.pollLast()); //f
		System.out.println(set.descendingSet()); //[d, c, b]
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
