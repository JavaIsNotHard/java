package threadcreation;

public class example6 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " started running");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(threadName + " finished running");
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

}
