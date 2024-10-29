package racecondition;

public class RaceConditionExample {

    public static void main(String[] args) {
        CounterExample counter = new CounterExample();

        Thread thread1 = new Thread(getRunnable(counter, "Thread1 final counter = "));
        Thread thread2 = new Thread(getRunnable(counter, "Thread2 final counter = "));

        thread1.start();
        thread2.start();
    }

    public static Runnable getRunnable(CounterExample counter, String message) {
        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.incAndGet();
            }
            System.out.println(message + counter.get());
        };
    }

}
