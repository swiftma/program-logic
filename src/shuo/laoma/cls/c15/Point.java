package shuo.laoma.cls.c15;

public class Point {
	private int x;
	private int y;
	
	public Point(){
		this(0, 0);
	}
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double distance(){
		return Math.sqrt(x*x+y*y);
	}
	
	public double distance(Point p){
		return Math.sqrt(Math.pow(x-p.getX(), 2)
				+Math.pow(y-p.getY(), 2));
	}
	
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	
	public static void main(String[] args){
		Point p1 = new Point();
		p1.setX(2);
		p1.setY(3);
		System.out.println(p1.getX()+","+p1.getY()+","+p1.distance());	
	
		Point p2 = new Point(4,5);
		System.out.println(p2.getX()+","+p2.getY()+", "+p2.distance());
	}
}





