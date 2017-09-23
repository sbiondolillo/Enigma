/*
 * FileInput Interface
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create an interface for input processing from files in the Enigma program
 * Version 0.0.1 - 9/22/17
 */

package interfaces;
import java.util.Scanner;

public interface FileInput extends Input {
	
	/*
	 * Getter for instance variable fileScanner
	 */
	Scanner getFileScanner();
	
}