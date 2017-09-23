/*
 * Dictionary Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To provide a standard set of characters for all of the constituent parts of our Enigma machine
 * Version 0.0.1 - 9/11/17
 * 		   0.0.2 - 9/18/17 - Added the space character to the default punctuation set
 * 		   0.0.3 - 9/21/17 - Renamed to Dictionary to fit naming convention given by Ed Cauthorn
 */

package enigma;

public class Dictionary {

	private Character[] dictionary;
	
	/* Constructor
	 * Builds a Dictionary with a default set of characters including all alphabetical letters 
	 * in lower and upper case, all ten numerical digits, and a small selection of common
	 * punctuation marks
	 */
	public Dictionary() {
		buildDictionary();
	}
	
	/* Constructor
	 * Builds a Dictionary with a custom set of characters
	 * @param letters Character array containing all of the alphabetic characters desired
	 * @param punctuation Character array of all the desired non-letter, non-number characters desired
	 * @param numbers Set to true if you desire to have the numerical digits 0-9 added for you
	 */
	public Dictionary(Character[] letters, Character[] punctuation, boolean numbers) {
		dictionary = new Character[letters.length + punctuation.length + (numbers ? 10 : 0)];
		System.arraycopy(letters, 0, dictionary, 0, letters.length);
		System.arraycopy(punctuation, 0, dictionary, letters.length, punctuation.length);
		if (numbers) {
			Character[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
			System.arraycopy(digits, 0, dictionary, letters.length + punctuation.length, digits.length);
		}
	}
	
	/* 
	 * Builds a custom set of characters
	 * @param completeCodex Character array of all the desired characters
	 */
	public Dictionary(Character[] completeCodex) {
		dictionary = completeCodex	;
	}
	
	/*
	 * Getters and Setters
	 */
	public Character[] getDictionary() {
		return dictionary;
	}
	
	/*
	 *  The default character set can be modified here
	 *  This method is invoked in the default constructor
	 */
	public void buildDictionary() {
		dictionary = new Character[72];
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
	}
	
	/*
	 *  Print the Dictionary in a legible format
	 */
	public String toString() {
		String output = "";
		output += "[";
		for (int i = 0; i < dictionary.length; i++) {
			if (i < dictionary.length - 1) {
				output += dictionary[i] + ",";
			} else {
				output += dictionary[i] + "]";
			}
		}
		return output;
	}
	
	/*
	 * Test if the Dictionary contains a specified character
	 */
	public boolean contains(Character test) {
		for (int i = 0; i < dictionary.length; i++) {
			if (test == dictionary[i]) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 *  Return length of the Dictionary
	 */
	public int length() {
		return dictionary.length;
	}
	
	/*
	 *  Sequential search for a specified character
	 *  returns -1 if character not found
	 */
	public int indexOf(Character quarry) {
		for (int i = 0; i < this.length(); i++) {
			if (dictionary[i] == quarry)
				return i;
		}
		return -1;
	}
	
	/*
	 *  Allow character lookup by direct indexing
	 */
	public Character charAt(int index) {
		return dictionary[index];
	}
}