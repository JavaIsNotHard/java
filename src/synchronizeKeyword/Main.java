package synchronizeKeyword;

public class Main {

    public static void main(String[] args) {
        SynchronizedExchange exchange = new SynchronizedExchange();

        Runnable runnable1 = () -> {
            for (int i =0 ; i < 1000; i++) {
                exchange.setObject("" + i);
            }
        };

        Runnable runnable2 = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(exchange.getObject());
            }
        };

        Thread thread1 = new Thread(runnable1, "thread1");
        Thread thread2 = new Thread(runnable2, "thread2");

        thread1.start();
        thread2.start();
    }

}
