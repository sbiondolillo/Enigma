/*
 * RotationManager Interface
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create an interface for an object which manages multiple-rotor encoding/decoding in the Enigma program
 * Version 	0.0.1 	9/25/17
 * 			0.0.2	10/4/17		modify setActiveRotors to accept 5 Rotors with settings
 * 								change encode() to utilize Strings
 * 								add decode() method
 */

package interfaces;

import encryption.Rotor;

public interface RotationManager {
	
	/** Return Rotor array set in Constructor */
	Rotor[] getActiveRotors();
	
	/**
	 * Correctly encode a String by using each of the available Rotors in series (1->5)
	 * @param	plaintext	a String to be encrypted
	 * @return				the cyphertext produced using activeRotors
	 * @see		Rotor
	 */
	String encode(String plaintext);
	
	/**
	 * Correctly decode a String by using the complementary decoder Rotor
	 * @param	cyphertext	a String to be decrypted
	 * @return				the plaintext produced using the decoder Rotor
	 * @see		Rotor
	 */
	String decode(String cyphertext);

}
