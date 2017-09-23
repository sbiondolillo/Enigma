/*
 * BaseConversionEncryptor Interface
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create an interface for converting encrypted characters into a new alphabet in the Enigma program
 * Version 0.0.1 - 9/23/17
 */

package interfaces;

public interface BaseConversionEncryptor extends Encryptor {

	/*
	 * Returns a character converted to the desired base
	 */
	Character convert(char plaintext);
}
