/*
 * Utilities Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To create a public class for managing access to sensitive program utilities
 * Version  0.0.1   9/29/17
 * 			0.0.2	10/2/17		fill in load() method, add handleError() method
 *          0.0.2   10/24/17    adjusted load() method to prioritize most used methods
 *          0.0.3   10/25/17    Add log4j2 Logger into class
 *                              Add debugging statements for Logger
 */

package utilities;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Utilities {        
	
	private Screens screenManager = new Screens();
	private final static Logger logger = LogManager.getLogger(Utilities.class.getName());
	
	/*
	 * Makes a call to a method in a class within the utilities package
	 * @param code - an int provided by the user from an input prompt
	 */
    public void load(int code){
    	
    	logger.debug("Running Utilities.load()");
        try{
            switch (code) {
            	// TODO - add additional cases as needed
                case 0:		logger.debug("load({})", code);
                			screenManager.displayWelcomeScreen();
                			break;
                
                case 1:     logger.debug("load({})", code);
                			screenManager.displayModeScreen();
                			break;
                    
                case 2:		logger.debug("load({})", code);
                			screenManager.displayMainMenuScreen();
                			break;
                    
                case 3:		logger.debug("load({})", code);
                			screenManager.displayInputScreen();
                			break;
                          
                case 4:		logger.debug("load({})", code);
                			screenManager.displayOutputScreen();
                			break;
                    
                case 5:		logger.debug("load({})", code);
                			screenManager.displayConfigScreen();
                			break;
                              
                case 6:		logger.debug("load({})", code);
                			screenManager.displayAboutScreen();
                			break;
                          
                case 7:		logger.debug("load({})", code);
                			screenManager.displayExitScreen();
                			break;
                                    
                default:	logger.debug("load({})", code);
                			System.out.println("Sorry, that is not a valid code");
                			break;
            }
        }
        catch(Exception NA){}
    }
    
    /*
     * Display the correct error screen
     * @param type - a String of a valid pre-defined error type
     */
    public void handleError(String type) {
    	logger.error("Running handleError({})", type);
    	screenManager.displayErrorScreen(type);
    	logger.error("handleError({}) completed successfully", type);
    }
}
