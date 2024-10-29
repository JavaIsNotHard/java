package executorservice;

import java.util.concurrent.*;

public class ExectorServiceExample3 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future future = executorService.submit(myCallable("task 1"));

        System.out.println(future.isDone());

        try {
            String result = (String) future.get();
            System.out.println(result);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(future.isDone());

        executorService.shutdown();
    }

    public static Callable myCallable(String msg) {
        return new Callable() {
            @Override
            public Object call() throws Exception {
                String returnMsg = Thread.currentThread().getName() + ":" + msg;
                return returnMsg;
            }
        };
    }

}
