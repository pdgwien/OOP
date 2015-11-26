public class Test
{
	public static void main(String[] args)
	{
		// Tests hier implementieren
		Bauholzlager bhl = new Bauholzlager("Lager1");
		
		Dachstuhl d = new Dachstuhl("Dachstuhl1");
		
		Holz h1 = new Kantholz( Holz.GEHOBELT, 10.5f, 25.10f, 20.0f, 10.0f );
		Holz h2 = new Rundholz( Holz.SAEGERAU, 30.5f, 30.0f, 10.0f );
		
		bhl.addDachstuhl(d);
		bhl.add(h1);
		bhl.add(h2);
		bhl.list();
	}
}
