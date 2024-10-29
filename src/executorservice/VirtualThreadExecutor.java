package executorservice;

import java.util.concurrent.*;

public class VirtualThreadExecutor {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

        Future future = executorService.submit(MyCallable());

        try {
            System.out.println(future.get()); // this is the blocking statement
            System.out.println("Hello World"); // this instruction is blocked for 3 seconds
            // why is this blocking the main thread?
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();



    }

    public static Callable MyCallable() {
        return new Callable() {
            @Override
            public Object call() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Hello, World";
            }
        };
    }

}
