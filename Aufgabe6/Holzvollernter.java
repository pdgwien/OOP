public abstract class Holzvollernter implements Ernter
{
	private int ID;
	private int typ;
	protected int betriebsstunden;
	
	private float laenge;
	private int maxDicke;
	
	public static final int TYP_STUECKE_SCHNEIDEN = 1;
	public static final int TYP_HACKSCHNAETZELN = 2;
	
	public static final int ERNTER_TYP_SCHREITER = 1;
	public static final int ERNTER_TYP_FAHRER = 2;
	
	public Holzvollernter( int ID, float laenge )
	{
		this.ID = ID;
		this.laenge = laenge;
		this.typ = Holzvollernter.TYP_STUECKE_SCHNEIDEN;
	}
	
	public Holzvollernter( int ID, int maxDicke )
	{
		this.ID = ID;
		this.maxDicke = maxDicke;
		this.typ = Holzvollernter.TYP_HACKSCHNAETZELN;
	}
	
	public int getID()
	{
		return this.ID;
	}
	
	public void setTyp( int typ )
	{
		switch( typ )
		{
		case Holzvollernter.TYP_HACKSCHNAETZELN:
		case Holzvollernter.TYP_STUECKE_SCHNEIDEN:
			this.typ = typ;
			this.laenge = 0.0f;
			this.maxDicke = 0;
		}
	}
	
	public int getTyp()
	{
		return this.typ;
	}
	
	public String getTypBezeichnung()
	{
		switch( this.typ )
		{
		case Holzvollernter.TYP_STUECKE_SCHNEIDEN: return "Stückeschneider";
		case Holzvollernter.TYP_HACKSCHNAETZELN: return "Hackschnätzler";
		}
		return null;
	}
	
	public float getLaenge()
	{
		return this.laenge;
	}
	
	public int getMaxDicke()
	{
		return this.maxDicke;
	}
	
	public void addBetriebsstunden( int b )
	{
		if( b > 0 )
		{
			this.betriebsstunden += b;
		}
	}
	
	public int getBetriebsstunden()
	{
		return this.betriebsstunden;
	}
}
