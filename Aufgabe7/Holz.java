public abstract class Holz
{
	public static final int GEHOBELT = 1;
	public static final int SAEGERAU = 2;
	
	private final int typ;
	private final float laenge;
	private final float price;
	
	public Holz( int typ, float laenge, float price )
	{
		this.typ = typ;
		this.laenge = laenge;
		this.price = price;
	}
	
	public int getTyp()
	{
		return this.typ;
	}
	
	public float getLaenge()
	{
		return this.laenge;
	}
	
	public float getPrice()
	{
		return this.price;
	}
}
