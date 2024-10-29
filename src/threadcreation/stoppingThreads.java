package threadcreation;

public class stoppingThreads {

    public static class StoppingThread implements Runnable {
        private boolean stopRequest = false;

        public synchronized void requestStop() {
            this.stopRequest = true;
        }

        public synchronized boolean isStopRequest() {
            return this.stopRequest;
        }

        private void sleep(long millis) {
            try {
                Thread.sleep(millis);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            System.out.println("Running stopping thread");

            while (!isStopRequest()) {
                sleep(1000);
                System.out.println("...");
            }

            System.out.println("Stopped thread");
        }
    }

    public static void main(String[] args) {
        StoppingThread stoppingThread = new StoppingThread();
        Thread thread = new Thread(stoppingThread);
        thread.start();

        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("before stop request");
        stoppingThread.requestStop();
        System.out.println("after stop request");
    }

}
