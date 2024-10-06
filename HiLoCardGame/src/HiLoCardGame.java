import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;

public class HiLoCardGame {
	
	public static final int ACE = 1;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	public static final int WIN_REQUIREMENT = 4;
	public static final String JACK_NAME = "Jack";
	public static final String QUEEN_NAME = "Queen";
	public static final String KING_NAME = "King";
	public static final String ACE_NAME = "Ace";

	public static void main(String[] args)
	{
		Random generator = new Random();
		int generatedNumber = generator.nextInt(KING) + ACE;
		
		int count = 0;
		String currentCard = "";
		String nextCard = "";
		
		//To explain the rules
		JOptionPane.showMessageDialog(null, "You will be presented with an initial card (2 – 10, Jack, Queen, King, or Ace) and must guess \n whether the next card with be Higher (Hi), Lower (Lo) or Equal to the current card. You \n must guess successfully 4 times in a row in order to win.");
		
		do
		{
			int nextGeneratedNumber = generator.nextInt(KING) + ACE;
			
			if (generatedNumber == ACE)
			{
				currentCard = ACE_NAME;
			}
			else if (generatedNumber == JACK)
			{
				currentCard = JACK_NAME;
			}
			else if (generatedNumber == QUEEN)
			{
				currentCard = QUEEN_NAME;
			}
			else if (generatedNumber == KING)
			{
				currentCard = KING_NAME;
			}
			else 
			{
				currentCard = "" + generatedNumber;
			}
			
			if (nextGeneratedNumber == ACE)
			{
				nextCard = ACE_NAME;
			}
			else if (nextGeneratedNumber == JACK)
			{
				nextCard = JACK_NAME;
			}
			else if (nextGeneratedNumber == QUEEN)
			{
				nextCard = QUEEN_NAME;
			}
			else if (nextGeneratedNumber == KING)
			{
				nextCard = KING_NAME;
			}
			else 
			{
				nextCard = "" + nextGeneratedNumber;
			}
			
			String input = JOptionPane.showInputDialog(null, " The card is a " + currentCard + ". Do you think the next card will be higher, lower or equal?");
			Scanner inputScanner = new Scanner(input);
			
			if (input.equalsIgnoreCase("lower")||input.equalsIgnoreCase("higher")||input.equalsIgnoreCase("equal"))
			{
				if (input.equalsIgnoreCase("lower") && nextGeneratedNumber < generatedNumber || input.equalsIgnoreCase("higher") && nextGeneratedNumber > generatedNumber || input.equalsIgnoreCase("equal") && nextGeneratedNumber == generatedNumber)
				{
					count++;
					JOptionPane.showMessageDialog(null,  "Correct!");
					generatedNumber = nextGeneratedNumber;
				}
				else
				{
					count = 0;
					JOptionPane.showMessageDialog(null,  "Incorrect.");
					generatedNumber = nextGeneratedNumber;
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,  "Invalid input. Please enter either 'higher', 'lower', or 'equal'. ");
			}
			inputScanner.close();
		} while (count < WIN_REQUIREMENT);
		JOptionPane.showMessageDialog(null, "Congratulations! You got 4 in a row correct. You win! ");
		
	}

}
