import java.util.ArrayList;

public abstract class Dachstuhl {
    private final String name;
    private final double length;
    private final ArrayList<Bauholz> hoelzer;

    public Dachstuhl(String name, double length) {
        this.name = name;
        this.length = length;
        this.hoelzer = new ArrayList<>();
    }

    public void addFittingWoodFromStorage(Bauholzlager storage) {
        Bauholz bh = storage.get(this);
        if (bh != null) {
            this.hoelzer.add(bh);
        }
    }

    public boolean isValidWood(KantholzGehobelt wood) {
        return false;
    }

    public boolean isValidWood(KantholzSaegerauh wood) {
        return false;
    }

    public boolean isValidWood(RundholzGehobelt wood) {
        return false;
    }

    public boolean isValidWood(RundholzSaegerauh wood) {
        return false;
    }

    public void list() {
        for (Bauholz aHoelzer : this.hoelzer) {
            System.out.println(aHoelzer);
        }
    }

    public int price() {
        return this.hoelzer.stream().mapToInt(Bauholz::getPrice).sum();
    }

    public String getName() {
        return this.name;
    }

    public double getLength() {
        return this.length;
    }
}