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
 *                          Add selectProgramMode() method and related functionality
 *                          Implement configureInput() and set up logic for building input file paths
 */

package enigma;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
import interfaces.EnigmaApparatus;
import rotors.RotorController;
import utilities.Utilities;

public class Enigma implements EnigmaApparatus {
	
	private Scanner inputScanner = new Scanner(System.in);
	private String plaintext = "";
	private String cyphertext = "";
	private RotorController rc = new RotorController();
	private Utilities utility = new Utilities();
	private int programMode = 1;
	private int inputMode = 1;
	private KeyboardInputProcessor keyboardIn;
	private FileInputProcessor fileIn;
	
	/*
	 * Set up rotors needed for encryption
	 */
	@Override
	public void configureRotors() {
		//TODO - Create logic to allow users to set the Rotors themselves
	}
	
	/*
	 * Introduce the program
	 */
	public void introduceProgram() {
		utility.load(0);
	}
	
	/*
	 * Set the program up to encrypt/decrypt
	 */
	public void selectProgramMode() {
		utility.load(1);
		setProgramMode();
	}
	
	/*
	 * Set up the Enigma to either encrypt (1) or decrypt (2)
	 */
	private void setProgramMode() {
		int mode = 0;
		while (mode != 1 && mode != 2) {
			try {
				System.out.print("Please enter 1 to encrypt a new message or 2 to decrypt an existing message: ");
				mode = inputScanner.nextInt();
				inputScanner.nextLine();
			}
			catch (InputMismatchException e) {
				utility.handleError("input");
				inputScanner.nextLine();
			}
		}
		this.programMode = mode;
	}
	
	/*
	 * Set up Enigma to receive input
	 */
	@Override
	public void configureInput() {
		utility.load(2);
		setInputMode();
		if (inputMode == 2) {
			setFilePath();
		}
	}
	
	/*
	 * Set the input mode to file/keyboard based on user input
	 */
	private void setInputMode() {
		int mode = 0;
		while (mode < 1 || mode > 2) {
			try {
				System.out.println("Enter 1 to enter your message via the keyboard.");
				System.out.println("Enter 2 to have the program read your message from a file on your system.");
				mode = inputScanner.nextInt();
				inputScanner.nextLine();
			}
			catch (InputMismatchException e) {
				utility.handleError("input");
				inputScanner.nextLine();
			}
		}
		this.inputMode = mode;
	}
	
	/*
	 * Allow the user to enter their own file path for input
	 */
	private void setFilePath() {
		System.out.println("OK, Please choose the drive where the file exists. The following drives are available:");
		File[] paths = File.listRoots();
		for (File path:paths) {
			System.out.println(path);
		}
		System.out.print("Please enter your drive selection: ");
		String drive = inputScanner.nextLine();
		System.out.println("OK, now please enter the location of the file on " + drive);
		String path = inputScanner.nextLine();
		String filePath = drive + path;
		utility.setInputFilePath(filePath);
	}
	/*
	 * Read the message into the InputProcessor
	 */
	public void readInput() {
		if (inputMode == 1)
			readKeyboardInput();
		else
			readFileInput();
	}
	
	/*
	 * Read the message into the KeyboardInputProcessor
	 */
	private void readKeyboardInput() {
		// Build the InputProcessor
		keyboardIn = new KeyboardInputProcessor();
		// Get the message from the user
		System.out.println("Please enter your message: ");
		// Store off the message into the InputProcessor
		keyboardIn.readKeyBoardIn();
		plaintext = keyboardIn.getMessageIn();
	}
	
	/*
	 * Read the message into the FileInputProcessor
	 */
	private void readFileInput() {
		try { 
			// Build the InputProcessor
			fileIn = new FileInputProcessor(utility.getInputFilePath());
			// Store off the message
			fileIn.readFileIn();
			plaintext = fileIn.getMessageIn();
		}
		catch (NullPointerException e) {
			utility.handleError("file");
		}
	}
	
	/*
	 * Encrypt/Decrypt input
	 */
	@Override
	public void processInput() {
		if (programMode == 1)
			// encrypt
			cyphertext = rc.encode(plaintext);	
		else
			// decrypt
			cyphertext = rc.decode(plaintext);
		
	}
	
	/*
	 * Set up apparatus to transmit message
	 */
	@Override
	public void configureOutput() {
		// TODO implement this setup routine to direct the output where the user desires
	}
	
	/*
	 * Send the final results out
	 */
	@Override
	public void publishResults() {
		// TODO - add logic to use OutputProcessor to publish results
		
		System.out.println("Your original message:" + plaintext);
		System.out.print("Your encoded message: ");
		System.out.println(cyphertext);
		inputScanner.close();
	}
	
	/*
	 *  Main - Sequentially call the input,processing,output routines
	 *  	   to yield a final encrypted/decrypted message
	 */
	public static void main(String[] args) {
		Enigma enigmaMachine = new Enigma();
		enigmaMachine.introduceProgram();
		enigmaMachine.selectProgramMode();
		enigmaMachine.configureInput();
		enigmaMachine.readInput();
		enigmaMachine.processInput();
		enigmaMachine.configureOutput();
		enigmaMachine.publishResults();
	}

}