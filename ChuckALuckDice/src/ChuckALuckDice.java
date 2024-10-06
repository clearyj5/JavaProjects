import java.util.Scanner;

public class ChuckALuckDice {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String openingQuestion = "How much cash do you have?: ";
		System.out.print(openingQuestion);
		double money = readDoubleFromUser(openingQuestion);
		Wallet wallet = new Wallet();	

		if (money > 0.0)
		{
			
			wallet.put(money);
		} 
		else 
		{
			System.out.println("You must have more than zero euro. Please enter the amount of cash that you have: ");
		}

		System.out.println("There are four types of bets you can make: \nTriple: All 3 dice show the same number (except 1s or 6s). Payout 30:1\n"
				+ "Field: Total number shown on the 3 dice is less than 8 or greater than 12. Payout 1:1.\n"
				+ "High: Total number shown on the 3 dice is greater than 10 (but not a Triple). Payout 1:1.\n"
				+ "Low: Total number shown on the 3 dice is less than 11, (but not a Triple). Payout 1:1.");

		boolean exit = false;
		while (!exit) {
			if (wallet.check() > 0.0) 
			{				
				System.out.println("\nPlease enter the type of bet you would like to place, or enter 'quit': ");

				String betType = input.next();
				if (betType.equalsIgnoreCase("Triple") || betType.equalsIgnoreCase("Field") || betType.equalsIgnoreCase("High") || betType.equalsIgnoreCase("Low"))
				{
					resolveBet (betType, wallet);					
				}			
				else if (betType.equalsIgnoreCase("quit")) 
				{
					System.out.println("Thank you for playing. Goodbye!");
					exit = true;
				}
				else if (input.hasNext())
				{
					System.out.println("Invalid Input. Please enter a type of bet or enter 'quit': ");
				}
			}

		}
		input.close();

	}

	public static void resolveBet (String betType, Wallet wallet) {

		double betAmount = 0.0;
		boolean valid = false;
		System.out.println("You have €" + String.format("%.2f", wallet.check()) + " in your wallet. How much would you like to bet?: ");
		Scanner input2 = new Scanner(System.in);

		do
		{
			if (input2.hasNextDouble()) 
			{
				if (wallet.get(input2.nextDouble()))
				{
					betAmount = input2.nextDouble();
					valid = true;
				}
				else if (input2.nextDouble() > wallet.check())
				{
					System.out.println("You have insufficient funds to place this bet. Please enter an amount less than or equal to the amount in your wallet: ");
				}

			}
			else if (!input2.hasNextDouble())
			{		
				System.out.println("Invalid input. Please enter a valid amount for your bet: ");
			}

		} while (!valid);

		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		Dice dice3 = new Dice();

		int roll1 = dice1.roll();
		int roll2 = dice2.roll();
		int roll3 = dice3.roll();
		int totalRoll = roll1 + roll2 + roll3;

		String result = "";

		if (roll1 == roll2 && roll1 == roll3 && roll1 != 1 && roll1 != 6) 
		{
			result = "Triple";
		}
		else if (totalRoll < 8 || totalRoll > 12)
		{
			result = "Field";
		}
		else if (totalRoll > 10 && ((roll1 != 4 && roll2 != 4 && roll3 != 4) || (roll1 != 5 && roll2 != 5 && roll3 != 5) || (roll1 != 6 && roll2 != 6 && roll3 != 6)))
		{
			result = "High";
		}
		else if (totalRoll < 11 && ((roll1 != 1 && roll2 != 1 && roll3 != 1) || (roll1 != 2 && roll2 != 2 && roll3 != 2) || (roll1 != 3 && roll2 != 3 && roll3 != 3)))
		{
			result = "Low";
		}
		System.out.println(dice1.topFace() + " " + dice2.topFace() + " " + dice3.topFace());

		if (result.equalsIgnoreCase(betType))
		{
			System.out.println("Congratulations, you won!");

			if (result.equalsIgnoreCase("Triple"))
			{
				wallet.put((betAmount * 30) + betAmount);
			}
			else if(result.equalsIgnoreCase("Field") || result.equalsIgnoreCase("High") || result.equalsIgnoreCase("Low"))
			{
				wallet.put(betAmount * 2);
			}

		}
		else 
		{
			System.out.println("Hard Luck, you lost.");
		}
		input2.close();

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


}






