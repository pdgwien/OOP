/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
@Author("Patrick Grosslicht")
public class RechteckSchachtel extends Schachtel {
    private double length;
    private double width;

    public RechteckSchachtel(double innerHeight, double length, double width) {
        super(innerHeight);
        this.length = length;
        this.width = width;
    }

    //Vorbedingung: schachtel != null
    @Author("Patrick Grosslicht")
    @Override
    public boolean canBePutIn(Schachtel schachtel) {
        if (schachtel instanceof RechteckSchachtel) {
            if (schachtel.getHeight() >= this.height && schachtel.getArea() >= this.getArea()) {
                return true;
            }
        }
        return false;
    }

    @Author("Patrick Grosslicht")
    @Override
    public double getArea() {
        return this.length*this.width;
    }
}
