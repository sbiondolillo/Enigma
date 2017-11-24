/*
 * Encryptor Interface
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create a base interface for encrypting characters in the Enigma program
 * Version 0.0.1 - 9/23/17
 */

package interfaces;

import encryption.Dictionary;

public interface Encryptor {

	/*
	 * Getter for instance variable validCharacters
	 */
	Dictionary getValidCharacters();
	
}
