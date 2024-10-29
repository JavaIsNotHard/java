package synchronizeKeyword;

public class StaticSynchronizedExchange {

    private static Object object = null;

    public static synchronized Object getObject() {
        return object;
    }

    public static synchronized void setObject(Object obj) {
        object = obj;
    }

    public static Object getObj() {
        synchronized (StaticSynchronizedExchange.class) {
            return object;
        }
    }

    public static void setObj(Object obj) {
        synchronized (StaticSynchronizedExchange.class) {
            object = obj;
        }
    }

}
