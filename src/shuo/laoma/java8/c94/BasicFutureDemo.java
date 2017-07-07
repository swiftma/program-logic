package shuo.laoma.java8.c94;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class BasicFutureDemo {

	private static ExecutorService executor =
	        Executors.newFixedThreadPool(10);
	
	private static Random rnd = new Random();

	static int delayRandom(int min, int max) {
	    int milli = max > min ? rnd.nextInt(max - min) : 0;
	    try {
	        Thread.sleep(min + milli);
	    } catch (InterruptedException e) {
	    }
	    return milli;
	}

	static Callable<Integer> externalTask = () -> {
	    int time = delayRandom(20, 2000);
	    return time;
	};
	
	public static Future<Integer> callExternalService(){
	    return executor.submit(externalTask);
	}
	
	public static Future<Integer> callExternalService2() {
	    FutureTask<Integer> future = new FutureTask<>(externalTask);
	    new Thread() {
	        public void run() {
	            future.run();
	        }
	    }.start();
	    return future;
	}
	
	public static void master() {
	    // 执行异步任务
	    Future<Integer> asyncRet = callExternalService();

	    // 执行其他任务 ...

	    // 获取异步任务的结果，处理可能的异常
	    try {
	        Integer ret = asyncRet.get();
	        System.out.println(ret);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    } catch (ExecutionException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void main(String[] args) {
		master();

	}

}
