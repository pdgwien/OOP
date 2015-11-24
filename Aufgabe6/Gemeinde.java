import java.util.Iterator;

public class Gemeinde
{
	private String name;
	
	private LinkedList forstbetriebe;
	
	public Gemeinde( String name )
	{
		this.forstbetriebe = new LinkedList();
		this.name = name;
	}
	
	public void addForstbetrieb( Forstbetrieb f )
	{
		this.forstbetriebe.add( f );
	}
	
	public boolean removeForstbetrieb( Forstbetrieb f )
	{
		return this.forstbetriebe.remove( f );
	}
	
	public Forstbetrieb getForstbetrieb( Forstbetrieb f )
	{
		return (Forstbetrieb) this.forstbetriebe.get( f );
	}
	
	public LinkedList getAlleForstbetriebe()
	{
		return this.forstbetriebe;
	}
	
	public int anzahlForstgemeinden()
	{
		return this.forstbetriebe.size();
	}
	
	@Override
	public String toString()
	{
		String s = "";
		int x = 1;
		for( Iterator i = this.forstbetriebe.iterator(); i.hasNext(); )
		{
			s += "\n" + (x++) + "   " + ( (Forstbetrieb) i.next());
		}
		return this.name + "\n=======================\nForstbetriebe:" + s;
	}
}
