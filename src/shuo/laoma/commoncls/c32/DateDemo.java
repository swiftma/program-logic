package shuo.laoma.commoncls.c32;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {

	public static void basic(){
		Calendar calendar = Calendar.getInstance();
		System.out.println("year: "+calendar.get(Calendar.YEAR));
		System.out.println("month: "+calendar.get(Calendar.MONTH));
		System.out.println("day: "+calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("hour: "+calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("minute: "+calendar.get(Calendar.MINUTE));
		System.out.println("second: "+calendar.get(Calendar.SECOND));
		System.out.println("millisecond: " +calendar.get(Calendar.MILLISECOND));
		System.out.println("day_of_week: " + calendar.get(Calendar.DAY_OF_WEEK));
	}
	
	public static void format(){
		Calendar calendar = Calendar.getInstance();
		//2016-08-15 14:15:20
		calendar.set(2016, 07, 15, 14, 15, 20);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 E HH时mm分ss秒");
		System.out.println(sdf.format(calendar.getTime()));
	}
	
	public static void parse() {
		String str = "2016-08-15 14:15:20.456";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		try {
			Date date = sdf.parse(str);
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年M月d h:m:s.S a");
			System.out.println(sdf2.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
