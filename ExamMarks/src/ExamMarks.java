import java.util.Scanner;

public class ExamMarks {
	
	public static final int MAX_NUMBER_OF_STUDENTS = 100;

	public static void main(String[] args) {
		
		double examMarks[] = new double[1];
		System.out.println("Please enter a student percentage (or enter quit): ");
		Scanner input = new Scanner(System.in);
		boolean finished  = false;
		for (int index = 0; finished == false; index++)
		{
			if (input.hasNextDouble())
			{	
				double studentMark = input.nextDouble();
				examMarks[index] = studentMark;
				extendArraySize(examMarks, studentMark);
				
				System.out.println(countFirstClassHonours(examMarks) + (countFirstClassHonours(examMarks) == 1? " student":" students") 
									+ " obtained first class honours. The highest mark was " + determineBestMark(examMarks) 
									+ "%. \nPlease enter a student percentage: ");
			}
			else if (input.hasNext("quit"))
			{
				System.out.print("Goodbye. ");
				finished = true;
			}
			else
			{
				System.out.println("Invalid input. Please enter a valid number or else enter quit.");
			}
			
		}
		input.close();

	}
	public static double determineBestMark( double array[]) {
		double bestMark = 0;
		for(int count = 0; count < array.length; count++)
		{
			double index = array[count];
			if (index > bestMark)
			{
				bestMark = index;
			}
		}
		return bestMark;
	}
	public static int countFirstClassHonours( double array[]) {
		int count = 0;
		for (int index = 0; index < array.length; index++)
		{
			if (array[index] >= 70)
			{
				count++;
			}
		}
		return count;
	}
	public static double[] extendArraySize(double [] array, double studentMark) {
	    double[] newArray = new double[array == null? 1 : array.length + 1];
	    if (array != null)
	    {
	    	System.arraycopy(array, 0, newArray, 0, array.length);
	    }
	    newArray[newArray.length -1] = studentMark;
		return array;
	}
	
}
