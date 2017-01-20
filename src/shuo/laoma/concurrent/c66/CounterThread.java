package shuo.laoma.concurrent.c66;

public class CounterThread extends Thread {
    Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 10));
        } catch (InterruptedException e) {
        }
        counter.incr();
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 100;
        Counter counter = new Counter();
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new CounterThread(counter);
            threads[i].start();
        }
        for (int i = 0; i < num; i++) {
            threads[i].join();
        }
        System.out.println(counter.getCount());
    }
}