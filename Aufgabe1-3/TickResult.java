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

    public double getAliveMass() {
        return aliveMass;
    }

    public double getDeadMass() {
        return deadMass;
    }

    public double getDeadRottenMass() {
        return deadRottenMass;
    }

    public double getHarvestedMass() {
        return harvestedMass;
    }

    public double getHarvestedRottenMass() {
        return harvestedRottenMass;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getProceed(){
        return proceed;
    }

    public double getErholungsWert() {
           return erholungsWert;
    }

    public double getEndprofit() {
           return endprofit;
    }
}
