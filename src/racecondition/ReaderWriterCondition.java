package racecondition;

// in this example we do not have a race condition because we do not have two threads
// modifying a shared data without any synchronization
public class ReaderWriterCondition {

    public static void main(String[] args) {
        CounterExample counter = new CounterExample();

        Thread thread1 = new Thread(WriterRunnable(counter, "Thread1 final count = "));
        Thread thread2 = new Thread(ReaderRunnable(counter, "Thread2 count = "));

        thread2.start();
        thread1.start();
    }

    public static Runnable WriterRunnable(CounterExample counter, String message) {
       return () -> {
           for (int i = 0; i < 1_000_000; i++) {
               counter.incAndGet();
           }
           System.out.println(message + counter.get());
       };
    }

    public static Runnable ReaderRunnable(CounterExample counter, String message) {
        return () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(message + counter.get());
            }
        };
    }

}
