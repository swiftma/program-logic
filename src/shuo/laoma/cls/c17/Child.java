package shuo.laoma.cls.c17;

public class Child extends Base {
	public static int s;
	private int a;
	
	static {
		System.out.println("子类静态代码块, s: "+s);
		s = 10;
	}
	
	{
		System.out.println("子类实例代码块, a: "+a);
		a = 10;
	}
	
	public Child(){
		System.out.println("子类构造方法, a: "+a);
		a = 20;
	}
	
	protected void step(){
		System.out.println("child s: " + s +", a: "+a);
	}
}

