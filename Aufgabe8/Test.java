import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {
	public static void main(String[] args) {
		Wald wald = new Wald( 10, 8 );
		
		BuchdruckerKolonie bk = new BuchdruckerKolonie( wald, 5, 4 );
		
		BuchdruckerKolonie bk2 = new BuchdruckerKolonie( wald, 8, 8 );
		
		Thread t = new Thread(bk);
		t.start();
		
		Thread t2 = new Thread(bk2);
		t2.start();
		
		Thread waldThread = new Thread( () -> { // Lambda Expression statt anonymer Runnable-Klasse, Bitch!
				while(true) {
					wald.print();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ex) {
						Logger.getLogger(Aufgabe8.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
		});
		
		waldThread.start();
	}
}
