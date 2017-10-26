/*
 * Rotor Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To provide encryption functionality by emulation of a physical Enigma rotor
 * Version 0.0.1	9/11/17
 *         0.0.2	9/18/17		Added automatic rotation to the encode() method
 *         0.0.3	9/22/17		Set up as implementation of EnryptionWheel
 *         0.0.4	9/24/17		Added a variable to store the notch position for use in multi-rotor setups
 *         					 	Added a constructor which sets the notch position
 *         0.0.5	10/4/17		Removed rotate() from encode() method logic
 *         0.0.6    10/26/17    Adjusted encode to cache dictionary length
 */

package rotors;

import enigma.Dictionary;
import interfaces.RotaryEncryptor;

public class Rotor implements RotaryEncryptor {

	/*
	 * Set up each rotor with an array of characters, an initial index, and a notch position
	 */
	private Dictionary validCharacters;
	private int index = 0;
	private int notch = 9;
	
	/*
	 * Constructor
	 * Default constructor gets the default character set
	 */
	public Rotor() {
		validCharacters = new Dictionary();
	}
	
	/*
	 * Constructor
	 * @param completeCodex - Users can enter their own array of characters for a custom rotor
	 */
	public Rotor(Character[] completeCodex) {
		validCharacters = new Dictionary(completeCodex);
	}
	
	/*
	 * Constructor
	 * @param completeCodex - Users can enter their own array of characters for a custom rotor
	 * @param notch - an int indicating the notch position where the rotor would cause 
	 * 				  a rotation in the next rotor in series
	 */
	public Rotor(Character[] completeCodex, int notch) {
		validCharacters = new Dictionary(completeCodex);
		this.notch = notch;
	}
	
	/*
	 * Getters and Setters
	 */
	@Override
	public int getIndex() {
		return index;
	}
	@Override
	public void setIndex(int index) {
		this.index = index;
	}
	@Override
	public Dictionary getValidCharacters() {
		return validCharacters;
	}
	@Override 
	public int getNotch() {
		return notch;
	}
	
	/*
	 * Advances the index by 1 and wraps around the end, emulating a mechanical rotor
	 */
	private void rotate() {
		index = (index + 1) % validCharacters.length();
	}
	
	/* 
	 * Uses the current index to encode a single character.
	 * Returns the encoded character or '#' if the encoding cannot be completed
	 */
	@Override
	public Character encode(Character plaintext) {
		if (validCharacters.contains(plaintext)) {
			int currentIndex = index;
			int dictionaryLength = validCharacters.length();
			int finalIndex = (currentIndex + validCharacters.indexOf(plaintext)) % dictionaryLength;
			Character cyphertext = validCharacters.charAt(finalIndex);
			return cyphertext;
		} else {
			return '#';
		}
	}	
}