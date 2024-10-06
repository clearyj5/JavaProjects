import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,4);
        testDLL.insertBefore(-10,3);
        testDLL.insertBefore(-10,2);
        testDLL.insertBefore(-10,1);
        testDLL.insertBefore(1,8);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "1,8,2,3,4", testDLL.toString() );
        
     }

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.
    

    //Check if the isEmpty works
  	@Test
  	public void testIsEmpty() {
  		
  		//create empty list and test
  		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
  		assertTrue(dll.isEmpty());
  		
  		//insert element into list and re-test
  		dll.insertBefore(0, 10);
  		assertFalse(dll.isEmpty());
  	}
  	
  //Check if the get works
  	@Test
  	public void testGet() {
  		
  		//create non-empty list
  		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
        dll.insertBefore(0,1);
        dll.insertBefore(1,2);
        dll.insertBefore(2,3);
        
        //test both the correct case and an incorrect case
        assertTrue(dll.get(0) == 1 && dll.get(1) == 2 && dll.get(2) == 3); 
        assertFalse(dll.get(0) == 3);
        
        //test invalid inputs
        assertTrue(dll.get(50) == null);
        assertTrue(dll.get(-3) == null);
  		
  	}
  	
  	//Check if the deleteAt works
  	@Test
  	public void testDeleteAt() {
  		
  		//create non-empty list
  		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
        dll.insertBefore(0,1);
        dll.insertBefore(1,2);
        dll.insertBefore(2,3);
        dll.insertBefore(3,4);
        dll.insertBefore(4,5);
        
        //delete element at head, tail, and in middle of stack
        dll.deleteAt(0);
        assertEquals( "Checking deleteAt for a list containing 5 elements", "2,3,4,5", dll.toString() );
        
        dll.insertBefore(0,1);
        dll.deleteAt(4);
        assertEquals( "Checking deleteAt for a list containing 5 elements", "1,2,3,4", dll.toString() );
        
        dll.insertBefore(4,5);
        dll.deleteAt(2);
        assertEquals( "Checking deleteAt for a list containing 5 elements", "1,2,4,5", dll.toString() );
        
        //test empty list
        dll = new DoublyLinkedList<Integer>();
        assertFalse(dll.deleteAt(0));
        assertFalse(dll.deleteAt(1));
        
        //test when pos points outside elements of the list
        dll = new DoublyLinkedList<Integer>();
        dll.insertBefore(0,1);
        
        assertFalse(dll.deleteAt(5));
        assertFalse(dll.deleteAt(100));
        assertFalse(dll.deleteAt(-3));
        
        //test when size of list is 1
       dll.deleteAt(0);
       assertTrue(dll.isEmpty());
        
        
  	}
  	
  	//Check if the reverse works
	@Test
  	public void testReverse() {
		
		//create non-empty list
  		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
        dll.insertBefore(0,1);
        dll.insertBefore(1,2);
        dll.insertBefore(2,3);
        dll.insertBefore(3,4);
        dll.insertBefore(4,5);
        
        dll.reverse();
        
        assertEquals( "Checking reverse to a list containing 5 elements", "5,4,3,2,1", dll.toString() );
        
        //Test empty list
        dll = new DoublyLinkedList<Integer>();
        dll.reverse();
        assertFalse(dll.toString() == "5,4,3,2,1");
	}
	
	//Check if the makeUnique works
	@Test
	public void testMakeUnique()
	{
		//test empty list
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		DoublyLinkedList<Integer> testDLL2 = testDLL;
		testDLL.makeUnique();
		assertTrue(testDLL == testDLL2);
		
		//test non-empty list
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0, 2);
		testDLL.insertBefore(1, 2);
		testDLL.insertBefore(2, 2);
		testDLL.insertBefore(3, 1);
		testDLL.insertBefore(4, 1);
		testDLL.insertBefore(5, 1);
		testDLL.insertBefore(6, 1);
		testDLL.makeUnique();
		assertEquals("Checking makeUnique() on a known non-empty list.", "2,1", testDLL.toString());
		
		testDLL.insertBefore(1,3);
		assertEquals("Checking makeUnique() on a known non-empty list.", "2,3,1", testDLL.toString());
	}

	
	//Check if the push works
	@Test
  	public void testPush() {
		
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.push(5);
		dll.push(4);
		dll.push(3);
		dll.push(2);
		dll.push(1);
		
		assertEquals( "Checking reverse to a list containing 5 elements", "1,2,3,4,5", dll.toString() );
	}
	
	//Check if the pop works
	@Test
  	public void testPop() {
		
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.push(5);
		dll.push(4);
		dll.push(3);
		dll.push(2);
		dll.push(1);
		
		assertTrue(dll.pop() == 1);
		assertTrue(dll.pop() == 2);
		assertFalse(dll.pop() == 1);
		
		//Test empty stack
		dll = new DoublyLinkedList<Integer>();
		assertTrue(dll.pop() == null);
	}
	
	//Check if the enqueue works
	@Test
  	public void testEnqueue() {
		
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.enqueue(1);
		dll.enqueue(2);
		dll.enqueue(3);
		dll.enqueue(4);
		dll.enqueue(5);
		
		assertEquals( "Checking reverse to a list containing 5 elements", "1,2,3,4,5", dll.toString() );
	}
	
	//Check if the dequeue works
	@Test
  	public void testDequeue() {
		
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.enqueue(1);
		dll.enqueue(2);
		dll.enqueue(3);
		dll.enqueue(4);
		dll.enqueue(5);
		
		assertTrue(dll.dequeue() == 1);
		assertTrue(dll.dequeue() == 2);
		assertFalse(dll.dequeue() == 1);
		
		//Test empty queue
		dll = new DoublyLinkedList<Integer>();
		assertTrue(dll.dequeue() == null);
		
		//test reproduce
		DoublyLinkedList testDLL = new DoublyLinkedList ();
		Comparable result = testDLL.dequeue();
		testDLL.enqueue(100);
		result = testDLL.dequeue();
		result = testDLL.dequeue();
		testDLL.enqueue(100);
		testDLL.enqueue(200);
		testDLL.enqueue(300);
		result = testDLL.dequeue();
		result = testDLL.dequeue();
		assertEquals("should return: 200 - received: " + result, (long)200, (long)result);
		assertEquals("list should be: [300] - received: [" + testDLL.toString() + "]", "300", testDLL.toString());

	}
}
