package locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                lockSleepUnlock(lock, 1000);
            }
        };

        Thread thread1 = new Thread(runnable, "thread 1");
        Thread thread2 = new Thread(runnable, "thread 2");
        Thread thread3 = new Thread(runnable, "thread 3");

        thread3.start();
        thread1.start();
        thread2.start();
    }

    public static void lockSleepUnlock(Lock lock, int time) {
        try {
            lock.lock();
            printThreadMsg(" holds the lock.");
            sleep(time);
        } finally {
            lock.unlock();
        }
    }

    private static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printThreadMsg(String s) {
        System.out.println(Thread.currentThread().getName() + s);
    }

}
