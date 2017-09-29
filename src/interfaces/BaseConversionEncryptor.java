/*
 * BaseConversionEncryptor Interface
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create an interface for converting encrypted characters into a new alphabet in the Enigma program
 * Version 0.0.1 - 9/23/17
 * 		   0.0.2 - 9/24/17	Added getters/setters for base instance variable
 */

package interfaces;

public interface BaseConversionEncryptor extends Encryptor {

	/*
	 * Getter and setter for the base instance variable
	 */
	int getBase();
	void setBase();
	
	/*
	 * Returns a character converted to the desired base
	 */
	Character convert(char plaintext);
}
