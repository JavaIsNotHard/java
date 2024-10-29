package threadlocalexample;

public class InheritableLocalThreadExample {

    public static void main(String[] args) {
        ThreadLocal<String> threadlocal = new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        Thread thread1 = new Thread(() -> {
            System.out.println("===== Thread 1 =====");
            threadlocal.set("Thread1");
            inheritableThreadLocal.set("Thread1 inheritable");

            System.out.println(threadlocal.get());
            System.out.println(inheritableThreadLocal.get());

            Thread childThread = new Thread(() -> {
                System.out.println(" ==== Child thread ====");
                System.out.println(
                        threadlocal.get()
                );
                System.out.println(inheritableThreadLocal.get());
            });
            childThread.start();
        });

        thread1.start();
    }

}
