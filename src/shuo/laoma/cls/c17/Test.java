package shuo.laoma.cls.c17;

public class Test {
	public static void main(String[] args) {
		System.out.println("---- new Child()");
		Child c = new Child();
		
		System.out.println("\n---- c.action()");
		c.action();
		
		Base b = c;
		System.out.println("\n---- b.action()");
		b.action();
		
		
		System.out.println("\n---- b.s: " + b.s); 
		System.out.println("\n---- c.s: " + c.s); 
	}
}
