package deadlock;

public class SyncRunnable1 implements Runnable {

    private Object monitor1;
    private Object monitor2;

    public SyncRunnable1(Object monitor1, Object monitor2) {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " attempting to acquire lock 1");
        synchronized (monitor1) {
            System.out.println(threadName + " acquired lock 1");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(threadName + " attempting to aquire lock 2");
            synchronized (monitor2) {
                System.out.println(threadName + " acquired lock 2");

            }
            System.out.println(threadName + " unlocking lock 2");
        }
        System.out.println(threadName + " unlocking lock 1");
    }

}
