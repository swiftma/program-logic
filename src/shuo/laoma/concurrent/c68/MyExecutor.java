package shuo.laoma.concurrent.c68;

import java.util.concurrent.Callable;

public class MyExecutor {

	static class ExecuteThread<V> extends Thread {
		private V result = null;
		private Exception exception = null;
		private boolean done = false;
		private Callable<V> task;
		private Object lock;
		
		public ExecuteThread(Callable<V> task, Object lock) {
			this.task = task;
			this.lock = lock;
		}

		@Override
		public void run() {
			try {
				result = task.call();
			} catch (Exception e) {
				exception = e;
			} finally {
				synchronized (lock) {
					done = true;
					lock.notifyAll();
				}
			}
		}

		public V getResult() {
			return result;
		}

		public boolean isDone() {
			return done;
		}

		public Exception getException() {
			return exception;
		}
	}

	public <V> MyFuture<V> execute(final Callable<V> task) {
		final Object lock = new Object();
		final ExecuteThread<V> thread = new ExecuteThread<>(task, lock);
		thread.start();

		MyFuture<V> future = new MyFuture<V>() {
			@Override
			public V get() throws Exception {
				synchronized (lock) {
					while (!thread.isDone()) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
						}
					}
					if (thread.getException() != null) {
						throw thread.getException();
					}
					return thread.getResult();
				}
			}
		};
		return future;
	}

	public static void main(String[] args) {
		MyExecutor executor = new MyExecutor();
		// 子任务
		Callable<Integer> subTask = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// ... 执行异步任务
				int millis = (int) (Math.random() * 1000);
				Thread.sleep(millis);
				return millis;
			}
		};
		// 异步调用，返回一个MyFuture对象
		MyFuture<Integer> future = executor.execute(subTask);
		// ... 执行其他操作
		try {
			// 获取异步调用的结果
			Integer result = future.get();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
