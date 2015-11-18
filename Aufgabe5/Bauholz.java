/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public abstract class Bauholz implements Smaller<Bauholz> {
    protected int length;

    public Bauholz(int length) {
        this.length = length;
    }

    public abstract double festmeter();

    @Override
    public boolean smaller(Bauholz a) {
        if (a == null) {
            return false;
        }
        return this.festmeter() < a.festmeter();
    }

    @Override
    public String toString() {
        return String.format("%s, festmeter: %f", super.toString(), festmeter());
    }
}
