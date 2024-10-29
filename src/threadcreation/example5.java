package threadcreation;

public class example5 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Running a new thread");
        };

        Thread thread = new Thread(runnable, "My Thread 1");
        thread.start();
        System.out.println(thread.getName());

        Thread thread1 = new Thread(runnable, "My Thread 2");
        thread1.start();
        System.out.println(thread1.getName());
    }

}
