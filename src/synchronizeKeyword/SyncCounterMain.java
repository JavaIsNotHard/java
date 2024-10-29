package synchronizeKeyword;

public class SyncCounterMain {

    public static void main(String[] args) {
        SyncCounter counter = new SyncCounter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.incCounter();
            }
            System.out.println(counter.getCounter());
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.incCounter();
            }
            System.out.println(counter.getCounter());
        }, "thread2");

        thread1.start();
        thread2.start();
    }

}
