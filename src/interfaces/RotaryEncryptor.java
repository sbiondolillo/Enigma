/*
 * RotaryEncryptor Interface
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create an interface for emulating a mechanical rotor in the Enigma program
 * Version 0.0.1 - 9/22/17
 * 		   0.0.2 - 9/23/17	Refactored to make this an extension of Ecryptor
 * 		   0.0.3 - 9/24/17  Added the getter for instance variable notch
 */

package interfaces;

public interface RotaryEncryptor extends Encryptor {

	/** @return the current index of the RotoryEncryptor */
	int getIndex();
	
	/**
	 * Sets the RotoryEncryptor to a given index
	 * @param index	an int representing the desired setting
	 */
	void setIndex(int index);
	
	/**
	 * Uses the current index to encode a single character.
	 * @param	plaintext	a char to be encoded
	 * @return the encoded char or '#' if plaintext can't be encoded
	 */
	Character encode(Character plaintext);
}
