/*
 * Rotor Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To provide encryption functionality by emulation of a physical Enigma rotor
 * Version 0.0.1 - 9/11/17
 *         0.0.2 - 9/18/17 - Added automatic rotation to the encode() method
 *         0.0.3 - 9/22/17 - Set up as implementation of EnryptionWheel
 */

package enigma;

import interfaces.RotaryEncryptor;

public class Rotor implements RotaryEncryptor {

	/*
	 * Set up each rotor with an array of characters and an initial index
	 */
	private Dictionary validCharacters;
	private int index = 0;
	
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
			int finalIndex = (currentIndex + validCharacters.indexOf(plaintext)) % validCharacters.length();
			Character cyphertext = validCharacters.charAt(finalIndex);
			rotate();
			return cyphertext;
		} else {
			return '#';
		}
	}	
}