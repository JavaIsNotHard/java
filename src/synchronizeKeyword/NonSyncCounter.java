package synchronizeKeyword;

public class NonSyncCounter {

    private long counter = 0;

    public void incCounter() {
        this.counter++;
    }

    public long getCounter() {
        return this.counter;
    }

}
