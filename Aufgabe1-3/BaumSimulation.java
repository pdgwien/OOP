import java.util.HashMap;

public class BaumSimulation {
    private Jahr anfangsJahr;

    private float holzzuwachs;
    private float erntemenge;
    private float totholz;
    private float verwertung;
    private float verrottung;

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
    public BaumSimulation(float holzwald_beginn,
                          float totholz_beginn,
                          float ernte_beginn,
                          float verwertung_beginn,
                          float verrottung_beginn,
                          float gebundenesCO2_beginn,
                          float holzzuwachs,
                          float totholz,
                          float erntemenge,
                          float verwertung,
                          float verrottung) {
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

        float holzwald_beginn = this.anfangsJahr.getHolzwald();
        float totholz_beginn = this.anfangsJahr.getTotholz();
        float ernte_beginn = this.anfangsJahr.getErnte();
        float verwertet_beginn = this.anfangsJahr.getVerwertet();
        float verrottet_beginn = this.anfangsJahr.getVerrottet();
        float gebundenesCO2_beginn = this.anfangsJahr.getGebundenesCO2();

        map.put(0, anfangsJahr);

        for (int i = 1; i <= jahre; i++) {
            holzwald_beginn += this.holzzuwachs - this.erntemenge - this.totholz;
            ernte_beginn += this.erntemenge;
            totholz_beginn += this.totholz;
            verwertet_beginn += (this.verwertung * ernte_beginn) / 100;
            verrottet_beginn += (this.verrottung * totholz_beginn) / 100;
            gebundenesCO2_beginn += this.holzzuwachs - ((this.verwertung * ernte_beginn) / 100) - ((this.verrottung * totholz_beginn) / 100) ;

            map.put(i, new Jahr(i, holzwald_beginn, totholz_beginn, ernte_beginn, verwertet_beginn, verrottet_beginn, gebundenesCO2_beginn));
        }

        return map;
    }
}


