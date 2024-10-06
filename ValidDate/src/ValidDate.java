import java.util.Scanner;

public class ValidDate {

	/*
	 * Write a program to determine if an entered date (day/month/year) is valid.
	 * As part of the program write and use the following routines:
	 *  - validDate() which takes a year, month and day and returns whether or not
	 *  the date is valid
	 *  - daysInMonth() which takes a month (between 1 and 12) and year, and returns
	 *    the number of days in the month.
	 *  - isLeapYear() which takes a year and return whether or not it is a leap year. 
	 */  
	
	public static final int DAYS_IN_SEPT_APR_JUN_NOV = 30;
	public static final int DAYS_IN_MOST_MONTHS = 31;
	public static final int DAYS_IN_FEBRUARY_USUALLY = 28;
	public static final int DAYS_IN_FEBRUARY_LEAP_YEAR = 29;
	 
	public static void main(String[] args) {
		
		System.out.print("Please enter the day, month and year of your date, seperated by \nspaces (e.g. 20 7 2001), to determine whether or not it is a valid date: ");
		Scanner input = new Scanner(System.in);
		if (input.hasNextInt())
		{
			int day = input.nextInt();
			int month = input.nextInt();
			int year = input.nextInt();
			
			if (validDate(day, month, year))
			{
				System.out.print("The date supplied, " + day + "/" + month + "/" + year + " is a valid date.");
			}
			else if (!validDate(day, month, year))
			{
				System.out.print("The date supplied, " + day + "/" + month + "/" + year + " is not a valid date.");
			}
		}
		else 
		{
			System.out.println("Invalid Input. Please enter the day, month and Year of your date as integers, seperated by spaces e.g. (20 7 2001): ");
		}
		input.close();

	}
	
	private static boolean validDate(int day, int month, int year)
	{
		if (day <= daysInMonth(month, year) && day >= 1 && month <=12 && month >=1)
		{
			return true;
		}
		else return false;
	}
	
	private static int daysInMonth(int month, int year)
	{
		switch (month)
		{
		case 2: 
				if (isLeapYear(year))
				{
					return DAYS_IN_FEBRUARY_LEAP_YEAR;
				}
				else if (!isLeapYear(year))
				{
					return DAYS_IN_FEBRUARY_USUALLY;
				}
				break;
		case 4:
		case 6:
		case 9:
		case 11:
				return DAYS_IN_SEPT_APR_JUN_NOV;
		default:
				return DAYS_IN_MOST_MONTHS;
		}
		return 0;

	}
	
	private static boolean isLeapYear(int year)
	{
		if ((((year%4 == 0) && (year%100 != 0)) || (year%400 == 0)) && year > 0)
		{
			return true;
		}
		return false;
	}

}
