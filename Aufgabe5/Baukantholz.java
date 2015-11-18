/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public class Baukantholz extends Bauholz {
    private int height;
    private int width;

    public Baukantholz(int length, int height, int width) {
        super(length);
        this.height = height;
        this.width = width;
    }

    @Override
    public double festmeter() {
        return this.length * this.height * this.width;
    }

    public String output() {
        return String.format("%s, height: %d, width: %d", super.toString(), this.height, this.width);
    }
}
