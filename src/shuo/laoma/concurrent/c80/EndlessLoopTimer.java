package shuo.laoma.concurrent.c80;

import java.util.Timer;
import java.util.TimerTask;

public class EndlessLoopTimer {

	static class LoopTask extends TimerTask {

		@Override
		public void run() {
			while (true) {
				try {
					// ... 执行任务
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 永远也没有机会执行
	static class ExampleTask extends TimerTask {
		@Override
		public void run() {

			System.out.println("hello");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer();
		timer.schedule(new LoopTask(), 10);
		timer.schedule(new ExampleTask(), 100);
	}

}
