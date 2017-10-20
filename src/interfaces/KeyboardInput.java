/*
 * KeyboardInput Interface
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create an interface for input processing from the keyboard in the Enigma program
 * Version 0.0.1 - 9/22/17
 *         0.0.2 - 10/20/17 - Renamed keyboard input method
 */

package interfaces;
import java.util.Scanner;

public interface KeyboardInput extends Input {
		
	/*
	 * Getter for instance variable keyboardScanner
	 */
	Scanner getKeyboardScanner();
	
	/*
	 * Reads in the next line from the keyboard and stores it in messageIn
	 */
	void readKeyBoardIn();

}