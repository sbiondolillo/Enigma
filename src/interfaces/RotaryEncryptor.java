/*
 * RotaryEncryptor Interface
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create an interface for emulating a mechanical rotor in the Enigma program
 * Version 0.0.1 - 9/22/17
 * 		   0.0.2 - 9/23/17	Refactored to make this an extension of Ecryptor
 */

package interfaces;

public interface RotaryEncryptor extends Encryptor {

	/*
	 * Getters and setters for instance variables
	 */
	int getIndex();
	void setIndex(int index);
	int getNotch();
	
	/* 
	 * Uses the current index to encode a single character.
	 * Returns the encoded character or '#' if the encoding cannot be completed
	 */
	Character encode(Character plaintext);
}
