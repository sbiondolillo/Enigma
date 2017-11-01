/*
 * Screens Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To create a package-private class for managing the user interface screens/prompt/menus
 * Version  0.0.1   9/29/17
 * 			0.0.2	10/2/17		Add nested Errors class and displayErrorScreen() method
 *          0.0.3   10/24/17    Moved most of the functionality from Enigma class to this class
 *                              Built out most methods, built stubs for the incomplete methods
 *          0.0.4   10/25/17    Add log4j2 Logger into class
 *                              Add debugging statements for Logger
 *          0.0.5   10/26/17    Converted Errors class to static
 *          0.0.6   10/31/17    Add methods for setting and processing Output
 *          0.0.7   11/1/17     Split encryption/decryption output into separate processes
 */

package utilities;

import java.io.File;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import enigma.Dictionary;
import enigma.FileInputProcessor;
import enigma.KeyboardInputProcessor;
import enigma.OutputProcessor;
import rotors.Rotor;
import rotors.RotorController;

class Screens {
	
	private Scanner input = new Scanner(System.in);
	private RotorController rc = new RotorController();
	private final static Logger logger = LogManager.getLogger(Screens.class.getName());
	
	/*
	 * Display the initial prompt to the user when the program launches
	 * Forward the user to the help menu to make an initial selection
	 */
	void displayWelcomeScreen() {
		
		logger.debug("Running displayWelcomeScreen()");
		
		logger.debug("Calling runWelcomeIntro()");
		runWelcomeIntro();
		
		logger.debug("displayWelcomeScreen() completed successfully");
		
	}
	
	/*
	 * Display the program introduction screen
	 */
	private void runWelcomeIntro() {
		
		logger.debug("Running runWelcomeIntro()");
		
		System.out.println("Welcome to the Enigma!");
		System.out.println("This program will allow you to encrypt a message to be shared with other users.");
		System.out.println("This program will also allow you to decrypt a message received from other users.");
		System.out.println();
		
		logger.debug("runWelcomeIntro() completed successfully");
		
	}
	
	/*
	 * Display the screen where the user can view their options
	 * Get a program selection from the user
	 * Display the selected screen
	 */
	void displayMainMenuScreen() {
		
		logger.debug("Running displayMainMenuScreen()");
		
		logger.debug("Calling showProgramOptions()");
		showProgramOptions();
		
		logger.debug("Calling getProgramSelection()");
		int selection = getProgramSelection();
		
		logger.debug("Calling displaySelectedScreen({})", selection);
		displaySelectedScreen(selection);
		
		logger.debug("displayMainMenuScreen() completed successfully");
		
	}
	
	/*
	 * Display the list of program options
	 */
	private void showProgramOptions() {
		
		logger.debug("Running showProgramOptions()");
		
		System.out.println("Welcome to the Main menu!");
		System.out.println("Enter 1 to select encrypt or decrypt mode");
		System.out.println("Enter 2 to configure your input settings");
		System.out.println("Enter 3 to configure your output settings");
		System.out.println("Enter 4 to process and output your message");
		System.out.println("Enter 5 to view a list of valid input characters");
		System.out.println("Enter 6 to view a list of all current settings");
		System.out.println("Enter 7 to view general information about the Enigma");
		System.out.println("Enter 8 to quit the program");
		
		logger.debug("showProgramOptions() completed successfully");
		
	}
	
	/*
	 * Get the user's selection from the Main Menu screen
	 */
	private int getProgramSelection() {
		
		logger.debug("Running getProgramSelection()");
		
		int selection = 0;
		while (selection < 1 || selection > 8) {
			try {
				
				System.out.print("Please enter your selection: ");
				selection = input.nextInt();
				input.nextLine();
				
			}
			catch (InputMismatchException e) {
				
				logger.error("Input error in getProgramSelection(): {}", e.getClass());
				
				logger.debug("Calling displayErrorScreen(input)");
				displayErrorScreen("input");
				
				input.nextLine();
				
			}
		}
		
		logger.debug("getProgramSelection() completed successfully with screen #{} selected", selection);
		
		return selection;
		
	}
	
	/*
	 * Display the screen chosen by the user in the Main Menu screen
	 * @param selection - an int returned from getProgramSelection()
	 */
	private void displaySelectedScreen(int selection) {
		
		logger.debug("Running displaySelectedScreen({})", selection);
		
		switch (selection) {
		
			case 1: logger.debug("Calling displayModeScreen()");
					displayModeScreen();
					break;
					
			case 2: logger.debug("Calling displayInputScreen()");
					displayInputScreen();
					break;
					
			case 3: logger.debug("Calling displayOutputScreen()");
					displayOutputScreen();
					break;
					
			case 4: logger.debug("Calling displayResultsScreen()");
					displayResultsScreen();
					break;
					
			case 5: logger.debug("Calling displayValidCharScreen()");
					displayValidCharScreen();
					break;
					
			case 6: logger.debug("Calling displayConfigScreen()");
					displayConfigScreen();
					break;
					
			case 7: logger.debug("Calling displayAboutScreen()");
					displayAboutScreen();
					break;
					
			case 8: logger.debug("Calling displayExitScreen()");
					displayExitScreen();
					break;
					
			default: logger.debug("Running displaySelectedScreen() default case");
					 System.out.println("Oops, something went wrong.");
					 
					 logger.debug("Calling exitToMainMenu() from displaySelectedScreen({})", selection);
					 exitToMainMenu();
		}
		
		logger.debug("displaySelectedScreen({}) completed successfully", selection);
		
	}
	
	/*
	 * Take the user back to the Main Menu
	 */
	private void exitToMainMenu() {
		
		logger.debug("Running exitToMainMenu()");
		
		System.out.println("OK, we're all set. You will now be directed back to the Main Menu.");
		System.out.println();
		
		logger.debug("exitToMainMenu() completed successfully");
		
	}
	
	/*
	 * Display the screen to allow users to set the machine to encrypt/decrypt mode
	 * Get mode selection from user
	 */
	void displayModeScreen() {
		
		logger.debug("Running displayModeScreen()");
		
		logger.debug("Calling runModeIntro()");
		runModeIntro();
		
		logger.debug("Calling selectProgramMode()");
		selectProgramMode();
		
		logger.debug("Calling exitToMainMenu() from displayModeScreen()");
		exitToMainMenu();
		
		logger.debug("displayModeScreen() completed successfully");
		
	}
	
	/*
	 * Display the encrypt/decrypt mode select screen
	 */
	private void runModeIntro() {
		
		logger.debug("Running runModeIntro()");
		
		System.out.println("Welcome to the Mode Select menu!");
		System.out.println();
		System.out.println("From here, you can decide if you want to encrypt a new message to be shared");
		System.out.println("or decrypt a message you received from another user.");
		
		logger.debug("runModeIntro() completed successfully");
		
	}
	
	/*
	 * Set up the Enigma to either encrypt (1) or decrypt (2)
	 */
	private void selectProgramMode() {
		
		logger.debug("Running selectProgramMode()");
		
		int mode = 0;
		while (mode != 1 && mode != 2) {
			try {
				
				System.out.print("Please enter 1 to encrypt a new message or 2 to decrypt an existing message: ");
				mode = input.nextInt();
				input.nextLine();
				
			}
			catch (InputMismatchException e) {
				
				logger.error("Input error in selectProgramMode(): {}", e.getClass());
				
				logger.debug("Calling displayErrorScreen(input)");
				displayErrorScreen("input");
				
				input.nextLine();
				
			}
		}
		
		logger.debug("Calling Config.setProgramMode({})", mode);
		Config.setProgramMode(mode);
		
		logger.debug("selectProgramMode() completed successfully");
		
	}
	
	/*
	 * Display the screen where the user sets the machine's input
	 * Set the input mode based on user entry
	 * Read in the input behind the scenes
	 */
	void displayInputScreen() {
		
		logger.debug("Running displayInputScreen()");
		
		logger.debug("Calling runInputInro()");
		runInputIntro();
		
		logger.debug("Calling selectInputMode()");
		selectInputMode();
		
		if (Config.getInputMode() == 2) {
			
			logger.debug("Calling setInFilePath()");
			setInFilePath();
			
			logger.debug("Calling readFileIn()");
			readFileIn();
			
		}
		else {
			
			logger.debug("Calling getKeyboardInput()");
			getKeyboardInput();
			
		}
		
		logger.debug("Calling exitToMainMenu() from displayInputScreen()");
		exitToMainMenu();
		
		logger.debug("displayInputScreen() completed successfully");
		
	}
	
	/*
	 * Display the file/keyboard input mode select screen
	 */
	private void runInputIntro() {
		
		logger.debug("Running runInputIntro()");
		
		System.out.println("Welcome to the Input Settings menu!");
		System.out.println();
		System.out.println("You may choose to use a file on your system as the input");
		System.out.println("or you may choose to simply type your message into the keyboard.");
		
		logger.debug("runInputIntro() completed successfully");
		
	}
	
	/*
	 * Set the input mode to file/keyboard based on user input
	 */
	private void selectInputMode() {
		
		logger.debug("Running selectInputMode()");
		
		int mode = 0;
		while (mode < 1 || mode > 2) {
			try {
				
				System.out.println("Enter 1 to enter your message via the keyboard.");
				System.out.println("Enter 2 to have the program read your message from a file on your system.");
				mode = input.nextInt();
				input.nextLine();
				
			}
			catch (InputMismatchException e) {
				
				logger.error("Input error in selectInputMode(): {}", e.getClass());
				
				logger.debug("Calling displayErrorScreen(input)");
				displayErrorScreen("input");
				
				input.nextLine();
				
			}
		}
		
		logger.debug("Calling Config.setInputMode({})", mode);
		Config.setInputMode(mode);
		
		logger.debug("selectInputMode() completed successfully");
		
	}
	
	/*
	 * Allow the user to enter their own file path for input
	 */
	private void setInFilePath() {
		
		logger.debug("Running setInFilePath()");
		
		logger.debug("Calling getFilePathSelection()");
		int useDefaultFilePath = getFilePathSelection();
		
		if (useDefaultFilePath == 2) {
			
			logger.debug("Calling getCustomFilePath()");
			String filePath = getCustomInputFilePath();
			
			logger.debug("Calling Config.setInputFilePath({})", filePath);
			Config.setInputFilePath(filePath);
			
			logger.debug("setInputFilePath() completed successfully with inputFilePath set to {}", filePath);
			
		} else {
			
			logger.debug("setInputFilePath() completed successfully with default path chosen.");
		
		}
		
	}
	
	private String getCustomInputFilePath() {
		
		logger.debug("Running getCustomInputFilePath()");
		
		logger.debug("Displaying available drives");
		System.out.println("OK, Please choose the drive where the file exists. The following drives are available:");
		File[] paths = File.listRoots();
		for (File path:paths) {
			System.out.println(path);
		}
		
		logger.debug("Getting Drive selection from user");
		System.out.print("Please enter your drive selection: ");
		String drive = input.nextLine();
		logger.debug("User selected drive {}", drive);
		
		logger.debug("Getting path selection from user");
		System.out.println("OK, now please enter the location of the file on " + drive);
		String path = input.nextLine();
		String filePath = drive + path;
		
		logger.debug("getCustomInputFilePath() completed successfully, returning {}", filePath);
		return filePath;
		
	}
	
	/*
	 * Read the contents of the specified file into the plainText Config variable
	 */
	private void readFileIn() {
		
		logger.debug("Running readFileIn()");
		
		logger.debug("Calling Config.setFileIn()");
		Config.setFileIn(new FileInputProcessor(Config.getInputFilePath()));
		
		logger.debug("Calling Config.getFileIn().readFileIn()");
		Config.getFileIn().readFileIn();
		
		logger.debug("Calling Config.setPlainText()");
		Config.setPlainText(Config.getFileIn().getMessageIn());
		
		logger.debug("readFileIn() completed successfully");
		
	}
	
	/*
	 * Allow user to enter their plaintext directly through the keyboard
	 */
	private void getKeyboardInput() {
		
		logger.debug("Running getKeyboardInput()");
		
		logger.debug("Calling Config.setKeyboardIn()");
		Config.setKeyboardIn(new KeyboardInputProcessor());
		
		logger.debug("Getting message from user");
		System.out.println("OK, great, we'll use the keyboard for input. Please type your message: ");
		
		logger.debug("Calling Config.getKeyboardIn().readKeyBoardIn()");
		Config.getKeyboardIn().readKeyBoardIn();
		
		logger.debug("Calling Config.setPlainText()");
		Config.setPlainText(Config.getKeyboardIn().getMessageIn());
		
		logger.debug("getKeyboardInput() completed successfully");
		
	}
		
	/*
	 * Display the screen where the user sets the machine's output
	 * Set the output mode based on user entry
	 * Write the output to file or console
	 */
	void displayOutputScreen() {
		
		logger.debug("Running displayOutputScreen()");
		
		logger.debug("Calling runOututInro()");
		runOutputIntro();
		
		logger.debug("Calling selectOutputMode()");
		selectOutputMode();
		
		if (Config.getOutputMode() == 2) {
			
			logger.debug("Calling setOutFilePath()");
			setOutFilePath();
			
		}
		else {
			
			logger.debug("Notifying user of console output");
			System.out.println("OK, great, we'll display your message to the screen.");
			
		}
		
		logger.debug("Calling exitToMainMenu() from displayOutputScreen()");
		exitToMainMenu();
		
		logger.debug("displayOutputScreen() completed successfully");
		
	}
	
	/*
	 * Display the file/screen output mode select screen
	 */
	private void runOutputIntro() {
		
		logger.debug("Running runOutputIntro()");
		
		System.out.println("Welcome to the Output Settings menu!");
		System.out.println();
		System.out.println("You may choose to write your message to a file on your system");
		System.out.println("or you may choose to simply display your message to the screen.");
		
		logger.debug("runOutputIntro() completed successfully");
		
	}
	
	/*
	 * Set the output mode to file/screen based on user input
	 */
	private void selectOutputMode() {
		
		logger.debug("Running selectOutputMode()");
		
		int mode = 0;
		while (mode < 1 || mode > 2) {
			try {
				
				System.out.println("Enter 1 to display your message to the screen.");
				System.out.println("Enter 2 to have the program write your message to a file on your system.");
				mode = input.nextInt();
				input.nextLine();
				
			}
			catch (InputMismatchException e) {
				
				logger.error("Input error in selectOutputMode(): {}", e.getClass());
				
				logger.debug("Calling displayErrorScreen(output)");
				displayErrorScreen("output");
				
				input.nextLine();
				
			}
		}
		
		logger.debug("Calling Config.setOutputMode({})", mode);
		Config.setOutputMode(mode);
		
		logger.debug("selectOutputMode() completed successfully");
		
	}
	
	/*
	 * Allow the user to enter their own file path for output
	 */
	private void setOutFilePath() {
		
		logger.debug("Running setOutFilePath()");
		
		logger.debug("Calling getFilePathSelection()");
		int useDefaultFilePath = getFilePathSelection();
				
		if (useDefaultFilePath == 2) {
			
			logger.debug("Calling getCustomFilePath()");
			String filePath = getCustomOutputFilePath() + "supersecretmessage.html";
			
			logger.debug("Calling Config.setOutputFilePath({})", filePath);
			Config.setOutputFilePath(filePath);
			
			logger.debug("setOutFilePath() completed successfully with outputFilePath set to {}", filePath);
			
		} else {
			
			logger.debug("setOutFilePath() completed successfully with default path chosen.");
		
		}
	}
	
	/*
	 * Allow user to choose whether or not to use the default file path
	 */
	private int getFilePathSelection() {
		
		logger.debug("Running getFilePathSelection()");
		
		logger.debug("Letting user choose default or custom file path");
		System.out.println("OK, you can choose your own file or proceed with the default file.");
		
		int mode = 0;
		while (mode < 1 || mode > 2) {
			try {
				
				System.out.println("Enter 1 to proceed with the default file path.");
				System.out.println("Enter 2 to select your own file path.");
				mode = input.nextInt();
				input.nextLine();
				
			}
			catch (InputMismatchException e) {
				
				logger.error("Input error in getFilePathSelection(): {}", e.getClass());
				
				logger.debug("Calling displayErrorScreen(output)");
				displayErrorScreen("output");
				
				input.nextLine();
				
			}
		}
		logger.debug("getFilePathSelection() completed successfully");
		return mode;
		
	}
	
	/*
	 * Allow the user to specify their own custom file path for output
	 */
	private String getCustomOutputFilePath() {
		
		logger.debug("Running getCustomFilePath()");
		
		logger.debug("Displaying available drives");
		System.out.println("OK, Please choose the drive where the file should be written. The following drives are available:");
		File[] paths = File.listRoots();
		for (File path:paths) {
			System.out.println(path);
		}
		
		logger.debug("Getting Drive selection from user");
		System.out.print("Please enter your drive selection: ");
		String drive = input.nextLine();
		logger.debug("User selected drive {}", drive);
		
		logger.debug("Getting path selection from user");
		System.out.println("OK, now please enter the folder on " + drive + " where the file should be written.");
		System.out.println("Please terminate your file path in a back-slash character '\\' to ensure proper location.");
		String path = input.nextLine();
		String filePath = drive + path;
		
		logger.debug("getCustomFilePath() completed successfully, returning {}", filePath);
		return filePath;
		
	}
	
	/*
	 * Write the contents of the encoded message to the specified file
	 */
	private void writeFileOut() {
		
		logger.debug("Running writeFileOut()");
		
		logger.debug("Calling Config.setOutput()");
		Config.setOutput(new OutputProcessor());
		
		logger.debug("Calling Config.getOutput().setMessageOut(cyphertext)");
		Config.getOutput().setMessageOut(Config.getCypherText());
		
		logger.debug("Calling Config.getOutput().setOutputFilePath({})", Config.getOutputFilePath());
		Config.getOutput().setOutputFilePath(Paths.get(Config.getOutputFilePath()));
		
		if (Config.getProgramMode() == 1) {
		
			logger.debug("Calling Config.getOutput().writeEncryptedMessageOutToFile()");
			Config.getOutput().writeEncryptedMessageOutToFile();
			
		} else {
			
			logger.debug("Calling Config.getOutput().writeDecryptedMessageOutToFile()");
			Config.getOutput().writeDecryptedMessageOutToFile();
			
		}
		
		logger.debug("writeFileOut() completed successfully");
		
	}
	
	/*
	 * Write the contents of the encoded message to the console
	 */
	private void writeConsoleOut() {
		
		logger.debug("Running writeConsoleOut()");
		
		logger.debug("Calling Config.setOutput()");
		Config.setOutput(new OutputProcessor());
		
		logger.debug("Calling Config.getOutput().setMessageOut(cyphertext)");
		Config.getOutput().setMessageOut(Config.getCypherText());
		
		if (Config.getProgramMode() == 1) {
			
			logger.debug("Calling Config.getOutput().displayEncryptedMessageOutToConsole()");
			Config.getOutput().displayEncryptedMessageOutToConsole();
			
		} else {
			
			logger.debug("Calling Config.getOutput().displayDecryptedMessageOutToConsole()");
			Config.getOutput().displayDecryptedMessageOutToConsole();
			
		}
		
		logger.debug("writeConsoleOut() completed successfully");
		
	}
	
	/*
	 * Display the results of the encryption/decryption
	 */
	void displayResultsScreen() {
		
		logger.debug("Running displayResultsScreen()");
		
		String input = Config.getPlainText();
		String output;
		if (Config.getProgramMode() == 1) {
			
			logger.debug("calling RotorController.encode()");
			output = rc.encode(input);
			
			logger.debug("Calling Config.setCypherText()");
			Config.setCypherText(output);
			
			if (Config.getOutputMode() == 1) {
			
				logger.debug("Displaying encrypted message");
				writeConsoleOut();
				
			} else {
				
				logger.debug("Calling writeFileOut()");
				writeFileOut();
				
				logger.debug("Notifying user of success writing encrypted message to file");
				System.out.println("Your encrypted message has been successfully written to " + Config.getOutputFilePath());
				
			}
			
		} else {
			
			logger.debug("calling RotorController.decode()");
			output = rc.decode(input);
			
			logger.debug("Calling Config.setCypherText()");
			Config.setCypherText(output);
			
			if (Config.getOutputMode() == 1) {
			
				logger.debug("Displaying decrypted message");
				writeConsoleOut();
				
			} else {
				
				logger.debug("Calling writeFileOut()");
				writeFileOut();
				
				logger.debug("Notifying user of success writing decrypted message to file");
				System.out.println("Your decrypted message has been successfully written to " + Config.getOutputFilePath());
				
			}
			
		}
		System.out.println();
		
		logger.debug("displayResultsScreen() completed successfully");
		
	}
	
	/*
	 * Display the list of valid input characters
	 */
	void displayValidCharScreen() {
		
		logger.debug("Running displayValidCharScreen()");
		
		logger.debug("Calling buildCharSet()");
		Dictionary validCharacters = buildCharSet();
		
		logger.debug("Displaying valid characters to user");
		System.out.println("Here is a list of the valid characters for your input:");
		System.out.println(validCharacters);
		System.out.println("If you enter any invalid characters, they will be encoded as a hash mark '#'");
		System.out.println("You will now be directed back to the Main Menu.");
		System.out.println();
		
		logger.debug("displayValidCharScreen() completed successfully");
		
	}
	
	/*
	 * Get the set of valid characters based on the active Rotors
	 */
	private Dictionary buildCharSet() {
		
		logger.debug("Running buildCharSet()");
		
		logger.debug("Calling RotorController.getActiveRotors()");
		Rotor[] baseRotor = rc.getActiveRotors();
		
		logger.debug("Calling Rotor.getValidCharacters()");
		Dictionary charSet = baseRotor[0].getValidCharacters();
		
		logger.debug("buildCharSet() completed successfully");
		return charSet;
		
	}
	
	/*
	 * Display the screen where users can get general info about the program
	 */
	void displayAboutScreen() {
		// TODO implement this
		
		logger.debug("Running displayAboutScreen()");
		
		System.out.println("Oops, this is embarassing, there doesn't seem to be anything here.");
		System.out.println("You will now be directed back to the Main Menu.");
		System.out.println();
		
		logger.debug("displayAboutScreen() completed successfully");
		
	}
	
	/*
	 * Display the screen where the user can view configuration info - no mods
	 */
	void displayConfigScreen() {
		// TODO implement this
		
		logger.debug("Running displayConfigScreen()");
		
		System.out.println("Oops, this is embarassing, there doesn't seem to be anything here.");
		System.out.println("You will now be directed back to the Main Menu.");
		System.out.println();
		
		logger.debug("displayConfigScreen() completed successfully");
		
	}
	
	/*
	 * Display the final screen before the program exits
	 */
	void displayExitScreen() {
		
		logger.debug("Running displayExitScreen()");
		
		System.out.println("Thanks for using the Enigma. Have a great day!");
		System.out.println();
		
		logger.debug("displayExitScreen() completed successfully");
		
		logger.debug("Closing System.in Scanner");
		input.close();
		
		logger.debug("Calling System.exit() with status code 1 to end program execution");
		System.exit(1);
		
	}
	
	/*
	 * Display an error message appropriate to the type of error
	 */
	static void displayErrorScreen(String type) {
		
		logger.debug("Running displayErrorScreen({})", type);
		// these are place-holders, will need to be updated to match final design
		switch (type) {
		
			case "file":	logger.debug("Calling Errors.fileError()");
							Errors.fileError();
							break;
							
			case "config":	logger.debug("Calling Errors.configError()");
							Errors.configError();
							break;
							
			case "input":	logger.debug("Calling Errors.inputError()");
							Errors.inputError();
							break;
							
			case "output":	logger.debug("Calling Errors.outputError()");
							Errors.outputError();
							break;
							
			default:		logger.debug("Running displayErrorScreen() default case");
							System.out.println("Oops, something went wrong. Please contact support.");
							
		}
		
		logger.debug("displayErrorScreen({}) completed successfully", type);
		
	}
	
	static class Errors {
		// this is a temporary mock-up, will need to be updated to reflect final design
		
			
		static void fileError() {
			// TODO - build method to display File Error Screen
			logger.debug("running Errors.fileError()");
			System.out.println("Sorry, unable to access that file. You will now be directed to the Main menu");
			System.out.println();
			
			logger.debug("Errors.fileError() completed successfully");
			
		}
		
		
		static void configError() {
			// TODO - build method to display Configuration Error Screen
			logger.debug("running Errors.configError()");
			
			logger.debug("Errors.configError() completed successfully");
			
		}
		
		static void inputError() {
			// TODO - build method to display Input Error Screen
			logger.debug("running Errors.inputError()");
			System.out.println("Sorry, you have entered an invalid input.");
			System.out.println();
			
			logger.debug("Errors.inputError() completed successfully");
			
		}
		
		static void outputError() {
			// TODO - build method to display Output Error Screen
			logger.debug("running Errors.outputError()");
			
			logger.debug("Errors.outputError() completed successfully");
			
		}
		
	}
	

}
