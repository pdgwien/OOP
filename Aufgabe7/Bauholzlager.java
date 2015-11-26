import java.util.ArrayList;
import java.util.Iterator;

public class Bauholzlager
{
	private final String name;
	private final ArrayList<Holz> lager;
	private final ArrayList<Dachstuhl> dachstuehle;
	
	public Bauholzlager( String name )
	{
		this.name = name;
		this.lager = new ArrayList<>();
		this.dachstuehle = new ArrayList<>();
	}
	
	public void addDachstuhl(Dachstuhl d)
	{
		this.dachstuehle.add(d);
	}
	
	public void add( Holz v )
	{
		this.lager.add(v);
	}
	
	public Holz get( Holz h )
	{
		if( this.lager.isEmpty() )
		{
			return null;
		}
		
		for (Holz hi : this.lager)
		{
			if( hi == h )
			{
				this.lager.remove(hi);
				return hi;
			}
		}
		
		return null;
	}
	
	public void holzAnDachstuhl( Dachstuhl d, Holz h )
	{
		d.add(this.get(h));
	}
	
	public void list()
	{
		for( Iterator<Holz> i = this.lager.iterator(); i.hasNext(); )
		{
			System.out.println( i.next().getLaenge() + " cm" );
		}
	}
	
	private Dachstuhl getDachstuhl( Dachstuhl d )
	{
		for( Iterator<Dachstuhl> i = this.dachstuehle.iterator(); i.hasNext(); )
		{
			if( i.next() == d )
			{
				return d;
			}
		}
		return null;
	}
	
	public void list( Dachstuhl d )
	{
		Dachstuhl dach = this.getDachstuhl(d);
		
		if( dach != null )
		{
			for( Iterator<Holz> i = dach.list().iterator(); i.hasNext(); )
			{
				System.out.println( i.next().getLaenge() + " cm" );
			}
		}
	}
	
	public void price( Dachstuhl d )
	{
		Dachstuhl dach = this.getDachstuhl(d);
		
		if( dach != null )
		{
			for( Iterator<Holz> i = dach.list().iterator(); i.hasNext(); )
			{
				System.out.println( i.next().getLaenge() + " €" );
			}
		}
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
}
