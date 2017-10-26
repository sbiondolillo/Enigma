/*
 * Dictionary Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To provide a standard set of characters for all of the constituent parts of our Enigma machine
 * Version 	0.0.1 - 9/11/17
 * 		   	0.0.2 - 9/18/17 - Added the space character to the default punctuation set
 * 		   	0.0.3 - 9/21/17 - Renamed to Dictionary to fit naming convention given by Ed Cauthorn
 * 			0.0.4 - 9/22/17 - Set up as implementation of CharacterSet
 *          0.0.5 - 10/26/17  Add log4j2 Logger into class
 *                            Add debugging statements for Logger
 *                            Added instance variable length to reduce calls to length()
 */

package enigma;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import interfaces.CharacterSet;

public class Dictionary implements CharacterSet{

	private Character[] dictionary;
	private int length;
	private final static Logger logger = LogManager.getLogger(Dictionary.class.getName());
	
	/* Constructor
	 * Builds a Dictionary with a default set of characters including all alphabetical letters 
	 * in lower and upper case, all ten numerical digits, and a small selection of common
	 * punctuation marks
	 */
	public Dictionary() {
		
		logger.debug("Running Dictionary()");
		
		logger.debug("Calling buildDictionary()");
		buildDictionary();
		this.length = dictionary.length;
		
		logger.debug("Dictionary() completed successfully");
	}
	
	/* Constructor
	 * Builds a Dictionary with a custom set of characters
	 * @param letters Character array containing all of the alphabetic characters desired
	 * @param punctuation Character array of all the desired non-letter, non-number characters desired
	 * @param numbers Set to true if you desire to have the numerical digits 0-9 added for you
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
	
	/* 
	 * Builds a custom set of characters
	 * @param completeCodex Character array of all the desired characters
	 */
	public Dictionary(Character[] completeCodex) {
		
		logger.debug("Running Dictionary(Character[] completeCodex)");
		dictionary = completeCodex;
		
		this.length = dictionary.length;
		
		logger.debug("Dictionary(Character[] completeCodex) completed successfully");
		
	}
	
	/*
	 * Getters and Setters
	 */
	@Override
	public Character[] getDictionary() {
		
		logger.debug("Running getDictionary()");
		
		logger.debug("getDictionary() completed successfully");
		return dictionary;
		
	}
	
	/*
	 *  The default character set can be modified here
	 *  This method is invoked in the default constructor
	 */
	private void buildDictionary() {
		
		logger.debug("Running buildDictionary()");
		
		logger.debug("Building new Character[]");
		dictionary = new Character[72];
		
		logger.debug("Populating Character[]");
		for (int i = 0; i < 26; i++) {
			int index = i + 65;
			dictionary[i] = (char)index;
		}
		for (int i = 26; i < 52; i++) {
			int index = i + 71;
			dictionary[i] = (char)index;
		}
		Character[] punctuation = {'.', ',', ';', ':', '?', '!', '"', '\'', '-', ' '};
		System.arraycopy(punctuation, 0, dictionary, 52, punctuation.length);
		Character[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		System.arraycopy(digits, 0, dictionary, 62, digits.length);
		
		logger.debug("Character[] built and populated successfully");
		
		logger.debug("buildDictionary() completed successfully");
		
	}
	
	/*
	 *  Print the Dictionary in a legible format
	 */
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
	
	/*
	 * Test if the Dictionary contains a specified character
	 */
	@Override
	public boolean contains(Character test) {
		
		logger.debug("Running Dictionary.contains({})", test);
		
		for (int i = 0; i < this.length; i++) {
			if (test == dictionary[i]) {
				
				logger.debug("Dictionary.contains({}) completed successfully, returned true", test);
				return true;
				
			}
		}
		
		logger.debug("Dictionary.contains({}) completed successfully, returned false", test);
		return false;
		
	}
	
	/*
	 *  Return length of the Dictionary
	 */
	@Override
	public int length() {
		
		logger.debug("Running Dictionary.length()");
		
		logger.debug("Dictionary.length() completed successfully");
		return this.length;
	}
	
	/*
	 *  Sequential search for a specified character
	 *  returns -1 if character not found
	 */
	@Override
	public int indexOf(Character quarry) {
		
		logger.debug("Running Dictionary.indexOf({})", quarry);
		
		for (int i = 0; i < this.length; i++) {
			if (dictionary[i] == quarry) {
				
				logger.debug("Running Dictionary.indexOf({}) completed successfully, returning {}", quarry, i);
				return i;
				
			}
				
		}
		
		logger.debug("Running Dictionary.indexOf({}) completed successfully, returning -1", quarry);
		return -1;
		
	}
	
	/*
	 *  Allow character lookup by direct indexing
	 */
	@Override
	public Character charAt(int index) {
		
		logger.debug("Running Dictionary.charAt({})", index);
		
		logger.debug("Dictionary.charAt({}) completed successfully, returning '{}'", index, dictionary[index]);
		return dictionary[index];
		
	}
}