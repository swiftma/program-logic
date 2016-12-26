package shuo.laoma.file.c63;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Polymorphic {

	@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
	@JsonSubTypes({
	    @JsonSubTypes.Type(value = Circle.class, name = "circle"),
	    @JsonSubTypes.Type(value = Square.class, name = "square") })

	static class Shape {
	}

	static class Circle extends Shape {
		private int r;
		
	    public int getR() {
			return r;
		}

		public void setR(int r) {
			this.r = r;
		}

		
		public Circle() {
			super();
		}

		public Circle(int r) {
			super();
			this.r = r;
		}

		@Override
		public String toString() {
			return "Circle [r=" + r + "]";
		}

		
	}

	static class Square extends Shape {
	    private int l;

		public Square(int l) {
			super();
			this.l = l;
		}

		public Square() {
			super();
		}

		public int getL() {
			return l;
		}

		public void setL(int l) {
			this.l = l;
		}

		@Override
		public String toString() {
			return "Square [l=" + l + "]";
		}   
		
		
	}

	static class ShapeManager {
	    private List<Shape> shapes;

		public List<Shape> getShapes() {
			return shapes;
		}

		public void setShapes(List<Shape> shapes) {
			this.shapes = shapes;
		}

		@Override
		public String toString() {
			return "ShapeManager [shapes=" + shapes + "]";
		}
		
		
	}
	
	public static void test() throws IOException{
		ShapeManager sm =  new ShapeManager();
		List<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Circle(10));
		shapes.add(new Square(5));
		sm.setShapes(shapes);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		String str = mapper.writeValueAsString(sm);
		
		ShapeManager sm2 =  mapper.readValue(str, ShapeManager.class);
		System.out.println(sm2);
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		test();

	}

}
