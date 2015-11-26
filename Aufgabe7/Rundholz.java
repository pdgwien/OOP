public class Rundholz extends Holz
{
	private final float radius;
	
	public Rundholz( int typ, float laenge, float price, float radius )
	{
		super(typ, laenge, price);
		this.radius = radius;
	}
	
	public float getRadius()
	{
		return this.radius;
	}
}

