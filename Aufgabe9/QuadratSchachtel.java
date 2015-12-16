/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
@Author("Patrick Grosslicht")
public class QuadratSchachtel extends Schachtel {
    private double side;

    public QuadratSchachtel(double innerHeight, double side) {
        super(innerHeight);
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

    @Author("Patrick Grosslicht")
    @Override
    public double getArea() {
        return Math.pow(this.side, 2);
    }
}
