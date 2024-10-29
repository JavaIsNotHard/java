package executorservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class ExectorServiceExample5 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Callable<String>> callables = new ArrayList<>();
        callables.add(myCallable("task1"));
        callables.add(myCallable("task2"));
        callables.add(myCallable("task3"));

        try {
            List<Future<String>> results = executorService.invokeAll(callables);
            for (Future<String> result : results) {
                System.out.println(result.get());
            }
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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

