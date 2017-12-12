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
	
	/**
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
	 * Interface Implementations
	 */
	public String getMessageIn() {
		
		logger.debug("Running getMessageIn()");
		
		logger.debug("getMessageIn() completed successfully");
		return messageIn;
		
	}
	
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
			
			logger.error("File error in readInputFile(): {}", e.getClass());
			
		}
		
		logger.debug("readFileIn() completed successfully");
		
	}
	
	/*
	 * Read from an HTML file into messageIn
	 */
	private void readHTMLFile() {
		
		logger.debug("Running readHTMLFile()");
		
		logger.debug("Building new HTMLParser()");
		HTMLParser parser = new HTMLParser();
		
		logger.debug("Calling parseHTMLFile({})", inputFile.getPath());
		messageIn = parser.parseHTMLFile(inputFile);
		
		logger.debug("readHTMLFile() completed successfully");
		
	}
	
	/*
	 * Read from a TXT file into messageIn
	 */
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
