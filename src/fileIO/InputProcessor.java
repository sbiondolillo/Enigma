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
 *         0.0.7 - 11/9/17    Refactor class to use BufferedReaders instead of Scanners
 *         0.0.8 - 11/10/17   Abstract html/txt reading methods out of readFileIn()
 */

package fileIO;

import java.io.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import interfaces.*;
import utilities.Utilities;

public class InputProcessor implements FileInput {

	private String messageIn = "";
	private File inputFile = null;
	private String fileExtension;
	private FileReader fileReader = null;
	private BufferedReader bufferedReader = null;
	private final static Logger logger = LogManager.getLogger(InputProcessor.class.getName());
	
	/*
	 * Constructor
	 * @param filePath - String containing any valid file path
	 */
	public InputProcessor(String filePath) {
		
		logger.debug("Running InputProcessor({})", filePath);
		
		try {
			
			logger.debug("Building File for {}", filePath);
			inputFile = new File(filePath);
			
			logger.debug("Building FileReader for {}", filePath);
			fileReader = new FileReader(inputFile);
			
			logger.debug("Building BufferedReader for {}", filePath);
			bufferedReader = new BufferedReader(fileReader);
			
			logger.debug("Getting file extension for {} as {}", 
					filePath, Utilities.getExtension(inputFile));
			fileExtension = Utilities.getExtension(inputFile);
			
		}
		catch (IOException e) {
			
			logger.error("Error accessing {}: {}", filePath, e.getClass());
			
		}
		
		logger.debug("InputProcessor({}) completed successfully", filePath);
		
	}
	
	/*
	 * Getters/Setters for instance variables
	 */
	public String getMessageIn() {
		
		logger.debug("Running getMessageIn()");
		
		logger.debug("getMessageIn() completed successfully");
		return messageIn;
		
	}
	
	/*
	 * Reads the text from a file into messageIn
	 * Calls readHTMLFileIn() for .html files
	 * Calls readTextFileIn() for .txt files
	 */
	@Override
	public void readInputFile() {
		
		logger.debug("Running readInputFile()");
		
		try {
			
			if (fileExtension.equals("html")) {
				
				logger.debug("Calling readHTMLFile()");
				readHTMLFile();
				
			}
			else {
				
				logger.debug("Calling readTextFile()");
				readTextFile();
				
			}
			
			logger.debug("Closing bufferedReader");
			bufferedReader.close();
			
		} 
		catch (IOException e) {
			
			logger.error("File error in readFileIn(): {}", e.getClass());
			
		}
		
		logger.debug("readFileIn() completed successfully");
		
	}
	
	private void readHTMLFile() {
		
		logger.debug("Running readHTMLFile()");
		
		logger.debug("Building new HTMLParser()");
		HTMLParser parser = new HTMLParser();
		
		logger.debug("Calling parseHTMLFile({})", inputFile.getPath());
		messageIn = parser.parseHTMLFile(inputFile);
		
		logger.debug("readHTMLFile() completed successfully");
		
	}
	
	private void readTextFile() throws IOException {
		
		logger.debug("Running readTextFile()");
		
		String line = null;
		
		logger.debug("Reading text file lines into messageIn");
		while((line = bufferedReader.readLine()) != null) {
			messageIn += line;
			messageIn += "\n";
		}
		
		logger.debug("readTextFile() completed successfully");
		
	}
	
}