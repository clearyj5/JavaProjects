import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 * 
 *  @author Jack Cleary
 *  @version HT 2020
 * 
 * *  *** AVERAGE OF 3 TRIALS, TIME MEASURE IN NANO-SECONDS
 * 
 *			    |  insertionSort |  SelectionSort | mergeSort | quickSort |
 *                           |                |                |           |           |
 * numbers1000               |   6            |    0           |  0        |  0        |
 * numbers10000              |   159          |    33          |  2        |  1        |
 * numbers10000Duplicates    |   1            |    0           |  0        |  0        |
 * numbersNearlyOrdered1000  |   1            |    0           |  0        |  0        |
 * numbersReverse1000        |   1            |    0           |  0        |  0        |
 * numbersSorted1000         |   0            |    0           |  0        |  0        |
 *  
 */

@RunWith(JUnit4.class)
public class SortComparisonTest
{
	//~ Constructor ........................................................
	@Test
	public void testConstructor()
	{
		new SortComparison();
	}

	//~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check that the methods work for empty arrays
	 */
	@Test
	public void testEmpty()
	{
		double [] emptyArray = {};
		try {

			SortComparison.insertionSort(emptyArray);
			SortComparison.selectionSort(emptyArray);
			SortComparison.quickSort(emptyArray);
			SortComparison.mergeSort(emptyArray);

		} catch (Exception e) {

			System.out.println("Cannot sort an empty array");
		}
	}

	@Test
	public void testInsertionSort() {

		boolean isEqual = true;
		double [] array = {1,10,9,4,7,8,11};
		double [] expectedArray = {1,4,7,8,9,10,11};
		array = SortComparison.insertionSort(array);

		for (int index = 0; index<array.length; index++) {

			if (array[index] != expectedArray[index]) {
				isEqual = false;
			}
			assertTrue(isEqual);
		}
	}

	@Test
	public void testSelectionSort() {

		boolean isEqual = true;
		double [] array = {1,10,9,4,7,8,11};
		double [] expectedArray = {1,4,7,8,9,10,11};
		array = SortComparison.selectionSort(array);

		for (int index = 0; index<array.length; index++) {

			if (array[index] != expectedArray[index]) {
				isEqual = false;
			}
			assertTrue(isEqual);
		}
	}

	@Test
	public void testquickSort() {

		boolean isEqual = true;
		double [] array = {1,10,9,4,7,8,11};
		double [] expectedArray = {1,4,7,8,9,10,11};
		array = SortComparison.quickSort(array);

		for (int index = 0; index<array.length; index++) {

			if (array[index] != expectedArray[index]) {
				isEqual = false;
			}
			assertTrue(isEqual);
		}
	}

	@Test
	public void testmergeSort(){

		boolean isEqual = true;
		double [] array = {1,10,9,4,7,8,11};
		double [] expectedArray = {1,4,7,8,9,10,11};
		array = SortComparison.mergeSort(array);

		for (int index = 0; index<array.length; index++) {

			if (array[index] != expectedArray[index]) {
				isEqual = false;
			}
			assertTrue(isEqual);
		}
		
		double [] array2 = {11,10,9,8,7,4,1};
		double [] expectedArray2 = {1,4,7,8,9,10,11};
		array2 = SortComparison.mergeSort(array2);

		for (int index = 0; index<array2.length; index++) {

			if (array2[index] != expectedArray2[index]) {
				isEqual = false;
			}
			assertTrue(isEqual);
		}
		
		double [] array3 = {1,1,1,1,1,1,1};
		double [] expectedArray3 = {1,1,1,1,1,1,1};
		array3 = SortComparison.mergeSort(array3);

		for (int index = 0; index<array3.length; index++) {

			if (array3[index] != expectedArray3[index]) {
				isEqual = false;
			}
			assertTrue(isEqual);
		}
	}

	/**
	 *  Main Method.
	 *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
	 * @throws FileNotFoundException 
	 *
	 */
	public static void main(String[] args) throws FileNotFoundException

	{
		double [] fileArray;
		String fileName ="";


		for (int fileNumber =0; fileNumber<6; fileNumber++) {
			
			long averageInsertionSort =0;
			long averageSelectionSort =0;
			long averageQuickSort =0;
			long averageMergeSort=0;

			switch(fileNumber) {

			case 0: fileName = "numbers1000.txt"; break;
			case 1: fileName = "numbers10000.txt"; break;
			case 2: fileName = "numbers1000Duplicates.txt"; break;
			case 3: fileName = "numbersNearlyOrdered1000.txt"; break;
			case 4: fileName = "numbersReverse1000.txt"; break;
			case 5: fileName = "numbersSorted1000.txt"; break;

			}
			
			System.out.println("The following tests were executed on the file '" + fileName + "'"  + "\n");

			for (int iteration = 0; iteration<3; iteration++) {

				for (int sortMethod=0; sortMethod<4; sortMethod++) {

					Scanner inputScanner = new Scanner(new File(fileName));
					if (fileName.contains("10000")) fileArray = new double[10000];

					else fileArray = new double[1000];
					
					int index=0;
					
					while (inputScanner.hasNext()) {
						fileArray[index] = inputScanner.nextDouble();
						index++;
					}

					if (sortMethod==0) {

						long startTime = System.currentTimeMillis();
						SortComparison.insertionSort(fileArray);
						long endTime = System.currentTimeMillis();
						averageInsertionSort += endTime-startTime;

						if (iteration==2) {
							System.out.println("- Average Time in miliseconds of insertion Sort: "+ (averageInsertionSort/3));
						}
					}

					else if (sortMethod ==1) {

						long startTime = System.currentTimeMillis();
						SortComparison.selectionSort(fileArray);
						long endTime = System.currentTimeMillis();
						averageSelectionSort += (endTime-startTime);

						if (iteration==2) {
							System.out.println("- Average Time in miliseconds of selection Sort: "+ (averageSelectionSort/3));
						}
					}
					else if (sortMethod==2) {

						long startTime = System.currentTimeMillis();
						SortComparison.mergeSort(fileArray);
						long endTime = System.currentTimeMillis();
						averageMergeSort += endTime-startTime;

						if (iteration==2) {
							System.out.println("- Average Time in miliseconds of merge Sort: "+ (averageMergeSort/3));
						}
					}
					else {

						long startTime = System.currentTimeMillis();
						SortComparison.quickSort(fileArray);
						long endTime = System.currentTimeMillis();
						averageQuickSort += endTime-startTime;

						if (iteration==2) {
							System.out.println("- Average Time in miliseconds of quick Sort: "+ (averageQuickSort/3));
						}
					}
				}
			}
			System.out.println("-----------------------------------------------------------");
		}
	}
}