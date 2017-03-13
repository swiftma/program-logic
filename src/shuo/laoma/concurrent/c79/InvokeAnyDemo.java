package shuo.laoma.concurrent.c79;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAnyDemo {
	static class SearchTask implements Callable<String> {
		private String engine;
		private String keyword;

		public SearchTask(String engine, String keyword) {
			this.engine = engine;
			this.keyword = keyword;
		}

		@Override
		public String call() throws Exception {
			// 模拟从给定引擎搜索结果
			Thread.sleep(engine.hashCode() % 1000);
			return "<result for> " + keyword;
		}
	}

	public static String search(List<String> engines, String keyword)
			throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		CompletionService<String> cs = new ExecutorCompletionService<>(executor);
		List<Future<String>> futures = new ArrayList<Future<String>>(
				engines.size());
		String result = null;
		try {
			for (String engine : engines) {
				futures.add(cs.submit(new SearchTask(engine, keyword)));
			}
			for (int i = 0; i < engines.size(); i++) {
				try {
					result = cs.take().get();
					if (result != null) {
						break;
					}
				} catch (ExecutionException ignore) {
					// 出现异常，结果无效，继续
				}
			}
		} finally {
			// 取消所有任务，对于已完成的任务，取消没有什么效果
			for (Future<String> f : futures)
				f.cancel(true);
			executor.shutdown();
		}
		return result;
	}

	public static void main(String[] args) throws InterruptedException {
		List<String> engines = Arrays.asList(new String[] { "www.baidu.com",
				"www.sogou.com", "www.so.com", "www.google.com" });
		System.out.println(search(engines, "老马说编程"));
	}
}
