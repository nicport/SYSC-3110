
//Class written by Ashton and Andrew

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
				tiles[i][j] = new Tile(i, j);				
			}
		}
		
		for(GamePiece g: boardpieces) {
			int i = g.getX();
			int j = g.getY();
			tiles[i][j].setOnTop(g);
			if(g instanceof Fox) {
				if(((Fox) g).getUpDown())
					tiles[i][j + 1].setOnTop(g);
				else
					tiles[i + 1][j].setOnTop(g);
			}
		}
	}
	
	public void movePiece(int x, int y, int direction) {
		GamePiece g = tiles[x][y].getOnTop();
		Tile newTile = tiles[x][y];
		
		switch(direction) {
			case 0: 
				if(y == 0) System.out.println("Cannot move up.");
				else newTile = tiles[x][y - 1]; // moving up
				break;
			
			case 1: 
				
				if(x == GameBoard.SIZE) System.out.println("Cannot move right.");
				else {
					
					if(g instanceof Fox) {
						if(x + 2 == GameBoard.SIZE) System.out.println("Cannot move right.");
						else newTile = tiles[x + 2][y];
					}
					else newTile = tiles[x + 1][y]; // moving right
				}
				break;
			
			case 2: 
				
				if(y == GameBoard.SIZE) System.out.println("Cannot move down.");
				else {
					if(g instanceof Fox) {
						if(y + 2 == GameBoard.SIZE) System.out.println("Cannot move down.");
						else newTile = tiles[x][y + 2];
					}
					else newTile = tiles[x][y + 1]; // moving down
				}
				break;
			
			case 3: 
				if(x == 0) System.out.println("Cannot move left.");
				else newTile = tiles[x - 1][y]; // moving left
				break;
				
			default: 
				System.out.println("Illegal direction.");
				break;
		}
		
		if(newTile != null) {
			if(g instanceof Fox) {
				tiles[((Fox) g).getBackX()][((Fox) g).getBackY()].setEmpty();
			}
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
				newTile = tiles[g.getX()][g.getY()];
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
				tiles[j][i].printTile();
			}
			System.out.println("");
		}
	}
}