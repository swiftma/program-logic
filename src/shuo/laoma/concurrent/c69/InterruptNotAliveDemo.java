package shuo.laoma.concurrent.c69;

public class InterruptNotAliveDemo {
    private static class A extends Thread {
        @Override
        public void run() {
        }
    }

    public static void test() throws InterruptedException {
        A a = new A();
        a.interrupt();
        System.out.println(a.isInterrupted());

        a.start();
        Thread.sleep(100);
        a.interrupt();
        System.out.println(a.isInterrupted());
    }

    public static void main(String[] args) throws InterruptedException {
        test();
    }
}