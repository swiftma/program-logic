package shuo.laoma.cls.c15;

public class ShapeManager {
	private static final int MAX_NUM = 100;
	private Shape[] shapes = new Shape[MAX_NUM];
	private int shapeNum = 0;
	
	public void addShape(Shape shape){
		if(shapeNum<MAX_NUM){
			shapes[shapeNum++] = shape;	
		}
	}
	
	public void draw(){
		for(int i=0;i<shapeNum;i++){
			shapes[i].draw();
		}
	}
	
	public static void main(String[] args) {
		ShapeManager manager = new ShapeManager();
		
		manager.addShape(new Circle(new Point(4,4),3));
		manager.addShape(new Line(new Point(2,3),
				new Point(3,4),"green"));
		manager.addShape(new ArrowLine(new Point(1,2), 
				new Point(5,5),"black",false,true));
		
		manager.draw();
	}
}
