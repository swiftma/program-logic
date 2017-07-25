package shuo.laoma.java8.c95;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

	public static void localDateTimeDemo(){
		LocalDateTime ldt3 = LocalDateTime.of(2017, 7, 11, 20, 45, 5);
		LocalDateTime ldt2 = LocalDateTime.now();
		
		LocalDateTime ldt = LocalDateTime.of(2017, 7, 11, 20, 45, 5);
		LocalDate ld = ldt.toLocalDate(); //2017-07-11
		LocalTime lt = ldt.toLocalTime(); // 20:45:05
	}
	
	public static void localDateDemo(){
	    //表示2017年7月11日
	    LocalDate ld = LocalDate.of(2017, 7, 11);


	    //当前时刻按系统默认时区解读的日期
	    LocalDate now = LocalDate.now();

	  //LocalDate加上时间，结果为2017-07-11 21:18:39
	    LocalDateTime ldt2 = ld.atTime(21, 18, 39);
	}
	
	public static void localTimeDemo(){
		 //表示21点10分34秒
	    LocalTime lt = LocalTime.of(21, 10, 34);

	    //当前时刻按系统默认时区解读的时间
	    LocalTime time = LocalTime.now();
	    
	  //LocalTime加上日期，结果为2016-03-24 20:45:05
	    LocalDateTime ldt3 = lt.atDate(LocalDate.of(2016, 3, 24));
	}
	
	public static void formatDemo(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime ldt = LocalDateTime.of(2016,8,18,14,20,45);
		System.out.println(formatter.format(ldt));
		
		
	}
	
	public static void parseDemo(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String str = "2016-08-18 14:20:45";
		LocalDateTime ldt = LocalDateTime.parse(str, formatter);
	}
	
	public static void adjustDateTime1(){
//		调整时间为下午3点20
	    LocalDateTime ldt = LocalDateTime.now();
	    ldt = ldt.withHour(15).withMinute(20).withSecond(0).withNano(0);
	    
//	    LocalDateTime ldt = LocalDateTime.now();
//	    ldt = ldt.toLocalDate().atTime(15, 20);

	}
	
	public static void adjustDateTime2(){
//		三小时五分钟后
		LocalDateTime ldt = LocalDateTime.now();
		ldt = ldt.plusHours(3).plusMinutes(5);
	}
	
	public static void adjustDateTime3(){
//		今天0点
		LocalDateTime ldt = LocalDateTime.now();
		ldt = ldt.with(ChronoField.MILLI_OF_DAY, 0);     
		
//		LocalDateTime ldt = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
//		LocalDateTime ldt = LocalDate.now().atTime(0, 0);
	}
	
//	下周二上午10点整
	public static void adjustDateTime4(){
		LocalDateTime ldt = LocalDateTime.now();
		ldt = ldt.plusWeeks(1).with(ChronoField.DAY_OF_WEEK, 2)
		    .with(ChronoField.MILLI_OF_DAY, 0).withHour(10);
	}
	
//	下一个周二上午10点整
	public static void adjustDateTime5(){
		LocalDate ld = LocalDate.now();
		LocalDateTime ldt = ld.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)).atTime(10, 0);
		
//		LocalDate ld = LocalDate.now();
//		if(!ld.getDayOfWeek().equals(DayOfWeek.MONDAY)){
//		    ld = ld.plusWeeks(1);
//		}
//		LocalDateTime ldt = ld.with(ChronoField.DAY_OF_WEEK, 2).atTime(10, 0);
	}
	
	public static void adjustDateTime6(){
//		明天最后一刻
		LocalDateTime ldt = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.MAX);
//		LocalDateTime ldt = LocalTime.MAX.atDate(LocalDate.now().plusDays(1));
	}
	
//	本月最后一天最后一刻
	public static void adjustDateTime7(){
		LocalDateTime ldt =  LocalDate.now()
		        .with(TemporalAdjusters.lastDayOfMonth())
		        .atTime(LocalTime.MAX);
	}
	
//	下个月第一个周一的下午5点整
	public static void adjustDateTime8(){
		LocalDateTime ldt = LocalDate.now()
		        .plusMonths(1)
		        .with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY))
		        .atTime(17, 0);
	}
	
	public static void periodDemo(){
		LocalDate ld1 = LocalDate.of(2016, 3, 24);
		LocalDate ld2 = LocalDate.of(2017, 7, 12);
		Period period = Period.between(ld1, ld2);
		System.out.println(period.getYears() + "年"
		        + period.getMonths() + "月" + period.getDays() + "天");
	}
	
	public static void ageByBorn(){
		LocalDate born = LocalDate.of(1990,06,20);
		int year = Period.between(born, LocalDate.now()).getYears();
	}
	
	
	public static void lateMinutes(){
	    long lateMinutes = Duration.between(
	            LocalTime.of(9,0),
	            LocalTime.now()).toMinutes();
	}
	
	public static void zonedDateTimeDemo(){
		ZonedDateTime ldt = ZonedDateTime.now();
		Instant now = ldt.toInstant();
		
	}
	
	public static Instant toInstant(Date date) {
	    return Instant.ofEpochMilli(date.getTime());
	}
	
	public static Date toDate(Instant instant) {
	    return new Date(instant.toEpochMilli());
	}
	
	public static Instant toBeijingInstant(LocalDateTime ldt) {
	    return ldt.toInstant(ZoneOffset.of("+08:00"));
	}
	
	public static Date toDate(LocalDateTime ldt){
	    return new Date(ldt.atZone(ZoneId.systemDefault())
	            .toInstant().toEpochMilli());
	}
	
	public static Calendar toCalendar(ZonedDateTime zdt) {
	    TimeZone tz = TimeZone.getTimeZone(zdt.getZone());
	    Calendar calendar = Calendar.getInstance(tz);
	    calendar.setTimeInMillis(zdt.toInstant().toEpochMilli());
	    return calendar;
	}
	
	public static LocalDateTime toLocalDateTime(Date date) {
	    return LocalDateTime.ofInstant(
	            Instant.ofEpochMilli(date.getTime()),
	            ZoneId.systemDefault());
	}
	
	public static ZonedDateTime toZonedDateTime(Calendar calendar) {
	    ZonedDateTime zdt = ZonedDateTime.ofInstant(
	            Instant.ofEpochMilli(calendar.getTimeInMillis()),
	            calendar.getTimeZone().toZoneId());
	    return zdt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
