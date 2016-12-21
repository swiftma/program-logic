package shuo.laoma.cls.c14;

public class Line {
	private Point start;
	private Point end;
	
	public Line(Point start, Point end){
		this.start= start;
		this.end = end;
	}
	
	public double length(){
		return start.distance(end);
	}
	
	public static void main(String[] args) {
		Point start = new Point(2,3);
		Point end = new Point(3,4);
		
		Line line = new Line(start, end);
		System.out.println(line.length());
	}
}



///**
// * @param args
// */


//定义类Line
//
//在类型Point中，属性x,y都是基本类型，但类的属性也可以是类，我们考虑一个表示线的类，它由两个点组成，有一个实例方法计算线的长度，代码如下：
//
//​
//
//
//
//
//Line类，构造函数，
//
//public/private关键字。
//
//变量初始化
//
//垃圾回收