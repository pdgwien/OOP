import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BuchdruckerKolonie implements Runnable {
    private static final int MAX_COUNT = 32;
    //Invariante: wald != null
    private Wald wald;
    //Invariante: field != null
    private Feld field;
    //Invariante: 0 <= counter <= MAX_COUNT
    private int counter = 0;
    private boolean healthy = true;
    //Invariante: 0 < colonisationRate
    private int colonisationRate;

    public BuchdruckerKolonie(Wald wald, Feld field, int colonisationRate, int counter) {
        this.wald = wald;
        this.field = field;
        this.counter = counter;
        this.colonisationRate = colonisationRate;
    }
    //Nachbedingung: wald != null
    //Nachbedingung: field != null
    //Nachbedingung: 0 <= counter <= MAX_COUNT
    //Nachbedingung: 0 < colonisationRate

    public BuchdruckerKolonie(Wald wald, Feld field, int colonisationRate) {
        this.wald = wald;
        this.field = field;
        this.colonisationRate = colonisationRate;
    }
    //Nachbedingung: wald != null
    //Nachbedingung: field != null
    //Nachbedingung: 0 < colonisationRate

    private boolean spawn() throws MaxCountReachedException {
        if (this.isHealthy() && this.counter < MAX_COUNT) {
            List<Feld> fields = wald.getNeighbors(field.getX(), field.getY());
            if (!this.acquireLocks(this.field, fields)) {
                return false;
            }
            Collections.shuffle(fields);
            for (Feld f : fields) {
                if (f.isEmpty()) {
                    this.counter++;
                    BuchdruckerKolonie temp = new BuchdruckerKolonie(this.wald, f, this.colonisationRate, this.counter);
                    wald.addColony(temp);
                    f.setBuchdruckerKolonie(temp);
                    Thread thread = new Thread(temp);
                    this.wald.addColonyThread(thread);
                    thread.start();
                    break;
                }
            }
            List<Feld> healthyFields = filterHealthyFields(fields);
            if (healthyFields.size() == 8) {
                this.healthy = false;
            }
            fields.forEach(Feld::unlock);
            field.unlock();
        } else if (this.counter >= MAX_COUNT) {
            throw new MaxCountReachedException();
        }
        return true;
    }

    private boolean infect() throws MaxCountReachedException {
        if (!this.isHealthy()) {
            List<Feld> fields = wald.getNeighbors(field.getX(), field.getY());
            if (!this.acquireLocks(this.field, fields)) {
                return false;
            }
            List<Feld> healthyFields = filterHealthyFields(fields);
            if (healthyFields.size() > 1) {
                Collections.shuffle(healthyFields);
                healthyFields.get(0).getBuchdruckerKolonie().setHealthy(false);
                healthyFields.get(1).getBuchdruckerKolonie().setHealthy(false);
            }
            field.setBuchdruckerKolonie(null);
            this.wald.removeColony(this);
            fields.forEach(Feld::unlock);
            field.unlock();
            if (this.wald.livingColonies() == 0) {
                throw new MaxCountReachedException();
            }
        }
        return true;
    }

    //Vorbedingung: fields != null
    private List<Feld> filterHealthyFields(List<Feld> fields) {
        return fields.stream().filter(f -> !f.isEmpty() && f.getBuchdruckerKolonie().isHealthy()).collect(Collectors.toList());
    }
    //Nachbedingung: fields unveraendert


    public boolean isHealthy() {
        return this.healthy;
    }
    //Nachbedingung: healthy unveraendert

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public int getCounter() {
        return counter;
    }
    //Nachbedingung: counter unveraendert

    public Feld getField() {
        return field;
    }
    //Nachbedingung: field unveraendert

    //Vorbedingung: current != null && neighbors != null
    private boolean acquireLocks(Feld current, List<Feld> neighbors) {
        List<Feld> lockedFields = new ArrayList<>();
        if (this.field.tryLock()) {
            lockedFields.add(this.field);
        } else {
            lockedFields.forEach(Feld::unlock);
            return false;
        }
        for (Feld f : neighbors) {
            if (f.tryLock()) {
                lockedFields.add(f);
            } else {
                lockedFields.forEach(Feld::unlock);
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        Random rand = new Random();
        try {
            Thread.sleep((rand.nextInt(45) + 5) * (colonisationRate/100));
            boolean spawned = false;
            boolean infected = false;
            while (!spawned) {
                spawned = this.spawn();
                Thread.sleep(rand.nextInt(10));
            }
            System.out.println(this.wald);
            while (!infected) {
                infected = this.infect();
                Thread.sleep(rand.nextInt(10));
            }
            System.out.println(this.wald);
        } catch (InterruptedException e) {
            System.out.printf("Colony at %d|%d was interrupted: %d multiplications%n", this.field.getX(), this.field.getY(), this.counter);
        } catch (MaxCountReachedException e) {
            this.wald.stop();
        }
    }
}
