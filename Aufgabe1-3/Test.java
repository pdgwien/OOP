import java.text.DecimalFormat;
import java.util.List;
import java.util.Iterator;

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
          float holzwald_beginn = 100, totholz_beginn = 80, ernte_beginn = 15, verwertung_beginn = 30, verrottung_beginn = 40, gebundenesCO2_beginn = 300, holzzuwachs = 57, totholz = 10, erntemenge = 8, verwertung = 20, verrottung = 50;
     //   float holzwald_beginn = 2000, totholz_beginn = 200, ernte_beginn = 0, verwertung_beginn = 100, verrottung_beginn = 0, gebundenesCO2_beginn = 2300, holzzuwachs = 1000, totholz = 50, erntemenge = 50, verwertung = 15, verrottung = 23;
     //   float holzwald_beginn = 2000, totholz_beginn = 200, ernte_beginn = 0, verwertung_beginn = 0, verrottung_beginn = 0, gebundenesCO2_beginn = 2300, holzzuwachs = 0, totholz = 0, erntemenge = 0, verwertung = 0, verrottung = 50;
     //   float holzwald_beginn = 2000, totholz_beginn = 0, ernte_beginn = 0, verwertung_beginn = 0, verrottung_beginn = 0, gebundenesCO2_beginn = 2300, holzzuwachs = 0, totholz = 0, erntemenge = 10, verwertung = 50, verrottung = 0;
        
        int jahre = 15;

		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.println("JAHRE:");
		System.out.println("======");
		jahre = sc.nextInt();
		
		System.out.println("ANFANGSWERTE:");
		System.out.println("=============");
		System.out.println("");
		System.out.print("Holzwald: ");
		holzwald_beginn = sc.nextFloat();
		System.out.println("");
		System.out.print("Totholz: ");
		totholz_beginn = sc.nextFloat();
		System.out.println("");
		System.out.print("Ernte: ");
		ernte_beginn = sc.nextFloat();
		System.out.println("");
		System.out.print("Verwertung: ");
		verwertung_beginn = sc.nextFloat();
		System.out.println("");
		System.out.print("Verrottung: ");
		verrottung_beginn = sc.nextFloat();
		System.out.println("");
		System.out.print("Gebundenes CO2: ");
		gebundenesCO2_beginn = sc.nextFloat();
		
		System.out.println("");
		System.out.println("DURCHSCHNITTSANGABEN:");
		System.out.println("=====================");
		System.out.println("");
		System.out.print("Holzzuwachs: ");
		holzzuwachs = sc.nextFloat();
		System.out.println("");
		System.out.print("Totholz: ");
		totholz = sc.nextFloat();
		System.out.println("");
		System.out.print("Erntemenge: ");
		erntemenge = sc.nextFloat();
		System.out.println("");
		System.out.print("Verwertung: ");
		verwertung = sc.nextFloat();
		System.out.println("");
		System.out.print("Verrottung: ");
		verrottung = sc.nextFloat();
		*/
        BaumSimulation ob = new BaumSimulation(holzwald_beginn, totholz_beginn, ernte_beginn, verwertung_beginn, verrottung_beginn, gebundenesCO2_beginn, holzzuwachs, totholz, erntemenge, verwertung, verrottung);

        List<Jahr> list = ob.getDaten(jahre);

        System.out.println("+------+----------+---------+-------+-----------+-----------+----------------+");
        System.out.println("| Jahr | Holzwald | Totholz | Ernte | Verwertet | Verrottet | Gebundenes CO2 |");
        System.out.println("+------+----------+---------+-------+-----------+-----------+----------------+");
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Jahr oj = (Jahr) it.next();

            String s = "|";

            DecimalFormat df = new DecimalFormat("0.0");
            s += entry(String.valueOf(oj.getJahr()), 6);
            s += entry(df.format(oj.getHolzwald()), 10);
            s += entry(df.format(oj.getTotholz()), 9);
            s += entry(df.format(oj.getErnte()), 7);
            s += entry(df.format(oj.getVerwertet()), 11);
            s += entry(df.format(oj.getVerrottet()), 11);
            s += entry(df.format(oj.getGebundenesCO2()), 16);
            System.out.println(s);
            System.out.println("+------+----------+---------+-------+-----------+-----------+----------------+");
        }
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