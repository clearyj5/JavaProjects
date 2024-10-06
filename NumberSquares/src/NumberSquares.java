import java.util.Scanner;

public class NumberSquares {

	public static void main(String[] args) {
		System.out.print("Please input a whole number to compute all squares less than or equal to this limit: ");
		Scanner input = new Scanner( System.in );
		if (input.hasNextInt())
		{
			int userLimit = input.nextInt();
			int count = 0;
			if (userLimit == 0)
			{
				System.out.print("The only number whose square is less than or equal to " + userLimit + " is 0. ");
			}
			else 
			{
				System.out.print("The numbers whose squares are less than or equal to " + userLimit + " are ");
				int finalCount = 0;
				do
				{
					count++;
					finalCount = (count*count);
					System.out.print(finalCount + ", ");
				} while (finalCount <= userLimit);
				
			}
			
		}
		input.close();

	}

}
