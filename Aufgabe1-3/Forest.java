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

    public Forest(int stock, Modelable modelable, double initialCost) {
        this.trees = new ArrayList<>(stock);
        for (int i = 0; i < stock; i++) {
            this.trees.add(new Tree(modelable, initialCost));
        }
        this.aliveMass = stock;
        this.totalCost = initialCost * stock;
    }



    public void tick() {
        this.aliveMass = 0.0;
        //this.deadMass = 0.0;
        //this.deadRottenMass = 0.0;
        this.harvestedMass = 0.0;
        //this.harvestedRottenMass = 0.0;
        this.totalCost = 0.0;
        for (Tree tree : this.trees) {
            TickResult result = tree.tick();
            this.aliveMass += result.getAliveMass();
            this.deadMass += result.getDeadMass();
            this.deadRottenMass += result.getDeadRottenMass();
            this.harvestedMass += result.getHarvestedMass();
            this.harvestedRottenMass += result.getHarvestedRottenMass();
            this.totalCost += result.getTotalCost();
            this.proceed += result.getProceed();
        }
        this.profit = this.proceed - this.totalCost;

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

    public double getProceed(){
        return this.proceed;
    }
    public double getProfit(){
        return this.profit;
    }

}
