package threadpool;

import java.util.concurrent.BlockingDeque;

public class PollThreadRunnable {

    private Thread thread = null;
    private BlockingDeque<Runnable> taskQueue = null;
    private Boolean isStopped = false;

    public PollThreadRunnable(BlockingDeque<Runnable> queue) {
        this.taskQueue = queue;
    }

    public void run() {

    }
}
