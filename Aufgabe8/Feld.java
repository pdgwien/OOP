import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public class Feld {
    private BuchdruckerKolonie buchdruckerKolonie;
    private final int x;
    private final int y;
    private final Lock lock = new ReentrantLock();

    public Feld(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public BuchdruckerKolonie getBuchdruckerKolonie() {
        return buchdruckerKolonie;
    }

    public void setBuchdruckerKolonie(BuchdruckerKolonie buchdruckerKolonie) {
        this.buchdruckerKolonie = buchdruckerKolonie;
    }

    public boolean isEmpty() {
        return this.buchdruckerKolonie == null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean tryLock() {
        return this.lock.tryLock();
    }

    public void unlock() {
        this.lock.unlock();
    }
}
