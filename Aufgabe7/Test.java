public class Test {
    public static void main(String[] args) {
        // Tests hier implementieren
        Bauholzlager bhl = new Bauholzlager("Lager1");

        WohnHolzbauDachstuhl whd = new WohnHolzbauDachstuhl("WohnHolzbau", 100.0);
        WohnSteinbauDachstuhl wsd = new WohnSteinbauDachstuhl("WohnSteinbau", 100.0);
        NutzHolzbauDachstuhl nhd = new NutzHolzbauDachstuhl("NutzHolzbau", 100.0);
        NutzSteinbauDachstuhl nsd = new NutzSteinbauDachstuhl("NutzSteinbau", 100.0);
        System.out.println("Von leerem Bauholzlager hinzufügen:");
        whd.addFittingWoodFromStorage(bhl);
        whd.list();

        System.out.println("Bauholzlager befüllen");
        for (int i = 1; i < 11; i++) {
            KantholzGehobelt kg = new KantholzGehobelt(i * 20, 50, 20, 20);
            bhl.add(kg);
        }
        for (int i = 1; i < 11; i++) {
            KantholzSaegerauh ks = new KantholzSaegerauh(i * 20, 50, 20, 20);
            bhl.add(ks);
        }
        for (int i = 1; i < 11; i++) {
            RundholzGehobelt rg = new RundholzGehobelt(i * 20, 50, 20);
            bhl.add(rg);
        }
        for (int i = 1; i < 11; i++) {
            RundholzSaegerauh rs = new RundholzSaegerauh(i * 20, 50, 20);
            bhl.add(rs);
        }
        bhl.list();

        System.out.println("Für Dachstühle benutzen:");
        for (int i = 0; i < 5; i++) {
            whd.addFittingWoodFromStorage(bhl);
        }
        System.out.println("Holzlager list()");
        bhl.list();
        System.out.println("Dachstuhl list()");
        whd.list();
    }
}
