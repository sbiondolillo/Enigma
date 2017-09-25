/*
 * CharacterSet Interface
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create an interface for an object which manages rotor rotation in the Enigma program
 * Version 0.0.1 - 9/25/17
 */

package interfaces;

import enigma.Rotor;

public interface RotationManager {
	
	/*
	 * Select the rotors to be used and initialize them with the given index
	 */
	void setActiveRotors(Rotor rotor1, int index1, Rotor rotor2, int index2, Rotor rotor3, int index3);
	
	/*
	 * Correctly encode a character by correctly rotating the rotors
	 */
	Character encode(Character plaintext);
	
	/*
	 * Reset the rotors to the initial configuration given by the user
	 */
	void reset();

}
