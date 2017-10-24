/*
 * Screens Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To create a package-private class for managing the user interface screens/prompt/menus
 * Version  0.0.1   9/29/17
 * 			0.0.2	10/2/17		Add nested Errors class and displayErrorScreen() method
 *          0.0.3   10/24/147   Implemented displayWelcomeScreen()
 *                              Implemented displayHelpScreen()
 *                              Implemented displayModeScreen()
 *                              Implemented displayInputScreen()
 */

package utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

class Screens {
	
	private Errors errorHandler = new Errors();
	
	/*
	 * Display the initial prompt to the user when the program launches
	 * Forward the user to the help menu to make an initial selection
	 */
	void displayWelcomeScreen() {
		runWelcomeIntro();
	}
	
	/*
	 * Display the program introduction screen
	 */
	private void runWelcomeIntro() {
		System.out.println("Welcome to the Enigma!");
		System.out.println("This program will allow you to encrypt a message to be shared with other users.");
		System.out.println("This program will also allow you to decrypt a message received from other users.");
		System.out.println();
	}
	
	/*
	 * Display the screen where the user can view their options
	 * Get a program selection from the user
	 * Display the selected screen
	 */
	void displayHelpScreen() {
		
		showProgramOptions();
		int selection = getProgramSelection();
		displaySelectedScreen(selection);
		
	}
	
	/*
	 * Display the list of program options
	 */
	private void showProgramOptions() {
		System.out.println("Welcome to the Main menu!");
		System.out.println("Here is a list of available options:");
		System.out.println("Enter 1 to select encrypt or decrypt mode");
		System.out.println("Enter 2 to configure your input settings");
		System.out.println("Enter 3 to configure your output settings");
		System.out.println("Enter 4 to process and output your message");
		System.out.println("Enter 5 to view a list of valid input characters");
		System.out.println("Enter 6 to view a lift of all current settings");
		System.out.println("Enter 7 to view general information about the Enigma");
		System.out.println("Enter 8 to quit the program");
	}
	
	/*
	 * Get the user's selection from the Help screen
	 */
	private int getProgramSelection() {
		Scanner input = new Scanner(System.in);
		int selection = 0;
		while (selection < 1 || selection > 8) {
			try {
				System.out.print("Please enter your selection: ");
				selection = input.nextInt();
				input.nextLine();
			}
			catch (InputMismatchException e) {
				displayErrorScreen("input");
				input.nextLine();
			}
		}
		return selection;
	}
	
	/*
	 * Display the screen chosen by the user in the Help screen
	 * @param selection - an int returned from getProgramSelection()
	 */
	private void displaySelectedScreen(int selection) {
		
		switch (selection) {
			case 1: displayModeScreen();
					break;
			case 2: displayInputScreen();
					break;
			case 3: displayOutputScreen();
					break;
			case 4: displayResultsScreen();
					break;
			case 5: displayValidCharScreen();
					break;
			case 6: displayConfigScreen();
					break;
			case 7: displayAboutScreen();
					break;
			case 8: displayExitScreen();
					break;
			default: System.out.println("Oops, something went wrong.");
					 displayHelpScreen();
		}
	}
	
	/*
	 * Display the screen to allow users to set the machine to encrypt/decrypt mode
	 * Get mode selection from user
	 */
	void displayModeScreen() {
		runModeIntro();
	}
	
	/*
	 * Display the encrypt/decrypt mode select screen
	 */
	private void runModeIntro() {
		System.out.println("Welcome to the Mode Select module.");
		System.out.println("From here, you can decide if you want to encrypt a new message to be shared");
		System.out.println("or decrypt a message you received from another user.");
	}
	
	
	/*
	 * Display the screen where the user sets the machine's input
	 */
	void displayInputScreen() {
		runInputIntro();
	}
	
	/*
	 * Display the file/keyboard input mode select screen
	 */
	private void runInputIntro() {
		System.out.println("Welcome to the Input Settings module.");
		System.out.println();
		System.out.println("You may choose to use a file on your system as the input");
		System.out.println("or you may choose to simply type your message into the keyboard.");
	}
	
	/*
	 * Display the screen where the user set's the machine's output
	 */
	void displayOutputScreen() {
		// TODO implement this
	}
	
	/*
	 * Display the results of the encryption/decryption
	 */
	void displayResultsScreen() {
		// TODO implement this
	}
	
	/*
	 * Display the list of valid input characters
	 */
	void displayValidCharScreen() {
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
			System.out.println("Sorry, unable to access that file. You will now be directed to the Main menu");
			System.out.println();
		}
		
		void configError() {
			// TODO - build method to display Configuration Error Screen
		}
		
		void inputError() {
			// TODO - build method to display Input Error Screen
			System.out.println("Sorry, you have entered an invalid input.");
			System.out.println();
		}
		
		void outputError() {
			// TODO - build method to display Output Error Screen
		}
		
	}
	

}
