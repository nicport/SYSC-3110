
public class GamePiece {
	protected int x;
	protected int y;
	private int size;
	
	public GamePiece(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
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

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
