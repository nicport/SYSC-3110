
public class Fox extends GamePiece {
	private String name;
	private boolean upDown;
	
	public Fox(String s, int xpos, int ypos, boolean direction) {
		super(xpos, ypos, 2);
		name = s;
		upDown = direction;	
	}
	
	public boolean getUpDown() {
		return upDown;
	}
	@Override
	public String getName(){
		return name;
	}
	public void move() {
		
	}
}
