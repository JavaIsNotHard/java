package threadcreation;

public class example1 {

    public static class MyThread extends Thread {
        public void run() {
            System.out.println("Running a new thread " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.setPriority(1);

        Thread thread2 = new MyThread();
        thread2.setPriority(5);

        thread2.start();
        thread.start();
    }


}