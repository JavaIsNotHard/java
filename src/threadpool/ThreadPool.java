package threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

public class ThreadPool {

    private BlockingDeque<Runnable> taskQueue = null;
    private List<PollThreadRunnable> runnables = new ArrayList<>();
    private Boolean isStopped = false;

}
