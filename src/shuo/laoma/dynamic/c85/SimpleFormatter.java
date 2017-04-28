package shuo.laoma.dynamic.c85;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class SimpleFormatter {

	private static Object formatDate(Field f, Object value) {
		Format format = f.getAnnotation(Format.class);
		if (format != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(format.pattern());
			sdf.setTimeZone(TimeZone.getTimeZone(format.timezone()));
			return sdf.format(value);
		}
		return value;
	}

	public static String format(Object obj) {
		try {
			Class<?> cls = obj.getClass();
			StringBuilder sb = new StringBuilder();
			for (Field f : cls.getDeclaredFields()) {
				if (!f.isAccessible()) {
					f.setAccessible(true);
				}
				Label label = f.getAnnotation(Label.class);
				String name = label != null ? label.value() : f.getName();
				Object value = f.get(obj);
				if (value != null && f.getType() == Date.class) {
					value = formatDate(f, value);
				}
				sb.append(name + "：" + value + "\n");
			}
			return sb.toString();
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

}
