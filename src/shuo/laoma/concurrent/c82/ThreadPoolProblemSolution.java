package shuo.laoma.concurrent.c82;

import java.lang.reflect.Field;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolProblemSolution {

	static ThreadLocal<AtomicInteger> sequencer = new ThreadLocal<AtomicInteger>() {

		@Override
		protected AtomicInteger initialValue() {
			return new AtomicInteger(0);
		}
	};

	static class Task implements Runnable {

		@Override
		public void run() {
			sequencer.set(new AtomicInteger(0));

			AtomicInteger s = sequencer.get();
			int initial = s.getAndIncrement();
			// 期望初始为0
			System.out.println(initial);
		}
	}

	static class MyThreadPool extends ThreadPoolExecutor {
		public MyThreadPool(int corePoolSize, int maximumPoolSize, 
				long keepAliveTime, TimeUnit unit,
				BlockingQueue<Runnable> workQueue) {
			super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		}

		@Override
		protected void beforeExecute(Thread t, Runnable r) {
			try {
				//使用反射清空所有ThreadLocal
				Field f = t.getClass().getDeclaredField("threadLocals");
				f.setAccessible(true);
				f.set(t, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			super.beforeExecute(t, r);
		}
	}

	public static void main(String[] args) {
		ExecutorService executor = new MyThreadPool(2, 2, 0,
				TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
		executor.execute(new Task());
		executor.execute(new Task());
		executor.execute(new Task());
		executor.shutdown();
	}
}
