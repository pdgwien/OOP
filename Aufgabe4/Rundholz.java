public class Rundholz implements Etikett {
    private int laenge;
    private int staerke;
    private String datum;
    private Etikett alt;

    @Override
    public int laenge() {
        return this.laenge;
    }

    public int staerke() {
        return this.staerke;
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
