import java.util.Iterator;

public class Forstbetrieb
{
	private String name;
	private LinkedList holzvollernter;
	
	public Forstbetrieb( String name )
	{
		this.name = name;
		this.holzvollernter = new LinkedList();
	}
	
	public void addHolzvollernter( Holzvollernter h )
	{
		this.holzvollernter.add(h);
	}
	
	public boolean removeHolzvollernter( Holzvollernter h )
	{
		return this.holzvollernter.remove(h);
	}
	
	public Holzvollernter getHolzvollernter( int i )
	{
		return (Holzvollernter) this.holzvollernter.get(i);
	}
	
	private float getDurchschnittlicheBetriebszeit()
	{
		if( this.holzvollernter.size() == 0 )
		{
			return 0f;
		}
		
		float d = 0.0f;
		int c = 0;
		
		for( Iterator i = this.holzvollernter.iterator(); i.hasNext(); )
		{
			d += ((Holzvollernter)i.next()).getBetriebsstunden();
			c++;
		}
		
		return d / c;
	}
	
	private float getDurchschnittlicheBetriebszeit( int typ )
	{
		if( this.holzvollernter.size() == 0 )
		{
			return 0f;
		}
		
		float d = 0.0f;
		int c = 0;
		
		for( Iterator i = this.holzvollernter.iterator(); i.hasNext(); )
		{
			Holzvollernter h = (Holzvollernter)i.next();
			if( h.getTyp() == typ )
			{
				d += h.getBetriebsstunden();
				c++;
			}
		}
		
		return d / c;
	}
	
	@Override
	public String toString()
	{
		String s = "";
		s += "=======================\n";
		s += "Durchschn. Betriebsst. (gesamt):          " + this.getDurchschnittlicheBetriebszeit() + "\n";
		s += "Durchschn. Betriebsst. (Stückeschneider): "+this.getDurchschnittlicheBetriebszeit(Holzvollernter.TYP_STUECKE_SCHNEIDEN) + "\n";
		s += "Durchschn. Betriebsst. (Hackschnätzler):  "+this.getDurchschnittlicheBetriebszeit(Holzvollernter.TYP_HACKSCHNAETZELN) + "\n";
		return this.name + "\n" + s;
	}
}
