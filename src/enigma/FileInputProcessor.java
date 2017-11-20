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

package enigma;

import java.io.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import interfaces.*;
import utilities.Utilities;

public class FileInputProcessor implements FileInput {

	private String messageIn = "";
	private File inputFile = null;
	private String fileExtension;
	private FileReader fileReader = null;
	private BufferedReader bufferedReader = null;
	private final static Logger logger = LogManager.getLogger(FileInputProcessor.class.getName());
	
	
	/*
	 * Constructor
	 * @param filePath - String containing any valid file path
	 */
	public FileInputProcessor(String filePath) {
		
		logger.debug("Running FileInputProcessor({})", filePath);
		
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
			
			System.out.println();
			logger.error("Error accessing {}: {}", filePath, e.getClass());
			
			logger.debug("Calling Utilities.handleError(file)");
			Utilities.handleError("file");
		}
		
		logger.debug("FileInputProcessor({}) completed successfully", filePath);
		
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
	 * Reads in the text from a html/txt file and stores it in messageIn
	 */
	@Override
	public void readFileIn() {
		
		logger.debug("Running readFileIn()");
		
		try {
			
			if (fileExtension.equals("html")) {
				
				logger.debug("Calling readHTMLFileIn()");
				readHTMLFileIn();
				
			}
			else {
				
				logger.debug("Calling readTextFileIn()");
				readTextFileIn();
				
			}
			
			logger.debug("Closing bufferedReader");				
			bufferedReader.close();
			
		} 
		catch (IOException e) {
			
			System.out.println();
			logger.error("File error in readFileIn(): {}", e.getClass());
			
			logger.debug("Calling Utilities.handleError(file)");
			Utilities.handleError("file");
			
		}
		
		logger.debug("readFileIn() completed successfully");
		
	}
	
	private void readHTMLFileIn() {
		
		logger.debug("Running readHTMLFileIn()");
		
		logger.debug("Building new HTMLParser()");
		HTMLParser parser = new HTMLParser();
		
		logger.debug("Calling parseHTMLFile({})", inputFile.getPath());
		messageIn = parser.parseHTMLFile(inputFile);
		
		logger.debug("readHTMLFileIn() completed successfully");
		
	}
	
	private void readTextFileIn() throws IOException {
		
		logger.debug("Running readTextFileIn()");
		
		String line = null;
		
		logger.debug("Reading text file into messageIn");
		while((line = bufferedReader.readLine()) != null) {
			messageIn += line;
			messageIn += "\n";
		}
		
		logger.debug("readTextFileIn() completed successfully");
		
	}
	

}