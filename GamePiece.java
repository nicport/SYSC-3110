
public class GamePiece {
	protected int x;
	protected int y;
	private int size;
	private String name;
	
	public GamePiece(int x, int y, int size, String name) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.name = name;
	}

	public boolean getUpDown() {
		return updown;
	}
	public boolean getFox() {
		return fox;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getSize() {
		return size;
	}
	public String getName(){
		return this.name;
	}
}
