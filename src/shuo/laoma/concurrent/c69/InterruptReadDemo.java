package shuo.laoma.concurrent.c69;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class InterruptReadDemo {
    private static class A extends Thread {
    	private Reader in=new StringReader("li yu bin up !!!");
    	
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println(in.read());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("exit");
        }

        public void cancel() {
            try {
                in.close();
            } catch (IOException e) {
            }
            interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        A t = new A();
        t.start();
        Thread.sleep(100);
        t.cancel();
    }
}
