package main;

import utilities.Utilities;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.nio.file.Paths;

public class Enigma {
	
	private final static String DEFAULT_INPUT_FILE = Paths.get(".").toAbsolutePath().normalize().toString() + 
													"\\resources\\misc\\input.txt";
	private final static String DEFAULT_OUTPUT_FILE = Paths.get(".").toAbsolutePath().normalize().toString() + 
													"\\resources\\misc\\output.html";
	private static ScreenManager screenManager;
	private final static Logger logger = LogManager.getLogger(Enigma.class.getName());
	
	/**
	 *  Main<br />
	 *  initializeConfig(), build a ScreenManager(), showMainMenu()
	 */
	public static void main(String[] args) {
		
		logger.debug("Starting program");
		
		logger.debug("Calling initializeConfig()");
		initializeConfig();
		
		logger.debug("Building new ScreenManager()");
		screenManager = new ScreenManager();
		
		logger.debug("Calling showMainMenu()");
		screenManager.showMainMenu();
		
	}
	
    /*
     * Sets the input and output file paths in Config to the default values
     * Creates any missing files among the defaults
     */
    private static void initializeConfig() {
    	
    	logger.debug("Running initializeConfig()");
    	
    	logger.debug("Calling setProgramMode(0)");
    	Config.setProgramMode(0);
    	
    	logger.debug("Calling createFile({})", DEFAULT_INPUT_FILE);
    	Utilities.createFile(DEFAULT_INPUT_FILE);
    	
    	logger.debug("Calling setInputFilePath({})", DEFAULT_INPUT_FILE);
    	Config.setInputFilePath(DEFAULT_INPUT_FILE);
    	
    	logger.debug("Calling createFile({})", DEFAULT_OUTPUT_FILE);
    	Utilities.createFile(DEFAULT_OUTPUT_FILE);
    	
    	logger.debug("Calling setOutputFilePath({})", DEFAULT_OUTPUT_FILE);
    	Config.setOutputFilePath(DEFAULT_OUTPUT_FILE);
    	
    	logger.debug("initializeConfig() completed successfully");
    	
    }

}
