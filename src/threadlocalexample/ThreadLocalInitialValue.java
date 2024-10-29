package threadlocalexample;

public class ThreadLocalInitialValue {

    public static void main(String[] args) {
        ThreadLocal<MyObject> threadLocal = new ThreadLocal<>() {
            @Override
            protected MyObject initialValue() {
                return new MyObject();
            }
        };

        ThreadLocal<MyObject> threadLocal1 = ThreadLocal.withInitial(() -> {
            return new MyObject();
        });

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread1's threadlocal value is = " + threadLocal.get());
            System.out.println("Thread1's threadlocal value is = " + threadLocal1.get());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread2's threadlocal value is = " + threadLocal.get());
            System.out.println("Thread2's threadlocal value is = " + threadLocal1.get());
        });

        // even though we access the same get method in both threads, the threadLocal created different instances of MyObject
        // for different threads

        thread1.start();
        thread2.start();
    }

}
