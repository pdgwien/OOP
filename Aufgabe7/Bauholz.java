import java.util.List;

public abstract class Bauholz {
    private final double length;
    private final int price;

    public Bauholz(double length, int price) {
        this.length = length;
        this.price = price;
    }

    public double getLength() {
        return this.length;
    }

    public int getPrice() {
        return this.price;
    }

    public void add(List list) {
        list.add(this);
    }

    @Override
    public String toString() {
        return "" + this.getClass() + "{" +
                "length=" + length +
                '}';
    }
}
