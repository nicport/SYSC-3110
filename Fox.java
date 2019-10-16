
public class Fox extends GamePiece {
	private boolean upDown;
	
	public Fox(String s, int xpos, int ypos, boolean direction) {
		super(xpos, ypos, 2, s);
		upDown = direction;	
	}
	
	public boolean getUpDown() {
		return upDown;
	}

	public void move() {
		
	}
}
