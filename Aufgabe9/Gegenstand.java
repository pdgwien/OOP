/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
@Author("Patrick Grosslicht")
public abstract class Gegenstand {
    protected double height;

    @Author("Patrick Grosslicht")
    public Gegenstand(double height) {
        this.height = height;
    }

    @Author("Patrick Grosslicht")
    public abstract double getArea();

    @Author("Patrick Grosslicht")
    public double getHeight() {
        return this.height;
    }

    @Author("Patrick Grosslicht")
    public double volumen() {
        return this.getArea() * this.getHeight();
    }

    @Author("Patrick Grosslicht")
    public abstract boolean canBePutIn(Schachtel schachtel);

    @Author("Patrick Grosslicht")
    public Gegenstand verpacke(Schachtellager lager) {
        return lager.verpacke(this);
    }
}
