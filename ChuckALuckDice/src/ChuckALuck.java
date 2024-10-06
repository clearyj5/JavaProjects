import java.util.Scanner;

public class ChuckALuck {
	
	/* SELF ASSESSMENT 

	1. ResolveBet

	I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: 7].
	Comment: yes
	My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8].
	Comment: yes
	My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5].
	Comment: Using the get method in the wallet class
	My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: 15].
	Comment: yes
	My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: 20].
	Comment: yes
	My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: 10].
	Comment: Removes the amount from user wallet when they place the bet, then adds it back in plus the winnings if they win.

	2. Main

	I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15]
	Comment: yes
	My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 5]
	Comment: yes
	I ask the user to enter any of the four bet types or quit [Mark out of 5: 5].
	Comment: yes
	My program calls resolveBet for each bet type entered [Mark out of 5: 5].
	Comment: yes
	At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 5]
	Comment: yes

	 Total Mark out of 100 (Add all the previous marks): 100
	*/

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String currentQuestion = "How much cash do you have?: ";
		System.out.println(currentQuestion);
		double money = readDoubleFromUser(currentQuestion);
		Wallet wallet = new Wallet();
		wallet.put(money);

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
					System.out.println("You have €" + String.format("%.2f", wallet.check()) + " left in your wallet. Thank you for playing. Goodbye!");
					exit = true;
				}
				else 
				{
					System.out.println("Invalid Input. ");
				}

			}
			else if (wallet.check() <= 0.0)
			{
				System.out.println("You have run out of money. Hard luck, thank you for playing. ");
				exit = true;
			}

		}
		if (wallet.check() > money)
		{
			double winnings = (wallet.check() - money);
			System.out.println("Your total winnings are " + String.format("%.2f", winnings));
		}
		else if (wallet.check() < money)
		{
			double losses = (money - wallet.check());
			System.out.println("Your total losses are " + String.format("%.2f", losses));
		}
		else if (wallet.check() == money)
		{
			System.out.println("You broke even!");
		}

	}

	public static void resolveBet (String betType, Wallet wallet) {
		double betAmount = 0.0;
		String question = "How much would you like to bet?: ";
		System.out.println("You have €" + String.format("%.2f", wallet.check()) + " left in your wallet. " + question);
		Scanner input2 = new Scanner(System.in);

		boolean valid = false;
		do
		{
			betAmount = readDoubleFromUser(question);
			if (wallet.get(betAmount))
			{
				valid = true;
			}
			else
			{
				System.out.println("Invalid input. " + question);
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
		else if (totalRoll > 10 && !(roll1 == roll2 && roll1 == roll3))
		{
			result = "High";
		}
		else if (totalRoll < 11 && !(roll1 == roll2 && roll1 == roll3))
		{
			result = "Low";
		}
		System.out.println("Results were: " + dice1.topFace() + " " + dice2.topFace() + " " + dice3.topFace());

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

	}

	public static double readDoubleFromUser( String currentQuestion ) {

		Scanner input = new Scanner( System.in );
		boolean finished = false;
		while (!finished) 
		{	
			if (input.hasNextDouble())
			{
				{
					finished = true;
					return input.nextDouble();
				}
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