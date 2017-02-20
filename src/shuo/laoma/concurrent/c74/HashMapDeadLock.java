package shuo.laoma.concurrent.c74;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HashMapDeadLock {

	public static void unsafeConcurrentUpdate() {
	    final Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < 100; i++) {
	        Thread t = new Thread() {
	            Random rnd = new Random();

	            @Override
	            public void run() {
	                for (int i = 0; i < 100; i++) {
	                    map.put(rnd.nextInt(), 1);
	                }
	            }
	        };
	        t.start();
	    }
	}    
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		unsafeConcurrentUpdate();

	}

}
