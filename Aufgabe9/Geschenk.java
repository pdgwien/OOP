/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
@Author("Patrick Grosslicht")
public abstract class Geschenk extends Gegenstand {
    protected String name;

    @Author("Patrick Grosslicht")
    Geschenk(double height, String name) {
        super(height);
        this.name = name;
    }

    @Author("Patrick Grosslicht")
    public String getName() {
        return this.name;
    }
}
