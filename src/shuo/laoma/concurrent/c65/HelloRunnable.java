package shuo.laoma.concurrent.c65;

public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("hello");
    }
    
    public static void main(String[] args) {
        Thread helloThread = new Thread(new HelloRunnable());
        helloThread.start();
    }
}    