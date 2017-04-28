package shuo.laoma.dynamic.c85;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleFormatterDemo {
	static class Student {
		@Label("姓名")
		String name;
		
		@Label("出生日期")
		@Format(pattern="yyyy/MM/dd")
		Date born;
		
		@Label("分数")
		double score;

		public Student() {
		}

		public Student(String name, Date born, Double score) {
			super();
			this.name = name;
			this.born = born;
			this.score = score;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", born=" + born + ", score=" + score + "]";
		}
	}

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Student zhangsan = new Student("张三", sdf.parse("1990-12-12"), 80.9d);
		
		System.out.println(SimpleFormatter.format(zhangsan));
	}
}
