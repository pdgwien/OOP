import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Wald {
	private final short[][] wald;
	
	// Bezieht sich auf die Kolonien, nicht auf den Wald !!
	static final int GESUND = 1;
	static final int KRANK = 2;
	
	public Wald( int width, int height) {
		this.wald = new short[height][width];
	}
	
	private void checkKolonien() {
		for( int y = 0; y < this.wald.length; y++ ) {
			for( int x = 0; x < this.wald[y].length; x++ ) {
				if( this.allHealthy(x, y) ) {
					this.wald[y][x] = Wald.KRANK;
				}
			}
		}
	}
	
	public boolean isFree( int x, int y ) {
		boolean free = false;
		try {
			free = this.wald[y-1][x-1] == 0;
		}
		catch( ArrayIndexOutOfBoundsException e ) {}
		return free;
	}
	
	public boolean isFree( Point p ) {
		return this.isFree(p.x, p.y);
	}
	
	private synchronized boolean allHealthy( int x, int y ) {
		boolean result = false;
		try {
			result = (this.wald[y][x] == Wald.GESUND &&
				this.wald[y-1][x] == Wald.GESUND &&
				this.wald[y-1][x+1] == Wald.GESUND &&
				this.wald[y][x+1] == Wald.GESUND &&
				this.wald[y+1][x+1] == Wald.GESUND &&
				this.wald[y+1][x] == Wald.GESUND &&
				this.wald[y+1][x-1] == Wald.GESUND &&
				this.wald[y][x-1] == Wald.GESUND &&
				this.wald[y-1][x-1] == Wald.GESUND);
		}
		catch( ArrayIndexOutOfBoundsException e ) {}
		return result;
	}
	
	public synchronized Point getNextFreeNeighbor( int x, int y ) {
		ArrayList<Point> pointerRoulette = new ArrayList<>();
		Random r = new Random();
		// Nord
		if( this.isFree(x, y-1) ) {
			pointerRoulette.add(new Point(x, y-1));
		}
		// Nord-Ost
		if( this.isFree(x+1, y-1) ) {
			pointerRoulette.add(new Point(x+1, y-1));
		}
		// Ost
		if( this.isFree(x+1, y) ) {
			pointerRoulette.add(new Point(x+1, y));
		}
		// Süd-Ost
		if( this.isFree(x+1, y+1) ) {
			pointerRoulette.add(new Point(x+1, y+1));
		}
		// Süd
		if( this.isFree(x, y+1) ) {
			pointerRoulette.add(new Point(x, y+1));
		}
		// Süd-West
		if( this.isFree(x-1, y+1) ) {
			pointerRoulette.add(new Point(x-1, y+1));
		}
		// West
		if( this.isFree(x-1, y) ) {
			pointerRoulette.add(new Point(x-1, y));
		}
		// Kanye West's Tochter
		if( this.isFree(x-1, y-1) ) {
			pointerRoulette.add(new Point(x-1, y-1));
		}
		
		if( !pointerRoulette.isEmpty() ) {
			return pointerRoulette.get(r.nextInt(pointerRoulette.size()));
		}
		
		return null;
	}
	
	public Point getNextFreeNeighbor( Point p ) {
		return this.getNextFreeNeighbor(p.x, p.y);
	}
	
	public synchronized void gesund( int x, int y ) {
		this.wald[y-1][x-1] = Wald.GESUND;
	}
	
	public void gesund( Point p ) {
		this.gesund(p.x, p.y);
		this.checkKolonien();
	}
	
	public synchronized void krank( int x, int y ) {
		this.wald[y-1][x-1] = Wald.KRANK;
	}
	
	public void krank( Point p ) {
		this.krank(p.x, p.y);
	}
	
	public void print() {
		for (short[] wald1 : this.wald) {
			for (short wald2 : wald1) {
				System.out.print( wald2 == 1 ? " o" : ( wald2 == 2 ? " x" : "  " ) );
			}
			System.out.println("");
		}
	}
}
