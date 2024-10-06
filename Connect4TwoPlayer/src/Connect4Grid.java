
public interface Connect4Grid {
	
	public void emptyGrid();
	public String toString();
	public boolean isValidColumn(int column);
	public boolean isColumnFull(int column);
	public void dropPiece(ConnectPlayer player, int column);
	public boolean didLastPieceConnect4();
	public boolean isGridFull();   
	
	public static final int NUMBER_OF_ROWS = 6;
	public static final int NUMBER_OF_COLUMNS = 7;
	public static final char EMPTY = ' ';
	
	public char[][] grid = new char[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
	
}