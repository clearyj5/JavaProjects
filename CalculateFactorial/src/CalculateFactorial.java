import java.util.Scanner;

public class CalculateFactorial {

	public static final int NUMBER_1 = 1;
	
	public static void main(String[] args) {
		
		System.out.print("Enter a number to determine whether or not it is a Factorian: ");
		Scanner input = new Scanner(System.in);
		int index = input.nextInt();
		if (isFactorian(index))
		{
			System.out.println("The number " + index + " is a Factorian.");
		}
		else if (!isFactorian(index))
		{
			System.out.println("The number " + index + " is not a Factorian.");
		}
		input.close();
	}
	
	private static int computeFactorial( int number ) {
		if (number > 1)
		{
			int result = number * computeFactorial(number - 1);
			return result;
		}
		else 
		{
			return NUMBER_1;
		}
	}
	
	private static boolean isFactorian( int index ) {
		int count = 0;
		int total = 0;
		int number = index;
		
		do
		{
			count = (number % 10);
			number = (number / 10);
			total += computeFactorial(count);
			
		} while(number >= NUMBER_1);
		return (total == index);
		
	}
	
}
