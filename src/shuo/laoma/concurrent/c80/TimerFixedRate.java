package shuo.laoma.concurrent.c80;

import java.util.Timer;
import java.util.TimerTask;

public class TimerFixedRate {

	static class LongRunningTask extends TimerTask {
		@Override
		public void run() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
			System.out.println("long running finished");
		}
	}

	static class FixedRateTask extends TimerTask {

		@Override
		public void run() {
			System.out.println(System.currentTimeMillis());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer();

		timer.schedule(new LongRunningTask(), 10);
		timer.scheduleAtFixedRate(new FixedRateTask(), 100, 1000);
	}

}
