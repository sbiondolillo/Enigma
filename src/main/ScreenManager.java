/*
 * ScreenManager Class
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
 *                              Modify text formatting for more pleasing user experience
 *                              Update documentation
 *          0.0.14  11/20/17    Refine Input/File error handling
 *          0.1.0   11/22/17    Renamed Screens to ScreenManager to reflect new responsibility to act as 
 *                              a go-between for program GUI and back-end functionality
 */

package main;

import java.awt.Component;
import java.io.IOException;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import encryption.RotorController;
import fileIO.InputProcessor;
import fileIO.OutputProcessor;
import forms.FileSelector;
import forms.MainMenu;
import utilities.Utilities;

public class ScreenManager {
	
	private static RotorController rc;
	private static OutputProcessor outputProcessor;
	private static InputProcessor inputProcessor;
	private MainMenu mainMenu = new MainMenu();
	private final static Logger logger = LogManager.getLogger(ScreenManager.class.getName());
	
	
	/*
	 * Constructor - Default
	 * Builds a Scanner for reading keyboard input
	 * Builds a RotorController for managing encryption/decryption
	 */
	public ScreenManager() {
	
		logger.debug("Running new ScreenManager()");
		
		logger.debug("Building new RotorController()");
		rc = new RotorController();
		
		logger.debug("Building new OutputProcessor()");
		outputProcessor = new OutputProcessor();
		
		logger.debug("Building new InputProcessor()");
		inputProcessor = new InputProcessor(Config.getInputFilePath());
		
		logger.debug("new ScreenManager() completed successfully");
		
	}
	
	/*
	 * Launch the program's Main Menu JFrame
	 */
	public void showMainMenu() {
		
		logger.debug("Running showMainMenu()");
		
		logger.debug("Calling MainMenu.show()");
		mainMenu.show();
		
		logger.debug("showMainMenu() completed successfully");
		
	}
	
	/*
	 * Launch the Select Program Mode... dialog
	 */
	public static void showProgramModeSelectForm(Component parent) {
		
		logger.debug("Running showProgramModeSelect()");
		
		Object[] options = {"Encrypt", "Decrypt"};
		int result = JOptionPane.showOptionDialog(parent,
			    "Please select a mode for the Enigma",
			    "Program Mode",
			    JOptionPane.YES_NO_OPTION,
			    JOptionPane.PLAIN_MESSAGE,
			    null,
			    options,
			    options[0]);
		if (result == 0 || result == 1)
			updateProgramMode(result);
		
		logger.debug("showProgramModeSelect() completed successfully");
		
	}
	
	/*
	 * Configure the Enigma to either encrypt or decrypt
	 * based on user input in the Select Program Mode... dialog
	 */
	private static void updateProgramMode(int selection) {
		
		logger.debug("Running updateProgramMode()");
		
		logger.debug("Calling Config.setProgramMode({})", selection);
		Config.setProgramMode(selection);
		
		logger.debug("updateProgramMode() completed successfully");
		
	}
	
	/*
	 * Let the user set their own file path with a GUI dialog
	 */
	public static void selectInputFile(Component parent) {
		
		logger.debug("Running selectInputFile()");
		
		logger.debug("Building new FileSelector");
		FileSelector fileSelector = new FileSelector("./resources/misc");
		
		logger.debug("Displaying Open File Dialog");
		String filePath = fileSelector.selectOpenFilePath(parent);
		
		if (filePath.equals("")) {
			
			logger.debug("Using DEFAULT_INPUT_FILE");
			// TODO - create alert dialog to let user know the default will be used
			filePath = Config.getInputFilePath();
		}
		
		logger.debug("calling Config.setInputFilePath({})", filePath);
		Config.setInputFilePath(filePath);
		
		logger.debug("Building new InputProcessor()");
		inputProcessor = new InputProcessor(filePath);
		
		logger.debug("selectInputFile() completed successfully");
	}
	
	/*
	 * Allow the user to specify their own custom file path for output
	 */
	public static void selectOutputFile(Component parent) {
		
		logger.debug("Running selectOutputFile()");
		
		logger.debug("Building new FileSelector");
		FileSelector fileSelector = new FileSelector("./resources/misc");
		
		logger.debug("Displaying Save File Dialog");
		String filePath = fileSelector.selectSaveFilePath(parent);
		
		if (filePath.equals("")) {
			
			logger.debug("Using DEFAULT_OUTPUT_FILE");
			// TODO - create alert dialog to let user know the default will be used
			filePath = Config.getOutputFilePath();
		}
		else {
			
			logger.debug("Checking user-supplied file path");
			if (!Utilities.getExtension(filePath).equalsIgnoreCase("html")) {
				
				logger.debug("Reformatting file to .txt");
				filePath = Utilities.formatFilePath(filePath, "txt");
				
			}
			
		}
		
		Config.setOutputFilePath(filePath);
		logger.debug("selectOutputFile() completed successfully");
		
	}
	
	/*
	 * Runs the encryption/decryption process and writes out to file
	 */
	public static boolean processResults() {
		
		logger.debug("Running processResults()");
		
		logger.debug("Calling setInputText()");
		String inputText = setInputText();
		
		logger.debug("Calling setOutputText()");
		setOutputText(inputText);
		
		try {
			
			logger.debug("Calling writeFileOut()");
			writeFileOut();
			
		} catch (IOException e) {
			
			logger.error("File error in writeFileOut(): " + e.getClass());
			
			logger.debug("Message not written to file");
			logger.debug("processResults() completed, returning false");
			return false;
			
		}
		
		logger.debug("Message successfully written to file");
		logger.debug("processResults() completed, returning true");
		return true;
		
	}
	
	/*
	 * Either gets keyboard input from the user or reads from file
	 * @returns the String stored in Config.plainText
	 */
	private static String setInputText() {
		
		logger.debug("Running setInputText()");
		
		logger.debug("Calling readFileIn()");
		readFileIn();
		
		logger.debug("Calling Config.setPlainText()");
		Config.setPlainText(inputProcessor.getMessageIn());
		
		logger.debug("setInputText() completed successfully");
		return Config.getPlainText();
		
	}
	
	/*
	 * Read the contents of the user-specified file
	 */
	private static void readFileIn() {
		
		logger.debug("Running readFileIn()");
		
		logger.debug("Calling Config.getFileIn().readFileIn()");
		inputProcessor.readInputFile();
		
		logger.debug("readFileIn() completed successfully");
		
	}
	
	/*
	 * Either encrypts or decrypts the user-supplied message base on the programMode
	 */
	private static void setOutputText(String inputText) {
		
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
	 * Write the contents of the encoded message to the specified file
	 */
	private static void writeFileOut() throws IOException {
		
		logger.debug("Running writeFileOut()");
		
		logger.debug("Calling setMessageOut(cyphertext)");
		outputProcessor.setMessageOut(Config.getCypherText());
		
		logger.debug("Calling setOutputFilePath({})", Config.getOutputFilePath());
		outputProcessor.setOutputFilePath(Config.getOutputFilePath());
		
		logger.debug("Calling writeMessageOutToFile()");
		outputProcessor.writeMessageOutToFile();
		
		logger.debug("writeFileOut() completed successfully");
		
	}
	
	/*
	 * Display the list of valid input characters
	 */
	public static String getValidChars() {
		
		logger.debug("Running getValidChars()");
		
		StringBuilder output = new StringBuilder();
		
		output.append("Here is a list of the valid characters for your input:\n\n");
		output.append(rc.getActiveRotors()[0].getValidCharacters());
		output.append("\n\nIf you enter any invalid characters, they will be encoded as a hash mark '#'\n\n");
		
		logger.debug("getValidChars() completed successfully");
		return output.toString();
		
	}
	
	/*
	 * Display the screen where users can get general info about the program
	 * and instructions on how to use its various parts
	 */
	public static String getHelpText() {
		
		logger.debug("Running getHelpText()");
		
		StringBuilder output = new StringBuilder();
		
		output.append("This program was designed to mimic the Enigma encryption machine made famous by\n");
		output.append("the Nazi command structure during the Second World War. In that machine, a series\n");
		output.append("of moving rotors were used to scramble a message into an encrypted message and then\n");
		output.append("another machine used those same rotors to decrypt the message at another time and place.\n\n");
		output.append("While some of the features of the German Enigma have been set aside, some of the main\n");
		output.append("components have been replicated here. As such, there are three primary settings which\n");
		output.append("need to be established in order for the machine to function as intended:\n\n");
		output.append("1. You must decide to either encrypt or decrypt a given message. From the Settings menu,\n");
		output.append("choose 'Select Program Mode...'\n");
		output.append("2. You must specify where the message will originate. The program is configured to read\n");
		output.append("messages from either .txt or .html files. From the Settings menu, choose 'Select Input File...'\n");
		output.append("3. You must specify where the final message will be displayed. You may choose to have the \n");
		output.append("message written out to a .txt or .html file. From the Settings menu, choose 'Select Output File...'\n\n");
		output.append("Once these settings have been configured, you may proceed to process your message and output\n");
		output.append("your results. The program will read from your specified input source and write to your specified\n");
		output.append("output source. Simply press 'Run!' on the Main menu to start this process.\n\n");
		output.append("It is important to keep in mind that there are a limited set of characters which this program\n");
		output.append("can encrypt or decrypt properly. The original, unencrypted message must only contain characters\n");
		output.append("from this set in order to produce a proper output after encrypting and finally decrypting the\n");
		output.append("original message. From the Settings menu, select 'Valid Characters...' to review this set.\n\n");
		
		logger.debug("getHelpText() completed successfully");
		return output.toString();
		
	}
	
	public static String getAboutText() {
		
		logger.debug("Running getAboutText()");
		
		StringBuilder output = new StringBuilder();
		
		output.append("This program was developed by Samuel Biondolillo for the Object Oriented Programming\n");
		output.append("course at Manchester Community College in the Fall of 2017.\n\n");
		output.append("The source code for this project lives at: https://github.com/sbiondolillo/Enigma\n\n");
		output.append("Feel free to build your own version, complete with your own Rotor keys. Please note\n");
		output.append("that if you change any settings in your own build, you will not be able to use my\n");
		output.append("version to encrypt/decrypt the messages produced by your Enigma and vice versa.\n\n");
		
		logger.debug("getAboutText() completed successfully");
		return output.toString();
		
	}

}
