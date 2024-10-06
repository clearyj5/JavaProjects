public class TwelveDaysOfChristmas {
	
	/*
	1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5: 5
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
       Mark out of 5: 5
   3. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
       Mark out of 10: 10
   4. Did I indent the code appropriately?
       Mark out of 10: 10
   5. Did I use an appropriate loop (or loops) to produce the different verses?
       Mark out of 20: 20
   6. Did I use a switch to build up the verses?
       Mark out of 25: 25
   7. Did I avoid duplication of code and of the lines which make up the verses (each line should be referred to in the code only once (or twice))?
       Mark out of 10: 10
   8. Does the program produce the correct output?
       Mark out of 10: 10
   9. How well did I complete this self-assessment?
       Mark out of 5: 5
   Total Mark out of 100 (Add all the previous marks): 100
	*/
	
	public static final int FIRST_DAY_OF_CHRISTMAS = 1;
	public static final int LAST_DAY_OF_CHRISTMAS = 12;

	public static void main(String[] args) {
		
		String outputGift = "a Partridge in a Pear Tree.";
		int dayOfChristmas = FIRST_DAY_OF_CHRISTMAS;
		String outputDay = "";

		for (dayOfChristmas = FIRST_DAY_OF_CHRISTMAS; dayOfChristmas <= LAST_DAY_OF_CHRISTMAS; dayOfChristmas++)
		{
			switch (dayOfChristmas)
			{
			case 1:
					outputDay = "first";
					break;
			case 2:
					outputDay = "second";
					outputGift = "2 Turtle Doves, \nand " + outputGift;
					break;
			case 3:
					outputDay = "third";
					outputGift = "3 French Hens, \n" + outputGift;
					break;
			case 4:
					outputDay = "fourth";
					outputGift = "4 Calling Birds, \n" + outputGift;
					break;
			case 5:
					outputDay = "fifth";
					outputGift = "5 Gold Rings,  \n" + outputGift;
					break;
			case 6:
					outputDay = "sixth";
					outputGift = "6 Geese a-laying,  \n" + outputGift;
					break;
			case 7:
					outputDay = "seventh";
					outputGift = "7 Swans a-swimming,  \n" + outputGift;
					break;
			case 8:
					outputDay = "eighth";
					outputGift = "8 Maids a-milking,  \n" + outputGift;
					break;
			case 9:
					outputDay = "ninth";
					outputGift = "9 ladies dancing,  \n" + outputGift;
					break;
			case 10:
					outputDay = "tenth";
					outputGift = "10 lords a-leaping,  \n" + outputGift;
					break;
			case 11:
					outputDay = "eleventh";
					outputGift = "11 pipers piping,  \n" + outputGift;
					break;
			case 12:
					outputDay = "twelfth";
					outputGift = "12 drummers drumming,  \n" + outputGift;
					break;
			}
			System.out.print( "On the " + outputDay + " day of Christmas \nmy true love sent to me: \n" + outputGift + "\n");
		}

	}

}
