import java.util.ArrayList;
import java.util.List;

/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
@Author("Patrick Grosslicht")
public class Einkaufstasche {
    private List<Gegenstand> things;

    public Einkaufstasche() {
        this.things = new ArrayList<>();
    }

    @Author("Patrick Grosslicht")
    public double volumen() {
        return this.things.stream().filter(t -> t instanceof Schachtel).mapToDouble(Gegenstand::volumen).sum();
    }

    @Author("Patrick Grosslicht")
    public void inhalt() {
        for (Gegenstand thing: this.things) {
            if (thing instanceof Geschenk) {
                System.out.printf("%s%n", ((Geschenk) thing).getName());
            } else if (thing instanceof Schachtel) {
                System.out.printf("%s%n", ((Schachtel) thing).getInnerMostGift().getName());
            }
        }
    }

    public void buy(Geschenk gift, Schachtellager lager) {
        this.add(lager.verpacke(gift));

    }

    @Author("Patrick Grosslicht")
    public void add(Gegenstand thing) {
        this.things.add(thing);
    }
}
