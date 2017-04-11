package shuo.laoma.concurrent.c82;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolProblem {
	static ThreadLocal<AtomicInteger> sequencer = new ThreadLocal<AtomicInteger>() {

		@Override
		protected AtomicInteger initialValue() {
			return new AtomicInteger(0);
		}
	};

	static class Task implements Runnable {

		@Override
		public void run() {
			try{
				AtomicInteger s = sequencer.get();
				int initial = s.getAndIncrement();
				// 期望初始为0
				System.out.println(initial);	
			}finally{
				sequencer.remove();
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new Task());
		executor.execute(new Task());
		executor.execute(new Task());
		executor.shutdown();
	}
}
