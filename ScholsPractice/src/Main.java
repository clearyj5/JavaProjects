
public class Main {

	public Word[] dictionary;

	public class Definitions {
		public Word[] definition;
	}

	public class Word {
		public String word;
		public Definitions[] definitions;

		Word(String word){
			this.word = word;
		}  
	}

	public void addWord(Word word){
		Word[] temp = new Word[dictionary.length + 1];
		for (int i = 0; i < dictionary.length; i++){
			temp[i] = dictionary[i];
		}
		temp[temp.length-1] = word;
		dictionary = temp;
	}
	
	public void removeWord(Word word) {
		
		boolean removed = false;
		Word[] temp = new Word[dictionary.length - 1];
		for (int i = 0; i < dictionary.length; i++){
			if (!removed) {
				if (word != dictionary[i]) {
					temp[i] = dictionary[i];
				}
			}
			else temp[i-1] = dictionary[i];
		}
		dictionary = temp;
	}
	
	public Definitions[] getMeanings(Word word) {
		
		for (int i = 0; i < dictionary.length; i++) {
			
			if (dictionary[i] == word) {
				return dictionary[i].definitions;
			}
		}
		System.out.println("Word not found in this dictionary... try oxford.com");
		return null;	
	}
}