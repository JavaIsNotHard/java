package racecondition;

public class SyncCounter {

    private int counter = 0;

    public int incAndGet() {
        synchronized (this) {
            this.counter++;
            return this.counter;
        }
    }

    public int get() {
        synchronized (this) {
            return this.counter;
        }
    }

}
