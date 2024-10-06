import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;

/* SELF ASSESSMENT
1. Did I use appropriate easy-to-understand, meaningful variables and CONSTANTS within the code? 
    Mark out of 10: 10
    Comment: Yes I did.
2. Did I format the variable and CONSTANT names appropriate (in lowerCamelCase and UPPERCASE)?
    Mark out of 5: 5
    Comment: Yes I did.
3. Did I generate the computer's choice in each game correctly using a Random number generator?
    Mark out of 10: Yes
    Comment: Yes I did.
4. Did I input the user's choice in each game correctly?
    Mark out of 10: 10
    Comment: Yes I did.
5. Did I correctly compare the choices and update the score appropriately?
    Mark out of 20: 20
    Comment: Yes I did.
6. Did I inform the user of who won each game (and why) correctly?
    Mark out of 10: 10
    Comment: Yes I did.
7. Did I use an appropriate for loop to allow the player to play 5 games?  There should be only one loop.
    Mark out of 20: 20
    Comment: Yes I did.
8. Did I output the final scores correctly after the 5 games were played. 
    Mark out of 10: 10
    Comment: Yes I did.
9. How well did I complete this self-assessment?
    Mark out of 5: 5
    Comment: With the utmost accuracy and precision.
Total Mark out of 100 (Add all the previous marks): 100
*/

public class RockPaperScissors {
	
	public static final int MAX_NUMBER = 3;
	public static final int NUMBER_OF_ROUNDS = 5;
	public static final int ROCK = 1;
	public static final int PAPER = 2;
	public static final int SCISSORS = 3;
	public static final int MAX_INPUT = 3;
	public static final int MIN_INPUT = 1;

	public static void main(String[] args) {

		
		int count;
		int computerScore = 0;
		int userScore = 0;
		
		for (count=0; count < NUMBER_OF_ROUNDS; count++ )
		{

			String input = JOptionPane.showInputDialog(" Enter 1 (for Rock) or 2 (for Paper) or 3 (for Scissors): ");
			Scanner inputScanner = new Scanner( input );
			if (inputScanner.hasNextInt())
			{
				int userChoice = inputScanner.nextInt();
				
				Random generator = new Random();
				int computerChoice = generator.nextInt( MAX_NUMBER ) + 1;
				
				if (computerChoice == ROCK && userChoice == ROCK )
				{
					JOptionPane.showMessageDialog(null, "This round was a draw as I chose Rock too.");
				}
				else if (computerChoice == SCISSORS && userChoice == SCISSORS )
				{
					JOptionPane.showMessageDialog(null, "This round was a draw as I chose Scissors too.");
				}
				else if (computerChoice == PAPER && userChoice == PAPER )
				{
					JOptionPane.showMessageDialog(null, "This round was a draw as I chose Paper too.");
				}
				else if (computerChoice == ROCK && userChoice == PAPER)
				{
					JOptionPane.showMessageDialog(null, "You won this round as I chose Rock.");
					userScore++;
				}
				else if (computerChoice == PAPER && userChoice == ROCK)
				{
					JOptionPane.showMessageDialog(null, "You lost this round as I chose Paper.");
					computerScore++;
				}
				else if (computerChoice == SCISSORS && userChoice == ROCK)
				{
					JOptionPane.showMessageDialog(null, "You won this round as I chose Scissors.");
					userScore++;
				}
				else if (computerChoice == ROCK && userChoice == SCISSORS)
				{
					JOptionPane.showMessageDialog(null, "You lost this round as I chose Rock.");
					computerScore++;
				}
				else if (computerChoice == PAPER && userChoice == SCISSORS)
				{
					JOptionPane.showMessageDialog(null, "You won this round as I chose Paper.");
					userScore++;
				}
				else if (computerChoice == SCISSORS && userChoice == PAPER)
				{
					JOptionPane.showMessageDialog(null, "You lost this round as I chose Scissors.");
					computerScore++;
				}
				else if (userChoice < MIN_INPUT || userChoice > MAX_INPUT)
				{
					JOptionPane.showMessageDialog(null, "Invalid input, please enter either 1, 2 or 3. You lost this round for breaking the rules.");
					computerScore++;
				}
			}
			inputScanner.close();
			
		}
		JOptionPane.showMessageDialog(null, " The final score was Computer " + computerScore + " - " + userScore + " User.");
		if (userScore > computerScore)
		{
			JOptionPane.showMessageDialog(null, " Winner winner chickn dinner... Congratulations!");
		}
		else if (userScore < computerScore)
		{
			JOptionPane.showMessageDialog(null, " Hard luck, you lost. The computers are taking over...");
		}
		else if (userScore == computerScore)
		{
			JOptionPane.showMessageDialog(null, " Draw game... You were a worthy opponent");
		}
		
	}

}
