/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public class DefaultModel implements Modelable {

    @Override
    public double getGrowth(int age) {
        return 0.1;
    }

    @Override
    public double getLoss(int age) {
        return 0.01;
    }

    @Override
    public double getDeadRot(int age) {
        return 0.2;
    }

    @Override
    public double getHarvest(int age) {
        return 0.05;
    }

    @Override
    public double getHarvestedRot(int age) {
        return 0.05;
    }

    @Override
    public short getForestType() {
           return Tree.TREE_LAUBBAUM;
    }
}
