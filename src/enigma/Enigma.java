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

package enigma;

import utilities.ScreenManager;
import utilities.Utilities;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Enigma {
	
	private static ScreenManager screenManager;
	private final static Logger logger = LogManager.getLogger(Enigma.class.getName());
	
	/*
	 *  Main
	 */
	public static void main(String[] args) {
		
		logger.debug("Starting program");
		
		logger.debug("Calling initializeConfig()");
		Utilities.initializeConfig();
		
		logger.debug("Building new ScreenManager()");
		screenManager = new ScreenManager();
		
		logger.debug("Calling showMainMenu()");
		screenManager.showMainMenu();
		
	}

}