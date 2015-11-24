public class Test
{
	public static void main(String[] args)
	{
		Gemeinde g = new Gemeinde( "Oaschhausen" );
		
		
		
		Forstbetrieb f1 = new Forstbetrieb( "Peniswald" );
		Forstbetrieb f2 = new Forstbetrieb( "Oaschwald" );
		Forstbetrieb f3 = new Forstbetrieb( "Nippelwald" );
		
		g.addForstbetrieb(f1);
		g.addForstbetrieb(f2);
		g.addForstbetrieb(f3);
		
		System.out.println(g);
		
		Schreiter s = new Schreiter(1, 2);
	}
}
