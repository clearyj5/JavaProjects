public class TwelveDaysExtended {
	
	public static final int FIRST_DAY_OF_CHRISTMAS = 1;
	public static final int LAST_DAY_OF_CHRISTMAS = 12;
	public static final String FIRST_GIFT = "A Partridge in a Pear Tree \n";
	public static final String SECOND_GIFT = "2 Turtle Doves, \nand ";
	public static final String THIRD_GIFT = "3 French Hens, \n";
	public static final String FOURTH_GIFT = "4 Calling Birds, \n";
	public static final String FIFTH_GIFT = "5 Gold Rings,  \n";
	public static final String SIXTH_GIFT = "6 Geese a-laying,  \n";
	public static final String SEVENTH_GIFT = "7 Swans a-swimming,  \n";
	public static final String EIGHTH_GIFT = "8 Maids a-milking,  \n";
	public static final String NINTH_GIFT = "9 Ladies dancing,  \n";
	public static final String TENTH_GIFT = "10 Lords a-leaping,  \n";
	public static final String ELEVENTH_GIFT = "11 Pipers piping,  \n";
	public static final String TWELFTH_GIFT = "12 Drummers drumming,  \n";
	
	public static void main(String[] args) {
		
		int dayOfChristmas = FIRST_DAY_OF_CHRISTMAS;
		String output = "";
		
		for (dayOfChristmas = FIRST_DAY_OF_CHRISTMAS; dayOfChristmas <= LAST_DAY_OF_CHRISTMAS; dayOfChristmas++)
		{
			output = getChristmasGift(dayOfChristmas) + output;
			System.out.println(getVerse(dayOfChristmas, output));
		}
		
	}
	
	public static String getVerse(int dayOfChristmas, String output) 
	{
		return "On the " + getOrdinalString(dayOfChristmas) + " day of Christmas \nmy true love gave to me:\n" + output;
	}
	
	public static String getChristmasGift( int dayOfChristmas )
	{
		switch (dayOfChristmas)
		{
		case 1:
				return FIRST_GIFT;
		case 2:
				return SECOND_GIFT;
		case 3:
				return THIRD_GIFT;
		case 4:
				return FOURTH_GIFT;
		case 5:
				return FIFTH_GIFT;
		case 6:
				return SIXTH_GIFT;
		case 7:
				return SEVENTH_GIFT;
		case 8:
				return EIGHTH_GIFT;
		case 9:
				return NINTH_GIFT;
		case 10:
				return TENTH_GIFT;
		case 11:
				return ELEVENTH_GIFT;
		case 12:
				return TWELFTH_GIFT;
		}return null;
	}
	
	public static String getOrdinalString(int dayOfChristmas )
	{
		if (dayOfChristmas == 1)
		{
			return "first";
		}
		else if (dayOfChristmas == 2)
		{
			return "second";
		}
		else if (dayOfChristmas == 3)
		{
			return "third";
		}
		else if (dayOfChristmas == 4)
		{
			return "fourth";
		}
		else if (dayOfChristmas == 5)
		{
			return "fifth";
		}
		else if (dayOfChristmas == 6)
		{
			return "sixth";
		}
		else if (dayOfChristmas == 7)
		{
			return "seventh";
		}
		else if (dayOfChristmas == 8)
		{
			return "eighth";
		}
		else if (dayOfChristmas == 9)
		{
			return "ninth";
		}
		else if (dayOfChristmas == 10)
		{
			return "tenth";
		}
		else if (dayOfChristmas == 11)
		{
			return "eleventh";
		}
		else if (dayOfChristmas == 12)
		{
			return "twelfth";
		}return null;
	}

}
