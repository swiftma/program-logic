package shuo.laoma.concurrent.c72;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitThread extends Thread {
	private volatile boolean fire = false;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	@Override
	public void run() {
		try {
			lock.lock();
			try {
				while (!fire) {
					condition.await();
				}
			} finally {
				lock.unlock();
			}
			System.out.println("fired");
		} catch (InterruptedException e) {
			Thread.interrupted();
		}
	}

	public void fire() {
		lock.lock();
		try {
			this.fire = true;
			condition.signal();
		} finally {
			lock.unlock();
		}
	}
	
	//错误用法，将signal误写为了notify
//	public void fire() {
//		lock.lock();
//		try {
//			this.fire = true;
//			condition.notify();
//		} finally {
//			lock.unlock();
//		}
//	}

	public static void main(String[] args) throws InterruptedException {
		WaitThread waitThread = new WaitThread();
		waitThread.start();
		Thread.sleep(1000);
		System.out.println("fire");
		waitThread.fire();
	}
}
