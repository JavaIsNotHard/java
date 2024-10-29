package forkjointask;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinExample {

    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        ForkJoinPool pool2 = new ForkJoinPool(4);

        MyRecursiveAction recursiveAction = new MyRecursiveAction(123);
        pool.invoke(recursiveAction);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
