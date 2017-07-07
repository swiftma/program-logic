package shuo.laoma.java8.c94;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class BasicCompletableFutureDemo {

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

	static Supplier<Integer> externalTask = () -> {
	    int time = delayRandom(20, 2000);
	    return time;
	};
	
	public static Future<Integer> callExternalService(){
	    return CompletableFuture.supplyAsync(externalTask, executor);
	}
	
	public static Future<Integer> callExternalService2() {
	    CompletableFuture<Integer> future = new CompletableFuture<>();
	    new Thread() {
	        public void run() {
	            try {
	                future.complete(externalTask.get());
	            } catch (Exception e) {
	                future.completeExceptionally(e);
	            }
	        }
	    }.start();
	    return future;
	}
	
	public static void whenCompleteDemo(){
		CompletableFuture.supplyAsync(externalTask).whenComplete((result, ex) -> {
		    if (result != null) {
		        System.out.println(result);
		    }
		    if (ex != null) {
		        ex.printStackTrace();
		    }
		}).join();
	}
	
	public static void handleDemo(){
	    String ret =
	            CompletableFuture.supplyAsync(()->{
	                throw new RuntimeException("test");
	            }).handle((result, ex)->{
	                return "hello";
	            }).join();
	    System.out.println(ret);
	}
	
	public static void taskStreamThenRun(){
		Runnable taskA = () -> System.out.println("task A");
		Runnable taskB = () -> System.out.println("task B");
		Runnable taskC = () -> System.out.println("task C");

		CompletableFuture.runAsync(taskA)
		    .thenRun(taskB)
		    .thenRun(taskC)
		    .join();
	}
	
	public static void taskStreamThenApply(){
		Supplier<String> taskA = () -> "hello";
		Function<String, String> taskB = (t) -> t.toUpperCase();
		Consumer<String> taskC = (t) -> System.out.println("consume: " + t);

		CompletableFuture.supplyAsync(taskA)
		    .thenApply(taskB)
		    .thenAccept(taskC)
		    .join();
	}
	
	public static void taskStreamThenCompose(){
		Supplier<String> taskA = () -> "hello";
		Function<String, CompletableFuture<String>> taskB = (t) ->
		    CompletableFuture.supplyAsync(() -> t.toUpperCase());
		Consumer<String> taskC = (t) -> System.out.println("consume: " + t);

		CompletableFuture.supplyAsync(taskA)
		    .thenCompose(taskB)
		    .thenAccept(taskC)
		    .join();
	}
	
	public static void taskStreamThenCombine(){
		Supplier<String> taskA = () -> "taskA";
		CompletableFuture<String> taskB = CompletableFuture.supplyAsync(() -> "taskB");
		BiFunction<String, String, String> taskC = (a, b) -> a + "," + b;

		String ret = CompletableFuture.supplyAsync(taskA)
		        .thenCombineAsync(taskB, taskC)
		        .join();
		System.out.println(ret);
	}
	
	public static void taskStreamAllOf(){
	    CompletableFuture<String> taskA = CompletableFuture.supplyAsync(() -> {
	        delayRandom(100, 1000);
	        return "helloA";
	    }, executor);

	    CompletableFuture<Void> taskB = CompletableFuture.runAsync(() -> {
	        delayRandom(2000, 3000);
	    }, executor);

	    CompletableFuture<Void> taskC = CompletableFuture.runAsync(() -> {
	        delayRandom(30, 100);
	        throw new RuntimeException("task C exception");
	    }, executor);

	    CompletableFuture.allOf(taskA, taskB, taskC).whenComplete((result, ex) -> {
	        if (ex != null) {
	            System.out.println(ex.getMessage());
	        }
	        if (!taskA.isCompletedExceptionally()) {
	            System.out.println("task A " + taskA.join());
	        }
	    });

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
