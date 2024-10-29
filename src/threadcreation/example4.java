package threadcreation;

public class example4 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Running a new thread");
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

}
