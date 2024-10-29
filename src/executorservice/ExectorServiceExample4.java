package executorservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class ExectorServiceExample4 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<String>> callables = new ArrayList<>();
        callables.add(myCallable("task1"));
        callables.add(myCallable("task2"));
        callables.add(myCallable("task3"));

        try {
            String result = (String) executorService.invokeAny((Collection) callables);
            System.out.println(result);
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
