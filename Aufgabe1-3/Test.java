import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Aufteilung der Arbeiten: Allgemeines Treffen im TS3 mit gemeinsamen Brainstormen
 * Durchgehende Review der Entstehung vom Code und Verbesserungen
 * <p>
 * Michael: Klimamodell & Sonderereignisse implementiert sowie Erholungswert
 * Harald: Modelle erstellt sowie Kosten & Gewinn
 * Patrick: Programmierung des Kernprogrammes, generelle Überarbeitungen
 */
public class Test {

    private static List<String> headers = Arrays.asList("Year", "AliveMass", "DeadMass", "DeadRottenMass", "HarvestedMass", "HarvestedRottenMass", "Bound CO2", "TotalCost", "Proceed", "Profit", "Erfolungswert", "Endprofit");
    private static String line = "";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Definiert drei Wachstumsmodelle und speichert sie in Variablen vom Typ DefaultModel, da alle Modelle von DefaultModel erben
        DefaultModel defaultModel = new DefaultModel();
        DefaultModel extendedModel = new ExtendedModel();
        DefaultModel klimaModel = new KlimaModel(KlimaModel.KLIMA_SOMMER); // Klima-Typen werden als Konstanten gespeichert und stellen short-Variablen dar

        List<Tree> trees1 = new ArrayList<>();
        List<Tree> trees2 = new ArrayList<>();
        List<Tree> trees3 = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            trees1.add(new Tree(defaultModel, 10.0));
            trees2.add(new LeafTree(extendedModel, 15.0));
            trees3.add(new NeedleTree(klimaModel, 13.0));
        }

        // Erzeugt Objekte vom Typ Forest
        Forest forest1 = new Forest(trees1, 10.0);
        Forest forest2 = new Forest(trees2, 15.0);
        Forest forest3 = new Forest(trees3, 13.0);
        // Definiert, wie lange die Simulation läuft
        int years = 50;

        /*
        * alle 10 Jahre 300 trees clearTrees
        */

        // Erzeugt den Header
        System.out.println(makeHeader());
        for (int i = 0; i < years; i++) {
            // Sort dafür, dass alle 10 Jahre 300 Bäume entfernt werden
            try
            {
                if ((i + 1) % 10 == 0) forest1.clearTrees(300);
            }
            // Fängt ArrayIndexOutOfBoundsExceptions ab
            catch (Exception e)
            {
                e.printStackTrace();
            }
            // Gibt alle Daten als Tabelle aus
            System.out.println(format(i, forest1.getAliveMass(), forest1.getDeadMass(), forest1.getDeadRottenMass(), forest1.getHarvestedMass(), forest1.getHarvestedRottenMass(), forest1.getBoundCO2(), forest1.getTotalCost(), forest1.getProceed(), forest1.getProfit(), forest1.getErholungsWert(), forest1.getEndprofit()));
            // Lässt den Wald um ein Jahr altern
            forest1.tick();
        }

        // Erzeugt den Header
        System.out.println(makeHeader());
        for (int i = 0; i < years; i++) {
            // Gibt alle Daten als Tabelle aus
            System.out.println(format(i, forest2.getAliveMass(), forest2.getDeadMass(), forest2.getDeadRottenMass(), forest2.getHarvestedMass(), forest2.getHarvestedRottenMass(), forest2.getBoundCO2(), forest2.getTotalCost(), forest2.getProceed(), forest2.getProfit(), forest2.getErholungsWert(), forest2.getEndprofit()));
            // Lässt den Wald um ein Jahr altern
            forest2.tick();
        }

        // Erzeugt den Header
        System.out.println(makeHeader());
        for (int i = 0; i < years; i++) {
            // Gibt alle Daten als Tabelle aus
            System.out.println(format(i, forest3.getAliveMass(), forest3.getDeadMass(), forest3.getDeadRottenMass(), forest3.getHarvestedMass(), forest3.getHarvestedRottenMass(), forest3.getBoundCO2(), forest3.getTotalCost(), forest3.getProceed(), forest3.getProfit(), forest3.getErholungsWert(), forest3.getEndprofit()));
            // Lässt den Wald um ein Jahr altern
            forest3.tick();
        }
    }

    /**
     * Erzeugt eine Tabellenreihe für die Tabellenansicht
     *
     * @param int year            Das Jahr / der erste Eintrag der Tabellenreihe und die einzige Integer-Variable
     * @param double... d         Dynamische Anzahl an Argumenten, die in der Tabelle von 2 bis x eingefügt werden
     *
     * @return String Gibt eine vollständige Tabellenreihe zurück
     */
    public static String format(int year, double... d) {
        String s = "|";
        DecimalFormat df = new DecimalFormat("0.0");

        s += entry(String.valueOf(year), 0);

        for (int i = 0; i < d.length; i++) {
            s += entry(df.format(d[i]), i + 1);
        }
        s += line;
        return s;
    }

    /**
     * Erzeugt eine Zelle für die Tabellenansicht
     *
     * @param String s           Inhalt der Zelle
     * @param int index          Berechnet die Größe der Zelle abhängig von dem Header
     *
     * @return String Tabellenzelle als String
     */
    public static String entry(String s, int index) {
        int headerWidth = headers.get(index).length() + 2;
        String res = "";
        int leftRightWidth = (headerWidth - s.length()) / 2;
        boolean isFull = (((double) (headerWidth - s.length()) / 2) % 1 == 0) ? true : false;

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

    /**
     * Generiert den Header der Tabelle
     */
    public static String makeHeader() {
        String l = "";
        for (String header : headers) {
            l += "+";
            for (int i = 0; i < header.length() + 2; i++) {
                l += "-";
            }
        }
        l += "+";
        line = "\n" + l;
        String headerLine = joinWith(" | ", headers) + " |";
        return l + "\n| " + headerLine + "\n" + l;
    }

    /**
     * Pendant zu PHP's implode()-Funktion, sowie Java8 joinWith()
     */
    public static String joinWith(final String separator, final List<String> list) {

        final StringBuilder result = new StringBuilder();

        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            final String value = iterator.next();
            result.append(value);

            if (iterator.hasNext()) {
                result.append(separator);
            }
        }

        return result.toString();
    }
}