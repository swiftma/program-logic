package shuo.laoma.concurrent.c79;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CompletionServiceDemo {
	static class UrlTitleParser implements Callable<String> {
		private String url;

		public UrlTitleParser(String url) {
			this.url = url;
		}

		@Override
		public String call() throws Exception {
			Document doc = Jsoup.connect(url).get();
			Elements elements = doc.select("head title");
			if (elements.size() > 0) {
				return url + ": " + elements.get(0).text();
			}
			return null;
		}
	}

	public static void parse(List<String> urls) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		try {
			CompletionService<String> completionService = new ExecutorCompletionService<>(
					executor);
			for (String url : urls) {
				completionService.submit(new UrlTitleParser(url));
			}
			for (int i = 0; i < urls.size(); i++) {
				Future<String> result = completionService.take();
				try {
					System.out.println(result.get());
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		} finally {
			executor.shutdown();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		List<String> urls = Arrays.asList(new String[] {
				"http://www.cnblogs.com/swiftma/p/5396551.html",
				"http://www.cnblogs.com/swiftma/p/5399315.html",
				"http://www.cnblogs.com/swiftma/p/5405417.html",
				"http://www.cnblogs.com/swiftma/p/5409424.html" });
		parse(urls);
	}
}
