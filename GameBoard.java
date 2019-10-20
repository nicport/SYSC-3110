import java.util.ArrayList;

public class GameBoard {
	public static final int SIZE = 5;
	private Tile[][] tiles;
	private ArrayList<GamePiece> boardpieces;
	
	public GameBoard(ArrayList<GamePiece> p) {
		boardpieces = p;
		tiles = new Tile[SIZE][SIZE];
		
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				tiles[i][j] = new Tile(j,i);						
			}
		}
		
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				for(int piece = 0; piece < 8; piece ++) {
					if(boardpieces.get(piece).getX() == j && boardpieces.get(piece).getY() == i) {
						
						tiles[i][j].setOnTop(boardpieces.get(piece));
						
						if(boardpieces.get(piece) instanceof Fox) {
							if(((Fox) boardpieces.get(piece)).getUpDown())
								tiles[i+1][j].setOnTop(boardpieces.get(piece));
							else
								tiles[i][j+1].setOnTop(boardpieces.get(piece));
						}
					}
				}
			}
		}
	}
	
	public void movePiece(int x, int y, int direction) {
		GamePiece g = tiles[x][y].getOnTop();
		Tile newTile = null;
		
		switch(direction) {
			case 0: 
				if(y == 0) System.out.println("Cannot move up.");
				else newTile = tiles[x][y - 1]; // moving up
			
			case 1: 
				
				if(x == GameBoard.SIZE) System.out.println("Cannot move right.");
				else {
					
					if(g instanceof Fox) {
						if(x + 1 == GameBoard.SIZE) System.out.println("Cannot move right.");
						else newTile = tiles[x + 2][y];
					}
					else newTile = tiles[x + 1][y]; // moving right
				}
			
			case 2: 
				
				if(y == GameBoard.SIZE) System.out.println("Cannot move down.");
				else {
					if(g instanceof Fox) {
						if(y + 1 == GameBoard.SIZE) System.out.println("Cannot move down.");
						else newTile = tiles[x][y + 2];
					}
					else newTile = tiles[x][y + 1]; // moving down
				}
			
			case 3: 
				if(x == 0) System.out.println("Cannot move left.");
				else newTile = tiles[x - 1][y]; // moving left
			default: System.out.println("Illegal direction.");
		}
		
		if(newTile != null) {
			g.move(direction);
			tiles[x][y].setEmpty();
			
			if(!(newTile.isEmpty())) {
				if(g instanceof Fox) newTile.getOnTop().handleFoxCollision(new MoveEvent(
						x, y, direction, g));
				else newTile.getOnTop().handleBunnyCollision(new MoveEvent(
						x, y, direction, g));
			}
			
			if(g instanceof Fox) {
				tiles[((Fox) g).getBackX()][((Fox) g).getBackY()].setOnTop(g);
			}
			newTile.setOnTop(g);
			
		}
	}
	
	public Tile getTile(int x, int y) {
		return this.tiles[x][y];
	}
	
	public void printBoard() {
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				tiles[i][j].printTile();
			}
			System.out.println("");
		}
	}
}