/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
@Author("Patrick Grosslicht")
public class SechseckGeschenk extends Geschenk {
    private double side;

    public SechseckGeschenk(double height, String name, double side) {
        super(height, name);
        this.side = side;
    }

    //Vorbedingung: schachtel != null
    @Author("Patrick Grosslicht")
    @Override
    public boolean canBePutIn(Schachtel schachtel) {
        if (schachtel instanceof SechseckSchachtel || schachtel instanceof KreisSchachtel || schachtel instanceof RechteckSchachtel) {
            if (schachtel.getHeight() >= this.height && schachtel.getArea() >= this.getArea()) {
                return true;
            }
        }
        return false;
    }

    @Author("Patrick Grosslicht")
    @Override
    public double getArea() {
        return 1.5 * Math.pow(this.side, 2) * Math.sqrt(3);
    }
}
