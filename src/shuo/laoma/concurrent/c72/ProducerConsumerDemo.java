package shuo.laoma.concurrent.c72;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerDemo {

	static class MyBlockingQueue<E> {
		private Queue<E> queue = null;
		private int limit;
		private Lock lock = new ReentrantLock();
		private Condition notFull  = lock.newCondition(); 
		private Condition notEmpty = lock.newCondition(); 


		public MyBlockingQueue(int limit) {
			this.limit = limit;
			queue = new ArrayDeque<>(limit);
		}

		public void put(E e) throws InterruptedException {
			lock.lockInterruptibly();
			try{
				while (queue.size() == limit) {
					notFull.await();
				}
				queue.add(e);
				notEmpty.signal();	
			}finally{
				lock.unlock();
			}
			
		}

		public E take() throws InterruptedException {
			lock.lockInterruptibly();
			try{
				while (queue.isEmpty()) {
					notEmpty.await();
				}
				E e = queue.poll();
				notFull.signal();
				return e;	
			}finally{
				lock.unlock();
			}
		}
	}

	static class Producer extends Thread {
		MyBlockingQueue<String> queue;

		public Producer(MyBlockingQueue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			int num = 0;
			try {
				while (true) {
					String task = String.valueOf(num);
					queue.put(task);
					System.out.println("produce task " + task);
					num++;
					Thread.sleep((int) (Math.random() * 100));
				}
			} catch (InterruptedException e) {
			}
		}
	}

	static class Consumer extends Thread {
		MyBlockingQueue<String> queue;

		public Consumer(MyBlockingQueue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				while (true) {
					String task = queue.take();
					System.out.println("handle task " + task);
					Thread.sleep((int) (Math.random() * 100));
				}
			} catch (InterruptedException e) {
			}
		}
	}

	public static void main(String[] args) {
		MyBlockingQueue<String> queue = new MyBlockingQueue<>(10);
		new Producer(queue).start();
		new Consumer(queue).start();
		
	}

}
