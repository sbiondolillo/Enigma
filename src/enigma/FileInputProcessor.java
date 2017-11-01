/*
 * FileInputProcessor Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To handle the input and output routines for an Enigma emulator
 * Version 0.0.1 - 9/18/17
 *         0.0.2 - 9/22/17 - Renamed to InputProcessor, segregating input/output responsibilities
 *                           refactored code to reflect new responsibilities
 *         0.0.3 - 10/20/17 - Refactored from InputProcessor into 2 classes: FileInputProcessor, KeyboardInputProcessor
 *                            renamed & refactored file input method
 *         0.0.4 - 10/24/17 - Incorporated Utilities class error handling
 *         0.0.5 - 10/26/17 - Add log4j2 Logger into class
 *                            Add debugging statements for Logger
 *                            Removed Utilities instance variable
 *         0.0.6 - 11/1/17    update readFileIn() to preserve input formatting
 */

package enigma;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import interfaces.*;
import utilities.Utilities;

public class FileInputProcessor implements FileInput {

	private String messageIn = "";
	private Scanner fileScanner;
	private final static Logger logger = LogManager.getLogger(FileInputProcessor.class.getName());
	
	
	/*
	 * Constructor
	 * @param filePath - String containing any valid file path
	 */
	public FileInputProcessor(String filePath) {
		
		logger.debug("Running FileInputProcessor({})", filePath);
		
		try {
			
			logger.debug("Building Scanner for {}", filePath);
			fileScanner = new Scanner(Paths.get(filePath));
			
		}
		catch (IOException e) {
			
			logger.error("File error in FileInputProcessor({}): {}", filePath, e.getClass());
			
			logger.debug("Calling Utilities.handleError(file)");
			Utilities.handleError("file");
		}
		
		logger.debug("FileInputProcessor({}) completed successfully", filePath);
		
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
	public Scanner getFileScanner() {
		
		logger.debug("Running getFileScanner()");
		
		logger.debug("getFileScanner() completed successfully");
		return fileScanner;
		
	}
	
	/*
	 * Reads in the next line from the file in and stores it in messageIn
	 */
	@Override
	public void readFileIn() {
		
		logger.debug("Running readFileIn()");
		
		while (fileScanner.hasNextLine()) {
			messageIn += fileScanner.nextLine();
			if (fileScanner.hasNextLine())
				messageIn += "\n";
		}
		
		logger.debug("readFileIn() completed successfully");
	}
	

}