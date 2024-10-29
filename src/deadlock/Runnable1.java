package deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runnable1 implements Runnable {

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public Runnable1(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " Attempting to acquire lock1");
        lock1.lock();
        System.out.println(threadName + " Acquired lock1");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(threadName + " Attempting to acquire lock2");
        lock2.lock();
        System.out.println(threadName + " Acquired lock2");

        System.out.println(threadName + " Unlocking lock 1");
        lock1.unlock();

        System.out.println(threadName + " Unlocking lock 2");
        lock2.unlock();
    }

}
