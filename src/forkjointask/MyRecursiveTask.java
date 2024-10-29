package forkjointask;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Long> {

    private long workload = 0;

    public MyRecursiveTask(long workload) {
        this.workload = workload;
    }

    @Override
    protected Long compute() {
        if (this.workload > 16) {
            System.out.println("splitting workdload: " + this.workload);

            long workload1 = this.workload / 2;
            long workload2 = this.workload - workload1;

            MyRecursiveTask left = new MyRecursiveTask(workload1);
            MyRecursiveTask right = new MyRecursiveTask(workload2);

            left.fork();
            right.fork();

            long result = 0;
            result += left.join();
            result += right.join();
            return result;

        } else {
            System.out.println("doing work itself: " + this.workload);
            return this.workload * 3;
        }
    }

}

