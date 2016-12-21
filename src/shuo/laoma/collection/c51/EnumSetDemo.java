package shuo.laoma.collection.c51;

import java.util.EnumSet;
import java.util.Set;

public class EnumSetDemo {

	public static void day(){
		Set<Day> weekend = EnumSet.noneOf(Day.class);
		weekend.add(Day.SATURDAY);
		weekend.add(Day.SUNDAY);
		System.out.println(weekend);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
