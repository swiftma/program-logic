package shuo.laoma.dynamic.c86;


public class CGLibContainerDemo {
	
	public static void main(String[] args) {
		
		ServiceA a = CGLibContainer.getInstance(ServiceA.class);
		a.callB();
		
	}
}
