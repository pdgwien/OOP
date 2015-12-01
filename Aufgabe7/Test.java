/**
 * Aufgabenteilung:
 * Michael Hambrusch: anfängliche Lagerverwaltung
 * Patrick Grosslicht: restliche Funktionalität, Testfälle
 * Harald Bernhard: NICHTS, da er die Gruppe verlassen hat, wodurch wir zu zweit die Arbeit von drei Leuten machen müssen.
 */
public class Test {
    public static void main(String[] args) {
        Bauholzlager bhl = new Bauholzlager("Lager1");

        WohnHolzbauDachstuhl whd = new WohnHolzbauDachstuhl("WohnHolzbau", 100.0);
        WohnSteinbauDachstuhl wsd = new WohnSteinbauDachstuhl("WohnSteinbau", 100.0);
        NutzHolzbauDachstuhl nhd = new NutzHolzbauDachstuhl("NutzHolzbau", 100.0);
        NutzSteinbauDachstuhl nsd = new NutzSteinbauDachstuhl("NutzSteinbau", 100.0);
        System.out.println("Von leerem Bauholzlager hinzufügen: ");
        whd.addFittingWoodFromStorage(bhl);
        whd.list();
        System.out.println("price() von leerem Dachstuhl: " + whd.price());


        System.out.println("Bauholzlager befüllen");
        for (int i = 1; i < 11; i++) {
            KantholzGehobelt kg = new KantholzGehobelt(i * 20, 200, 20, 20);
            bhl.add(kg);
        }
        for (int i = 1; i < 11; i++) {
            KantholzSaegerauh ks = new KantholzSaegerauh(i * 20, 50, 20, 20);
            bhl.add(ks);
        }
        for (int i = 1; i < 11; i++) {
            RundholzGehobelt rg = new RundholzGehobelt(i * 20, 200, 20);
            bhl.add(rg);
        }
        for (int i = 1; i < 11; i++) {
            RundholzSaegerauh rs = new RundholzSaegerauh(i * 20, 50, 20);
            bhl.add(rs);
        }
        bhl.list();

        System.out.println("Für WohnHolzbauDachstuhl benutzen:");
        for (int i = 0; i < 5; i++) {
            whd.addFittingWoodFromStorage(bhl);
        }
        System.out.println("Holzlager list()");
        bhl.list();
        System.out.println("WohnHolzbauDachstuhl list()");
        whd.list();
        System.out.println("Dachstuhl price(): " + whd.price());

        System.out.println("Für NutzHolzbauDachstuhl (mehr als gehobeltes vorhanden) benutzen:");
        for (int i = 0; i < 15; i++) {
            nhd.addFittingWoodFromStorage(bhl);
        }
        System.out.println("Holzlager list()");
        bhl.list();
        System.out.println("NutzHolzbauDachstuhl list()");
        nhd.list();

        System.out.println("Für WohnSteinbauDachstuhl benutzen:");
        for (int i = 0; i < 5; i++) {
            wsd.addFittingWoodFromStorage(bhl);
        }
        System.out.println("Holzlager list()");
        bhl.list();
        System.out.println("WohnHolzbauDachstuhl list()");
        wsd.list();
        System.out.println("Dachstuhl price(): " + wsd.price());

        System.out.println("Für NutzSteinbauDachstuhl (mehr als gehobeltes vorhanden) benutzen:");
        for (int i = 0; i < 15; i++) {
            nsd.addFittingWoodFromStorage(bhl);
        }
        System.out.println("Holzlager list()");
        bhl.list();
        System.out.println("NutzHolzbauDachstuhl list()");
        nsd.list();

        System.out.println("Kein passendes Holz vorhanden, Bauholzlager get(): " + bhl.get(nsd));
    }
}
