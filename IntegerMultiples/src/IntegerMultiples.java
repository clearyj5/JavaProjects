import java.util.Scanner;

public class IntegerMultiples {

	public static void main(String[] args) {
		System.out.print ("Please enter a positive integer: ");
		Scanner input = new Scanner (System.in);
		int startNumber = input.nextInt();
		System.out.print("Please enter a positive integer for the upper limit of the multiples: ");
		int upperLimit = input.nextInt();
		input.close();
		
		if ( startNumber <= 0)
		{
			System.out.print( "The starting number must be greater than zero. ");
		}
		else 
		{
			System.out.print("The multiples of " + startNumber + "(up to " + upperLimit + ") are ");
			int count;
			for ( count = 0; count <= upperLimit; count++ ) 
			{
				if (count%startNumber == 0 ) 
				{
					System.out.print( count + ((count == upperLimit)? "." : ", "));
				}
		
			}
		}	

	}

}
