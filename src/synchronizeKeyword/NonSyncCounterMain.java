package synchronizeKeyword;

public class NonSyncCounterMain {

    public static void main(String[] args) {
        NonSyncCounter nonSyncCounter = new NonSyncCounter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                nonSyncCounter.incCounter();
            }
            System.out.println(nonSyncCounter.getCounter());
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                nonSyncCounter.incCounter();
            }
            System.out.println(nonSyncCounter.getCounter());
        }, "thread2");

        thread1.start();
        thread2.start();
    }

}
