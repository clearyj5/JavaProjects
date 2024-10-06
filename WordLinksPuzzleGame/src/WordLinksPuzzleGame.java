/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes
- My method reads the words from the "words.txt" file. [Mark out of 5:5]
- Comment: Yes
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment: Yes

2. readWordList
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment: Yes

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment: Yes
- Exits the loop when a non-unique word is found. [Mark out of 5:5]
- Comment: Yes
- Returns true if all the words are unique and false otherwise. [Mark out of 5:5]
- Comment: Yes

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment: Yes
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: Yes

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: Yes

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment: Yes

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of the Java.IO classes covered in lectures [Mark out of 10:10]
- Comment: Yes
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: Yes

 Total Mark out of 100 (Add all the previous marks): 100
*/




import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;

public class WordLinksPuzzleGame {

	public static void main(String[] args) throws Exception {
		
		boolean finished = false;
		Scanner input = new Scanner(System.in);
		
		while (!finished)
		{
			String[] dictionaryArray = readDictionary();
			
			System.out.println("Enter a comma separated list of words (or an empty list to quit): ");
			String wordList = input.nextLine().trim();
			if (wordList.equals(""))
			{
				finished = true;
			}
			else
			{
				ArrayList<String> wordsAsArrayList = readWordList(wordList);
				isWordChain(wordsAsArrayList, dictionaryArray);
				
			}
			
		}
		input.close();
		
	}
	
	public static String[] readDictionary() throws Exception {
		
		try 
		{
			ArrayList<String> englishWords = new ArrayList<String>();

			File file = new File("word.txt"); 
			Scanner scanner = new Scanner(file); 

			while (scanner.hasNextLine()) 
			{
				englishWords.add(scanner.nextLine());
			}

			String[] dictionaryArray = new String[englishWords.size()];
			dictionaryArray = englishWords.toArray(dictionaryArray);

			return dictionaryArray;
		}
		
		catch (FileNotFoundException exception)
		{
			System.out.println("File not found");
		}
		return null;

	}
	
	public static ArrayList<String> readWordList(String input) {
		
		ArrayList<String> inputAsArrayList = new ArrayList<String>();
		String[] inputAsArray = input.split(", ?");
		for (int index = 0; index < inputAsArray.length; index++)
		{
			inputAsArrayList.add(index, inputAsArray[index]); 
		}
		
		return inputAsArrayList;
	}
	
	public static boolean isUniqueList(ArrayList<String> list) {
		
		for(int index = 0; index < list.size(); index++)
		{
			for (int index2 = 0; index2 < list.size(); index2++)
			{
				if (list.get(index).equalsIgnoreCase(list.get(index2)) && index != index2)
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static boolean isEnglishWord(ArrayList<String> wordList, String[] dictionary) {
		
		Collections.sort(wordList);
		for (int index = 0; index < wordList.size(); index++)
		{
			int result = Arrays.binarySearch(dictionary, wordList.get(index));
			if (result < 0)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isDifferentByOne(String wordOne, String wordTwo) {
		
		int count = 0;
		for(int index = 0; index < wordOne.length(); index++)
		{
			for (int index2 = 0; index2 < wordOne.length(); index2++)
			{
				if (wordOne.charAt(index) != wordTwo.charAt(index2))
				{
					count++;
				}
			}
		}
		if (wordOne.length() != wordTwo.length())
		{
			count++;
			if (wordOne.length() != (wordTwo.length() + 1) && (wordOne.length() + 1) != wordTwo.length())
			{
				count++;
			}
		}
		if (count > 1)
		{
			return false;
		}
		else 
		{
			return true;
		}
		
	}
	
	public static void isWordChain(ArrayList<String> wordList, String[] dictionary) {
		
		if (isUniqueList(wordList) && isEnglishWord(wordList, dictionary))
		{
			for (int index = 0; index < wordList.size(); index++)
			{
				String wordOne = wordList.get(index);
				for (int index2 = 0; index2 < wordList.size(); index2++)
				{
					String wordTwo = wordList.get(index2);
					if (!isDifferentByOne(wordOne, wordTwo) && (index != index2))
					{
						System.out.println("Not a valid chain of words from Lewis Carroll's word-links game. ");
					}
					
				}
				
			}
			
		}
		else
		{
			System.out.println("Valid chain of words from Lewis Carroll's word-links game. ");
		}
		
	}

}