package shuo.laoma.collection.c51;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WorkerDemo {
	
	//哪些天一个人都不会来？
	public static void daysNoOneWillCome(Worker[] workers){
		Set<Day> days = EnumSet.allOf(Day.class);
		for(Worker w : workers){
		    days.removeAll(w.getAvailableDays());
		}
		System.out.println(days);
	}
	
	//有哪些天至少会有一个人来？
	public static void daysAtLeastOneWillCome(Worker[] workers){
		Set<Day> days = EnumSet.noneOf(Day.class);
		for(Worker w : workers){
		    days.addAll(w.getAvailableDays());
		}
		System.out.println(days);
	}
	
	//有哪些天所有人都会来？
	public static void daysEveryoneWillCome(Worker[] workers){
		Set<Day> days = EnumSet.allOf(Day.class);
		for(Worker w : workers){
		    days.retainAll(w.getAvailableDays());
		}
		System.out.println(days);
	}
	
	//哪些人周一和周二都会来？
	public static void availableOnMondayAndTuesday(Worker[] workers){
		Set<Worker> availableWorkers = new HashSet<Worker>();
		for(Worker w : workers){
		    if(w.getAvailableDays().containsAll(
		            EnumSet.of(Day.MONDAY,Day.TUESDAY))){
		        availableWorkers.add(w);
		    }
		}
		for(Worker w : availableWorkers){
		    System.out.println(w.getName());
		}
	}
	
	//哪些天至少会有两个人来？
	public static void daysAtLeastHavingTwoWorkers(Worker[] workers){
		Map<Day, Integer> countMap = new EnumMap<>(Day.class);
		for(Worker w : workers){
		    for(Day d : w.getAvailableDays()){
		        Integer count = countMap.get(d);
		        countMap.put(d, count==null?1:count+1);
		    }
		}
		Set<Day> days = EnumSet.noneOf(Day.class);
		for(Map.Entry<Day, Integer> entry : countMap.entrySet()){
		    if(entry.getValue()>=2){
		        days.add(entry.getKey());
		    }
		}
		System.out.println(days);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Worker[] workers = new Worker[]{
		        new Worker("张三", EnumSet.of(
		                Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.FRIDAY)),
		        new Worker("李四", EnumSet.of(
		                Day.TUESDAY, Day.THURSDAY, Day.SATURDAY)),
		        new Worker("王五", EnumSet.of(
		                Day.TUESDAY, Day.THURSDAY)),
		};

	}

}
