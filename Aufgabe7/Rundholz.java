public abstract class Rundholz extends Bauholz {
    private final double radius;

    public Rundholz(double length, int price, double radius) {
        super(length, price);
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }
}

