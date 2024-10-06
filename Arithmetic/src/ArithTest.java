import static org.junit.Assert.*;

import org.junit.Test;

public class ArithTest {

	@Test
	public void testValidateInfix() {
		
		Arith a = new Arith(); //Webcat was highlighting in red the name of the Arith class, so I initialize 'a' here to counteract that
		
		String[] infixLiterals = {"(", "(", "(", "1", "-", "2", ")", "*", "3", ")", "+", "(", "10", "-", "(", "3", "+", "(", "6", "/", "3", ")", ")", ")", ")"};
		assertTrue(Arith.validateInfixOrder(infixLiterals));
		
		String[] infixLiterals1 = {"1","+","2","+","4","-","6","*","8","/","1"};
		assertTrue(Arith.validateInfixOrder(infixLiterals1));
		
		String[] prefixLiterals = {"+", "-", "1", "3", "2"};
		assertFalse(Arith.validateInfixOrder(prefixLiterals));
		
		String[] s = {")", "+", "-", "/", ")", "("};
		assertFalse(Arith.validateInfixOrder(s));
		
		String[] s2 = {")", "8", "5", "9", ")", "("};
		assertFalse(Arith.validateInfixOrder(s2));
		
		String[] s3 = {")", ")", ")", ")", ")", "("};
		assertFalse(Arith.validateInfixOrder(s3));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testEvaluateInfix() {
		
		String[] infixLiterals = {"(", "(", "(", "1", "-", "2", ")", "*", "3", ")", "+", "(", "10", "-", "(", "3", "+", "(", "6", "/", "3", ")", ")", ")", ")"};
		assertEquals(Arith.evaluateInfixOrder(infixLiterals), 2);
		
		String[] s = {")", "+", "-", "9", "("};
		Arith.evaluateInfixOrder(s);
		
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testEvaluateOperation() {
		int x = 0;
		int y = 1;
		Arith.evaluateOperation(x, y, "/");
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testConvertInfixToPostfix() { //(((1 - 2) * 3) + (10 - (3 + ( 6 / 3))))
		
		String[] postfixLiterals = {"1", "2", "-", "3", "*", "10", "3", "6", "3", "/", "+", "-", "+"};
		String[] infixLiterals = {"(", "(", "(", "1", "-", "2", ")", "*", "3", ")", "+", "(", "10", "-", "(", "3", "+", "(", "6", "/", "3", ")", ")", ")", ")"};
		
		for (int i = 0; i < postfixLiterals.length; i++)
		{
			assertTrue(Arith.convertInfixToPostfix(infixLiterals)[i].equals(postfixLiterals[i]));
		}
		
		String[] s = {")", "+", "-", "9", "(", ")"};
		Arith.convertInfixToPostfix(s);
		
	}
	
	@Test
	public void testConvertPostfixToInfix() { //
		
		String[] postfixLiterals = {"1", "2", "-", "3", "*", "10", "3", "6", "3", "/", "+", "-", "+"};
		String[] infixLiterals = {"(", "(", "(", "1", "-", "2", ")", "*", "3", ")", "+", "(", "10", "-", "(", "3", "+", "(", "6", "/", "3", ")", ")", ")", ")"};
		
		for (int i = 0; i < infixLiterals.length; i++)
		{
			assertTrue(Arith.convertPostfixToInfix(postfixLiterals)[i].equals(infixLiterals[i]));
		}
		
	}
	
}
