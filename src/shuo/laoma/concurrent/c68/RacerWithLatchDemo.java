package shuo.laoma.concurrent.c68;

public class RacerWithLatchDemo {
	static class Racer extends Thread {
		MyLatch latch;

		public Racer(MyLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			try {
				this.latch.await();
				System.out.println("start run "
						+ Thread.currentThread().getName());
			} catch (InterruptedException e) {
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int num = 10;
		MyLatch latch = new MyLatch(1);
		Thread[] racers = new Thread[num];
		for (int i = 0; i < num; i++) {
			racers[i] = new Racer(latch);
			racers[i].start();
		}
		Thread.sleep(1000);
		latch.countDown();
	}

}
