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
