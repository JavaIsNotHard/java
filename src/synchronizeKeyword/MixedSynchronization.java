package synchronizeKeyword;

public class MixedSynchronization {

    private static Object object = null;

    // this is synchronized in the MixedSynchronization class monitor
    public static synchronized void setStaticObject(Object o) {
        object = o;
    }

    protected Object obj = null;

    // this is synchronized in the MixedSynchronization instance monitor
    public synchronized void setInstanceObj(Object o) {
        this.obj = o;
    }

    // this means that two threads executing the MixedSynchronization class
    // can execute both setStaticObject and setInstanceObj at the same time
    // because the monitor object for both of them are different

}
