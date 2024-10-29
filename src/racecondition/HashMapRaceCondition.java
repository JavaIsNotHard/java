package racecondition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapRaceCondition {

    public static void main(String[] args) {
        Map<String, Integer> sharedMap = new ConcurrentHashMap<>();

        Thread thread1 = new Thread(getRunnable(sharedMap), "thread1");
        Thread thread2 = new Thread(getRunnable(sharedMap), "thread2");

        thread1.start();
        thread2.start();
    }

    public static Runnable getRunnable(Map<String, Integer> sharedMap) {
        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                synchronized (sharedMap) {
                    if (sharedMap.containsKey("key")) {
                        int value = sharedMap.remove("key");
                        System.out.println(value + "By thread " + Thread.currentThread().getName());
//                    if (value == null) {
//                        System.out.println("Iteration : " + i + " Value of key was null");
//                    } else {
//                        System.out.println("Iteration : " + i + " Value of key: " + value);
//                    }
                    } else {
                        System.out.println("value added by thread" + Thread.currentThread().getName());
                        sharedMap.put("key", i);
                    }
                }
            }
        };
    }
}
