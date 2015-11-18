/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public class Baurundholz extends Bauholz {
    private int diameter;

    public Baurundholz(int length, int diameter) {
        super(length);
        this.diameter = diameter;
    }

    @Override
    public double festmeter() {
        return Math.PI * this.length * Math.pow(this.diameter, 2);
    }

    public String output() {
        return String.format("%s, diameter: %d", super.toString(), this.diameter);
    }
}
