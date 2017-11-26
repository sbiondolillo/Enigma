/*
 * FileInput Interface
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create an interface for input processing from files in the Enigma program
 * Version 0.0.1 - 9/22/17
 *         0.0.2 - 10/20/17 - Renamed file input method
 *         0.0.3 - 11/9/17  - Removed method for returning fileScanner
 */

package interfaces;

public interface FileInput {
	
	/** @return the String read in from the file passed to the constructor */
	String getMessageIn();
	
	/**
	 * Reads the text from the file passed to the constructor<br />
	 * and stores it off in messageIn
	 */
	void readInputFile();
	
}