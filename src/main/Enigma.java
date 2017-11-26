/*
 * Enigma Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To manage the control logic for all of the constituent parts of our Enigma machine
 * Version 0.0.1 - 9/18/17
 * 		   0.0.2 - 9/23/17	Add logic to user input to scale to size of Rotor dictionary
 * 							refactor user input to include correct methods from InputProcessor
 * 		   0.0.3 - 9/24/17	Adjust Enigma to utilize three rotors in series
 *         0.0.4 - 10/24/17 Add introduceProgram() method and related functionality
 *                          Add runMainMenu() method and related functionality
 *                          Move all other functionality out of this main class
 *         0.0.5 - 10/25/17 Add log4j2 logging framework into project
 *                          Add log4j2 Logger into class
 *                          Add debugging statements for Logger
 *         0.0.6 - 11/1/17  Removed unnecessary methods and interface implementation
 *         0.0.7 - 11/6/17  Added default constructor with logging
 *         0.1.0 - 11/22/17 Refactor to minimize responsibilies. Now responsible for setting up
 *                          the Config file and launching the Main Menu only
 */

package main;

import utilities.Utilities;
import org.apache.logging.log4j.Logger;

import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;

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