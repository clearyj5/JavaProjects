import java.util.Scanner;

public class MinusBFormula {

	public static void main(String[] args) {
		
		System.out.print("Please enter the coefficients of your second order polynomial, seperated by spaces: ");
		Scanner input = new Scanner( System.in );
		if (input.hasNextDouble())
		{
			double a=0, b=0, c=0;
			a = input.nextDouble();
			b = input.nextDouble();
			c = input.nextDouble();
			double squareRoot = Math.pow(b, 2.0) - 4 * a * c;
			
			if (squareRoot > 0.0)
			{
				double positiveRoot = (-b + Math.sqrt(squareRoot))/(2.0 * a);
				double negativeRoot = (-b - Math.sqrt(squareRoot))/(2.0 * a);
				System.out.print("The roots of your second order polynomial are x = " + positiveRoot + " and x = " + negativeRoot + ".");
			}
			else if (squareRoot == 0.0)
			{
				double root = (-b/(2.0 * a));
				System.out.print("The roots of your second order polynomial are both at x = " + root);
			}
			else if (squareRoot < 0.0)
			{
				System.out.print("This equation has no real roots.");
			}
		}
		else
		{
			System.out.print("Input invalid. Please re-enter your coefficients correctly.");
		}
		input.close();
	}
}
