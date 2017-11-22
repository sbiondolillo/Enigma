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

package utilities;

import java.nio.file.Paths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import enigma.FileInputProcessor;
import enigma.OutputProcessor;
import forms.MainMenu;
import rotors.RotorController;

public class ScreenManager {
	
	private static RotorController rc;
	private final static Logger logger = LogManager.getLogger(ScreenManager.class.getName());
	
	
	/*
	 * Constructor - Default
	 * Builds a Scanner for reading keyboard input
	 * Builds a RotorController for managing encryption/decryption
	 */
	public ScreenManager() {
	
		logger.debug("Running new Screens()");
		
		logger.debug("Building new RotorController()");
		rc = new RotorController();
		
		logger.debug("new Screens() completed successfully");
		
	}
	
	/*
	 * Launch the program's Main Menu JFrame
	 */
	public void showMainMenu() {
		
		logger.debug("Running showMainMenu()");
		
		logger.debug("Building new MainMenu()");
		MainMenu mainMenu = new MainMenu();
		
		logger.debug("Calling MainMenu.show()");
		mainMenu.show();
		
		logger.debug("showMainMenu() completed successfully");
		
	}
	
	/*
	 * Launch the Select Program Mode... dialog
	 */
	public void showProgramModeSelectForm() {
		
		logger.debug("Running showProgramModeSelect()");
		
		// TODO - add code to show the Select Program Mode... dialog
		
		logger.debug("showProgramModeSelect() completed successfully");
		
	}
	
	/*
	 * Configure the Enigma to either encrypt or decrypt
	 * based on user input in the Select Program Mode... dialog
	 */
	private void updateProgramMode() {
		
		logger.debug("Running updateProgramMode()");
		
		int mode = 0;
		
		// TODO - add in logic to set mode based on form data
		
		logger.debug("Calling Config.setProgramMode({})", mode);
		Config.setProgramMode(mode);
		
		logger.debug("updateProgramMode() completed successfully");
		
	}
	
	/*
	 * Let the user set their own file path with a GUI dialog
	 */
	public static String getCustomInputFilePath() {
		
		logger.debug("Running getCustomInputFilePath()");
		
		logger.debug("Building new FileSelector");
		FileSelector fileSelector = new FileSelector("./resources/misc");
		
		logger.debug("Displaying Open File Dialog");
		String filePath = fileSelector.selectOpenFilePath();
		
		if (filePath.equals("")) {
			
			logger.debug("Using DEFAULT_INPUT_FILE");
			// TODO - create alert dialog to let user know the default will be used
			filePath = Config.getDefaultInputFile();
		}
		
		logger.debug("getCustomInputFilePath() completed successfully, returning {}", filePath);
		return filePath;
		
	}
	
	/*
	 * Allow the user to specify their own custom file path for output
	 */
	public static String getCustomOutputFilePath() {
		
		logger.debug("Running getCustomOutputFilePath()");
		
		logger.debug("Building new FileSelector");
		FileSelector fileSelector = new FileSelector("./resources/misc");
		
		logger.debug("Displaying Save File Dialog");
		String filePath = fileSelector.selectSaveFilePath();
		
		if (filePath.equals("")) {
			
			logger.debug("Using DEFAULT_OUTPUT_FILE");
			// TODO - create alert dialog to let user know the default will be used
			filePath = Config.getDefaultOutputFile();
		}
		
		logger.debug("getCustomOutputFilePath() completed successfully, returning {}", filePath);
		return filePath;
		
	}
	
	/*
	 * Write the contents of the encoded message to the specified file
	 */
	private static void writeFileOut() {
		
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
	 * Runs the encryption/decryption process and writes out to file
	 */
	public static void processResults() {
		
		logger.debug("Running processResults()");
		
		logger.debug("Calling setInputText()");
		String inputText = setInputText();
		
		logger.debug("Calling setOutputText()");
		setOutputText(inputText);
				
		logger.debug("Writing message to file");
		
		logger.debug("Calling writeFileOut()");
		writeFileOut();
		
		logger.debug("Message successfully written to file");
			
		
		logger.debug("processResults() completed successfully");
		
	}
	
	/*
	 * Either gets keyboard input from the user or reads from file
	 * @returns the String stored in Config.plainText
	 */
	private static String setInputText() {
		
		logger.debug("Running setInputText()");
		
		logger.debug("Calling readFileIn()");
		readFileIn();
		
		logger.debug("setInputText() completed successfully");
		return Config.getPlainText();
		
	}
	
	/*
	 * Read the contents of the user-specified file into the plainText Config variable
	 */
	private static void readFileIn() {
		
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
		
		logger.debug("displayValidCharScreen() completed successfully");
		
	}
	
	/*
	 * Display the screen where users can get general info about the program
	 * and instructions on how to use the various parts of the program
	 */
	public static void displayAboutScreen() {
		
		logger.debug("Running displayAboutScreen()");
		
		System.out.println();
		System.out.println("Welcome to the General Info / Instruction menu!");
		System.out.println();
		System.out.println("This program was designed to mimic the Enigma encryption machine made famous by");
		System.out.println("the Nazi command structure during the Second World War. In that machine, a series");
		System.out.println("of moving rotors were used to scramble a message into an encrypted message and then");
		System.out.println("another machine used those same rotors to decrypt the message at another time and place.");
		System.out.println();
		System.out.println("While some of the features of the German Enigma have been set aside, some of the main");
		System.out.println("components have been replicated here. As such, there are three primary settings which");
		System.out.println("need to be established in order for the machine to function as intended:");
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
		
		logger.debug("displayAboutScreen() completed successfully");
		
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
			
			logger.debug("running Errors.fileError()");
			
			System.out.println();
			System.out.println("Sorry, unable to access your file. Please see the error message above for details.");
			System.out.println("You will now be taken back to the Main menu");
			System.out.println("If you continue to have trouble, please contact Customer Support at enigmasupport@gmail.com.");
			System.out.println("Please include the error message printed above when you contact Customer Support.");
			System.out.println();
			
			logger.debug("Errors.fileError() completed successfully");
			
		}
		
		
		static void configError() {
			// TODO - build method to display Configuration Error Screen
			logger.debug("running Errors.configError()");
			
			logger.debug("Errors.configError() completed successfully");
			
		}
		
		static void inputError() {
			
			logger.debug("running Errors.inputError()");
			
			System.out.println();
			System.out.println("Sorry, you have entered an invalid input. Please try again.");
			System.out.println("If you continue to have trouble, please contact Customer Support at enigmasupport@gmail.com.");
			System.out.println("Please include the error message printed above when you contact Customer Support.");
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
