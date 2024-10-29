package synchronizeKeyword;

// for a single instance of MultipleMonitorObject class we can have two threads
// executing the incCounter1 and incCounter2 methods at the same time.
public class MultipleMonitorObject {

    private final Object monitor1 = new Object();
    private final Object monitor2 = new Object();

    private int counter1 = 0;
    private int counter2 = 0;

    public void incCounter1() {
        synchronized (this.monitor1) {
            this.counter1++;
        }
    }

    public void incCounter2() {
        synchronized (this.monitor2) {
            this.counter2++;
        }
    }

}
