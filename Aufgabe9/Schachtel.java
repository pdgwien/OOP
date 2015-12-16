/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
@Author("Patrick Grosslicht")
public abstract class Schachtel extends Gegenstand {
    protected static final double CARDBOARD_WIDTH = 0.5;
    protected double innerHeight;
    protected Gegenstand content;

    public Schachtel(double innerHeight) {
        super(innerHeight + (2*CARDBOARD_WIDTH));
        this.innerHeight = innerHeight;
    }

    @Author("Patrick Grosslicht")
    public void putIn(Gegenstand thing) {
        if (thing.canBePutIn(this)) {
            this.content = thing;
        }
    }

    @Author("Patrick Grosslicht")
    public Gegenstand getContent() {
        return this.content;
    }

    //Vorbedingung: content != null
    @Author("Patrick Grosslicht")
    public Geschenk getInnerMostGift() {
        if (this.getContent() instanceof Geschenk) {
            return (Geschenk) this.getContent();
        }
        return ((Schachtel) this.getContent()).getInnerMostGift();
    }
}
