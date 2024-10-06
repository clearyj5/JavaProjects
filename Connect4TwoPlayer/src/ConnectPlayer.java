import java.util.*;
public abstract class ConnectPlayer {

	private char colour;
	private String name;
	
	void setColour(char colour) {
		this.colour = colour;
	}
	
	char getColour() {
		for ()
		return colour;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	String getName() {
		return name;
	}
	
	void dropPiece(ConnectPlayer player, Connect4Grid2DArray grid) {
		
		int column = getColumn(grid);
		grid.dropPiece(player, column);
		
	}
	
	abstract int getColumn(Connect4Grid2DArray grid);
	
	
}