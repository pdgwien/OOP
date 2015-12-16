/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 *
 * Aufgabenteilung:
 * Patrick Grosslicht: alles
 */
@Author("Patrick Grosslicht")
public class Test {
    public static void main(String[] args) {
        Schachtellager lager = new Schachtellager();
        Einkaufstasche einkaufstasche = new Einkaufstasche();

        Buch buch = new Buch(5, "A Hitchhiker's Guide to the Galaxy", 15, 10);
        Notizblock notizblock = new Notizblock(3, "Moleskine Notizblock liniert", 15, 10);
        Kerze kerze = new Kerze(10, "Honigkerze", 5);
        Weinflasche weinflasche = new Weinflasche(20, "Roter Veltliner", 7);
        Lebkuchen lebkuchen = new Lebkuchen(5, "Honiglebkuchenquadrat", 10);
        Wuerfel wuerfel = new Wuerfel(20, "Wuerfel", 20);
        Topf topf = new Topf(20, "WMF Edelstahl Topf", 10);
        Marmelade marmelade = new Marmelade(10, "Marillenmarmelade", 3);

        System.out.println("Kaufen ohne Verpackungen:");
        einkaufstasche.buy(topf, lager);
        einkaufstasche.inhalt();
        System.out.printf("volumen() trotzdem 0, da keine Schachtel in der Tasche ist: %f%n", einkaufstasche.volumen());

        einkaufstasche = new Einkaufstasche();

        for (int i = 0; i < 25; i++) {
            lager.add(new KreisSchachtel(i*2, i*1.5));
            lager.add(new SechseckSchachtel(i*2, i*1.5));
            lager.add(new QuadratSchachtel(i*2, i*1.5));
            lager.add(new RechteckSchachtel(i*2, i*2, i*2));
        }

        System.out.println("Kaufen mit Verpackungen:");
        einkaufstasche.buy(buch, lager);
        einkaufstasche.buy(notizblock, lager);
        einkaufstasche.buy(kerze, lager);
        einkaufstasche.buy(weinflasche, lager);
        einkaufstasche.buy(lebkuchen, lager);
        einkaufstasche.buy(wuerfel, lager);
        einkaufstasche.buy(topf, lager);
        einkaufstasche.buy(marmelade, lager);
        einkaufstasche.inhalt();
        System.out.printf("volumen(): %f%n", einkaufstasche.volumen());

        Einkaufstasche einkaufstasche2 = new Einkaufstasche();
        System.out.println("Mehrfach verpacken:");
        Gegenstand temp = lager.verpacke(wuerfel);
        temp = lager.verpacke(temp);
        temp = lager.verpacke(temp);
        einkaufstasche2.add(temp);
        einkaufstasche2.inhalt();

        Schachtellager lager2 = new Schachtellager();
        lager2.add(new SechseckSchachtel(21, 8));
        System.out.println("Nur sechseckig für Kreis verfügbar:");
        System.out.println(lager2.verpacke(weinflasche).volumen());
    }
}
