package shuo.laoma.cls.c13;

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
	
	public static void main(String[] args){
		Point p1 = new Point();
		p1.setX(2);
		p1.setY(3);
		System.out.println(p1.getX()+","+p1.getY()+","+p1.distance());	
	
		Point p2 = new Point(4,5);
		System.out.println(p2.getX()+","+p2.getY()+", "+p2.distance());
	}
}





