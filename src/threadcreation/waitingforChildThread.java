package threadcreation;

public class waitingforChildThread {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++){
                sleep(1000);
                System.out.println("Running new thread");
            }
        };

        Thread thread = new Thread(runnable);
        // run the new thread as daemon thread which does not prevent the
        // JVM from exiting after the main thread has completed
        thread.setDaemon(true);
        thread.start();

        try {
            // wait for the child thread to complete before resuming the main thread
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting main thread");
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
