import java.util.Scanner;

public class AnalysingDisposableIncome {
	
	/*  SELF ASSESSMENT
	   1. Did I use appropriate CONSTANTS instead of numbers within the code?
	       Mark out of 10:   10
	       Comment: Yes
	   2. Did I use easy-to-understand, meaningful CONSTANT names?
	       Mark out of 5:  5
	       Comment: Yes
	    3. Did I format the CONSTANT names properly (in UPPERCASE)?
	       Mark out of 5:  5
	       Comment: Yes
	   4. Did I use easy-to-understand meaningful variable names?
	       Mark out of 10:  10
	       Comment: Made good use of clear, understandable variable names
	   5. Did I format the variable names properly (in lowerCamelCase)?
	       Mark out of 10: 10 
	       Comment: yes, made good use of lowerCamelCase
	   6. Did I indent the code appropriately?
	       Mark out of 10:  10
	       Comment: Used correct indentation
	   7. Did I read the input correctly from the user using appropriate question(s)?
	       Mark out of 10:  10
	       Comment: Used clear understandable questions
	   8. Did I compute the disposable income correctly?
	       Mark out of 10:  10
	       Comment: Yes the computations were correct
	   9. Did I compute the disposable income percentage correctly?
	       Mark out of 10:  10
	       Comment: Yes the computations were correct
	   10. Did I output the correct answer in the correct format (as shown in the examples)?
	       Mark out of 10:  10
	       Comment: Yes I used the correct format
	    11. How well did I complete this self-assessment?
	       Mark out of 10:  10
	       Comment: Very well
	   Total Mark out of 100 (Add all the previous marks):  100
	      */
	
	
	public static final String WELL_ABOVE_AVERAGE = "much more than the average disposable income per month.";
	public static final double MIN_ABOVE_AVERAGE = 750.00;
	public static final String ABOVE_AVERAGE = "more than the average disposable income per month.";
	public static final double AVERAGE = 500.00;
	public static final String EXACTLY_AVERAGE = "exactly the average disposable income per month.";
	public static final String BELOW_AVERAGE = "less than the average disposable income per month.";
	public static final double MAX_BELOW_AVERAGE = 250.00;
	public static final String WELL_BELOW_AVERAGE = "much less than the average disposable income per month.";

	public static void main(String[] args) {
		System.out.print("How much are you paid a month before tax? ");
		Scanner input = new Scanner( System.in );
		double incomeBeforeTax = input.nextDouble();
		double incomeAfterTax = incomeBeforeTax * 0.65;
		
		System.out.print("How much do you pay in rent/mortgage a month? ");
		double accomodation = input.nextDouble();
		
		System.out.print("How much does your commute cost a month? ");
		double travel = input.nextDouble();
		
		System.out.print("How much do you spend on food per month? ");
		double food = input.nextDouble();
		
		double disposableIncome = incomeAfterTax - accomodation - travel - food;
		double percentage = (disposableIncome * 100 / incomeBeforeTax );
		
		if (disposableIncome > MIN_ABOVE_AVERAGE)
		{
			System.out.print("Your disposable income is " + disposableIncome + "which is " + percentage + "% of your salary. This is " + WELL_ABOVE_AVERAGE );
		}
		else if (disposableIncome > AVERAGE)
		{
			System.out.print("Your disposable income is " + disposableIncome + "which is " + percentage + "% of your salary. This is " + ABOVE_AVERAGE );
		}
		else if (disposableIncome == AVERAGE)
		{
			System.out.print("Your disposable income is " + disposableIncome + "which is " + percentage + "% of your salary. This is " + EXACTLY_AVERAGE );
		}
		else if (disposableIncome < AVERAGE)
		{
			System.out.print("Your disposable income is " + disposableIncome + "which is " + percentage + "% of your salary. This is " + BELOW_AVERAGE );
		}
		else if (disposableIncome < MAX_BELOW_AVERAGE)
		{
			System.out.print("Your disposable income is " + disposableIncome + "which is " + percentage + "% of your salary. This is " + WELL_BELOW_AVERAGE );
		}
		input.close();
	}

}

