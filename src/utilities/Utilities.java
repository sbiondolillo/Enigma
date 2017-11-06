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
 *          0.0.4   10/26/17    Converted handleError() to static
 *          0.0.5   11/5/17     Add method for formatting file paths to .html
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
    	
    	logger.debug("Running Utilities.load({})", code);
    	
        try{
            switch (code) {
            	
                case 0:		logger.debug("Calling displayWelcomeScreen()");
                			screenManager.displayWelcomeScreen();
                			break;
                
                case 1:     logger.debug("Calling displayModeScreen()");
                			screenManager.displayModeScreen();
                			break;
                    
                case 2:		logger.debug("Calling displayMainMenuScreen()");
                			screenManager.displayMainMenuScreen();
                			break;
                    
                case 3:		logger.debug("Calling displayInputScreen()");
                			screenManager.displayInputScreen();
                			break;
                          
                case 4:		logger.debug("Calling displayOutputScreen()");
                			screenManager.displayOutputScreen();
                			break;
                    
                case 5:		logger.debug("Calling displayConfigScreen()");
                			screenManager.displayConfigScreen();
                			break;
                              
                case 6:		logger.debug("Calling displayAboutScreen()");
                			screenManager.displayAboutScreen();
                			break;
                          
                case 7:		logger.debug("Calling displayExitScreen()");
                			screenManager.displayExitScreen();
                			break;
                                    
                default:	logger.debug("Running Utilities.load() default case");
                			System.out.println("Sorry, that is not a valid code");
                			break;
            }
        }
        catch(Exception NA){}
        
        logger.debug("Utilities.load({}) completed successfully", code);
    }
    
    /*
     * Display the correct error screen
     * @param type - a String of a valid pre-defined error type
     * See Errors class for valid types
     */
    public static void handleError(String type) {
    	
    	logger.error("Running handleError({})", type);
    	Screens.displayErrorScreen(type);
    	
    	logger.error("handleError({}) completed successfully", type);
    	
    }
    
    public static String formatHTMLFilePath(String filePath) {
    		
		logger.debug("Running formatHTMLFilePath({})", filePath);
		
		String formattedFilePath;
		
		/*
		 * Regex:
		 * Starts with - ^
		 * Any number of any type of characters - (.+)
		 * Followed by ".html" - (\\.html)
		 */
		if (!filePath.matches("^(.+)(\\.html)")) {
			
			/*
			 * Regex:
			 * Starts with - ^
			 * Any number of any type of characters - (.+)
			 * Followed by a dot character - (\\.)
			 * Followed by any number of any type of characters - (.+)
			 */
			if (filePath.matches("^(.+)(\\.)(.+)")) {
				
				logger.debug("Changing file extension to .html");
				formattedFilePath = filePath.substring(0, filePath.lastIndexOf("."));
				formattedFilePath += ".html";
				
			}
			else {
				
				logger.debug("Adding .html file extension");
				formattedFilePath = filePath + ".html";
				
			}
		}
		else {
			
			logger.debug("Current file path formatted correctly");
			formattedFilePath = filePath;
			
		}
		
		logger.debug("formatHTMLFilePath({}) completed successfully, returning {}", filePath, formattedFilePath);
		return formattedFilePath;
		
	}
}
