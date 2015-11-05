public class Energieholz implements Etikett, Verwertbar {
    private int laenge;
    private int volumen;
    private String datum;
    private Etikett alt;

    @Override
    public int laenge() {
        return this.laenge;
    }

    public int volumen() {
        return this.volumen;
    }

    @Override
    public String datum() {
        return this.datum;
    }

    @Override
    public Etikett alt() {
        return this.alt;
    }
}
