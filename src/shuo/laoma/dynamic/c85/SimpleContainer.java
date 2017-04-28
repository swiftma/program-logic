package shuo.laoma.dynamic.c85;

import java.lang.reflect.Field;

public class SimpleContainer {
	public static <T> T getInstance(Class<T> cls) {
		try {
			T obj = cls.newInstance();
			Field[] fields = cls.getDeclaredFields();
			for (Field f : fields) {
				if (f.isAnnotationPresent(SimpleInject.class)) {
					if (!f.isAccessible()) {
						f.setAccessible(true);
					}
					Class<?> fieldCls = f.getType();
					f.set(obj, getInstance(fieldCls));
				}
			}
			return obj;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
