/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public class LeafTree extends Tree {

    public LeafTree(Modelable modelable, double initialCost) {
        super(modelable, initialCost);
    }

    @Override
    protected double getGrowth() {
        return 2.0;
    }

    @Override
    protected double getLoss() {
        return 0.5;
    }

    @Override
    protected double getDeadRot() {
        return 0.5;
    }

    @Override
    protected double getHarvest() {
        return 0.5;
    }

    @Override
    protected double getHarvestedRot() {
        return 0.5;
    }

    @Override
    protected double getErholungsWert() {
        return 0.1;
    }

    @Override
    protected double getMaintainanceCost() {
        return 5.0;
    }

    @Override
    protected double getRetailPrice() {
        return 100;
    }
}
