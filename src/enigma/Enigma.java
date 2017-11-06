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
 */

package enigma;

import utilities.Utilities;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Enigma {
	
	private Utilities utility;
	private final static Logger logger = LogManager.getLogger(Enigma.class.getName());
	
	/*
	 * Constructor - Default
	 * Builds a Utilities object to handle program execution and coordination
	 */
	public Enigma() {
		
		logger.debug("Running new Enigma()");
		
		logger.debug("Building new Utilities()");
		utility = new Utilities();
		
		logger.debug("new Enigma() completed successfully");
		
	}
	
	/*
	 * Introduce the program
	 */
	private void introduceProgram() {
		
		logger.debug("Running introduceProgram()");
		utility.load(0);
		
		logger.debug("introduceProgram() completed successfully");
	}
	
	/*
	 * Display the Main Menu which directs the flow of the program
	 */
	private void runMainMenu() {
		
		logger.debug("Running runMainMenu()");
		utility.load(2);
		
		logger.debug("runMainMenu() completed successfully");
	}
	
	/*
	 *  Main
	 *  Create an Enigma()
	 *  Put the user into the Menus screens
	 *  Allow the user to view the various Menus until they choose to exit
	 */
	public static void main(String[] args) {
		
		logger.debug("Starting program");
		
		logger.debug("Building new Enigma()");
		Enigma enigmaMachine = new Enigma();
		
		logger.debug("Calling introduceProgram()");
		enigmaMachine.introduceProgram();
		
		while (true) {
			
			logger.debug("Calling runMainMenu()");
			enigmaMachine.runMainMenu();
			
		}
	}

}