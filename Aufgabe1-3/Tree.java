/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public class Tree {
    private int age = 0;
    private double mass = 1.0;
    private IGrowthModel growthModel;

    public Tree(IGrowthModel growthModel) {
        this.growthModel = growthModel;
    }

    /**
     * ages this tree one year
     */
    public void tick() {
        this.age++;
        this.mass += this.growthModel.getGrowth(age) * this.getGrowth();
    }

    /**
     * tree specific growth percentage
     *
     * @return
     */
    private double getGrowth() {
        return 1;
    }

}
