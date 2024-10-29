package threadsignaling;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSignalingExample {

    public static void main(String[] args) {
        Object monitor = new Object();

        AtomicInteger sharedData = new AtomicInteger();

        Thread waitingThread = new Thread(() -> {
            synchronized (monitor) {
                try {
                    System.out.println("Waiting for thread");
                    sharedData.set(10);
                    monitor.wait();
                    System.out.println("After wait call");
                } catch (InterruptedException e) {
                    System.out.println("Thread was interrupted");
                }
            }
        });

        Thread notifyThread = new Thread(() -> {
            synchronized (monitor) {
                System.out.println("inside the notify thread");
                while (sharedData.get() != 10) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Thread was interrupted");
                    }
                }
                monitor.notify();
            }
        });

        notifyThread.start();
        waitingThread.start();
    }

}
