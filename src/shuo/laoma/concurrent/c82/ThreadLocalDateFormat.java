package shuo.laoma.concurrent.c82;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalDateFormat {
	static ThreadLocal<DateFormat> sdf = new ThreadLocal<DateFormat>() {

		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};

	public static String date2String(Date date) {
		return sdf.get().format(date);
	}

	public static Date string2Date(String str) throws ParseException {
		return sdf.get().parse(str);
	}
}
