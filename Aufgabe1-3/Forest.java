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

    /**
     * Konstruktor
     *
     * @param List trees                    Liste an Bäumen
     */
    public Forest(List<Tree> trees, double initialCost) {
        this.trees = trees;
        // Lebendmasse definieren
        this.aliveMass = trees.size();
        // Gesamtkosten berechnen
        this.totalCost = initialCost * trees.size();
    }

    /**
     * Gesamten Wald um ein Jahr altern lassen
     */
    public void tick() {
        this.aliveMass = 0.0;
        this.harvestedMass = 0.0;
        this.totalCost = 0.0;
        this.proceed = 0.0;
        this.endprofit = 0.0;
        this.erholungsWert = 0.0;

        // ArrayList durchlaufen
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

    /**
     * Bäume entfernen
     *
     * @param int trees                 Anzahl der Bäume, die entfernt werden sollen
     */
    public void clearTrees(int trees) {
        for (int i = 0; i < ((trees >= this.trees.size() - 1) ? this.trees.size() - 1 : trees); i++) {
            this.trees.remove(i);
        }
    }

    /**
     * Wald um eine bestimmte Anzahl von Jahren altern lassen
     *
     * @param int years       Anzahl der Jahre
     */
    public void tick(int years) {
        for (int i = 0; i < years; i++) {
            this.tick();
        }
    }

    /**
     * @return double   Gesamtmasse lebend
     */
    public double getAliveMass() {
        return this.aliveMass;
    }

    /**
     * @return double   Gesamtmasse geerntet
     */
    public double getHarvestedMass() {
        return harvestedMass;
    }

    /**
     * @return double   Gesamtmasse geerntet und verrottet
     */
    public double getHarvestedRottenMass() {
        return harvestedRottenMass;
    }

    /**
     * @return double   Gesamtmasse tot
     */
    public double getDeadMass() {
        return deadMass;
    }

    /**
     * @return double   Gesamtmasse verrottet und tot
     */
    public double getDeadRottenMass() {
        return deadRottenMass;
    }

    /**
     * @return double   Gesamtmasse gebundenes CO2
     */
    public double getBoundCO2() {
        return this.getAliveMass() + this.getDeadMass() + this.getHarvestedMass();
    }

    /**
     * @return double   Gesamtkosten Wald
     */
    public double getTotalCost() {
        return this.totalCost;
    }

    /**
     * @return double   Gesamte Kosten
     */
    public double getProceed() {
        return this.proceed;
    }

    /**
     * @return double   Gesamter Profit
     */
    public double getProfit() {
        return this.profit;
    }

    /**
     * @return double   Gesamter Erholungswert
     */
    public double getErholungsWert() {
        return this.erholungsWert;
    }

    /**
     * @return double   Gesamter Endprofit
     */
    public double getEndprofit() {
        return this.endprofit;
    }
}