import java.util.Scanner;

public class MortgageCalculator {
	
	/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful, properly formatted, variable names and CONSTANTS?
        Mark out of 10: 10
        Comment:  Yes I did.
 2. Did I indent the code appropriately?
        Mark out of 5: 5
        Comment:  Yes I did. 
 3. Did I implement the mainline correctly with a loop which continues using the user says "no" ?
       Mark out of 10: 10
        Comment:  Yes I did.
 4. Did I obtain the relevant inputs from the user and produce the relevant outputs using the specified prompts & formats ?
       Mark out of 10: 10
        Comment:  Yes I did.
 5. Did I implement the readDoubleFromUser function correctly and in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20: 20
        Comment:  Yes I did.
 6. Did I implement the calculateMonthlyRepayment function correctly in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20: 20
        Comment:  Yes I did.
 7. Did I implement the calculateMonthsToRepayMortgage function correctly in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20: 20
        Comment:  Yes I did.
 8. How well did I complete this self-assessment?
        Mark out of 5: 5
        Comment: Very well.
 Total Mark out of 100 (Add all the previous marks): 100
 
 */
	
	public static final double MORTGAGE_LENGTH_ASSUMPTION = 20;
	public static final int NUMBER_OF_MONTHS_IN_YEAR = 12;

	public static void main(String[] args) {
		
		boolean finished = false;
		while (finished == false)
		{
			String currentQuestion = "Please enter the mortgage amount: ";
			System.out.print("Welcome to the mortgage calculator. \n" + currentQuestion );
			Scanner input = new Scanner( System.in );
			double principal = readDoubleFromUser(currentQuestion);
			
			currentQuestion = "Please enter the annual interest rate: ";
			System.out.println(currentQuestion);
			double apr = readDoubleFromUser(currentQuestion);
			double duration = MORTGAGE_LENGTH_ASSUMPTION;
			
			currentQuestion = "How much can you afford to pay per month?: ";
			System.out.println("Assuming a 20 year term, the monthly repayments would be " 
								+ String.format("%.2f", calculateMonthlyRepayment(principal, duration, apr)) + ". \n" + currentQuestion);
			double affordableRepayment = readDoubleFromUser(currentQuestion);
			
			System.out.println("If you pay €" + affordableRepayment + " per month your mortgage would be paid off in " 
								+ calculateMonthsToRepayMortgage(principal, affordableRepayment, apr) / NUMBER_OF_MONTHS_IN_YEAR 
								+ " years and " + calculateMonthsToRepayMortgage(principal, affordableRepayment, apr) % NUMBER_OF_MONTHS_IN_YEAR 
								+ " months. " + "\nWould you like to use the mortgage calculator again (yes/no)?: ");
					
			while(!input.hasNext("yes"))
			{	
				if (input.hasNext("no"))
				{
					finished = true;
				}
				else
				{
					System.out.println("Invalid input. You must enter yes or no to proceed. \nWould you like to use the mortgage calculator again (yes/no)?: ");
					String inputDump = input.next();
				}		
			
			}
			input.close();
			
		}

	}
	
	public static double readDoubleFromUser( String currentQuestion ) {
		
		Scanner input = new Scanner( System.in );
		boolean finished = false;
		while (!finished) 
		{	
			if (input.hasNextDouble())
			{
				finished = true;
				return input.nextDouble();
			}
			else 
			{
				System.out.print("Invalid input. You must enter a valid number to proceed. \n" + currentQuestion );
				String inputDump = input.next();
			}
		}
		input.close(); 
		return 0;	
	}
	
	public static double calculateMonthlyRepayment( double principal, double duration, double apr) {
		
		double monthlyRepayment = (principal * (apr / 1200)) / (1 - Math.pow(1+apr/12/100, -duration * 12));
		return monthlyRepayment;
	}
	
	public static int calculateMonthsToRepayMortgage( double principal, double affordableRepayment, double apr) {
		
		boolean finished = false;
		int months = 0;
		double monthlyInterestRate = apr / NUMBER_OF_MONTHS_IN_YEAR / 100;
		do
		{
			principal = principal + (monthlyInterestRate * principal) - affordableRepayment;
			months++;
			if (principal <= 0)
			{
				finished = true;
			}
		} while (!finished);
		return months;
	}
	
}

