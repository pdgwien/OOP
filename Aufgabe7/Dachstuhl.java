import java.util.ArrayList;

public class Dachstuhl
{
	private final String name;
	private final ArrayList<Holz> hoelzer;
	
	public Dachstuhl( String name )
	{
		this.name = name;
		this.hoelzer = new ArrayList<>();
	}
	
	public void add( Holz h )
	{
		this.hoelzer.add(h);
	}
	
	public ArrayList<Holz> list()
	{
		return this.hoelzer;
	}
	
	public String getName()
	{
		return this.name;
	}
}