import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

/**
 * Aufteilung der Arbeiten: Allgemeines Treffen im TS3 mit gemeinsamen Brainstormen
 * Durchgehende Review der Entstehung vom Code und Verbesserungen
 *
 * Michael: Grundkonzept programmiert
 * Harald: Vorschläge zum Lösen des Aufgabe und Ideen
 * Patrick: Überarbeitung der Semantik
 */
public class Test {

    private static List<String> headers = Arrays.asList("Year", "AliveMass", "DeadMass", "DeadRottenMass", "HarvestedMass", "HarvestedRottenMass", "Bound CO2", "TotalCost", "Proceed", "Profit");
    private static String line = "";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Modelable defaultModel = new DefaultModel();
        Modelable extendedModel = new ExtendedModel();

        Forest forest =  new Forest(1000, defaultModel, 10.0);
        Forest forest2 = new Forest(1000, extendedModel, 10.0);
        int years = 50;


        System.out.println(makeHeader());
        for (int i = 0; i < years; i++) {
            System.out.println(format(i, forest.getAliveMass(), forest.getDeadMass(), forest.getDeadRottenMass(), forest.getHarvestedMass(), forest.getHarvestedRottenMass(), forest.getBoundCO2(), forest.getTotalCost(), forest.getProceed(), forest.getProfit()));
            forest.tick();
        }

        System.out.println(makeHeader());
        for (int i = 0; i < years; i++) {
            System.out.println(format(i, forest2.getAliveMass(), forest2.getDeadMass(), forest2.getDeadRottenMass(), forest2.getHarvestedMass(), forest2.getHarvestedRottenMass(), forest2.getBoundCO2(), forest2.getTotalCost(), forest2.getProceed(), forest2.getProfit()));
            forest2.tick();
        }
    }

    public static String format(int year, double aliveMass, double deadMass, double deadRottenMass, double harvestedMass, double harvestedRottenMass, double boundCO2, double totalCost, double proceed, double profit) {
        String s = "|";
        DecimalFormat df = new DecimalFormat("0.0");

        s += entry(String.valueOf(year), 0);
        s += entry(df.format(aliveMass), 1);
        s += entry(df.format(deadMass), 2);
        s += entry(df.format(deadRottenMass), 3);
        s += entry(df.format(harvestedMass), 4);
        s += entry(df.format(harvestedRottenMass), 5);
        s += entry(df.format(boundCO2), 6);
        s += entry(df.format(totalCost), 7);
        s += entry(df.format(proceed), 8);
        s += entry(df.format(profit), 9);
        s += line;
        return s;
    }

    public static String entry(String s, int index) {
        int headerWidth = headers.get(index).length() + 2;
        String res = "";
        int leftRightWidth = (headerWidth - s.length()) / 2;
        boolean isFull = (((double) (headerWidth - s.length()) / 2) % 1 == 0) ? true : false;

        //res += ((double)(headerWidth - s.length()) / 2)+ " "+isFull;

        for (int i = 0; i < leftRightWidth; i++) {
            res += " ";
        }

        res += s;

        for (int i = 0; i < leftRightWidth; i++) {
            res += " ";
        }

        if (!isFull) {
            res += " ";
        }
        return res + "|";
    }

    public static String makeHeader() {
        String l = "";
        for (String header : headers) {
            l += "+";
            for (int i = 0; i < header.length()+2; i++) {
                l += "-";
            }
        }
        l += "+";
        line = "\n" + l;
        String headerLine = String.join(" | ", headers) + " |";
        return l + "\n| " + headerLine + "\n" + l;
    }
}