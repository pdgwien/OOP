public class Fahrer extends Holzvollernter
{
	private float strecke;
	
	public Fahrer( int ID, int typ )
	{
		super(ID, typ);
	}
	
	public void addStrecke( float s )
	{
		if( s > 0 )
		{
			this.strecke = s;
		}
	}
	
	public float getStrecke()
	{
		return this.strecke;
	}
}
