/*
 * EncryptionWheel Interface
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create an interface for emulating a mechanical rotor in the Enigma program
 * Version 0.0.1 - 9/22/17
 */

package interfaces;

import enigma.Dictionary;

public interface EncryptionWheel {

	/*
	 * Getters and setters for instance variables
	 */
	int getIndex();
	void setIndex(int index);
	Dictionary getValidCharacters();
	
	/* 
	 * Uses the current index to encode a single character.
	 * Returns the encoded character or '#' if the encoding cannot be completed
	 */
	Character encode(Character plaintext);
}
