/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public class NeedleTree extends Tree {

    public NeedleTree(Modelable modelable, double initialCost) {
        super(modelable, initialCost);
    }

    @Override
    protected double getGrowth() {
        return super.getGrowth();
    }

    @Override
    protected double getLoss() {
        return super.getLoss();
    }

    @Override
    protected double getDeadRot() {
        return super.getDeadRot();
    }

    @Override
    protected double getHarvest() {
        return super.getHarvest();
    }

    @Override
    protected double getHarvestedRot() {
        return super.getHarvestedRot();
    }

    @Override
    protected double getErholungsWert() {
        return 0.2;
    }

    @Override
    protected double getMaintainanceCost() {
        return 10;
    }

    @Override
    protected double getRetailPrice() {
        return 150;
    }
}
