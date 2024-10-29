package synchronizeKeyword;

public class SharedMonitorObjectMain {

    public static void main(String[] args) {
        Object monitor1 = new Object();

        SharedMonitorObject smo1 = new SharedMonitorObject(monitor1);
        SharedMonitorObject smo2 = new SharedMonitorObject(monitor1);

        // threads executing these instruction are going to be blocking because
        // smo1 and smo2 have the same monitor object monitor1
        smo1.incCounter();
        smo2.incCounter();

        Object monitor2 = new Object();

        SharedMonitorObject smo3 = new SharedMonitorObject(monitor2);
        // this is non-blocking
        smo3.incCounter();
    }

}
