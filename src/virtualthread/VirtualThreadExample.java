package virtualthread;

import java.util.ArrayList;
import java.util.List;

public class VirtualThreadExample {

    public static void main(String[] args) {

        List<Thread> vThreads = new ArrayList<Thread>();

        int vThread_Count = 1000000;

        for (int i = 0; i < vThread_Count; i++) {
            int vThreadIndex = i;
            Thread vThread = Thread.ofVirtual().start(() -> {
                int result = 1;
                for (int j = 0; j < 10; j++) {
                    result *= (j + 1);
                }
                System.out.println("Result[" + vThreadIndex + "]: " + result);
            });
            vThreads.add(vThread);
        }

        for(int i = 0; i < vThreads.size(); i++) {
            try {
                vThreads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
