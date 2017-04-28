package shuo.laoma.dynamic.c85;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class InheritDemo {
	@Inherited
	@Retention(RetentionPolicy.RUNTIME)
	static @interface Test {
	}
	
	@Test
	static class Base {
	}
	
	static class Child extends Base {
	}
	
	public static void main(String[] args) {
		Class<?> cls = Child.class;
		System.out.println(Child.class.isAnnotationPresent(Test.class));
	}
}
