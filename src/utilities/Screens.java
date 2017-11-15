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
 *          0.0.8   11/2/17     Adjust input/output file path setting to properly utilize default paths
 *          0.0.9   11/5/17     Modify input file selection to use GUI FileSelector
 *                              Modify output file selection to use GUI FileSelector
 *          0.0.10  11/6/17     Added default constructor with logging
 *          0.0.11  11/10/17    Adjust setOutFilePath() to turn any non-html file into a .txt file
 *          0.0.12  11/14/17    Built out displayConfigScreen()
 *                              Revise formatting on various screens and adjust 
 *                              to utilize Outro methods which call exitToMainMenu() 
 *          0.0.13  11/15/17    Move methods to read in input to displayResultsScreen()
 *                              Build displayAboutScreen() and set it to run at the start of the program          
 */

package utilities;

import java.io.File;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import enigma.FileInputProcessor;
import enigma.KeyboardInputProcessor;
import enigma.OutputProcessor;
import rotors.RotorController;

class Screens {
	
	private Scanner input;
	private RotorController rc;
	private final static Logger logger = LogManager.getLogger(Screens.class.getName());
	
	
	/*
	 * Constructor - Default
	 * Builds a Scanner for reading keyboard input
	 * Builds a RotorController for managing encryption/decryption
	 */
	public Screens() {
	
		logger.debug("Running new Screens()");
		
		logger.debug("Building new Scanner(System.in)");
		input = new Scanner(System.in);
		
		logger.debug("Building new RotorController()");
		rc = new RotorController();
		
		logger.debug("new Screens() completed successfully");
		
	}
	
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
		System.out.println();
		System.out.println("You will now be shown some basic information about this program and instructions");
		System.out.println("on how to use it effectively. After that, you will be taken to the Main menu where");
		System.out.println("you can make your selections");
		System.out.println();
		System.out.println("Please press ENTER to proceed.");
		System.out.println();
		input.nextLine();
		
		logger.debug("Calling displayAboutScreen() from runWelcomeIntro()");
		displayAboutScreen();
		
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
		System.out.println("Enter 7 to view general information about the Enigma, including operating instructions");
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
		
		System.out.println();
		System.out.println("Please press ENTER to be taken to the Main menu.");
		System.out.println();
		input.nextLine();
		
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
		
		logger.debug("Calling runModeOutro()");
		runModeOutro();
		
		logger.debug("displayModeScreen() completed successfully");
		
	}
	
	/*
	 * Display the encrypt/decrypt mode select screen
	 */
	private void runModeIntro() {
		
		logger.debug("Running runModeIntro()");
		
		System.out.println();
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
	
	private void runModeOutro() {
		
		logger.debug("Running runModeOutro()");
		
		System.out.println();
		System.out.println("The program has been set to " + 
						(Config.getProgramMode() == 1 ? "Encrypt": "Decrypt") + " mode.");
		
		logger.debug("Calling exitToMainMenu() from runModeOutro()");
		exitToMainMenu();
		
		logger.debug("runModeOutro() completed successfully");
		
	}
	
	/*
	 * Display the screen where the user sets the machine's input
	 * Set the input mode based on user entry
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
			
		}
		else {
			
			System.out.println();
			System.out.println("OK, great, we will use the keyboard for input.");
			System.out.println("You will be prompted to type your input when you are ready to process and output your message.");
			
		}
		
		logger.debug("Calling runInputOutro()");
		runInputOutro();
		
		logger.debug("displayInputScreen() completed successfully");
		
	}
	
	/*
	 * Display the file/keyboard input mode select screen
	 */
	private void runInputIntro() {
		
		logger.debug("Running runInputIntro()");
		
		System.out.println();
		System.out.println("Welcome to the Input Settings menu!");
		System.out.println();
		System.out.println("You may choose to use a file on your system as the input");
		System.out.println("You may also choose to type your message in via the keyboard");
		System.out.println();
		System.out.println("Please note that the system is only designed to read in .html or .txt files");
		System.out.println("Files in other formats may yield inaccurate results");
		System.out.println();
		
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
				
				System.out.println("Enter 1 to type your message in via the keyboard.");
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
			
			logger.debug("Calling Config.setInputFilePath({})", Config.getDefaultInputFile());
			Config.setInputFilePath(Config.getDefaultInputFile());
			
			logger.debug("setInputFilePath() completed successfully with default path chosen.");
		
		}
		
	}
	
	private String getCustomInputFilePath() {
		
		logger.debug("Running getCustomInputFilePath()");
		
		logger.debug("Building new FileSelector");
		FileSelector fileSelector = new FileSelector("./resources/misc");
		
		logger.debug("Displaying Open File Dialog");
		String filePath = fileSelector.selectOpenFilePath();
		
		if (filePath.equals("")) {
			
			logger.debug("Using DEFAULT_INPUT_FILE");
			System.out.println("We will proceed with the default file path." +
					" You can access the Input settings menu again to change this.");
			filePath = Config.getDefaultInputFile();
		}
		
		logger.debug("getCustomInputFilePath() completed successfully, returning {}", filePath);
		return filePath;
		
	}
	
	private void runInputOutro() {
		
		logger.debug("Running runInputOutro()");
		
		System.out.println();
		System.out.println("The program has been set to read from " +
				(Config.getInputMode() == 1 ? "the keyboard.": Config.getInputFilePath()) );
		
		logger.debug("Calling exitToMainMenu() from runInputOutro()");
		exitToMainMenu();
		
		logger.debug("runInputOutro() completed successfully");
		
	}
	/*
	 * Display the screen where the user sets the machine's output
	 * Set the output mode based on user entry
	 * Write the output to file or console
	 */
	void displayOutputScreen() {
		
		logger.debug("Running displayOutputScreen()");
		
		logger.debug("Calling runOutputInro()");
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
		
		logger.debug("Calling runOutputOutro()");
		runOutputOutro();
		
		logger.debug("displayOutputScreen() completed successfully");
		
	}
	
	/*
	 * Display the file/screen output mode select screen
	 */
	private void runOutputIntro() {
		
		logger.debug("Running runOutputIntro()");
		
		System.out.println();
		System.out.println("Welcome to the Output Settings menu!");
		System.out.println();
		System.out.println("You may choose to write your message to a file on your system");
		System.out.println("You may also choose to display your message to the screen");
		System.out.println();
		System.out.println("Please note that the system is only designed to write to .html or .txt files");
		System.out.println("Files in other formats will be converted to .txt for accurate processing");
		System.out.println();
		
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
			String filePath = getCustomOutputFilePath();
			
			if (!Utilities.getExtension(new File(filePath)).equals("html")) {
				
				logger.debug("Calling Utilities.formatFilePath({},txt)", filePath);
				filePath = Utilities.formatFilePath(filePath, "txt");
				
			}
			
			logger.debug("Calling Config.setOutputFilePath({})", filePath);
			Config.setOutputFilePath(filePath);
			
			logger.debug("setOutFilePath() completed successfully with outputFilePath set to {}", filePath);
			
		} else {
			
			logger.debug("Calling Config.setOutputFilePath({})", Config.getDefaultOutputFile());
			Config.setOutputFilePath(Config.getDefaultOutputFile());
			
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
		
		logger.debug("Running getCustomOutputFilePath()");
		
		logger.debug("Building new FileSelector");
		FileSelector fileSelector = new FileSelector("./resources/misc");
		
		logger.debug("Displaying Save File Dialog");
		String filePath = fileSelector.selectSaveFilePath();
		
		if (filePath.equals("")) {
			
			logger.debug("Using DEFAULT_OUTPUT_FILE");
			System.out.println("We will proceed with the default file path." +
					" You can access the Output settings menu again to change this.");
			filePath = Config.getDefaultOutputFile();
		}
		
		logger.debug("getCustomOutputFilePath() completed successfully, returning {}", filePath);
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
	
	private void runOutputOutro() {
		
		logger.debug("Running runOutputOutro()");
		
		System.out.println();
		System.out.println("The program has been set to output results to " +
				(Config.getOutputMode() == 1 ? "the screen.": Config.getOutputFilePath()) );
		
		logger.debug("Calling exitToMainMenu() from runOutputOutro()");
		exitToMainMenu();
		
		logger.debug("runOutputOutro() completed successfully");
		
	}
	
	/*
	 * Display the results of the encryption/decryption
	 */
	void displayResultsScreen() {
		
		logger.debug("Running displayResultsScreen()");
		
		logger.debug("Calling setInputText()");
		String inputText = setInputText();
		
		logger.debug("Calling setOutputText()");
		setOutputText(inputText);
		
		System.out.println();
		System.out.println("Your results are now being processed...");
		System.out.println();
				
		if (Config.getOutputMode() == 1) {
		
			logger.debug("Displaying message to screen");
			
			logger.debug("Calling writeConsoleOut()");
			writeConsoleOut();
			
		} else {
			
			logger.debug("Writing message to file");
			
			logger.debug("Calling writeFileOut()");
			writeFileOut();
			
			logger.debug("Notifying user of success writing message to file");
			System.out.println("Your " + (Config.getProgramMode() == 1 ? "encrypted": "decrypted") + 
					" message has been successfully written to " + Config.getOutputFilePath());
			
		}
			
		
		logger.debug("Calling exitToMainMenu() from displayResultsScreen()");
		exitToMainMenu();
		
		logger.debug("displayResultsScreen() completed successfully");
		
	}
	
	private String setInputText() {
		
		logger.debug("Running setInputText()");
		
		if (Config.getInputMode() == 1) {
			
			logger.debug("Calling getKeyboardInput()");
			getKeyboardInput();
			
		} else {
			
			logger.debug("Calling readFileIn()");
			readFileIn();
		}
		
		logger.debug("setInputText() completed successfully");
		return Config.getPlainText();
		
	}
	
	/*
	 * Read the contents of the user-specified file into the plainText Config variable
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
	 * Allow user to enter their message directly through the keyboard
	 */
	private void getKeyboardInput() {
		
		logger.debug("Running getKeyboardInput()");
		
		logger.debug("Calling Config.setKeyboardIn()");
		Config.setKeyboardIn(new KeyboardInputProcessor());
		
		logger.debug("Getting message from user");
		System.out.println("You have chosen to enter your message via the keyboard. Please type your message now.");
		System.out.println("Please note that hitting ENTER will end your input session.");
		
		logger.debug("Calling Config.getKeyboardIn().readKeyBoardIn()");
		Config.getKeyboardIn().readKeyBoardIn();
		
		logger.debug("Calling Config.setPlainText()");
		Config.setPlainText(Config.getKeyboardIn().getMessageIn());
		
		logger.debug("getKeyboardInput() completed successfully");
		
	}
	
	private void setOutputText(String inputText) {
		
		logger.debug("Running setOutputText()");
		
		String outputText;
		
		if (Config.getProgramMode() == 1) {
			
			logger.debug("calling RotorController.encode()");
			outputText = rc.encode(inputText);
			
		} else {
			
			logger.debug("calling RotorController.decode()");
			outputText = rc.decode(inputText);
			
		}
		
		logger.debug("Calling Config.setCypherText()");
		Config.setCypherText(outputText);
		
		logger.debug("setOutputText() completed successfully");
		
	}
	
	/*
	 * Display the list of valid input characters
	 */
	void displayValidCharScreen() {
		
		logger.debug("Running displayValidCharScreen()");
		
		logger.debug("Displaying valid characters to user");
		System.out.println();
		System.out.println("Here is a list of the valid characters for your input:");
		System.out.println(rc.getActiveRotors()[0].getValidCharacters());
		System.out.println();
		System.out.println("If you enter any invalid characters, they will be encoded as a hash mark '#'");
		
		logger.debug("Calling exitToMainMenu() from displayValidCharScreen()");
		exitToMainMenu();
		
		logger.debug("displayValidCharScreen() completed successfully");
		
	}
	
	/*
	 * Display the screen where users can get general info about the program
	 */
	void displayAboutScreen() {
		
		logger.debug("Running displayAboutScreen()");
		
		System.out.println();
		System.out.println("Welcome to the General Info / Instruction menu!");
		System.out.println();
		System.out.println("This program was designed to mimic the Enigma encryption machine made famous by");
		System.out.println("the Nazi command structure during the second World War. In this machine, a series");
		System.out.println("of moving rotors are used to scramble a message into an encrypted message and then");
		System.out.println("another machine uses those same rotors to decrypt the message at another time and place.");
		System.out.println();
		System.out.println("While some of the features of the German Enigma have been set aside, the main components");
		System.out.println("have been replicated here. As such, there are three primary settings which need to be");
		System.out.println("established in order for the machine to function as intended:");
		System.out.println();
		System.out.println("1) The user must decide to either encrypt or decrypt a given message. This is done by ");
		System.out.println("   choosing screen #1 from the Main menu.");
		System.out.println("2) The user must specify where the message will originate. Much like the original, there");
		System.out.println("   is an option to type the message in via the keyboard. Keyboard entry only allows a single");
		System.out.println("   line of text to be entered at a time. For multi-line messages, the machine is configured");
		System.out.println("   to read messages from either .txt or .html files. This is all done by choosing screen #2");
		System.out.println("   from the Main menu.");
		System.out.println("3) The user must specify where the final message will be displayed. Much like the original,");
		System.out.println("   the message may be displayed immediately from within the machine itself. If you prefer,");
		System.out.println("   you may choose to have the message written out to a .txt or .html file. This is all done ");
		System.out.println("   by choosing screen #3 from the Main menu.");
		System.out.println();
		System.out.println("Once these settings have been configured, you may proceed to process your message and output");
		System.out.println("your results. The program will read from your specified input source and write to your specified");
		System.out.println("output source. This process is initiated by selecting screen #4 from the Main menu.");
		System.out.println();
		System.out.println("It is important to keep in mind that there are a limited set of characters which this program");
		System.out.println("can encrypt or decrypt properly. The original, unencrypted message must only contain characters");
		System.out.println("from this set in order to produce a proper output after encrypting and finally decrypting the");
		System.out.println("original message. To view a list of valid characters for your original message, select screen #5");
		System.out.println("from the Main menu.");
		System.out.println();
		System.out.println("If, at any time, you need to verify the settings of this program, simply select screen #6 from ");
		System.out.println("the Main menu and you will be shown the three key settings described above. You will almost ");
		System.out.println("certainly want to verify these before processing and outputting your final message.");
		System.out.println();
		System.out.println("If you are feeling lost at any point, simply select screen #7 from the Main menu to view these");
		System.out.println("instructions again. Thank you for using the Enigma!");
		
		
		logger.debug("Calling exitToMainMenu() from displayAboutScreen()");
		exitToMainMenu();
		
		logger.debug("displayAboutScreen() completed successfully");
		
	}
	
	/*
	 * Display the screen where the user can view configuration info - no mods
	 */
	void displayConfigScreen() {
		
		logger.debug("Running displayConfigScreen()");
		
		runConfigIntro();
		displayProgramModeSettings();
		displayInputSettings();
		displayOutputSettings();
		runConfigOutro();
		
		logger.debug("displayConfigScreen() completed successfully");
		
	}
	
	private void runConfigIntro() {
		
		logger.debug("Running runConfigIntro()");
		
		System.out.println();
		System.out.println("Welcome to the Configuration Menu!");
		System.out.println("From here you will be able to view the current status " + 
							"of the most important settings in the Enigma");
		System.out.println();
		
		logger.debug("runConfigIntro() completed successfully");
		
	}
	
	private void displayProgramModeSettings() {
		
		logger.debug("Running displayProgramModeSettings()");
		
		System.out.println("The program is currently set to " + 
							(Config.getProgramMode() == 1 ? "Encrypt": "Decrypt") + " mode.");
		
		logger.debug("displayProgramModeSettings() completed successfully");
		
	}
	
	private void displayInputSettings() {
		
		logger.debug("Running displayInputSettings()");
		
		System.out.println("The program is currently set to read from " +
							(Config.getInputMode() == 1 ? "the keyboard.": 
								"the following file: " + Config.getInputFilePath()) );
		
		logger.debug("displayInputSettings() completed successfully");
		
	}
	
	private void displayOutputSettings() {
		
		logger.debug("Running displayOutputSettings()");
		
		System.out.println("The program is currently set to output results to " +
				(Config.getOutputMode() == 1 ? "the screen.": 
					"the following file: " + Config.getOutputFilePath()) );
		
		logger.debug("displayOutputSettings() completed successfully");
		
	}
	
	private void runConfigOutro() {
		
		logger.debug("Running runConfigOutro()");
		
		System.out.println();
		System.out.println("If you wish to change any of these settings, you may do so from the Main Menu.");

		logger.debug("Calling exitToMainMenu() from runConfigOutro()");
		exitToMainMenu();
		
		logger.debug("runConfigOutro() completed successfully");
		
	}
	
	/*
	 * Display the final screen before the program exits
	 */
	void displayExitScreen() {
		
		logger.debug("Running displayExitScreen()");
		
		System.out.println();
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
