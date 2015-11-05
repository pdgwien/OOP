public class Schnittholz implements Etikett {
    private int laenge;
    private int dicke;
    private int breite;
    private String datum;
    private Etikett alt;

    @Override
    public int laenge() {
        return this.laenge;
    }

    public int dicke() {
        return this.dicke;
    }

    public int breite() {
        return this.breite;
    }

    @Override
    public String datum() {
        return this.datum;
    }

    @Override
    public Etikett alt() {
        return this.alt;
    }

    public void neu(Schnittholz neu) {
        this.alt = neu;
    }

    public void neu(Verwertbar neu) {
        this.alt = (Etikett) neu;
    }

    /*
    // ALTERNATIVE zum Verwertbar-Interface
    public void neu(Energieholz neu)
    {
        this.alt = neu;
    }

    public void neu(Bauholz neu)
    {
        this.alt = neu;
    }
    */

    public Etikett[] saegen() {
        // Todo: Implementierung von: In welche Teile wird die Klasse zerlegt
        return new Etikett[]{};
    }
}
