package executorservice;

import java.util.concurrent.*;

public class ExecutorServiceExample2 {

    public static void main(String[] args) {
        int corePoolSize = 10;  // no of starting threads in the thread pool
        int maxPoolSize  = 20;  // if more task are placed in the queue then we can increase the size of threads to 20
        long keepAliveTime  = 3000;

        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(128)
        );

        // creates 3 threads in the thread pool
        ExecutorService threadPoolExecutor2 = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
    }

}
