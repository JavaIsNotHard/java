package threadcreation;

public class example2 {

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Running a new thread");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }

}
