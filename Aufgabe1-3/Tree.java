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
    private double erholungsWert = 0.0;
    private double endprofit = 0.0;

    private Modelable growthModel;

    /**
     * @param Modelable modelable      Ausgangswerte für einen Baum
     * @param double initialCost       Anfangskosten
     */
    public Tree(Modelable modelable, double initialCost) {
        this.growthModel = modelable;
        this.totalCost = initialCost;
    }

    /**
     * Alter des Bauem um ein Jahr inkrementieren und neue Werte abspeichern
     *
     * @return TickResult
     */
    public TickResult tick() {
        // Neuer Wert: Geerntete, verrottete Masse berechnen
        double harvestedRottingMass = this.harvestedMass * (this.growthModel.getHarvestedRot(age) * this.getHarvestedRot());
        // Neuen Wert abspeichern
        this.harvestedRottenMass = harvestedRottingMass;
        // Neuer Wert: Geerntete Masse (lebend) berechnen
        double harvestingMass = this.growthModel.getHarvest(age) * this.getHarvest();
        // Neue, geerntete Masse hinzufügen
        this.harvestedMass += harvestingMass;
        // Neue, geerntete, tote Masse abziehen
        this.harvestedMass -= harvestedRottingMass;
        // Neuer Wert: Tote, verrottete Masse berechnen
        double deadRottingMass = this.deadMass * (this.growthModel.getDeadRot(age) * this.getDeadRot());
        // Neuen Wert abspeichern
        this.deadRottenMass = deadRottingMass;
        // Neuer Wert: Tote Masse berechnen
        double dyingMass = this.growthModel.getLoss(age) * this.getLoss();
        // Neue tote Masse hinzufügen
        this.deadMass += dyingMass;
        // Neue, tote, verrottete Masse abziehen
        this.deadMass -= deadRottingMass;

        // Neue Lebenmasse berechnen
        this.aliveMass += this.growthModel.getGrowth(age) * this.getGrowth();
        // Tote und abgerntete Masse abziehen
        this.aliveMass -= dyingMass + harvestingMass;

        // Neue Kosten für Erhaltung hinzufügen
        this.totalCost += this.getMaintainanceCost();
        // Verkaufspreis und abgeerntete Masse abziehen
        this.totalCost -= this.getRetailPrice() * harvestingMass;

        // Verkaufspreis und abgeerntete Masse zum Erlös hinzufügen
        this.proceed += this.getRetailPrice() * harvestingMass;

        // Erholungswert erhöhen
        this.erholungsWert += this.getErholungsWert();

        // Endprofit berechnen
        this.endprofit += this.getErholungsWert();

        // Alter erhöhen
        this.age++;

        // Alle Daten in einem TickResult speichern und so transportieren
        return new TickResult(this.aliveMass, this.deadMass, this.deadRottenMass, this.harvestedMass, this.harvestedRottenMass, this.totalCost, this.proceed, this.erholungsWert, this.endprofit);
    }

    /**
     * tree specific growth factor
     *
     * @return
     */
    protected double getGrowth() {
        return 1.0;
    }

    /**
     * tree specific loss factor
     *
     * @return
     */
    protected double getLoss() {
        return 1.0;
    }

    /**
     * tree specific dead rotting factor
     *
     * @return
     */
    protected double getDeadRot() {
        return 1.0;
    }

    /**
     * tree specific harvest factor
     *
     * @return
     */
    protected double getHarvest() {
        return 1.0;
    }

    /**
     * tree specific harvested rotting factor
     *
     * @return
     */
    protected double getHarvestedRot() {
        return 1.0;
    }

    protected double getErholungsWert() {
        return 0.01;
    }

    /**
     * costs for maintainance of the tree per year
     *
     * @return
     */
    protected double getMaintainanceCost() {
        return 1.0;
    }

    /**
     * retail price for 1 m³ of wood
     *
     * @return
     */
    protected double getRetailPrice() {
        return 15.0;
    }

    /**
     * Verbliebene Lebensmasse an Holz
     *
     * @return double
     */
    public double getAliveMass() {
        return this.aliveMass;
    }

    /**
     * Gebundenes CO2
     *
     * @return double
     */
    public double getBoundCO2() {
        return this.aliveMass + this.deadMass + this.harvestedMass;
    }

    /**
     * Tote Masse an Holz
     *
     * @return double
     */
    public double getDeadMass() {
        return this.deadMass;
    }

    /**
     * Tote und verrottete Masse an Holz
     *
     * @return double
     */
    public double getDeadRottenMass() {
        return this.deadRottenMass;
    }

    /**
     * Geerntete Masse an Holz
     *
     * @return double
     */
    public double getHarvestedMass() {
        return this.harvestedMass;
    }

    /**
     * Abgebaute, verrottete Masse an Holz
     *
     * @return double
     */
    public double getHarvestedRottenMass() {
        return this.harvestedRottenMass;
    }

}