public class Jahr {
    private int jahr;

    private double holzwald;
    private double totholz;
    private double ernte;
    private double verwertet;
    private double verrottet;
    private double gebundenesCO2;

    public Jahr(int jahr, double holzwald, double totholz, double ernte, double verwertet, double verrottet, double gebundenesCO2) {
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

    public double getHolzwald() {
        return this.holzwald;
    }

    public double getTotholz() {
        return this.totholz;
    }

    public double getErnte() {
        return this.ernte;
    }

    public double getVerwertet() {
        return this.verwertet;
    }

    public double getVerrottet() {
        return this.verrottet;
    }

    public double getGebundenesCO2() {
        return this.gebundenesCO2;
    }

    @Override
    public String toString() {
        return "Holzwald: " + this.holzwald + "\r\nTotholz: " + this.totholz + "\r\nErnte: " + this.ernte + "\r\nVerwertet: " + this.verwertet + "\r\nVerrottet: " + this.verrottet + "\r\nGebundenes CO2: " + this.getGebundenesCO2() + "\r\n\r\n";
    }
}