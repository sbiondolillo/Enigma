package interfaces;

import encryption.Rotor;

public interface RotationManager {
	
	/** @return Rotor array set in Constructor */
	Rotor[] getActiveRotors();
	
	/**
	 * Correctly encode a String by using each of the available Rotors in series (1->5)
	 * @param	plaintext	a String to be encrypted
	 * @return			the cyphertext produced using activeRotors
	 * @see		Rotor
	 */
	String encode(String plaintext);
	
	/**
	 * Correctly decode a String by using the complementary decoder Rotor
	 * @param	cyphertext	a String to be decrypted
	 * @return			the plaintext produced using the decoder Rotor
	 * @see		Rotor
	 */
	String decode(String cyphertext);

}
