public class Test
{
	public static void main(String[] args)
	{
		Gemeinde g = new Gemeinde( "St. Inkmorchel" );
		
		Forstbetrieb f1 = new Forstbetrieb( "Forstbetrieb Feichtinger" );
		Forstbetrieb f2 = new Forstbetrieb( "Forstbetrieb Unger" );
		Forstbetrieb f3 = new Forstbetrieb( "Forstbetrieb Nimmer" );
		
		g.addForstbetrieb(f1);
		g.addForstbetrieb(f2);
		g.addForstbetrieb(f3);
		
		System.out.println(g);
		
		Schreiter s = new Schreiter(1, 2);
	}
}
