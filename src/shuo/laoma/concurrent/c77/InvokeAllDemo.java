package shuo.laoma.concurrent.c77;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class InvokeAllDemo {
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
                return elements.get(0).text();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        String url1 = "http://www.cnblogs.com/swiftma/p/5396551.html";
        String url2 = "http://www.cnblogs.com/swiftma/p/5399315.html";

        Collection<UrlTitleParser> tasks = Arrays.asList(new UrlTitleParser[] {
                new UrlTitleParser(url1), new UrlTitleParser(url2) });
        try {
            List<Future<String>> results = executor.invokeAll(tasks, 10,
                    TimeUnit.SECONDS);
            for (Future<String> result : results) {
                try {
                    System.out.println(result.get());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }

}
