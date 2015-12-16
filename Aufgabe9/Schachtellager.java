import java.util.ArrayList;
import java.util.List;

/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
@Author("Patrick Grosslicht")
public class Schachtellager {
    private List<Schachtel> boxes;

    public Schachtellager() {
        this.boxes = new ArrayList<>();
    }

    @Author("Patrick Grosslicht")
    public void add(Schachtel box) {
        this.boxes.add(box);
    }

    @Author("Patrick Grosslicht")
    public Gegenstand verpacke(Gegenstand gegenstand) {
        for (Schachtel schachtel : this.boxes) {
            if (gegenstand.canBePutIn(schachtel)) {
                schachtel.putIn(gegenstand);
                this.boxes.remove(schachtel);
                return schachtel;
            }
        }
        return gegenstand;
    }
}
