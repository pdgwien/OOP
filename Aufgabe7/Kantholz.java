public abstract class Kantholz extends Bauholz {
    private final double width;
    private final double height;

    public Kantholz(float length, int price, double width, double height) {
        super(length, price);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }
}