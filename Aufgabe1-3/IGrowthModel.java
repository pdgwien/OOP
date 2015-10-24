/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public interface IGrowthModel {
    /**
     * returns how much a tree should grow in one year in m^3
     * @param age age of the tree
     * @return growth
     */
    public double getGrowth(int age);
}
