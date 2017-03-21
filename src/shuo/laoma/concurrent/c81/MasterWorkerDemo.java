package shuo.laoma.concurrent.c81;

import java.util.concurrent.CountDownLatch;

public class MasterWorkerDemo {

    static class Worker extends Thread {
        CountDownLatch latch;

        public Worker(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                // simulate working on task
                Thread.sleep((int) (Math.random() * 1000));

                // simulate exception
                if (Math.random() < 0.02) {
                    throw new RuntimeException("bad luck");
                }
            } catch (InterruptedException e) {
            } finally {
                this.latch.countDown();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int workerNum = 100;
        CountDownLatch latch = new CountDownLatch(workerNum);
        Worker[] workers = new Worker[workerNum];
        for (int i = 0; i < workerNum; i++) {
            workers[i] = new Worker(latch);
            workers[i].start();
        }
        latch.await();
        System.out.println("collect worker results");
    }

}
