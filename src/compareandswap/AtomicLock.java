package compareandswap;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicLock {

    private AtomicBoolean locked = new AtomicBoolean(false);

    public void unlock() {
        this.locked.set(false);
    }

    public void lock() {
        while(!this.locked.compareAndSet(false, true)) {
            // busy wait other threads]
            [poiuytrdsa]
        }
        this.locked.set(true);
    }

}
