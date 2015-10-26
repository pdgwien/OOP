/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public class Tree {
    private int age = 0;
    private double totalCost;
    private double proceed;
    private double aliveMass = 1.0;
    private double deadMass = 0.0;
    private double deadRottenMass = 0.0;
    private double harvestedMass = 0.0;
    private double harvestedRottenMass = 0.0;



    private Modelable growthModel;

    public Tree(Modelable modelable, double initialCost) {
        this.growthModel = modelable;
        this.totalCost = initialCost;
    }

    /**
     * ages this tree one year
     */

    public TickResult tick() {

        double harvestedRottingMass = this.harvestedMass * (this.growthModel.getHarvestedRot(age) * this.getHarvestedRot());
        this.harvestedRottenMass = harvestedRottingMass;
        double harvestingMass = this.growthModel.getHarvest(age) * this.getHarvest();
        this.harvestedMass += harvestingMass;
        this.harvestedMass -= harvestedRottingMass;
        double deadRottingMass = this.deadMass * (this.growthModel.getDeadRot(age) * this.getDeadRot());
        this.deadRottenMass = deadRottingMass;
        double dyingMass = this.growthModel.getLoss(age) * this.getLoss();
        this.deadMass += dyingMass;
        this.deadMass -= deadRottingMass;

        this.aliveMass += this.growthModel.getGrowth(age) * this.getGrowth();
        this.aliveMass -= dyingMass + harvestingMass;

        this.totalCost += this.getMaintainanceCost();
        this.totalCost -= this.getRetailPrice() * harvestingMass;

        this.proceed += this.getRetailPrice() * harvestingMass;

        this.age++;
        return new TickResult(this.aliveMass, this.deadMass, this.deadRottenMass, this.harvestedMass, this.harvestedRottenMass, this.totalCost, this.proceed);
    }

    /**
     * tree specific growth factor
     *
     * @return
     */
    private double getGrowth() {
        return 1.0;
    }

    /**
     * tree specific loss factor
     * @return
     */
    private double getLoss() {
        return 1.0;
    }

    /**
     * tree specific dead rotting factor
     * @return
     */
    private double getDeadRot() {
        return 1.0;
    }

    /**
     * tree specific harvest factor
     * @return
     */
    private double getHarvest() {
        return 1.0;
    }

    /**
     * tree specific harvested rotting factor
     * @return
     */
    private double getHarvestedRot() {
        return 1.0;
    }

    /**
     * costs for maintainance of the tree per year
     * @return
     */
    private double getMaintainanceCost() {
        return 1.0;
    }

    /**
     * retail price for 1 m³ of wood
     * @return
     */
    private double getRetailPrice(){
        return 15.0;
    }

    public double getAliveMass() {
        return this.aliveMass;
    }

    public double getBoundCO2() {
        return this.aliveMass + this.deadMass + this.harvestedMass;
    }

    public double getDeadMass() {
        return this.deadMass;
    }

    public double getDeadRottenMass() {
        return this.deadRottenMass;
    }

    public double getHarvestedMass() {
        return this.harvestedMass;
    }

    public double getHarvestedRottenMass() {
        return this.harvestedRottenMass;
    }

}
