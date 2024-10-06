import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Random;

public class HiLowGame {
	
	public static final int MAX_NUMBER = 20;
	public static final int GUESSES_ALLOWED = 5;

	public static void main(String[] args) {
		
		int count = 1;
		Random generator = new Random();
		int numberToGuess = generator.nextInt( MAX_NUMBER );
		for (count=1; count <= GUESSES_ALLOWED; count++)
		{
			String numberInput = JOptionPane.showInputDialog(null, "Choose a number between 0 and 20 (or enter Cancel): ");
			Scanner input = new Scanner( numberInput );
			if (input.hasNextInt());
			{
				int numberGuessed = input.nextInt();
				if (numberGuessed == numberToGuess)
				{
					JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number correctly in " + count + " tries!" );
				}
				else if (numberGuessed < numberToGuess)
				{
					JOptionPane.showMessageDialog(null, "Your guess " + numberGuessed + " was too low. ");
				}
				else if (numberGuessed > numberToGuess)
				{
					JOptionPane.showMessageDialog(null, "Your guess " + numberGuessed + " was too high. ");
				}	
				
			} 
			input.close();
			
		}
		count++;
		if (count > GUESSES_ALLOWED)
		{
			JOptionPane.showMessageDialog(null, "Hard Luck! The correct number was " + numberToGuess);
		}

	}

}
