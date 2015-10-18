public class Jahr {
    private int jahr;

    private float holzwald;
    private float totholz;
    private float ernte;
    private float verwertet;
    private float verrottet;
    private float gebundenesCO2;

    public Jahr(int jahr, float holzwald, float totholz, float ernte, float verwertet, float verrottet, float gebundenesCO2) {
        this.jahr = jahr;
        this.holzwald = holzwald;
        this.totholz = totholz;
        this.ernte = ernte;
        this.verwertet = verwertet;
        this.verrottet = verrottet;
        this.gebundenesCO2 = gebundenesCO2;
    }

    public int getJahr() {
        return this.jahr;
    }

    public float getHolzwald() {
        return this.holzwald;
    }

    public float getTotholz() {
        return this.totholz;
    }

    public float getErnte() {
        return this.ernte;
    }

    public float getVerwertet() {
        return this.verwertet;
    }

    public float getVerrottet() {
        return this.verrottet;
    }

    public float getGebundenesCO2() {
        return this.gebundenesCO2;
    }

    @Override
    public String toString() {
        return "Holzwald: " + this.holzwald + "\r\nTotholz: " + this.totholz + "\r\nErnte: " + this.ernte + "\r\nVerwertet: " + this.verwertet + "\r\nVerrottet: " + this.verrottet + "\r\nGebundenes CO2: " + this.getGebundenesCO2() + "\r\n\r\n";
    }
}