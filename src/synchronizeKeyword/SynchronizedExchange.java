package synchronizeKeyword;

public class SynchronizedExchange {

    private Object object = null;

    public synchronized Object getObject () {
        return this.object;
    }

    public synchronized void setObject (Object object) {
        this.object = object;
    }

    public Object getObj() {
        synchronized (this) {
            return this.object;
        }
    }

    public void setObj(Object obj) {
        synchronized (this) {
            this.object = obj;
        }
    }

}
