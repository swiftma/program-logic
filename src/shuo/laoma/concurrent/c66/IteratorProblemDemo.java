package shuo.laoma.concurrent.c66;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IteratorProblemDemo {

    private static void startModifyThread(final List<String> list) {
        Thread modifyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    list.add("item " + i);
                    try {
                        Thread.sleep((int) (Math.random() * 10));
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        modifyThread.start();
    }

    private static void startIteratorThread(final List<String> list) {
        Thread iteratorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    for (String str : list) {
                    }
                }
            }
        });
        iteratorThread.start();
    }

    public static void main(String[] args) {
        final List<String> list = Collections
                .synchronizedList(new ArrayList<String>());
        startIteratorThread(list);
        startModifyThread(list);
    }
}
