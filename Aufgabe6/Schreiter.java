public class Schreiter extends Holzvollernter
{
	private int schritte;
	
	public Schreiter( int ID, int typ )
	{
		super(ID, typ);
	}
	
	public void addSchritte( int s )
	{
		this.schritte = s;
	}
	
	public int getSchritte()
	{
		return this.schritte;
	}
}
