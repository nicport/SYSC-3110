
public class Bunny extends GamePiece {
	private String name;
	
	public Bunny(String s, int xpos, int ypos) {
		super(xpos, ypos, 1);
		this.name = s;
	}
	public void move() {
		
	}
	@Override
	public String getName(){
		return name;
	}
}
