import java.util.Scanner;

public class ETest2 {

	public static void main(String[] args) {
		boolean finished = false;
		int[] numberList = new int[0];
		while (!finished)
		{
			System.out.println("Enter an integer to add to the array (or 'quit' to finish): ");
			Scanner input = new Scanner(System.in);
			if (input.hasNextInt())
			{
				extendArraySize(numberList, input.nextInt());
				System.out.println("The average is " + getAverage(numberList) + ", and " + (isIncreasing(numberList)? "all " : "not all ") + "values are increasing. ");
			}
			else if (input.hasNext("quit"))
			{
				finished = true;
			}
			else
			{
				System.out.println("Invalid input. Please enter a valid number or enter 'quit': ");
				String inputDump = input.next();
			}
			input.close();
		}

	}
	public static double getAverage(int[] array) {
		double sumOfValues = 0;
		for (int index = 0; index < array.length; index++)
		{
			double currentValue = array[index];
			sumOfValues += currentValue;
		}
		
		return (sumOfValues / array.length);
	}
	
	public static boolean isIncreasing(int[] array) {
		boolean isIncreasing = false;
		int index = 0;
		do
		{
			for (index = 0; index < array.length; index++)
			{
				if (array[index] > array[index + 1] || array[index] == array[index + 1] || index == array.length - 1)
				{
					isIncreasing = false;
				}
			}
		} while (isIncreasing);
		return isIncreasing;
		
	}
	
	public static int[] extendArraySize(int [] array, int newValue) {
	    int[] newArray = new int[array == null? 1 : array.length + 1];
	    if (array != null)
	    {
	    	System.arraycopy(array, 0, newArray, 0, array.length);
	    }
	    newArray[newArray.length -1] = newValue;
		return array;
	}

}
