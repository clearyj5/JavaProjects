// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Jack Cleary
 *  @version HT 2020
 */

class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
        // cycles through each element, if it is in wrong position it continually moves it to the left until it it correct.
        for (int i = 0; i < a.length; i++) {

            // shift it to the left until it's in the right spot
            int index = i;
            while (index > 0 && a[index - 1] >= a[index]) {
                double tmp = a[index - 1];
                a[index - 1] = a[index];
                a[index] = tmp;
                index -= 1;
            }
        }
        return a;
    }//end insertionsort
    
        /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
        // finds the smallest value, puts it at the beginning, repeats with rest of array.
        for (int i = 0; i < a.length - 1; i++) {
            int smallest = i;
            int j = i+1;
            while (j < a.length){
                if (a[smallest] >= a[j]) smallest = j;
                j++;
            }
            double temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
        }
        return a;
    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double[] quickSort(double[] a) {

		//Checks to ensure array is not empty
		if (a.length ==0) {
			System.out.println("array is empty will not be sorted");
			return a;
		}


		quickSort(a, 0, a.length - 1);
		return a;

	}
    
    private static void quickSort(double[] a, int low, int high) {
    	
		if (low < high) {
			int pivotIndex = partition(a, low, high);
			quickSort(a, low, pivotIndex - 1);
			quickSort(a, pivotIndex + 1, high);
		}
	}

	private static void swap(double[] a, int element1, int element2) {
		
		//Executes a basic swap
		double temp = a[element1];
		a[element1] = a[element2];
		a[element2] = temp ;
	}

	private static int partition(double[] a, int low, int high) {

		double pValue = a[high];
		int smaller = low;

		for (int i = low; i < high; i++) {
			if (a[i] < pValue) {
				swap(a, smaller, i);
				smaller++;
			}
		}
		int out = 0;

		if (smaller == high) {
			out = high;
		} 
		else {

			swap(a, smaller, high);
			out = smaller;
		}
		return out;
		
	}//end quicksort

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSort (double a[]) {
        //Divide array in half, then the halves in half and so on until it's all single value arrays.
        //Merge these arrays back together in order.
        if (a.length > 1) {
            double[] b = new double[a.length/2];
            double[] c = new double[a.length - b.length];

            int j = 0;
            for (int i = 0; i < a.length; i++){
                if (i < b.length) b[i] = a[i];
                else {
                    c[j] = a[i];
                    j++;
                }
            }
            double[] d = mergeSort(b);
            double[] e = mergeSort(c);
            
            int indexD = 0;
            int indexE = 0;
            int indexA = 0;

            //while both arrays have elements left
            while (indexD < d.length && indexE < e.length){
                if (d[indexD] < e[indexE]){
                    a[indexA] = d[indexD];
                    indexA++; indexD++;
                }
                else if (e[indexE] < d[indexD]){
                    a[indexA] = e[indexE];
                    indexA++; indexE++;
                }
                else {
                    a[indexA] = e[indexE];
                    indexA++; indexE++;
                    a[indexA] = d[indexD];
                    indexA++; indexD++;
                }
            }
            //if array d has elements left over
            while (indexD < d.length){
                a[indexA] = d[indexD];
                indexA++; indexD++;
            } 
            //if array e has elements left over
            while (indexE < e.length){
                a[indexA] = e[indexE];
                indexA++; indexE++;
            }
            return a;
        }
        else return a;
    
    }//end mergesort
    
 }//end class
