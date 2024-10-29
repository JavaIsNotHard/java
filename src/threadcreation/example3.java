package threadcreation;

public class example3 {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running a new thread");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

}
