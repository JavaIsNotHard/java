package jvm;

public class MyRunnable implements Runnable {

    private int count = 0;
    private MyObject myObject;

    MyRunnable(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        // MyObject myObject = new MyObject();
        System.out.println(myObject);
        for (int i = 0; i < 1_000_000; i++) {
            this.count++;
        }
        System.out.println(Thread.currentThread().getName() + " : " + this.count);
    }

}
