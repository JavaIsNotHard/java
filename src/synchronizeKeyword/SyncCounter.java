package synchronizeKeyword;

public class SyncCounter {

    private long counter = 0;

    public void incCounter() {
        synchronized (this) {
            this.counter++;
        }
    }

    public long getCounter() {
        synchronized (this) {
            return this.counter;
        }
    }

}

