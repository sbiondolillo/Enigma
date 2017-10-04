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

import enigma.Rotor;

public interface RotationManager {
	
	/*
	 * Select the rotors to be used and initialize them with the given index
	 */
	void setActiveRotors(Rotor rotor1, int index1, Rotor rotor2, int index2, Rotor rotor3, 
						int index3, Rotor rotor4, int index4, Rotor rotor5, int index5);
	
	/*
	 * Correctly encode a String by using each of the available Rotors
	 */
	String encode(String plaintext);
	
	/*
	 * Correctly decode a String by using each of the available Rotors
	 */
	String decode(String cyphertext);
	
	/*
	 * Reset the rotors to the initial configuration given by the user
	 */
	void reset();

}
