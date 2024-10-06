
public class Connect4Grid2DArray implements Connect4Grid {

	@Override
	public void emptyGrid() {
		
		for (int index = 0; index < NUMBER_OF_ROWS; index++)
		{
			for (int index2 = 0; index2 < NUMBER_OF_COLUMNS; index2++)
			{
				grid[index][index2] = EMPTY;
			}
		
		}
		
	}

	@Override
	public boolean isValidColumn(int column) {
		
		if (column <= (NUMBER_OF_COLUMNS-1) && column >= 0)
		{
			return true;
		}
		return false;
		
	}

	@Override
	public boolean isColumnFull(int column) {
		
		if (isValidColumn(column))
		{
			if (grid[0][column - 1] != EMPTY)
			{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void dropPiece(ConnectPlayer player, int column) {
		
		for (int index = (NUMBER_OF_ROWS - 1); index >= 0; index--)
		{
			if (grid[index][column - 1] == EMPTY)
			{
				grid[index][column - 1] = player.getColour();
				break;
			}
			
		}
		
	}

	@Override
	public boolean didLastPieceConnect4() {
		
		boolean result = false;
		for (int index = 0; index < NUMBER_OF_ROWS; index++)
		{
			for (int index2 = 0; index2 < NUMBER_OF_COLUMNS; index2++)
			{
				char check = grid[index][index2];
				try {
					if (check != EMPTY && ((check == grid[index][index2 + 1] &&  check == grid[index][index2 + 2] &&  check == grid[index][index2 + 3] )
					 || (check == grid[index + 1][index2] && check == grid[index + 2][index2] && check == grid[index + 3][index2])
					 || (check == grid[index + 1][index2 + 1] && check == grid[index + 2][index2 + 2] && check == grid[index + 3][index2 + 3])
					 || (check == grid[index + 1][index2 - 1] && check == grid[index + 2][index2 - 2] && check == grid[index + 3][index2 - 3])))
					{
						result = true;
					}
					
				} catch (Exception e) {}
				
			}
			
		}
		return result;
	}

	@Override
	public boolean isGridFull() {
		
		for (int index = 0; index < NUMBER_OF_ROWS; index++)
		{
			for (int index2 = 0; index2 < NUMBER_OF_COLUMNS; index2++)
			{
				if (grid[index][index2] == EMPTY)
				{
					return false;
				}
			}
		}
		
		return true;
	}

	@Override
	public String toString() {
		
		String gridOutput = " 1   2   3   4   5   6   7 \n"
				+ "---|---|---|---|---|---|---\n"
				+ " " + grid[0][0] + " | " + grid[0][1] + " | " + grid[0][2] + " | " + grid[0][3] + " | " + grid[0][4] + " | " + grid[0][5] + " | " + grid[0][6] + " \n"
				+ "---|---|---|---|---|---|---\n"
				+ " " + grid[1][0] + " | " + grid[1][1] + " | " + grid[1][2] + " | " + grid[1][3] + " | " + grid[1][4] + " | " + grid[1][5] + " | " + grid[1][6] + " \n"
				+ "---|---|---|---|---|---|---\n"
				+ " " + grid[2][0] + " | " + grid[2][1] + " | " + grid[2][2] + " | " + grid[2][3] + " | " + grid[2][4] + " | " + grid[2][5] + " | " + grid[2][6] + " \n"
				+ "---|---|---|---|---|---|---\n"
				+ " " + grid[3][0] + " | " + grid[3][1] + " | " + grid[3][2] + " | " + grid[3][3] + " | " + grid[3][4] + " | " + grid[3][5] + " | " + grid[3][6] + " \n"
				+ "---|---|---|---|---|---|---\n"
				+ " " + grid[4][0] + " | " + grid[4][1] + " | " + grid[4][2] + " | " + grid[4][3] + " | " + grid[4][4] + " | " + grid[4][5] + " | " + grid[4][6] + " \n"
				+ "---|---|---|---|---|---|---\n"
				+ " " + grid[5][0] + " | " + grid[5][1] + " | " + grid[5][2] + " | " + grid[5][3] + " | " + grid[5][4] + " | " + grid[5][5] + " | " + grid[5][6] + " \n";
		
		return gridOutput;
	}

}
	
	

	
	
