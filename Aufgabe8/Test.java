/**
 * Aufgabenteilung:
 * Patrick Grosslicht: alles
 * Michael Hambrusch: initiale Version, verworfen
 * Harald Bernhard: NICHTS, da er die Gruppe verlassen hat, wodurch wir zu zweit die Arbeit von drei Leuten machen müssen.
*/
public class Test {
	public static void main(String[] args) {
		Wald wald = new Wald(10, 10, "Wald1");
        BuchdruckerKolonie bk1 = new BuchdruckerKolonie(wald, wald.getField(4, 3), 500);
        wald.getField(4, 3).setBuchdruckerKolonie(bk1);
        wald.addColony(bk1);
        wald.start();


        Wald wald2 = new Wald(10, 10, "Wald2");
        BuchdruckerKolonie bk2 = new BuchdruckerKolonie(wald2, wald2.getField(9, 8), 100);
        BuchdruckerKolonie bk3 = new BuchdruckerKolonie(wald2, wald2.getField(8, 8), 110);
        BuchdruckerKolonie bk4 = new BuchdruckerKolonie(wald2, wald2.getField(7, 8), 120);
        BuchdruckerKolonie bk5 = new BuchdruckerKolonie(wald2, wald2.getField(6, 8), 130);
        BuchdruckerKolonie bk6 = new BuchdruckerKolonie(wald2, wald2.getField(5, 8), 140);
        wald2.getField(9, 8).setBuchdruckerKolonie(bk2);
        wald2.getField(8, 8).setBuchdruckerKolonie(bk3);
        wald2.getField(7, 8).setBuchdruckerKolonie(bk4);
        wald2.getField(6, 8).setBuchdruckerKolonie(bk5);
        wald2.getField(5, 8).setBuchdruckerKolonie(bk6);
        wald2.addColony(bk2);
        wald2.addColony(bk3);
        wald2.addColony(bk4);
        wald2.addColony(bk5);
        wald2.addColony(bk6);
        wald2.start();

        Wald wald3 = new Wald(3, 3, "Wald3");
        BuchdruckerKolonie bk7 = new BuchdruckerKolonie(wald3, wald3.getField(0, 0), 300);
        wald3.getField(0, 0).setBuchdruckerKolonie(bk7);
        wald3.addColony(bk7);
        wald3.start();
    }
}
