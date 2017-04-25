package shuo.laoma.dynamic.c84;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.List;

public class GenericDemo {
	static class GenericTest<U extends Comparable<U>, V> {
		U u;
		V v;
		List<String> list;

		public U test(List<? extends Number> numbers) {
			return null;
		}
	}

	public static void main(String[] args) throws Exception {
		Class<?> cls = GenericTest.class;
		// 类的类型参数
		for (TypeVariable t : cls.getTypeParameters()) {
			System.out.println(t.getName() + " extends " + Arrays.toString(t.getBounds()));
		}

		// 字段 - 泛型类型
		Field fu = cls.getDeclaredField("u");
		System.out.println(fu.getGenericType());

		// 字段 - 参数化的类型
		Field flist = cls.getDeclaredField("list");
		Type listType = flist.getGenericType();
		if (listType instanceof ParameterizedType) {
			ParameterizedType pType = (ParameterizedType) listType;
			System.out.println("raw type: " + pType.getRawType() + ",type arguments:"
					+ Arrays.toString(pType.getActualTypeArguments()));
		}

		// 方法的泛型参数
		Method m = cls.getMethod("test", new Class[] { List.class });
		for (Type t : m.getGenericParameterTypes()) {
			System.out.println(t);
		}
	}
}
