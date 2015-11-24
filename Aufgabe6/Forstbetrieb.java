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
		
		int d = 0;
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
		
		int d = 0;
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
	
	private float getDurchschnittlicheWegstrecke()
	{
		if( this.holzvollernter.size() == 0 )
		{
			return 0f;
		}
		
		float d = 0.0f;
		int c = 0;
		
		for( Iterator i = this.holzvollernter.iterator(); i.hasNext(); )
		{
			Object o = i.next();
			if( o instanceof Fahrer )
			{
				Fahrer f = (Fahrer)o;
				d += f.getStrecke();
				c++;
			}
		}
		
		return d / c;
	}
	
	private float getDurchschnittlicheWegstrecke(int typ)
	{
		if( this.holzvollernter.size() == 0 )
		{
			return 0f;
		}
		
		float d = 0.0f;
		int c = 0;
		
		for( Iterator i = this.holzvollernter.iterator(); i.hasNext(); )
		{
			Object o = i.next();
			if( o instanceof Fahrer && ((Holzvollernter)o).getTyp() == typ )
			{
				Fahrer f = (Fahrer)o;
				d += f.getStrecke();
				c++;
			}
		}
		
		return d / c;
	}
	
	private float getDurchschnittlicheSchritte()
	{
		if( this.holzvollernter.size() == 0 )
		{
			return 0f;
		}
		
		float d = 0.0f;
		int c = 0;
		
		for( Iterator i = this.holzvollernter.iterator(); i.hasNext(); )
		{
			Object o = i.next();
			if( o instanceof Fahrer )
			{
				Fahrer f = (Fahrer)o;
				d += f.getStrecke();
				c++;
			}
		}
		
		return d / c;
	}
	
	private float getDurchschnittlicheSchritte(int typ)
	{
		if( this.holzvollernter.size() == 0 )
		{
			return 0f;
		}
		
		int d = 0;
		int c = 0;
		
		for( Iterator i = this.holzvollernter.iterator(); i.hasNext(); )
		{
			Object o = i.next();
			if( o instanceof Schreiter && ((Holzvollernter)o).getTyp() == typ )
			{
				Schreiter f = (Schreiter)o;
				d += f.getSchritte();
				c++;
			}
		}
		
		return d / c;
	}
	
	private float getDurchschnittlicheBaumdicke()
	{
		if( this.holzvollernter.size() == 0 )
		{
			return 0f;
		}
		
		int d = 0;
		int c = 0;
		
		for( Iterator i = this.holzvollernter.iterator(); i.hasNext(); )
		{
			Holzvollernter h = (Holzvollernter) i.next();
			if( h.getTyp() == Holzvollernter.TYP_HACKSCHNAETZELN )
			{
				d += h.getMaxDicke();
				c++;
			}
		}
		
		return d / c;
	}
	
	private float getDurchschnittlicheBaumdicke(int typ)
	{
		if( this.holzvollernter.size() == 0 )
		{
			return 0f;
		}
		
		int d = 0;
		int c = 0;
		
		for( Iterator i = this.holzvollernter.iterator(); i.hasNext(); )
		{
			Ernter e = (Holzvollernter) i.next();
			if( e.getErnterTyp() == typ )
			{
				Holzvollernter h = (Holzvollernter)e;
				if( h.getTyp() == Holzvollernter.TYP_HACKSCHNAETZELN )
				{
					d += h.getMaxDicke();
					c++;
				}
			}
		}
		
		return d / c;
	}
	
	private float getKuerzesteLaenge()
	{
		if( this.holzvollernter.size() == 0 )
		{
			return 0f;
		}
		
		float smallest = 0.0f;
		for( Iterator i = this.holzvollernter.iterator(); i.hasNext(); )
		{
			Holzvollernter h = (Holzvollernter)i.next();
			if( h.getTyp() == Holzvollernter.TYP_STUECKE_SCHNEIDEN )
			{
				if( smallest == 0 )
				{
					smallest = h.getLaenge();
				}
				else if(smallest > h.getLaenge())
				{
					smallest = h.getLaenge();
				}
			}
		}
		return smallest;
	}
	
	private float getLaengsteLaenge()
	{
		if( this.holzvollernter.size() == 0 )
		{
			return 0f;
		}
		
		float biggest = 0.0f;
		for( Iterator i = this.holzvollernter.iterator(); i.hasNext(); )
		{
			Holzvollernter h = (Holzvollernter)i.next();
			if( h.getTyp() == Holzvollernter.TYP_STUECKE_SCHNEIDEN )
			{
				if(biggest < h.getLaenge())
				{
					biggest = h.getLaenge();
				}
			}
		}
		return biggest;
	}
	
	@Override
	public String toString()
	{
		String s = "";
		s += "======== Durchschnittliche Betriebsstunden ========\n";
		s += "Gesamt:               " + this.getDurchschnittlicheBetriebszeit() + "\n";
		s += "Stückeschneider:      " + this.getDurchschnittlicheBetriebszeit(Holzvollernter.TYP_STUECKE_SCHNEIDEN) + "\n";
		s += "Hackschnätzler:       " + this.getDurchschnittlicheBetriebszeit(Holzvollernter.TYP_HACKSCHNAETZELN) + "\n";
		s += "=========== Durchschnittliche Wegstrecke ==========\n";
		s += "Gesamt:               " + this.getDurchschnittlicheWegstrecke() + "\n";
		s += "Stückeschneider:      " + this.getDurchschnittlicheWegstrecke(Holzvollernter.TYP_STUECKE_SCHNEIDEN) + "\n";
		s += "Hackschnätzler:       " + this.getDurchschnittlicheWegstrecke(Holzvollernter.TYP_HACKSCHNAETZELN) + "\n";
		s += "============ Durchschnittliche Schritte ===========\n";
		s += "Gesamt:               " + this.getDurchschnittlicheSchritte() + "\n";
		s += "Stückeschneider:      " + this.getDurchschnittlicheSchritte(Holzvollernter.TYP_STUECKE_SCHNEIDEN) + "\n";
		s += "Hackschnätzler:       " + this.getDurchschnittlicheSchritte(Holzvollernter.TYP_HACKSCHNAETZELN) + "\n";
		s += "====================== Längen =====================\n";
		s += "Kleinste Länge:       " + this.getKuerzesteLaenge() + "m\n";
		s += "Längste Länge:        " + this.getLaengsteLaenge() + "m\n";
		s += "=========== Durchschnittliche Baumdicke ===========\n";
		s += "Gesamt:               " + this.getDurchschnittlicheBaumdicke() + "cm\n";
		s += "Kleinste Länge:       " + this.getDurchschnittlicheBaumdicke(Holzvollernter.ERNTER_TYP_FAHRER) + "cm\n";
		s += "Längste Länge:        " + this.getDurchschnittlicheBaumdicke(Holzvollernter.ERNTER_TYP_SCHREITER) + "cm\n";
		return this.name + "\n" + s;
	}
}
