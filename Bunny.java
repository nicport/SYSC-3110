//Class written by Ashton and Andrew

public class Bunny extends GamePiece {
	
	private boolean hasMoved;
	
	public Bunny(String s, int xpos, int ypos) {
		super(xpos, ypos, 1, s);
		hasMoved = false;
	}
	
	@Override
	public String toString() {
		return super.getName();
	}
	
	@Override
	public void move(int direction) {
		super.move(direction);
		hasMoved = true;
	}
	
	public boolean getHasMoved() {
		return this.hasMoved;
	}
}