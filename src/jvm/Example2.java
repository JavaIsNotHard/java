package jvm;

public class Example2 {

    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        Runnable runnable = new MyRunnable(myObject);

        Thread thread1 = new Thread(runnable, "my thread1");
        Thread thread2 = new Thread(runnable, "my thread2");

        thread1.start();
        thread2.start();
    }

}
