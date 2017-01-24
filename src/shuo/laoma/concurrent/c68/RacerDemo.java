package shuo.laoma.concurrent.c68;

public class RacerDemo {

	static class FireFlag {
		private volatile boolean fired = false;

		public synchronized void waitForFire() throws InterruptedException {
			while (!fired) {
				wait();
			}
		}

		public synchronized void fire() {
			this.fired = true;
			notifyAll();
		}
	}
	
	static class Racer extends Thread {
		FireFlag fireFlag;

		public Racer(FireFlag fireFlag) {
			this.fireFlag = fireFlag;
		}

		@Override
		public void run() {
			try {
				this.fireFlag.waitForFire();
				System.out.println("start run "
						+ Thread.currentThread().getName());
			} catch (InterruptedException e) {
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		int num = 10;
		FireFlag fireFlag = new FireFlag();
		Thread[] racers = new Thread[num];
		for (int i = 0; i < num; i++) {
			racers[i] = new Racer(fireFlag);
			racers[i].start();
		}
		Thread.sleep(1000);
		fireFlag.fire();
	}

}
