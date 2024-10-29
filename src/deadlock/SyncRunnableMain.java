package deadlock;

public class SyncRunnableMain {

    public static void main(String[] args) {
        Object monitor1 = new Object();
        Object monitor2 = new Object();

        Runnable runnable1 = new SyncRunnable1(monitor1, monitor2);
        Runnable runnable2 = new SyncRunnable2(monitor1, monitor2);

        Thread thread1 = new Thread(runnable1, "thread 1");
        Thread thread2 = new Thread(runnable2, "thread 2");

        thread1.start();
        thread2.start();
    }

}
