package shuo.laoma.commoncls.c33;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.Minutes;
import org.joda.time.Period;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class JodaDemo {

	public static void create() {
		// 2016-08-18 15:20
		DateTime dt = new DateTime(2016, 8, 18, 15, 20);

		// 2016-08-18 15:20:47
		DateTime dt2 = new DateTime(2016, 8, 18, 15, 20, 47);

		// 2016-08-18 15:20:47.345
		DateTime dt3 = new DateTime(2016, 8, 18, 15, 20, 47, 345);
	}
	
	public static void basic(){
		//2016-08-18 15:20:47.345
		DateTime dt = new DateTime(2016,8,18,15,20,47,345);
		System.out.println("year: "+dt.getYear());
		System.out.println("month: "+dt.getMonthOfYear());
		System.out.println("day: "+dt.getDayOfMonth());
		System.out.println("hour: "+dt.getHourOfDay());
		System.out.println("minute: "+dt.getMinuteOfHour());
		System.out.println("second: "+dt.getSecondOfMinute());
		System.out.println("millisecond: " +dt.getMillisOfSecond());
		System.out.println("day_of_week: " +dt.getDayOfWeek());
	}
	
	public static void format(){
		//2016-08-18 14:20:45.345
		DateTime dt = new DateTime(2016,8,18,14,20,45,345);
		System.out.println(dt.toString("yyyy-MM-dd HH:mm:ss"));
	}
	
	public static void format2(){
		DateTime dt = new DateTime(2016,8,18,14,20);
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
		System.out.println(formatter.print(dt));
	}
	
	public static void parse(){
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
		DateTime dt = formatter.parseDateTime("2016-08-18 14:20");
	}
	
//	调整时间为下午3点20
	public static void setTime1(){
		DateTime dt = new DateTime();
		dt = dt.withHourOfDay(15).withMinuteOfHour(20);
	}
	
	//三小时五分钟后
	public static void setTime2(){
		DateTime dt = new DateTime().plusHours(3).plusMinutes(5);
	}
	
	//今天0点
	public static void setTime3(){
		DateTime dt = new DateTime().withMillisOfDay(0);
		System.out.println(dt.toString("yyyy-MM-dd HH:mm:ss.SSS"));
	}
	
	//下周二上午10点整
	public static void setTime4(){
		DateTime dt = new DateTime().plusWeeks(1).withDayOfWeek(2)
		        .withMillisOfDay(0).withHourOfDay(10);
	}
	
	//明天最后一刻
	public static void setTime5(){
		DateTime dt = new DateTime().plusDays(1).millisOfDay().withMaximumValue();
		System.out.println(dt.toString("yyyy-MM-dd HH:mm:ss.SSS"));
	}
	
	//本月最后一天最后一刻
	public static void setTime6(){
		DateTime dt = new DateTime().dayOfMonth().withMaximumValue()
				.millisOfDay().withMaximumValue();
	}
	
	//下个月第一个周一的下午5点整
	public static void setTime7(){
		DateTime dt = new DateTime().plusMonths(1).dayOfMonth().withMinimumValue()
		        .plusDays(6).withDayOfWeek(1).withMillisOfDay(0).withHourOfDay(17);
	}
	
	//计算两个时间之间的差
	public static void delta(){
		DateTime start = new DateTime(2016,8,18,10,58);
		DateTime end = new DateTime(2016,9,19,12,3);
		Period period = new Period(start,end);        
		System.out.println(period.getMonths()+"月"+period.getDays()+"天"
		        +period.getHours()+"小时"+period.getMinutes()+"分");
	}
	
	//根据生日计算年龄
	public static void age(){
		DateTime born = new DateTime(1990,11,20,12,30);
		int age = Years.yearsBetween(born, DateTime.now()).getYears();
	}
	
	//计算迟到分钟数
	public static void lateMinutes(){
		int lateMinutes = Minutes.minutesBetween(
		        DateTime.now().withMillisOfDay(0).withHourOfDay(9), 
		        DateTime.now()).getMinutes();
	}
	
	//使用LocalDate计算年龄
	public static void age2(){
		LocalDate born = new LocalDate(1990,11,20);
		int age = Years.yearsBetween(born, LocalDate.now()).getYears();
	}
	
	//使用LocalTime计算迟到时间
	public static void lateMinutes2(){
		int lateMinutes = Minutes.minutesBetween(
		        new LocalTime(9,0), 
		        LocalTime.now()).getMinutes();
	}
	
	//LocalDate和LocalTime可以与DateTime进行相互转换
	public static void convert(){
		DateTime dt = new DateTime(1990,11,20,12,30);
		LocalDate date = dt.toLocalDate();
		LocalTime time = dt.toLocalTime();
		DateTime newDt = DateTime.now().withDate(date).withTime(time);
	}
	
	//JDK -> Joda 
	public static void jdk2joda(){
		DateTime dt = new DateTime(new Date());
		DateTime dt2 = new DateTime(Calendar.getInstance());
		
		LocalDate.fromDateFields(new Date());
		LocalDate.fromCalendarFields(Calendar.getInstance());
		LocalTime.fromDateFields(new Date());
		LocalTime.fromCalendarFields(Calendar.getInstance());
	}
	
	//Joda -> JDK
	public static void joda2jdk(){
		DateTime dt = new DateTime();
		Date date = dt.toDate();
		Calendar calendar = dt.toCalendar(Locale.CHINA);
		
		LocalDate localDate = new LocalDate(2016,8,18);
		Date date2 = localDate.toDate();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
