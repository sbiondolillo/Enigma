/*
 * KeyboardInputProcessor Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To handle the input and output routines for an Enigma emulator
 * Version 0.0.1 - 9/18/17
 *         0.0.2 - 9/22/17  Renamed to InputProcessor, segregating input/output responsibilities
 *                          refactored code to reflect new responsibilities
 *         0.0.3 - 10/20/17 Refactored from InputProcessor into 2 classes: FileInputProcessor, KeyboardInputProcessor
 *                          renamed keyboard input method
 *         0.0.4 - 10/27/17 Add log4j2 Logger into class
 *                          Add debugging statements for Logger
 */

package enigma;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import interfaces.KeyboardInput;

public class KeyboardInputProcessor implements KeyboardInput {

	private String messageIn;
	private Scanner keyboardScanner;
	private final static Logger logger = LogManager.getLogger(KeyboardInputProcessor.class.getName());
	
	/*
	 * Constructor
	 * Default constructor uses keyboard input for processing
	 */
	public KeyboardInputProcessor() {
		
		logger.debug("Running KeyboardInputProcessor()");
		
		logger.debug("Building Scanner for System.in");
		keyboardScanner = new Scanner(System.in);
		
		logger.debug("keyboardInputProcessor() completed successfully");
		
	}
	
	/*
	 * Getters for instance variables
	 */
	public String getMessageIn() {
		
		logger.debug("Running getMessageIn()");
		
		logger.debug("getMessageIn() completed successfully");
		return messageIn;
		
	}
	@Override
	public Scanner getKeyboardScanner() {
		
		logger.debug("Running getKeyboardScanner()");
		
		logger.debug("getKeyboardScanner() completed successfully, returning {}", keyboardScanner);
		return keyboardScanner;
		
	}
	
	/*
	 * Reads in the next line from the keyboard and stores it in messageIn
	 */
	@Override
	public void readKeyBoardIn() {
		
		logger.debug("Running readKeyBoardIn()");
		
		if (keyboardScanner.hasNextLine())
			messageIn = keyboardScanner.nextLine();
		else
			messageIn = "";
		
		logger.debug("readKeyBoardIn() completed successfully");
		
	}
}
