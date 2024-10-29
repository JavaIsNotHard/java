package locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample2 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);
        Runnable runnable = () -> {
            tryLock(lock);
        };

        Thread t1 = new Thread(runnable, "thread 1");
        Thread t2 = new Thread(runnable, "thread 2");
        Thread t3 = new Thread(runnable, "thread 3");

        t1.start();
        t2.start();
        t3.start();
    }

    public static void tryLock(Lock lock) {
        try {
            // boolean acquired = lock.tryLock(); // this does not guarantee fairness of thread execution
            boolean acquired = lock.tryLock(1000, TimeUnit.MILLISECONDS);
            if (acquired) {
                printThreadName(" lock acquired");
            } else {
                printThreadName(" lock not acquired");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void printThreadName(String messsage) {
        System.out.println(Thread.currentThread().getName() + messsage);
    }

}
