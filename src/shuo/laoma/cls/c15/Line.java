package shuo.laoma.cls.c15;

public class Line extends Shape {
	private Point start;
	private Point end;
	
	public Line(Point start, Point end, String color) {
		super(color);
		this.start = start;
		this.end = end;
	}

	public double length(){
		return start.distance(end);
	}
	
	public Point getStart() {
		return start;
	}

	public Point getEnd() {
		return end;
	}
	
	@Override
	public void draw() {
		System.out.println("draw line from "
				+ start.toString()+" to "+end.toString()
				+ ",using color "+super.getColor());
	}
}

