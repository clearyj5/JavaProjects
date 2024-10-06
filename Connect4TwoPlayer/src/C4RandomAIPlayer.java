import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer {

	@Override
	int getColumn(Connect4Grid2DArray grid) {
		
		boolean gotColumn = false;
		while (!gotColumn)
		{
			Random gen = new Random();
			int column = gen.nextInt(Connect4Grid.NUMBER_OF_COLUMNS) + 1;
			
			if (!grid.isColumnFull(column))
			{
				gotColumn = true;
				return column;
			}
			
		}
	
		return -1;
	}
	
}
