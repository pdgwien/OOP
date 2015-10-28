import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public class Forest {
    private List<Tree> trees;
    private double aliveMass;
    private double deadMass;
    private double deadRottenMass;
    private double harvestedMass;
    private double harvestedRottenMass;
    private double totalCost;
    private double proceed;
    private double profit;
    private double erholungsWert;
    private double endprofit;

    public Forest(Constructor<? extends Tree> treeConstructor, int stock, Modelable modelable, double initialCost) {
        this.trees = new ArrayList<>(stock);
        for (int i = 0; i < stock; i++) {
            try {
                this.trees.add(treeConstructor.newInstance(new Object[]{modelable, initialCost}));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        this.aliveMass = stock;
        this.totalCost = initialCost * stock;
    }

    public void tick() {
        this.aliveMass = 0.0;
        this.harvestedMass = 0.0;
        this.totalCost = 0.0;
        this.proceed = 0.0;
        this.endprofit = 0.0;
        this.erholungsWert = 0.0;
        for (Tree tree : this.trees) {
            TickResult result = tree.tick();
            this.aliveMass += result.getAliveMass();
            this.deadMass += result.getDeadMass();
            this.deadRottenMass += result.getDeadRottenMass();
            this.harvestedMass += result.getHarvestedMass();
            this.harvestedRottenMass += result.getHarvestedRottenMass();
            this.totalCost += result.getTotalCost();
            this.proceed += result.getProceed();
            this.erholungsWert += result.getErholungsWert();
            this.endprofit += result.getEndprofit();
        }
        this.profit = this.proceed - this.totalCost;

        this.endprofit = this.endprofit + this.profit;
    }

    public void clearTrees(int trees) {
        for (int i = 0; i < ((trees >= this.trees.size() - 1) ? this.trees.size() - 1 : trees); i++) {
            this.trees.remove(i);
        }
    }

    public void tick(int years) {
        for (int i = 0; i < years; i++) {
            this.tick();
        }
    }

    public double getAliveMass() {
        return this.aliveMass;
    }

    public double getHarvestedMass() {
        return harvestedMass;
    }

    public double getHarvestedRottenMass() {
        return harvestedRottenMass;
    }

    public double getDeadMass() {
        return deadMass;
    }

    public double getDeadRottenMass() {
        return deadRottenMass;
    }

    public double getBoundCO2() {
        return this.getAliveMass() + this.getDeadMass() + this.getHarvestedMass();
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public double getProceed() {
        return this.proceed;
    }

    public double getProfit() {
        return this.profit;
    }

    public double getErholungsWert() {
        return this.erholungsWert;
    }

    public double getEndprofit() {
        return this.endprofit;
    }
}