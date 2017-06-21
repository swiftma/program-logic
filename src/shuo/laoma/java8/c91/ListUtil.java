package shuo.laoma.java8.c91;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListUtil {

	static class Student {
	    String name;
	    double score;
	    
	    public Student(String name, double score) {
	        this.name = name;
	        this.score = score;
	    }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getScore() {
			return score;
		}

		public void setScore(double score) {
			this.score = score;
		}
	}
	
	public static <E> List<E> filter(List<E> list, Predicate<E> pred) {
	    List<E> retList = new ArrayList<>();
	    for (E e : list) {
	        if (pred.test(e)) {
	            retList.add(e);
	        }
	    }
	    return retList;
	}
	
	public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
	    List<R> retList = new ArrayList<>(list.size());
	    for (T e : list) {
	        retList.add(mapper.apply(e));
	    }
	    return retList;
	}
	
    public static <E> void foreach(List<E> list, Consumer<E> consumer) {
        for (E e : list) {
            consumer.accept(e);
        }
    }

	
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(new Student[] {
		        new Student("zhangsan", 89d),
		        new Student("lisi", 89d),
		        new Student("wangwu", 98d) });
		
		// 过滤90分以上的
		students = filter(students, t -> t.getScore() > 90);

		//根据学生列表返回名称列表
		List<String> names = map(students, t -> t.getName());
		
		//将学生名称转换为大写
		students = map(students, t -> new Student(t.getName().toUpperCase(), t.getScore()));
		
		foreach(students, t -> t.setName(t.getName().toUpperCase()));
	}

}
