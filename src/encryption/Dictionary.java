package encryption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import interfaces.CharacterSet;

public class Dictionary implements CharacterSet {

	private Character[] dictionary;
	private int length;
	private final static Logger logger = LogManager.getLogger(Dictionary.class.getName());
	
	/**
	 * Constructor<br />
	 * <br />
	 * Builds a Dictionary with a default set of characters including:<br />
	 * 1) all alphabetical letters in lower and upper case<br />
	 * 2) all ten numerical digits<br />
	 * 3) a small selection of common punctuation marks<br />
	 * Finally, sets length accordingly
	 */
	public Dictionary() {
		
		logger.debug("Running Dictionary()");
		
		logger.debug("Calling buildDictionary()");
		buildDictionary();
		this.length = dictionary.length;
		
		logger.debug("Dictionary() completed successfully");
	}
	
	/**
	 * Constructor<br />
	 * <br />
	 * Builds a Dictionary with a custom set of characters and sets length accordingly
	 * @param letters 		Character[] containing all of the alphabetic characters desired
	 * @param punctuation 	Character[] of all the non-letter, non-number characters desired
	 * @param numbers 		boolean set to true if you want the numerical digits 0-9 added for you
	 */
	public Dictionary(Character[] letters, Character[] punctuation, boolean numbers) {
		
		logger.debug("Running Dictionary(Character[] letters, Character[] punctuation, boolean numbers)");
		
		logger.debug("Building new Character[]");
		dictionary = new Character[letters.length + punctuation.length + (numbers ? 10 : 0)];
		
		logger.debug("Populating Character[]");
		System.arraycopy(letters, 0, dictionary, 0, letters.length);
		System.arraycopy(punctuation, 0, dictionary, letters.length, punctuation.length);
		if (numbers) {
			Character[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
			System.arraycopy(digits, 0, dictionary, letters.length + punctuation.length, digits.length);
		}
		
		this.length = dictionary.length;
		
		logger.debug("Character[] built and populated successfully");
		
		logger.debug("Dictionary(Character[] letters, Character[] punctuation, boolean numbers) completed successfully");
		
	}
	
	/**
	 * Constructor<br />
	 * <br />
	 * Builds a Dictionary with a custom set of characters and sets length accordingly
	 * @param completeCodex Character[] of all the desired characters
	 */
	public Dictionary(Character[] completeCodex) {
		
		logger.debug("Running Dictionary(Character[] completeCodex)");
		dictionary = completeCodex;
		
		this.length = dictionary.length;
		
		logger.debug("Dictionary(Character[] completeCodex) completed successfully");
		
	}
	
	/*
	 * Interface Implementations
	 */
	@Override
	public Character[] getDictionary() {
		
		logger.debug("Running getDictionary()");
		
		logger.debug("getDictionary() completed successfully");
		return dictionary;
		
	}
	@Override
	public int getLength() {
		
		logger.debug("Running Dictionary.length()");
		
		logger.debug("Dictionary.length() completed successfully");
		return this.length;
	}
	@Override
	public String toString() {
		
		logger.debug("Running Dictionary.toString()");
		
		String output = "";
		output += "[";
		for (int i = 0; i < this.length; i++) {
			if (i < dictionary.length - 1) {
				output += dictionary[i] + ",";
			} else {
				output += dictionary[i] + "]";
			}
		}
		
		logger.debug("Dictionary.toString() completed successfully");
		return output;
	}
	@Override
	public boolean contains(Character target) {
		
		logger.debug("Running Dictionary.contains({})", target);
		
		for (int i = 0; i < this.length; i++) {
			if (target == dictionary[i]) {
				
				logger.debug("Dictionary.contains({}) completed successfully, returned true", target);
				return true;
				
			}
		}
		
		logger.debug("Dictionary.contains({}) completed successfully, returned false", target);
		return false;
		
	}
	@Override
	public int indexOf(Character target) {
		
		logger.debug("Running Dictionary.indexOf({})", target);
		
		for (int i = 0; i < this.length; i++) {
			if (dictionary[i] == target) {
				
				logger.debug("Running Dictionary.indexOf({}) completed successfully, returning {}", target, i);
				return i;
				
			}
				
		}
		
		logger.debug("Running Dictionary.indexOf({}) completed successfully, returning -1", target);
		return -1;
		
	}
	@Override
	public Character charAt(int index) {
		
		logger.debug("Running Dictionary.charAt({})", index);
		
		logger.debug("Dictionary.charAt({}) completed successfully, returning '{}'", index, dictionary[index]);
		return dictionary[index];
		
	}
	
	/*
	 * The default character set can be modified here
	 * This method is invoked in the default constructor
	 */
	private void buildDictionary() {
		
		logger.debug("Running buildDictionary()");
		
		logger.debug("Building new Character[]");
		dictionary = new Character[77];
		
		logger.debug("Populating Character[]");
		Character[] letters = new Character[52];
		for (int i = 0; i < 26; i++) {
			int index = i + 65;
			letters[i] = (char)index;
		}
		for (int i = 26; i < 52; i++) {
			int index = i + 71;
			letters[i] = (char)index;
		}
		System.arraycopy(letters, 0, dictionary, 0, letters.length);
		Character[] punctuation = {'.', ',', ';', ':', '?', '!', '"', '\'', '-','(',')','[',']','\\','/'};
		System.arraycopy(punctuation, 0, dictionary, letters.length, punctuation.length);
		Character[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		System.arraycopy(digits, 0, dictionary, letters.length + punctuation.length, digits.length);
		
		logger.debug("Character[] built and populated successfully");
		
		logger.debug("buildDictionary() completed successfully");
		
	}
		
}
