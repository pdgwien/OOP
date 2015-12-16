/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
@Author("Patrick Grosslicht")
public class KreisSchachtel extends Schachtel {
    private double diameter;

    public KreisSchachtel(double innerHeight, double diameter) {
        super(innerHeight);
        this.diameter = diameter;
    }

    @Author("Patrick Grosslicht")
    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.diameter/2, 2);
    }

    //Vorbedingung: schachtel != null
    @Author("Patrick Grosslicht")
    @Override
    public boolean canBePutIn(Schachtel schachtel) {
        if (schachtel instanceof KreisSchachtel || schachtel instanceof SechseckSchachtel || schachtel instanceof QuadratSchachtel) {
            if (schachtel.getHeight() >= this.height && schachtel.getArea() >= this.getArea()) {
                return true;
            }
        }
        return false;
    }
}
