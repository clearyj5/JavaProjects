import java.util.Scanner;

public class FibonacciSequence {

	public static void main(String[] args) {
		
		System.out.print("What number would you like closest Fibonacci number for: ");
		Scanner input = new Scanner(System.in);
		int fibonacciNumberOne = 0;
		int fibonacciNumberTwo = 1;
		int fibonacciNumbersAdded = 1;
		
		if (input.hasNextInt());
		{
			int numberEntered = input.nextInt();
			if (numberEntered == 0)
			{
				System.out.print("The closest Fibonacci number to 0 is 0");
			}
			else if (numberEntered == 1)
			{
				System.out.print("The closest Fibonacci number to 1 is 1");
			}
			else if ((numberEntered < 0))
			{
				System.out.print("Invalid Input. Please enter a whole number greater than zero e.g. 24");
			}
			else
			{
				while (numberEntered >= fibonacciNumbersAdded)
				{
					fibonacciNumberTwo = fibonacciNumbersAdded;
					fibonacciNumbersAdded = fibonacciNumberOne + fibonacciNumberTwo;
					fibonacciNumberOne = fibonacciNumberTwo;
				}
				if (numberEntered == fibonacciNumberTwo)
				{
					System.out.print("The number " + numberEntered + " is a Fibonacci number itself.");
				}
				else if ((fibonacciNumberTwo - numberEntered) > (fibonacciNumbersAdded - numberEntered))
				{
					System.out.print("The closest Fibonacci number to " + numberEntered + " is " + fibonacciNumberOne + ".");
				}
				else if ((fibonacciNumberTwo - numberEntered) < (fibonacciNumbersAdded - numberEntered))
				{
					System.out.print("The closest Fibonacci number to " + numberEntered + " is " + fibonacciNumberTwo + ".");
				}
				else if ((fibonacciNumberTwo - numberEntered) == (fibonacciNumbersAdded - numberEntered))
				{
					System.out.print("The closest Fibonacci numbers to " + numberEntered + " are " + fibonacciNumberOne + " and " + fibonacciNumberTwo + ".");
				}
				input.close();
			}
		}
		
	}
}		