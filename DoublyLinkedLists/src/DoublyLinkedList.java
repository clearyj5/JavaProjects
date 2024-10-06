import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.Test;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  19333982
 *  @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
    
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;
    public int size; //stores the number of Nodes in the list.

    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() 
    {
      head = null;
      tail = null;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  We assume that this single line of code has a constant running time and hence the cost is Theta(1).
     */
    public boolean isEmpty()
    {
      return (head == null);
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  The cost of each branch of the if else statements are Theta(1), Theta(1), Theta(1) and Theta(N) respectively, 
     *  hence the worst case running time is the maximum of these, so Theta(N).
     */
    public void insertBefore( int pos, T data ) {	
    	
    	DLLNode newNode = new DLLNode(data, null, null);
    	DLLNode spareNode;
    	if (isEmpty())
    	{
    		head = newNode;
    		tail = newNode;
    		size++;
    	}
    	else if (pos <= 0)
    	{
    		newNode.next = head;
    		head.prev = newNode;
    		spareNode = head;
    		head = newNode;
    		size++;
    	}
    	else if (pos >= size)
    	{
    		newNode.prev = tail;
    		tail.next = newNode;
    		spareNode = tail;
    		tail = newNode;
    		size++;
    	}
    	else 
    	{
    		int i = 0;
    		spareNode = head;
    		while (i < pos)
    		{
    			spareNode = spareNode.next;
    			i++;
    		}
    		
    		spareNode.prev.next = newNode;
    		newNode.prev = spareNode.prev;
    		spareNode.prev = newNode;
    		newNode.next = spareNode;
    		size++;
    		
    	}
   
    }
    

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  The cost of each branch of the if else statements are Theta(N) and Theta(1) respectively, hence the worst case running time
     *  is the maximum of these, so Theta(N).
     *
     */
    public T get(int pos) 
    {
    	if (pos < size && pos >= 0) 
    	{
	    	int i = 0;
			DLLNode temp = head;
			while (i != pos)
			{
				temp = temp.next;
				i++;
			}
			return temp.data;
    	}
    	else return null;
    }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  The cost of each branch of the if else statements are Theta(1), Theta(1) and Theta(N) respectively, hence the worst case running time
     *  is the maximum of these, so Theta(N).
     */
    public boolean deleteAt(int pos) 
    {
    	if (isEmpty())
    	{
    		return false;
    	}
    	else if (pos > size - 1 || pos < 0)
    	{
    		return false;
    	}
    	else if (pos == 0)
    	{
    		if (size == 1)
    		{
    			head = null;
    			tail = null;
    			size--;
    			return true;
    		}
    		else
    		{
    			head = head.next;
        		head.prev = null;
        		size--;
        		return true;
    		}
    	}
    	else if (pos == size - 1)
    	{
    		tail = tail.prev;
    		tail.next = null;
    		size--;
    		return true;
    	}
    	else
    	{
			int i = 0;
			DLLNode temp = head;
			while (i != pos)
			{
				temp = temp.next;
				i++;
			}
			
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
			temp.next = null;
			temp.prev = null;
			size--;
			return true;
    	}
    	
    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  Each line of code inside the while loop has running time Theta(1), hence the cost of the method is N*Theta(1) = Theta(N)
     */
    public void reverse()
    {
    	if (size > 1)
    	{
    		DLLNode temp = head;
    		head = tail;
    		tail = temp;
    		DLLNode current = head;
    		while (current != null)
    		{
    			temp = current.next;
    			current.next = current.prev;
    			current.prev = temp;
    			current = current.next;
    		}
    	}
    	
    }

    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements unique.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: Theta(N^3)
     *
     * Justification:
     *  We assume that the deleteAt() method runs in Theta(N) asymptotic time. 
     *  Therefore, the max run time for each iteration of the inner for loop is N. It will always iterate over all n elements of the list, 
     *  and therefore the total cost of the inner for loop is Theta(N^2).
     *  This is a nested loop, so hence the total cost of this method will be Theta(N^3).
     */ 
     
     public void makeUnique()
    {
    	 if (!isEmpty())
    	 {
	    	 DLLNode temp = head;
	    	 int count = 0;
	    	 while (temp != null)
	    	 {
	    		 for (int i = 0; i < size; i++)
	        	 {
	        		 if (get(i) == temp.data && count != i)
	        		 {
	        			 deleteAt(i);
	        			 i--;
	        		 }
	        		 
	        	 }
	    		 count++;
	    		 temp = temp.next;
	    	 }
    	 }
    	 
    }


    /*----------------------- STACK API 
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  We assume that the method call here (insertBefore) runs in Theta(N) asymptotic time.
     *  Hence the max running time is Theta(N).
     */
     
    public void push(T item) 
    {
    	insertBefore(0, item);
    }
    
    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification: 
     *  We assume that each method call here (e.g. get() and deleteAt() methods) run in Theta(N) asymptotic time.
     *  Hence the max running time is 2*Theta(N) = Theta(N).
     */
    
    public T pop() 
    {
    	int topOfStack = 0;
    	if (!isEmpty())
    	{
    		T data =  get(topOfStack);
    		deleteAt(topOfStack);
    		return data;
    	}
    	else return null;
    	
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */
 
    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  We assume that the method call here (insertBefore) runs in Theta(N) asymptotic time.
     *  Hence the max running time is Theta(N).
     */
    
    public void enqueue(T item) 
    {
    	insertBefore(size, item);
    }

     /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an equeue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  We assume that each method call here (e.g. get() and deleteAt() methods) run in Theta(N) asymptotic time.
     *  Hence the max running time is 2*Theta(N) = Theta(N).
     */
    
    public T dequeue() 
    {
      int topOfQueue = 0;
      if (!isEmpty())
      {
    	  T data = get(topOfQueue);
    	  deleteAt(topOfQueue);
    	  return data;
      }
      else return null;
    }
 

    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    
    public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; 

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }

}