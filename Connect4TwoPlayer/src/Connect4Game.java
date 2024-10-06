import java.util.Scanner;
import java.util.Random;

public class Connect4Game {
	/* SELF ASSESSMENT

	Connect4Game class (35 marks): 35 
	My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit 
	inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players 
	are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like 
	to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
	Comment: 

	Connect4Grid interface (10 marks): 10
	I define all 7 methods within this interface.
	Comment: Yes

	Connect4Grid2DArray class (25 marks): 25
	My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column 
	to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides 
	as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
	Comment: Yes it does all of this

	ConnectPlayer abstract class (10 marks): 10
	My class provides at lest one non-abstract method and at least one abstract method. 
	Comment: Yes

	C4HumanPlayer class (10 marks): 10
	My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.
	Comment: Yes

	C4RandomAIPlayer class (10 marks): 10
	My class extends the ConnectPlayer class and overrides the abstract method(s). It provides AI player functionality. 
	Comment: Yes

	Total Marks out of 100: 100

	*/

	public static void main(String[] args) {
		
		boolean finished = false;
		while (!finished)
		{
			System.out.println("Welcome to Connect 4! Enter 'go' to play or 'quit' to exit: ");
			Scanner sc = new Scanner(System.in);
			String answer = sc.next();
			if (answer.equalsIgnoreCase("quit"))
			{
				System.out.println("Goodbye, thanks for playing!");
				finished = true;
			}
			else if (answer.equalsIgnoreCase("go"))
			{
				Connect4Grid2DArray grid = new Connect4Grid2DArray();
				grid.emptyGrid(); //Creates an empty grid

				
				ConnectPlayer player1 = new C4HumanPlayer();
				System.out.println("Player 1 enter your name: ");
				player1.setName(sc.next());
				player1.setColour('R'); //creates Human Player 1, sets name to Player 1 and sets colour to red
				
				System.out.println("Do you want to play against the computer (Enter '1') or with two players (Enter '2')?: ");
				int numberOfPlayers = sc.nextInt();
				if (numberOfPlayers == 1)
				{
					ConnectPlayer player2 = new C4RandomAIPlayer();
					player2.setName("Computer");
					player2.setColour('Y');
					System.out.println(player1.getName() + " you will be Red. " + player2.getName() + " will be Yellow.");
					System.out.println(grid.toString()); 
					
					boolean gameOver = false;
					while (!gameOver)
					{
						player1.dropPiece(player1, grid);
						System.out.println(grid.toString());
						
						if (grid.didLastPieceConnect4())
						{
							gameOver = true;
							System.out.println("Congratulations " + player1.getName() + ", you won!");
						}
						else if (grid.isGridFull())
						{
							gameOver = true;
							System.out.println("Game over. Neither of you connected 4. Try again to decide who is superior!");
						}
						else 
						{
							player2.dropPiece(player2, grid);
							System.out.println(grid.toString());
							
							if (grid.didLastPieceConnect4())
							{
								gameOver = true;
								System.out.println("Hard luck " + player1.getName() + " but it seems you are no match for the Computer.");
							}
							else if (grid.isGridFull())
							{
								gameOver = true;
								System.out.println("Game over. Neither of you connected 4. Try again to decide who is superior!");
							}
							
						}
						
					}	
					
				}
				else if (numberOfPlayers == 2)
				{
					ConnectPlayer player2 = new C4HumanPlayer();
					System.out.println("Player 2 enter your name: ");
					player2.setName(sc.next());
					player2.setColour('Y');
					System.out.println(player1.getName() + " you will be Red. " + player2.getName() + " you will be Yellow.");
					System.out.println(grid.toString()); 
					
					boolean gameOver = false;
					while (!gameOver)
					{
						player1.dropPiece(player1, grid);
						System.out.println(grid.toString());
						
						if (grid.didLastPieceConnect4())
						{
							gameOver = true;
							System.out.println("Congratulations " + player1.getName() + ", you won! Hard luck " + player2.getName() + " but it seems " + player1.getName() + " is the superior human.");
						}
						else if (grid.isGridFull())
						{
							gameOver = true;
							System.out.println("It's a draw!. Neither of you connected 4.");
						}
						else 
						{
							player2.dropPiece(player2, grid);
							System.out.println(grid.toString());
							
							if (grid.didLastPieceConnect4())
							{
								gameOver = true;
								System.out.println("Congratulations " + player2.getName() + ", you won! Hard luck " + player1.getName() + " but it seems " + player2.getName() + " is the superior human.");
							}
							else if (grid.isGridFull())
							{
								gameOver = true;
								System.out.println("It's a draw!. Neither of you connected 4.");
							}
							
						}
						
					}
					
				}
				else 
				{
					System.out.println("Invalid input.");
				}
				
			}
			else 
			{
				System.out.println("Invalid input.");
			}
			
		}
		
	}

}
