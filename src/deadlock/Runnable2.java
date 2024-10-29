package deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runnable2 implements Runnable {

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public Runnable2(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " attempting to acquire lock 2");
        lock2.lock();
        System.out.println(threadName + " acquired lock 2");

        System.out.println(threadName + " attempting to acquire lock 1");
        lock1.lock();
        System.out.println(threadName + " acquired lock 1");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(threadName + " unlocking lock 2");
        lock2.unlock();

        System.out.println(threadName + " unlocked lock 1");
        lock1.unlock();
    }
}
