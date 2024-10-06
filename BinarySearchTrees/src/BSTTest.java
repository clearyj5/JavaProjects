import static org.junit.Assert.*;

import org.junit.Test;

public class BSTTest {
	
	@Test
	public void testIsEmpty() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		
		assertTrue(bst.isEmpty()); //Test an empty tree
	}
	
	@Test
	public void testSize() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		
		assertEquals(bst.size(), 0); //Test an empty tree
		bst.put(1, 1);
		assertEquals(bst.size(), 1);
	}
	
	@Test
	public void testGet() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		
		assertTrue(bst.get(1) == null);
		bst.put(1, 1);
		bst.put(2, 2);
		assertTrue(bst.get(1) == 1);
		assertTrue(bst.get(2) == 2);
		bst.put(5, 5);
		bst.put(4, 4);
		bst.put(6, 6);
		assertTrue(bst.get(4) == 4);
		
	}
	
	@Test
	public void testPut() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		
		bst.put(1, null);
		bst.put(1, 1);
		bst.put(2, 2);
		bst.put(1, 3);
		
		assertTrue(bst.size() == 2);
		
	}
	
	@Test
	public void testContains() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		
		 	bst.put(7, 7);   //        _7_
	        bst.put(8, 8);   //      /     \
	        bst.put(3, 3);   //    _3_      8
	        bst.put(1, 1);   //  /     \
	        bst.put(2, 2);   // 1       6
	        bst.put(6, 6);   //  \     /
	        bst.put(4, 4);   //   2   4
	        bst.put(5, 5);   //        \
	                         //         5
	        
	        assertFalse(bst.contains(9));
	        assertTrue(bst.contains(5));
	}
	
	@Test
	public void testHeight() {
		
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		
		assertEquals(bst.height(), -1); //Test an empty tree
        
        bst.put(7, 7);   //        _7_
        bst.put(8, 8);   //      /     \
        bst.put(3, 3);   //    _3_      8
        bst.put(1, 1);   //  /     \
        bst.put(2, 2);   // 1       6
        bst.put(6, 6);   //  \     /
        bst.put(4, 4);   //   2   4
        bst.put(5, 5);   //        \
                         //         5
        
        assertEquals(bst.height(), 4); //Test on non-empty Tree
        
        bst.put(9,9);
        assertEquals(bst.height(), 4); //Test on new non-empty Tree
        
        bst.delete(5);
        assertEquals(bst.height(), 3); //Test on new non-empty Tree
        
	}

	@Test
	public void testMedian() {
		
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		
		assertTrue(bst.median() == null); //Test median for an empty Tree
        
        bst.put(7, 7);   //        _7_
        bst.put(8, 8);   //      /     \
        bst.put(3, 3);   //    _3_      8
        bst.put(1, 1);   //  /     \	 \
        bst.put(2, 2);   // 1       6	  9
        bst.put(6, 6);   //  \     /	   \
        bst.put(4, 4);   //   2   4			10
        bst.put(5, 5);   //        \
        bst.put(9, 9);   //         5
        bst.put(10, 10);
        
        
        assertTrue(bst.median() == 5); //Test on non-empty tree
        
        bst.put(11, 11);
        bst.put(12, 12);
        assertTrue(bst.median() == 6); //Test for new non-empty tree
        //TODO
		
	}
	
	@Test
	public void testPrintKeysInOrder() {
		
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		
		assertTrue(bst.printKeysInOrder() == "()");
        
        bst.put(7, 7);   //        _7_
        bst.put(8, 8);   //      /     \
        bst.put(3, 3);   //    _3_      8
        bst.put(1, 1);   //  /     \
        bst.put(2, 2);   // 1       6
        bst.put(6, 6);   //  \     /
        bst.put(4, 4);   //   2   4
        bst.put(5, 5);   //        \
                         //         5
        
        String print = bst.printKeysInOrder();
        assertEquals( "Checking printKeysInOrder for a BST with 7 elements and height of 5", "(((()1(()2()))3((()4(()5()))6()))7(()8()))", print);
		//Tests whether or not the printKeysInOrder method will print the keys in the correct format, with each subtree 
        //in parentheses and empty subtrees represented by ().
	}
	
	@Test
	public void testPrettyPrint() {
		
	     BST<Integer, Integer> bst = new BST<Integer, Integer>();
	     assertEquals("Checking pretty printing of empty tree",
	             "-null\n", bst.prettyPrintKeys());
	      
	                          //  -7
	                          //   |-3
	                          //   | |-1
	                          //   | | |-null
	     bst.put(7, 7);       //   | |  -2
	     bst.put(8, 8);       //   | |   |-null
	     bst.put(3, 3);       //   | |    -null
	     bst.put(1, 1);       //   |  -6
	     bst.put(2, 2);       //   |   |-4
	     bst.put(6, 6);       //   |   | |-null
	     bst.put(4, 4);       //   |   |  -5
	     bst.put(5, 5);       //   |   |   |-null
	                          //   |   |    -null
	                          //   |    -null
	                          //    -8
	                          //     |-null
	                          //      -null
	     
	     String result = 
	      "-7\n" +
	      " |-3\n" + 
	      " | |-1\n" +
	      " | | |-null\n" + 
	      " | |  -2\n" +
	      " | |   |-null\n" +
	      " | |    -null\n" +
	      " |  -6\n" +
	      " |   |-4\n" +
	      " |   | |-null\n" +
	      " |   |  -5\n" +
	      " |   |   |-null\n" +
	      " |   |    -null\n" +
	      " |    -null\n" +
	      "  -8\n" +
	      "   |-null\n" +
	      "    -null\n";
	     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
	}

	  
	     /** <p>Test {@link BST#delete(Comparable)}.</p> */
	@Test
	public void testDelete() {
		
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
	    bst.delete(1);
	    assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
	    
	    BST<Integer, Integer> bst2 = null;
	    bst.delete(1);
	    assertEquals("Deleting from null tree", "()", bst.printKeysInOrder());
	    
	         
	    bst.put(7, 7);   //        _7_
	     bst.put(8, 8);   //      /     \
	     bst.put(3, 3);   //    _3_      8
	     bst.put(1, 1);   //  /     \
	     bst.put(2, 2);   // 1       6
	     bst.put(6, 6);   //  \     /
	     bst.put(4, 4);   //   2   4
	     bst.put(5, 5);   //        \
	                      //         5
	     
	     assertEquals("Checking order of constructed tree",
	             "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
	     
	     bst.delete(9);
	     assertEquals("Deleting non-existent key",
	             "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
	 
         bst.delete(8);
         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
 
         bst.delete(6);
         assertEquals("Deleting node with single child",
             "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());
 
         bst.delete(3);
         assertEquals("Deleting node with two children",
             "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
	 }
	     
}


