import java.util.Scanner;

public class SieveOfEratosthenes {
	
	/* SELF ASSESSMENT 
	   1.  createSequence:
	Did I use the correct method definition?
	Mark out of 5:5
	Comment:
	Did I create an array of size n (passed as the parameter) and initialise it?
	Mark out of 5:5
	Comment:
	Did I return the correct item?
	Mark out of 5:5
	Comment:
	   2.  crossOutMultiples
	Did I use the correct method definition?
	Mark out of 5:5
	Comment:
	Did I ensure the parameters are not null and one of them is a valid index into the array
	Mark out of 2:2
	Comment:
	Did I loop through the array using the correct multiple?
	Mark out of 5:5
	Comment:
	Did I cross out correct items in the array that were not already crossed out?
	Mark out of 3:3
	Comment:
	   3.  sieve   
	Did I have the correct function definition?
	Mark out of 5:5
	Comment:
	Did I make calls to other methods?
	Mark out of 5:5
	Comment:      
	Did I return an array with all non-prime numbers are crossed out?
	Mark out of 2:2
	Comment:
	   4.  sequenceTostring  
	Did I have the correct function definition?
	Mark out of 5:5
	Comment:
	Did I ensure the parameter to be used is not null?
	Mark out of 3:3
	Comment: 
	Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
	Mark out of 10:10
	Comment:    
	   5.  nonCrossedOutSubseqToString  
	Did I have the correct function definition
	Mark out of 5:5
	Comment:        
	Did I ensure the parameter to be used is not null?  
	Mark out of 3:3
	Comment:
	Did I loop through the array updating the String variable with just the non-crossed out numbers? 
	Mark out of 5:5
	Comment:
	   6.  main  
	Did I ask  the user for input n and handles input errors?  
	Mark out of 5:5
	Comments:
	Did I make calls to other methods (at least one)?
	Mark out of 5:5
	Comment:  
	Did I print the output as shown in the question?  
	Mark out of 5:5
	Comment:  
	   7.  Overall
	Is my code indented correctly?
	Mark out of 4:4
	Comments:
	Do my variable names make sense?
	Mark out of 4:4
	Comments:
	Do my variable names, method names and class name follow the Java coding standard
	Mark out of 4:4
	Comments:
	      Total Mark out of 100 (Add all the previous marks): 100
	*/

	
	public static final int CROSSED_OUT_NUMBER = 0;
	public static final int FIRST_PRIME = 2;

	public static void main(String[] args) {
		
		boolean finished = false;
		while (!finished)
		{
			System.out.print("Please enter a whole number greater than two: ");
			Scanner input = new Scanner(System.in);
			int inputNumber = input.nextInt();
			if(inputNumber >= FIRST_PRIME)
			{
				int [] numberSequence = createSequence(inputNumber);
				System.out.println(sequenceToString(numberSequence));
				sieve(inputNumber, numberSequence);
				nonCrossedOutSubseqToString(numberSequence);
				finished = true;
				input.close();
			}
			else
			{
				System.out.println("Invalid input. Please enter a whole number greater than two: ");
			}
			
		}
		
	}
	
	public static int[] createSequence (int number) {
		int[] array = new int[number - 1];
		for (int index = 0; index < array.length; index++)
		{
			array[index] = (index + 2);
		}
		return array;
	}
	
	public static void crossOutHigherMultiples(int[] array, int number) {
		for (int index = 0; index < array.length; index++)
		{
			if (array[index] % number == 0 && array[index] != number )
			{
				array[index] = CROSSED_OUT_NUMBER;
			}
			
		}
		
	}

	public static void sieve (int inputNumber, int [] numberSequence )
	{
		String sequenceString = "";
		for( int index = 0; index < numberSequence.length; index++)
		{
			if( numberSequence[index] != CROSSED_OUT_NUMBER)
			{
				crossOutHigherMultiples(numberSequence, numberSequence[index]);
				sequenceString = sequenceToString(numberSequence);
				System.out.println(sequenceString);
			}
			
		}
		
	}
	
	public static void nonCrossedOutSubseqToString( int [] numberSequence )
	{
		for (int index = 0; index < numberSequence.length; index++)
		{
			if (numberSequence[index] != CROSSED_OUT_NUMBER)
			{
				System.out.print(numberSequence[index] + ((numberSequence.length - 2) == index ? ". " : ", "));
			}
			
		}
		
	}
	
	public static String sequenceToString( int [] numberSequence)
	{
		String numberSequenceString = "";
		int numberCount = FIRST_PRIME;
		for (int index = 0; index < numberSequence.length; index++)
		{
			if (numberSequence[index] != CROSSED_OUT_NUMBER)
			{
				numberSequenceString += numberSequence[index] + (( numberSequence.length - 1 ) == index ? ". " : ", ");
				numberCount ++;
			}
			else
			{
				numberSequenceString += ((numberSequence.length - 1) == index ? "[" + numberCount + "]. " : "[" + numberCount + "], ");
				numberCount++;
			}
			
		}
		return numberSequenceString;
		
	}

}
