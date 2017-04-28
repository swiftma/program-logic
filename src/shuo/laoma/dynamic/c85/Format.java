package shuo.laoma.dynamic.c85;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Format {
	String pattern() default "yyyy-MM-dd HH:mm:ss";
	String timezone() default "GMT+8";
}
