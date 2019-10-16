
public class Mushroom extends GamePiece {
	private String name;
	
	public Mushroom(String s, int xpos, int ypos) {
		super(xpos, ypos, 1);
		name = s;
	}
	
	public void move() {
		
	}
	
	@Override
	public String getName(){
		return name;
	}
}
