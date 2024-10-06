import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer {

	@Override
	int getColumn(Connect4Grid2DArray grid) {
		
		System.out.print(getName() + " it's your turn. Choose a column number to drop a piece (1-7): ");
		boolean finished = false;
		while (!finished)
		{
			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt())
			{
					int input = sc.nextInt();
					if (!grid.isColumnFull(input))
					{
						finished = true;
						return input;
					}
					else
					{
						System.out.println("Column full. Enter a different number between 1 and 7: ");
					}
				
			}
			else 
			{
				System.out.println("Enter a number between 1 and 7: ");
			}
			
		}
		return -1;
	}
	

	
}
