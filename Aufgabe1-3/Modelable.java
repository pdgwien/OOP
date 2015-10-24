/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public interface Modelable {
    /**
     * returns how much a tree should grow in one year in m^3
     * @param age age of the tree
     * @return growth
     */
    double getGrowth(int age);

    /**
     * returns how much of a tree dies off in one year in m^3
     * @param age
     * @return
     */
    double getLoss(int age);

    /**
     * returns percentage of how much dead wood rots in one year
     * @param age
     * @return
     */
    double getDeadRot(int age);

    /**
     * returns how much wood is harvested in one year in m^3
     * @param age
     * @return
     */
    double getHarvest(int age);

    /**
     * returns percentage of how much harvested wood rots or is burned in one year
     * @param age
     * @return
     */
    double getHarvestedRot(int age);

}
