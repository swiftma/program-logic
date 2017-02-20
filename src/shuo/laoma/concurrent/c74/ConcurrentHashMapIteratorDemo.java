package shuo.laoma.concurrent.c74;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapIteratorDemo {
	
    public static void test() {
        final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("a", "abstract");
        map.put("b", "basic");

        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (Entry<String, String> entry : map.entrySet()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(entry.getKey() + "," + entry.getValue());
                }
            }
        };
        t1.start();
        // 确保线程t1启动
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        map.put("c", "call");
    }

    public static void main(String[] args) {
        test();
    }

}
