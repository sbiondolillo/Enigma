/*
 * Screens Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To create a package-private class for managing the user interface screens/prompt/menus
 * Version  0.0.1   9/29/17
 * 			0.0.2	10/2/17		Add nested Errors class and displayErrorScreen() method
 */

package utilities;

class Screens {
	
	private Errors errorHandler = new Errors();
	
	/*
	 * Display the initial prompt to the user when the program launches
	 */
	void displayWelcomeScreen() {
		// TODO implement this
	}
	
	/*
	 * Display the screen where the user sets the machine's input
	 */
	void displayInputScreen() {
		// TODO implement this
	}
	
	/*
	 * Display the screen where the user set's the machine's output
	 */
	void displayOutputScreen() {
		// TODO implement this
	}
	
	/*
	 * Display the screen where the user can receive help
	 */
	void displayHelpScreen() {
		// TODO - implement this
	}
	
	/*
	 * Display the screen where users can get general info about the program
	 */
	void displayAboutScreen() {
		// TODO implement this
	}
	
	/*
	 * Display the screen where the user can view configuration info - no mods
	 */
	void displayConfigScreen() {
		// TODO implement this
	}
	
	/*
	 * Display the final screen before the program exits
	 */
	void displayExitScreen() {
		// TODO implement this
	}
	
	/*
	 * Display an error message appropriate to the type of error
	 */
	void displayErrorScreen(String type) {
		// these are place-holders, will need to be updated to match final design
		switch (type) {
			case "file":	errorHandler.fileError();
							break;
			case "config":	errorHandler.configError();
							break;
			case "input":	errorHandler.inputError();
							break;
			case "output":	errorHandler.outputError();
							break;
			default:		System.out.println("Oops, something went wrong. Please contact support.");
		}
	}
	
	class Errors {
		// this is a temporary mock-up, will need to be updated to reflect final design
		
		void fileError() {
			// TODO - build method to display File Error Screen
		}
		
		void configError() {
			// TODO - build method to display Configuration Error Screen
		}
		
		void inputError() {
			// TODO - build method to display Input Error Screen
		}
		
		void outputError() {
			// TODO - build method to display Output Error Screen
		}
		
	}
	

}
