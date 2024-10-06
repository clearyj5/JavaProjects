import java.util.Scanner;
import javax.swing.JOptionPane;

public class CompetitionPrizes {

	public static void main(String[] args) {
		
		int currentNumber = 3;
		int divisor = 2;
		boolean isPrimeNumber = true;
		
		String input = JOptionPane.showInputDialog(null, "Please enter the total number of competitors: ");
		Scanner inputScanner = new Scanner(input);
		if (inputScanner.hasNextInt());
		{
			int totalCompetitors = inputScanner.nextInt();
			String output = ("Prizes should be given to competitors who come 1st, 2nd, 3rd, ");
			for (currentNumber = 3; currentNumber == totalCompetitors ;currentNumber++)
			{
				for (divisor = 2; (divisor <= (currentNumber)) && (isPrimeNumber); divisor++)
				{
					if (currentNumber % divisor == 0)
					{
						isPrimeNumber = false;
					}
				}
				if (isPrimeNumber = true)
				{
					output = output + currentNumber + "th, " ;
					
				}
			}
			JOptionPane.showMessageDialog(null, output);
		}
		inputScanner.close();

	}

}
