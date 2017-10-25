/*
 * Utilities Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To create a public class for managing access to sensitive program utilities
 * Version  0.0.1   9/29/17
 * 			0.0.2	10/2/17		fill in load() method, add handleError() method
 *          0.0.2   10/24/17    adjusted load() method to prioritize most used methods
 */

package utilities;

public class Utilities {        
	
	private Screens screenManager = new Screens();
	/*
	 * Makes a call to a method in a class within the utilities package
	 * @param code - an int provided by the user from an input prompt
	 */
    public void load(int code){
        try{
            switch (code) {
            	// TODO - add additional cases as needed
                case 0:		screenManager.displayWelcomeScreen();
                    break;
                
                case 1:     screenManager.displayModeScreen();
                    break;
                    
                case 2:		screenManager.displayMainMenuScreen();
                    break;
                    
                case 3:		screenManager.displayInputScreen();
                    break;
                          
                case 4:		screenManager.displayOutputScreen();
                    break;
                    
                case 5:		screenManager.displayConfigScreen();
                    break;
                              
                case 6:		screenManager.displayAboutScreen();
                    break;
                          
                case 7:		screenManager.displayExitScreen();
                    break;
                                    
                default:	System.out.println("Sorry, that is not a valid code");
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
    	screenManager.displayErrorScreen(type);
    }
}
