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

	/*
	 * Getters and setters for instance variables index and notch
	 * 		notch is only set in the constructor, never at runtime
	 */
	int getIndex();
	void setIndex(int index);
	int getNotch();
	
	/* 
	 * Uses the current index to encode a single character.
	 * @param plaintext - any char from validCharacters
	 */
	Character encode(Character plaintext);
}
