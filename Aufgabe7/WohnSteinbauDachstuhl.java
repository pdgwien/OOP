/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public class WohnSteinbauDachstuhl extends Dachstuhl {
    public WohnSteinbauDachstuhl(String name, double length) {
        super(name, length);
    }

    @Override
    protected boolean isValidWood(KantholzGehobelt wood) {
        return wood.getLength() >= this.getLength();
    }
}
