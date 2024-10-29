package javavolatile;

public class Counter {

    private volatile int count = 0;

    public boolean increment() {
        if (count == 10) {
            return false;
        }
        this.count++;
        return true;
    }

}
