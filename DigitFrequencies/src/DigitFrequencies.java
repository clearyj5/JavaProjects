import java.util.Scanner;

/* Write a program which determines the frequency of digits.  The user is allowed to repeatedly enter integers 
 * and the program determines how many times each digit has appeared.  The frequencies should be cumulative 
 * (i.e. the digit frequencies after n numbers have been entered are the frequencies of occurrence of each digit 
 * over all the n numbers entered so far).  As part of your solution, you must write and use the following routines:

void countDigitFrequencies( int number, int[ ] frequencies ) which takes an integer and an array of frequencies 
															and updates the array of frequencies depending on the 
															digits which appear in the number.

void printDigitFrequencies( int[ ] frequencies ) which takes an array containing the frequencies and prints out the 
												frequencies to System.out (but only for the digits which have occurred).

Example input/output: 

   Enter a number> 355333

   Digit frequencies:  3(4) 5(2)

   Enter a number> 113322

   Digit frequencies:  1(2) 2(2) 3(6) 5(2)

   Enter a number> 209339

   Digit frequencies:  0(1) 1(2) 2(3) 3(8) 5(2) 9(2)

   Enter a number>

 */

public class DigitFrequencies {

	public static void main(String[] args) {
		boolean finished = false;
		int[] frequencies = new int[10];
		do
		{
			System.out.println("Enter a number (or enter quit): ");
			Scanner input = new Scanner(System.in);
			if (input.hasNextInt())
			{
				int number = input.nextInt();
				countDigitFrequencies(number, frequencies);
				printDigitFrequencies(frequencies);
			}
			else if (input.hasNext("quit"))
			{
				finished = true;
			}
			else
			{
				System.out.print("Invalid input. Please enter a valid number or enter 'quit': ");
			}
		} while (!finished);

	}
	public static void countDigitFrequencies( int number, int[] frequencies) {
		do
		{
			int count = number%10;
			number = number/10;
			for(int index = 0; index < frequencies.length; index++)
			{
				if (count == index)
				{
					frequencies[index]++;
				}
			} 
			
		} while (number >= 1);
	}
	public static void printDigitFrequencies(int[] frequencies) {
		System.out.print("Digit Frequencies: ");
		for (int index = 0; index < frequencies.length; index++)
		{
			if (frequencies[index] > 0)
			{
				switch (frequencies[index])
				{
				default:
					System.out.print(index + "(" + frequencies[index] + ") ");
				}
			}
		}
	}
}
