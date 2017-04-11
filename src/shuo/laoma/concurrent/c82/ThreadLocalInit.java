package shuo.laoma.concurrent.c82;

public class ThreadLocalInit {
	static ThreadLocal<Integer> local = new ThreadLocal<Integer>(){

		@Override
		protected Integer initialValue() {
			return 100;
		}
	};

	public static void main(String[] args) {
		System.out.println(local.get());
		local.set(200);
		local.remove();
		System.out.println(local.get());
	}
}
