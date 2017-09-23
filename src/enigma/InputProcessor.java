/*
 * InputProcessor Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To handle the input and output routines for an Enigma emulator
 * Version 0.0.1 - 9/18/17
 *         0.0.2 - 9/22/17 - Renamed to InputProcessor, segregating input/output responsibilities
 *                           refactored code to reflect new responsibilities
 */

package enigma;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import interfaces.*;

public class InputProcessor implements FileInput, KeyboardInput {

	private String messageIn;
	private Scanner keyboardScanner;
	private Scanner fileScanner;
	private int inputMode;
	
	/*
	 * Constructor
	 * Default constructor uses keyboard input for processing
	 */
	public InputProcessor() {
		keyboardScanner = new Scanner(System.in);
		inputMode = 1;
	}
	
	/*
	 * Constructor
	 * @param filePath - String containing any valid file path
	 */
	public InputProcessor(String filePath) {
		try {
			fileScanner = new Scanner(Paths.get(filePath));
		}
		catch (IOException e) {
			System.out.println("Unable to access file: " + e);
		}
		inputMode = 0;
	}
	
	/*
	 * Getters for instance variables
	 */
	public String getMessageIn() {
		return messageIn;
	}
	@Override
	public Scanner getFileScanner() {
		return fileScanner;
	}
	@Override
	public Scanner getKeyboardScanner() {
		return keyboardScanner;
	}
	public int getInputMode() {
		return inputMode;
	}
	
	/*
	 * Decides if it is keyboard input or from a file
	 * calls the appropriate routine for processing
	 */
	public void getNextLineIn() {
		
		if (inputMode == 0)
			getFileIn();
		else
			getKeyBoardIn();
		
	}
	
	/*
	 * Reads in the next line from the keyboard and stores it in messageIn
	 */
	public void getKeyBoardIn() {
		if (keyboardScanner.hasNextLine())
			messageIn = keyboardScanner.nextLine();
		else
			messageIn = "";
	}
	
	/*
	 * Reads in the next line from the file in and stores it in messageIn
	 */
	public void getFileIn() {
		if (fileScanner.hasNextLine())
			if (messageIn == null)
				messageIn = fileScanner.nextLine();
			else 
				messageIn += fileScanner.nextLine();
		else
			messageIn += "";
	}
	

}