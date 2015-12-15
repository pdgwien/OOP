import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public class Wald {
    //Invariante: 0 < cols
    private final int cols;
    //Invariante: 0 < rows
    private final int rows;
    //Invariante: felder != null
    private Feld[][] felder;
    private List<BuchdruckerKolonie> colony = new CopyOnWriteArrayList<>();
    private List<Thread> colonyThreads = new CopyOnWriteArrayList<>();
    private boolean running = true;
    //Invariante: name != null
    private String name;

    public Wald(int cols, int rows, String name) {
        this.cols = cols;
        this.rows = rows;
        this.name = name;
        this.felder = new Feld[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                this.felder[i][j] = new Feld(i, j);
            }
        }
    }
    //Nachbedingung: 0 < cols
    //Nachbedingung: 0 < rows
    //Nachbedingung: felder != null
    //Nachbedingung: name != null

    //Vorbedingung: 0 < cols
    //Vorbedingung: 0 < rows
    //Vorbedingung: felder != null
    public List<Feld> getNeighbors(int x, int y) {
        List<Feld> neighbors = new ArrayList<>();
        for (int xx = -1; xx <= 1; xx++) {
            for (int yy = -1; yy <= 1; yy++) {
                if (xx == 0 && yy == 0) {
                    continue;
                }
                if (isOnMap(x + xx, y + yy)) {
                    neighbors.add(this.felder[x + xx][y + yy]);
                }
            }
        }
        return neighbors;
    }

    //Vorbedingung: colony != null
    public int livingColonies() {
        return this.colony.size();
    }
    //Nachbedingung: colony unverändert

    //Vorbedingung: 0 < x < rows
    //Vorbedingung: 0 < y < rows
    //Vorbedingung: felder != null
    public Feld getField(int x, int y) {
        if (isOnMap(x, y)) {
            return this.felder[x][y];
        }
        return null;
    }
    //Nachbedingung: felder unverändert

    //Vorbedingung: 0 < x < rows
    //Vorbedingung: 0 < y < rows
    //Vorbedingung: felder != null
    @Override
    public String toString() {
        if (!this.running) {
            return null;
        }
        String output = name + ": ";
        synchronized (this) {
            for (Feld[] rows : this.felder) {
                for (Feld feld : rows) {
                    if (feld.isEmpty()) {
                        output += " ";
                    } else {
                        if (feld.getBuchdruckerKolonie().isHealthy()) {
                            output += "o";
                        } else {
                            output += "x";
                        }
                    }
                }
                output += "\n" + name + ": ";
            }
        }
        return output + "\n";
    }
    //Nachbedingung: felder unverändert

    //Vorbedingung: 0 < x < rows
    //Vorbedingung: 0 < y < rows
    private boolean isOnMap(int x, int y) {
        return x >= 0 && y >= 0 && x < this.cols && y < this.rows;
    }

    //Vorbedingung: colony != null
    public void addColony(BuchdruckerKolonie buchdruckerKolonie) {
        this.colony.add(buchdruckerKolonie);
    }

    //Vorbedingung: colonyThreads != null
    public void addColonyThread(Thread thread) {
        this.colonyThreads.add(thread);
    }

    //Vorbedingung: colony != null
    public void removeColony(BuchdruckerKolonie buchdruckerKolonie) {
        this.colony.remove(buchdruckerKolonie);
    }


    public void start() {
        for (BuchdruckerKolonie buchdrucker: this.colony) {
            Thread thread = new Thread(buchdrucker);
            colonyThreads.add(thread);
            thread.start();
        }
    }

    public void stop() {
        this.running = false;
        for (Thread thread: this.colonyThreads) {
            thread.interrupt();
        }
        for (BuchdruckerKolonie buchdrucker: this.colony) {
            System.out.printf("Colony at %d|%d in %s: %d multiplications%n", buchdrucker.getField().getX(), buchdrucker.getField().getY(), this.name, buchdrucker.getCounter());
        }
    }
}
