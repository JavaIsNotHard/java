package executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExectorServiceExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(myRunnable("Task 1"));
        executorService.execute(myRunnable("Task 2"));
        executorService.execute(myRunnable("Task 3"));

        executorService.shutdown();
    }

    private static Runnable myRunnable(String msg) {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + msg);
            }
        };
    }

}
