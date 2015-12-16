/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
@Author("Patrick Grosslicht")
public class KreisGeschenk extends Geschenk {
    private double diameter;

    KreisGeschenk(double height, String name, double diameter) {
        super(height, name);
        this.diameter = diameter;
    }

    //Vorbedingung: schachtel != null
    @Override
    public boolean canBePutIn(Schachtel schachtel) {
        if (schachtel instanceof KreisSchachtel || schachtel instanceof SechseckSchachtel || schachtel instanceof QuadratSchachtel) {
            if (schachtel.getHeight() >= this.height && schachtel.getArea() >= this.getArea()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.diameter/2, 2);
    }
}
