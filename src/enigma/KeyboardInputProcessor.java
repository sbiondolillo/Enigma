/*
 * FileInputProcessor Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To handle the input and output routines for an Enigma emulator
 * Version 0.0.1 - 9/18/17
 *         0.0.2 - 9/22/17 - Renamed to InputProcessor, segregating input/output responsibilities
 *                           refactored code to reflect new responsibilities
 *         0.0.3 - 10/20/17 - Refactored from InputProcessor into 2 classes: FileInputProcessor, KeyboardInputProcessor
 *                            renamed keyboard input method
 */

package enigma;

import java.util.Scanner;
import interfaces.KeyboardInput;

public class KeyboardInputProcessor implements KeyboardInput {

	private String messageIn;
	private Scanner keyboardScanner;
	
	/*
	 * Constructor
	 * Default constructor uses keyboard input for processing
	 */
	public KeyboardInputProcessor() {
		keyboardScanner = new Scanner(System.in);
	}
	
	/*
	 * Getters for instance variables
	 */
	public String getMessageIn() {
		return messageIn;
	}
	@Override
	public Scanner getKeyboardScanner() {
		return keyboardScanner;
	}
	
	/*
	 * Reads in the next line from the keyboard and stores it in messageIn
	 */
	@Override
	public void readKeyBoardIn() {
		if (keyboardScanner.hasNextLine())
			messageIn = keyboardScanner.nextLine();
		else
			messageIn = "";
	}
}
