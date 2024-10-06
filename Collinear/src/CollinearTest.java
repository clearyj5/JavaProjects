import org.junit.Test;
import org.junit.Ignore;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.junit.Assert.*;

//-------------------------------------------------------------------------
@RunWith(JUnit4.class)
public class CollinearTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new Collinear();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the two methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
        int expectedResult = 0;

        assertEquals("countCollinear failed with 3 empty arrays", expectedResult, Collinear.countCollinear(new int[0], new int[0], new int[0]));
        assertEquals("countCollinearFast failed with 3 empty arrays", expectedResult, Collinear.countCollinearFast(new int[0], new int[0], new int[0]));
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleFalse()
    {
        int[] a3 = { 15 };
        int[] a2 = { 5 };
        int[] a1 = { 10 };

        int expectedResult = 0;

        assertEquals("countCollinear({10}, {5}, {15})",       expectedResult, Collinear.countCollinear(a1, a2, a3) );
        assertEquals("countCollinearFast({10}, {5}, {15})", expectedResult, Collinear.countCollinearFast(a1, a2, a3) );
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleTrue()
    {
        int[] a3 = { 15, 5 };       int[] a2 = { 5 };       int[] a1 = { 10, 15, 5 };

        int expectedResult = 1;

        assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")",     expectedResult, Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    }


    // TODO: add more tests here. Each line of code and each decision in Collinear.java should
    // be executed at least once from at least one test.

    // Check that an element not contained in an array cannot be found
    @Test
    public void binaryCannotFindValue()
    {
        int [] a1 = {5,10,20,40,80,160};
        int findNumber = 4;
        assertFalse(Collinear.binarySearch(a1,findNumber));
    }

    // Check that an element contained in an array can be found

    @Test
    public void binaryCanFindValue() 
    {
        int[] a1 = {3, 6, 8, 10, 12, 17};
        int numberToFind = 12;
        assertTrue(Collinear.binarySearch(a1, numberToFind));
    }

    //Check that the sort function will arrange a randomised array from smallest to largest

    @Test
    public void sortCheck()
    {
        int [] a1 = {22,1,45,78,54,12};
        int [] a2 = {1,12,22,45,54,78};
        Collinear.sort(a1);
        assertArrayEquals(a1,a2);
    }

    //check the collinear function counts collinear elements in 3 arrays

    @Test
    public void countCollinearCheck(){
        int [] a1 = {1,2};
        int [] a2 = {1};
        int [] a3 = {1,3};
        int collinearCount = 1;
        assertEquals(Collinear.countCollinear(a1,a2,a3), collinearCount);
        // test collinear count fast
        assertEquals(Collinear.countCollinearFast(a1,a2,a3), collinearCount);
    }



}
