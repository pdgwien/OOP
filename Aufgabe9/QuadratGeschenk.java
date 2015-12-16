/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
@Author("Patrick Grosslicht")
public class QuadratGeschenk extends Geschenk {
    private double side;

    public QuadratGeschenk(double height, String name, double side) {
        super(height, name);
        this.side = side;
    }

    //Vorbedingung: schachtel != null
    @Author("Patrick Grosslicht")
    @Override
    public boolean canBePutIn(Schachtel schachtel) {
        if (schachtel instanceof QuadratSchachtel) {
            if (schachtel.getHeight() >= this.height && schachtel.getArea() >= this.getArea()) {
                return true;
            }
        }
        return false;
    }

    @Override
    @Author("Patrick Grosslicht")
    public double getArea() {
        return Math.pow(side, 2);
    }
}
