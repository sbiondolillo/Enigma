/*
 * FileInputProcessor Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To handle the input and output routines for an Enigma emulator
 * Version 0.0.1 - 9/18/17
 *         0.0.2 - 9/22/17 - Renamed to InputProcessor, segregating input/output responsibilities
 *                           refactored code to reflect new responsibilities
 *         0.0.3 - 10/20/17 - Refactored from InputProcessor into 2 classes: FileInputProcessor, KeyboardInputProcessor
 */

package enigma;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import interfaces.*;

public class FileInputProcessor implements FileInput {

	private String messageIn;
	private Scanner fileScanner;
	
	
	
	/*
	 * Constructor
	 * @param filePath - String containing any valid file path
	 */
	public FileInputProcessor(String filePath) {
		try {
			fileScanner = new Scanner(Paths.get(filePath));
		}
		catch (IOException e) {
			System.out.println("Unable to access file: " + e);
		}
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
	
	/*
	 * Reads in the next line from the file in and stores it in messageIn
	 */
	@Override
	public void readFileIn() {
		while (fileScanner.hasNextLine()) {
			if (messageIn == null)
				messageIn = fileScanner.nextLine();
			else 
				messageIn += fileScanner.nextLine();
		}
	}
	

}