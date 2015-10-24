import java.text.DecimalFormat;

/**
 * Aufteilung der Arbeiten: Allgemeines Treffen im TS3 mit gemeinsamen Brainstormen
 * Durchgehende Review der Entstehung vom Code und Verbesserungen
 *
 * Michael: Grundkonzept programmiert
 * Harald: Vorschläge zum Lösen des Aufgabe und Ideen
 * Patrick: Überarbeitung der Semantik
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Modelable defaultModel = new DefaultModel();
        Forest forest = new Forest(100, defaultModel);
        int years = 15;


        System.out.println("+------+----------+---------+-----------+-------+-----------+----------------+");
        System.out.println("| Jahr | Holzwald | Totholz | Verrottet | Ernte | Verwertet | Gebundenes CO2 |");
        System.out.println("+------+----------+---------+-----------+-------+-----------+----------------+");
        for (int i = 0; i < years; i++) {
            System.out.println(format(i, forest.getAliveMass(), forest.getDeadMass(), forest.getDeadRottenMass(), forest.getHarvestedMass(), forest.getHarvestedRottenMass(), forest.getBoundCO2()));
            forest.tick();
        }
    }

    public static String format(int year, double aliveMass, double deadMass, double deadRottenMass, double harvestedMass, double harvestedRottenMass, double boundCO2) {
        String s = "|";
        DecimalFormat df = new DecimalFormat("0.0");

        s += entry(String.valueOf(year), 6);
        s += entry(df.format(aliveMass), 10);
        s += entry(df.format(deadMass), 9);
        s += entry(df.format(deadRottenMass), 11);
        s += entry(df.format(harvestedMass), 7);
        s += entry(df.format(harvestedRottenMass), 11);
        s += entry(df.format(boundCO2), 16);
        s += "\n+------+----------+---------+-----------+-------+-----------+----------------";
        return s;
    }

    public static String entry(String s, int headerWidth) {
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
}