
public class ChessBoard {

	public ChessBoard board;
	public static final int AMOUNT_OF_MOVES_KING_CAN_MAKE = 10;

	public void initialiseGame() {

		//ChessPiece blackCastle = new ChessPiece(CASTLE, BLACK, 8, "A");

		board = null;

	}

	private boolean canMakeMove(ChessPiece piece, int row, char column) {

		return piece.canMakeMove(row, column, board);
	}
	
	private void undoLastMove(ChessPiece piece, int oldRow, char oldColumn) {
		piece.makeMove(oldRow, oldColumn);
	}
	
	public boolean makeMove(ChessPiece piece, int toRow, char toColumn) {
		
		if (piece.canMakeMove(toRow, toColumn, board)) {
			piece.makeMove(toRow, toColumn);
			return true;
		}
		else return false;
	}
	
	public boolean inCheckMate(ChessPiece king) {
		
		for(int i = 0; i < AMOUNT_OF_MOVES_KING_CAN_MAKE; i++)
		{
			
		}
		
		return false;
	}
}
