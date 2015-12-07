import java.awt.Point;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuchdruckerKolonie implements Runnable {
	private final Wald wald;
	
	private int besiedelungen;
	
	private Point position;
	
	public BuchdruckerKolonie( Wald wald, int x, int y ) {
		this.wald = wald;
		this.wald.gesund(x, y);
		
		this.position = new Point(x, y);
	}
	
	public int getBesiedelungen() {
		return this.besiedelungen;
	}
	
	public void addBesiedelungen( int besiedelungen ) {
		this.besiedelungen = besiedelungen;
	}
	
	@Override
	public void run() {
		while(true) {
			Random r = new Random();
			Point p = this.wald.getNextFreeNeighbor(this.position);
			if( p != null ) {
				this.wald.gesund(p);
				this.position = p;
			}
			try {
				//Thread.sleep(1000);
				Thread.sleep( ( 5 + r.nextInt(50) ) * 1000 );
			} catch (InterruptedException ex) {
				Logger.getLogger(BuchdruckerKolonie.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
