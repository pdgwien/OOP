/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public class DefaultModel {

    /**
     * returns how much a tree should grow in one year in m^3
     *
     * @param age age of the tree
     * @return growth
     */
    public double getGrowth(int age) {
        return 0.1;
    }

    /**
     * returns how much of a tree dies off in one year in m^3
     *
     * @param age
     * @return
     */
    public double getLoss(int age) {
        return 0.01;
    }

    /**
     * returns percentage of how much dead wood rots in one year
     *
     * @param age
     * @return
     */
    public double getDeadRot(int age) {
        return 0.2;
    }

    /**
     * returns how much wood is harvested in one year in m^3
     *
     * @param age
     * @return
     */
    public double getHarvest(int age) {
        return 0.05;
    }

    /**
     * returns percentage of how much harvested wood rots or is burned in one year
     *
     * @param age
     * @return
     */
    public double getHarvestedRot(int age) {
        return 0.05;
    }
}
