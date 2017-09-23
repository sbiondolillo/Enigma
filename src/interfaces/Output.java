/*
 * Output Interface
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create a base interface for output processing in the Enigma machine
 * Version 0.0.1 - 9/23/17
 */

package interfaces;

public interface Output {

	/*
	 * Getter for instance variable messageOut
	 */
	String getMessageOut();
	
	/*
	 * Display the contents of messageOut directly to the console
	 */
	void printMessageOutToConsole();
}
