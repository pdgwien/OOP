import java.util.HashMap;

public class BaumSimulation {
    private Jahr anfangsJahr;

    private double holzzuwachs;
    private double erntemenge;
    private double totholz;
    private double verwertung;
    private double verrottung;

    /**
    * Konstruktor für die BaumSimulation
    * @param holzwald_beginn Anfangsbestand des lebenden Holzes im Wald in Kubikmeter
    * @param totholz_beginn Anfangsbestand des toten Holzes im Wald in Kubikmeter
    * @param ernte_beginn Anfangsbestand des geernteten Holzes in Kubikmeter
    * @param verwertung_beginn Anfangsbestand des verwerteten Holzes in Kubikmeter
    * @param verrottung_beginn Anfangsbestand des verrotteten Holzes im Wald in Kubikmeter
    * @param gebundenesCO2_beginn Anfangsbestand des gebundenen CO2 in Tonnen
    * @param holzzuwachs Zuwachs an lebendem Holz im Wald pro Jahr in Kubikmeter
    * @param totholz Umwandlung von Holzzuwach in Totholz pro Jahr in Kubikmeter
    * @param erntemenge Ernte von lebendem Holz pro Jahr in Kubikmeter
    * @param verwertung Anteil des verwerteten Holzes vom geernteten Holz pro Jahr in Prozent
    * @param verrottung Anteil des geernteten Holzes vom toten Holz pro Jahr in Prozent
    */
    public BaumSimulation(double holzwald_beginn,
                          double totholz_beginn,
                          double ernte_beginn,
                          double verwertung_beginn,
                          double verrottung_beginn,
                          double gebundenesCO2_beginn,
                          double holzzuwachs,
                          double totholz,
                          double erntemenge,
                          double verwertung,
                          double verrottung) {
        this.anfangsJahr = new Jahr(0, holzwald_beginn, totholz_beginn, ernte_beginn, verwertung_beginn, verrottung_beginn, gebundenesCO2_beginn);

        this.holzzuwachs = holzzuwachs;
        this.totholz = totholz;
        this.erntemenge = erntemenge;
        this.verwertung = verwertung;
        this.verrottung = verrottung;
    }

    /**
    * Erzeugt eine Hashmap mit sovielen Zeilen, wieviele Jahre die Simulation laufen soll.
    * @param jahre Anzahl der Jahre die die Simulation laufen soll
    */
    public HashMap<Integer, Jahr> getDaten(int jahre) {
        HashMap<Integer, Jahr> map = new HashMap<Integer, Jahr>();

        double holzwald_beginn = this.anfangsJahr.getHolzwald();
        double totholz_beginn = this.anfangsJahr.getTotholz();
        double ernte_beginn = this.anfangsJahr.getErnte();
        double verwertet_beginn = this.anfangsJahr.getVerwertet();
        double verrottet_beginn = this.anfangsJahr.getVerrottet();
        double gebundenesCO2_beginn = this.anfangsJahr.getGebundenesCO2();

        map.put(0, anfangsJahr);

        for (int i = 1; i <= jahre; i++) {
            holzwald_beginn += this.holzzuwachs - this.erntemenge - this.totholz;
            ernte_beginn += this.erntemenge;
            totholz_beginn += this.totholz;
            verwertet_beginn += (this.verwertung * this.erntemenge) / 100;
            verrottet_beginn += (this.verrottung * this.totholz) / 100;
            gebundenesCO2_beginn += this.holzzuwachs - ((this.verwertung * this.erntemenge) / 100) - ((this.verrottung * this.totholz) / 100) ;

            map.put(i, new Jahr(i, holzwald_beginn, totholz_beginn, ernte_beginn, verwertet_beginn, verrottet_beginn, gebundenesCO2_beginn));
        }

        return map;
    }
}


