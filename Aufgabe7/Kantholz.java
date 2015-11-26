public class Kantholz extends Holz
{
	private final float breite;
	private final float hoehe;
	
	public Kantholz( int typ, float laenge, float price, float breite, float hoehe )
	{
		super(typ, laenge, price);
		this.breite = breite;
		this.hoehe = hoehe;
	}
	
	public float getBreite()
	{
		return this.breite;
	}
	
	public float getHoehe()
	{
		return this.hoehe;
	}
}