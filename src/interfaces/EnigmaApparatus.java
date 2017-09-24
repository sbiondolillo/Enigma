/*
 * EnigmaApparatus Interface
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create a more specific interface for the Enigma machine main procedures
 * Version 0.0.1 - 9/24/17
 */

package interfaces;

public interface EnigmaApparatus extends EncryptionDecryptionApparatus {
	
	/*
	 * Configure necessary rotors for encryption algorithm
	 */
	void configureRotors();

}
