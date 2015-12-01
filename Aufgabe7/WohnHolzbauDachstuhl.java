/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public class WohnHolzbauDachstuhl extends Dachstuhl {
    public WohnHolzbauDachstuhl(String name, double length) {
        super(name, length);
    }

    @Override
    public boolean isValidWood(RundholzGehobelt wood) {
        return wood.getLength() >= this.getLength();
    }
}
