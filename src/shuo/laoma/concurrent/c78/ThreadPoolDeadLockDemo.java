package shuo.laoma.concurrent.c78;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDeadLockDemo {
	private static final int THREAD_NUM = 5;
	static ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUM);

	static class TaskA implements Runnable {
		@Override
		public void run() {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Future<?> future = executor.submit(new TaskB());
			try {
				future.get();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("finished task A");
		}
	}

	static class TaskB implements Runnable {
		@Override
		public void run() {
			System.out.println("finished task B");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			executor.execute(new TaskA());
		}
		Thread.sleep(2000);
		executor.shutdown();
	}

}
