/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public final class TickResult {
    private final double aliveMass;
    private final double deadMass;
    private final double deadRottenMass;
    private final double harvestedMass;
    private final double harvestedRottenMass;
    private final double totalCost;
    private final double proceed;
    private final double erholungsWert;
    private final double endprofit;

    /**
     * Konstruktor von TickResult
     *
     * @param double aliveMass                Lebendmasse
     * @param double deadMass                 Tote Masse
     * @param double deadRottenMass           Tote, verrottete Masse
     * @param double harvestedMass            Geerntete Masse
     * @param double harvestedRottenMass      Verrottete, geerntete Masse
     * @param double totalCost                Kosten
     * @param double proceed                  Profit
     * @param double erholungsWert            Erholungswert
     * @param double endprofit                Endprofit
     */
    public TickResult(double aliveMass, double deadMass, double deadRottenMass, double harvestedMass, double harvestedRottenMass, double totalCost, double proceed, double erholungsWert, double endprofit) {
        this.aliveMass = aliveMass;
        this.deadMass = deadMass;
        this.deadRottenMass = deadRottenMass;
        this.harvestedMass = harvestedMass;
        this.harvestedRottenMass = harvestedRottenMass;
        this.totalCost = totalCost;
        this.proceed = proceed;
        this.erholungsWert = erholungsWert;
        this.endprofit = endprofit;
    }

    /**
     * @return double  Lebendmasse
     */
    public double getAliveMass() {
        return aliveMass;
    }

    /**
     * @return double  Tote Masse
     */
    public double getDeadMass() {
        return deadMass;
    }

    /**
     * @return double  Tote, verrottete Masse
     */
    public double getDeadRottenMass() {
        return deadRottenMass;
    }

    /**
     * @return double  Geerntete Masse
     */
    public double getHarvestedMass() {
        return harvestedMass;
    }

    /**
     * @return double  Geerntete, verrottete Masse
     */
    public double getHarvestedRottenMass() {
        return harvestedRottenMass;
    }

    /**
     * @return double  Gesamtkosten
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * @return double  Profit
     */
    public double getProceed(){
        return proceed;
    }

    /**
     * @return double  Erholungswert
     */
    public double getErholungsWert() {
           return erholungsWert;
    }

    /**
     * @return double  Endprofit
     */
    public double getEndprofit() {
           return endprofit;
    }
}
