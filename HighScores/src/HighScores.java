import java.util.Scanner;

public class HighScores {
	
	/*	public static void sortArray( int[] array )
		{
		 	if (array!=null)
		  	{
		    	for (int index=0; index<array.length-1; index++)
		    	{
		      		int minimumIndex = index;
		      		for (int index2=index+1; index2<array.length; index2++)
		      		{
		        		if (array[index2] < array[minimumIndex])
		          		{
		          			minimumIndex = index2;
		      			}
		      		}
		      		int temp = array[index];
		      		array[index] = array[minimumIndex];
		      		array[minimumIndex] = temp;
		    	}
		  	}
		}	
		public static void randomiseOrder( int[] array )
		{		
		  	if (array!=null)		
		  	{		
		    	Random generator = new Random();		
		    	for (int index=0; index<array.length; index++ )		
		    	{		
		      		int otherIndex = generator.nextInt(array.length);
		      		int temp = array[index];		
		      		array[index] = array[otherIndex];		
		      		array[otherIndex] = temp;
		    	}
		    
		  	}
		
		}													*/

	public static void main(String[] args) {
		System.out.print("Enter the number of high scores you would like to maintain: ");
		Scanner input = new Scanner(System.in);
		int maximum = input.nextInt();
		int[] highScores = new int[maximum];
		boolean finished = false;
		while (!finished)
		{
			System.out.print("Enter a high score (or enter quit): ");
			if (input.hasNextInt())
			{
				insertScore(highScores, input.nextInt());
			}
			else if (input.hasNext("quit"))
			{
				finished = true;
			}
		}
		printHighScores(highScores);
		input.close();
	}
	
	public static void insertScore(int[] highScoreList, int newScore) {
		boolean higherThan = higherThan(highScoreList, newScore);
		if (higherThan) 
		{
			int indexToInsert = 0;
			boolean foundPlace = false;
			for (int index = 0; index < highScoreList.length && !foundPlace; index++) 
			{
				if (newScore >= highScoreList[index]) 
				{
					indexToInsert = index;
					for (int i = highScoreList.length - 1; index < i; i--) 
					{
						highScoreList[i] = highScoreList[i - 1];
					}
					foundPlace = true;
				}
			}
			highScoreList[indexToInsert] = newScore;
		}
	}
	
	public static boolean higherThan(int highScoreList[], int newHighScore) {
		for (int index = 0; index < highScoreList.length; index++)
		{
			if (highScoreList[index] < newHighScore)
			{
				return true;
			}
		}
		return false;
	}
	
	public static void printHighScores(int highScores[]) {
		String outputString = "The high scores are ";
		for (int index = 0; index < highScores.length; index++)
		{
			outputString += index == highScores.length -1? "and " + highScores[index] + ". " : highScores[index] + ", ";
		}
		System.out.print(outputString);
	}
	public static void initialiseHighScores(int[] highScoreList) {
		for (int index = 0; index < highScoreList.length; index++)
		{
			highScoreList[index] = 0;
		}
	}

}
