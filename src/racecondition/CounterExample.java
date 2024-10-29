package racecondition;

public class CounterExample {

    private int counter = 0;

    public int incAndGet() {
        this.counter++;
        return this.counter;
    }

    public int get() {
        return this.counter;
    }

}
