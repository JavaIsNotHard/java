package threadcreation;

public class daemonThread {

    public static void main(String[] args) {
        Runnable runnable = () -> {
           while(true)  {
               sleep(1000);
               System.out.println("Running new thread");
           }
        };

        Thread thread = new Thread(runnable);
        // run the new thread as daemon thread which does not prevent the
        // JVM from exiting after the main thread has completed
        thread.setDaemon(true);
        thread.start();
        sleep(3000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
