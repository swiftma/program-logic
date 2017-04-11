package shuo.laoma.concurrent.c82;

public class ThreadLocalBasic {
	static ThreadLocal<Integer> local = new ThreadLocal<>();

	public static void main(String[] args) throws InterruptedException {
		Thread child = new Thread() {
			@Override
			public void run() {
				System.out.println("child thread initial: " + local.get());
				local.set(200);
				System.out.println("child thread final: " + local.get());
			}
		};
		local.set(100);
		child.start();
		child.join();
		System.out.println("main thread final: " + local.get());
	}
}
