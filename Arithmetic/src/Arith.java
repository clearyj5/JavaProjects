import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// -------------------------------------------------------------------------
/**
 *  Utility class containing validation/evaluation/conversion operations
 *  for infix arithmetic expressions.
 *
 *  @author  
 *  @version 1/12/15 13:03:48
 */

public class Arith
{

	//~ Validation methods ..........................................................


	/**
	 * Validation method for infix notation.
	 *
	 * @param infixLiterals : an array containing the string literals hopefully in infix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer "0", "1" , "2", ..., "-1", "-2", ...
	 *
	 * @return true if the parameter is indeed in infix notation, and false otherwise.
	 **/
	public static boolean validateInfixOrder(String infixLiterals[]) {

		int parenthesisCounter = 0;
		int count = 1;
		for (int i = 0; i < infixLiterals.length; i++)
		{
			if (stringIsOperator(infixLiterals[i])) count++;
			else if (stringIsInteger(infixLiterals[i])) count--;

			if (infixLiterals[i].equals("(")) parenthesisCounter++;
			else if (infixLiterals[i].equals(")")) parenthesisCounter--;

			if (count != 1 && count != 0) return false; 
			if (parenthesisCounter < 0) return false;

		}
		return true;
	}

	public static boolean stringIsInteger(String s) {

		try {
			Integer.parseInt(s);
			return true;

		}catch (Exception e) {return false;}

	}

	public static boolean stringIsOperator(String s) {
		if (s.equals("+") || s.equals("-") 
				|| s.equals("*") || s.equals("/")) return true;
		else return false;

	}




	//~ Evaluation  methods ..........................................................


	/**
	 * Evaluation method for infix notation.
	 *
	 * @param infixLiterals : an array containing the string literals in infix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer.
	 *
	 * @return the integer result of evaluating the expression
	 *
	 **/
	public static int evaluateInfixOrder(String infixLiterals[]) {

		if (!validateInfixOrder(infixLiterals)) throw new UnsupportedOperationException("Invalid infix expression");

		Stack<Integer> numbers = new Stack<Integer>();
		Stack<String> operators = new Stack<String>();

		for (int i = 0; i < infixLiterals.length; i++)
		{
			if (stringIsOperator(infixLiterals[i]) || (infixLiterals[i].equals("("))) 
			{
				operators.push(infixLiterals[i]);
			}
			else if (stringIsInteger(infixLiterals[i])) 
			{
				numbers.push(Integer.parseInt(infixLiterals[i])); 
			}
			else
			{
				if (i < infixLiterals.length -1) 
				{
					while (operators.peek() != "(")
					{
						numbers.push(evaluateOperation(numbers.pop(), numbers.pop(), operators.pop()));
					}
					operators.pop();
				} 
			}
		}

		return evaluateOperation(numbers.pop(), numbers.pop(), operators.pop());
	}

	public static int evaluateOperation(int x, int y, String op) {

		if (op == "+")
		{
			return x + y;
		}
		else if (op == "-")
		{
			return y - x;
		}
		else if (op == "*")
		{
			return x * y;
		}
		else
		{
			if (x == 0) throw new UnsupportedOperationException("Cannot divide by zero");
			else return y / x;

		}
		
	}


	//~ Conversion  methods ..........................................................


	/**
	 * Converts infix to postfix.
	 *
	 * @param infixLiterals : an array containing the string literals in infix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer.
	 *
	 * @return the expression in postfix order.
	 **/
	public static String[] convertInfixToPostfix(String infixLiterals[])
	{
		if (!validateInfixOrder(infixLiterals)) throw new UnsupportedOperationException("Invalid infix expression");

		Queue<String> numbers = new LinkedList<String>();
		Stack<String> operators = new Stack<String>();
		ArrayList<String> postfixLiterals = new ArrayList<String>();

		for (int i = 0; i < infixLiterals.length; i++) //(((1 - 2) * 3) + (10 - (3 + ( 6 / 3))))
		{
			if (stringIsOperator(infixLiterals[i]) || infixLiterals[i] == "(") 
			{
				operators.add(infixLiterals[i]);
			}
			else if (stringIsInteger(infixLiterals[i])) 
			{
				numbers.add(infixLiterals[i]); 
			}
			else
			{
				while (operators.peek() != "(") 
				{
					if (!numbers.isEmpty()) postfixLiterals.add(numbers.remove());
					else postfixLiterals.add(operators.pop());
				}
				operators.pop();
			}
		}

		String[] postfix = new String[postfixLiterals.size()];
		postfix = postfixLiterals.toArray(postfix);

		return postfix;

	}



	/**
	 * Converts postfix to infix.
	 *
	 * @param postfixLiterals : an array containing the string literals in postfix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer.
	 *
	 * @return the expression in infix order.
	 **/
	public static String[] convertPostfixToInfix(String postfixLiterals[]) {
		
		Stack<String> numbers = new Stack<String>(); 
		
		for (int i = 0; i < postfixLiterals.length; i++)
		{
			if (stringIsInteger(postfixLiterals[i]) ) 
			{
				numbers.push(postfixLiterals[i]);
			} 
			else
			{
				String s1 = numbers.pop(); 
				String s2 = numbers.pop();
				String n = "( " + s2 +" " + postfixLiterals[i] + " " + s1 + " )";
				numbers.push(n);
			}
		}
		
		String n = numbers.pop();
		String[] infix = n.split(" ");
		return infix;
	}
		//2,3,4,*,+      	a,b,*,5,+ 		1, 2, -, 3, *, 10, 3, 6, 3, /, +, -, +
		//2 + 3 * 4			a * b + 5		(((1 - 2) * 3) + (10 - (3 + ( 6 / 3))))
			

}