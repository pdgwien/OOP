/**
 * @author Harald Bernhard <e1054776@student.tuwien.ac.at>
 */

public class ExtendedModel implements Modelable{

    @Override
    public double getGrowth(int age) {
        return 0.1*ageFactor(age);
    }

    @Override
    public double getLoss(int age) {
        return 0.01*ageFactor(age);
    }

    @Override
    public double getDeadRot(int age) {
        return 0.2*ageFactor(age);
    }

    @Override
    public double getHarvest(int age) {
        return 0.05*ageFactor(age);
    }

    @Override
    public double getHarvestedRot(int age) {
        return 0.05*ageFactor(age);
    }

    public double ageFactor(int age){
        if (age <30){
            return 1.5;
        }
        else if (age >30 && age <60){
            return 1.3;
        }
        else return 1;
    }

    @Override
    public short getForestType() {
           return Tree.TREE_TANNE;
    }
}