package shuo.laoma.file.c61;

import java.io.IOException;
import java.util.Random;

public class Producer {
	
    public static void main(String[] args) throws InterruptedException {
        try {
            BasicQueue queue = new BasicQueue("./", "task");
            int i = 0;
            Random rnd = new Random();
            while (true) {
                String msg = new String("task " + (i++));
                queue.enqueue(msg.getBytes("UTF-8"));
                System.out.println("produce: " + msg);
                Thread.sleep(rnd.nextInt(1000));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}