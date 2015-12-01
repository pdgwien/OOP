/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public class NutzSteinbauDachstuhl extends Dachstuhl {
    public NutzSteinbauDachstuhl(String name, double length) {
        super(name, length);
    }

    @Override
    public boolean isValidWood(KantholzGehobelt wood) {
        return wood.getLength() >= this.getLength();
    }

    @Override
    public boolean isValidWood(KantholzSaegerauh wood) {
        return wood.getLength() >= this.getLength();
    }
}
