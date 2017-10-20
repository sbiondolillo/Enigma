/*
 * Enigma Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To manage the control logic for all of the constituent parts of our Enigma machine
 * Version 0.0.1 - 9/18/17
 * 		   0.0.2 - 9/23/17	Add logic to user input to scale to size of Rotor dictionary
 * 							refactor user input to include correct methods from InputProcessor
 * 		   0.0.3 - 9/24/17	Adjust Enigma to utilize three rotors in series
 */

package enigma;

import java.util.Scanner;
import interfaces.EnigmaApparatus;
import rotors.Rotor;
import rotors.RotorController;

public class Enigma implements EnigmaApparatus {
	
	private int inputMode;
	private int offset;
	private FileInputProcessor mainFileIO;
	private KeyboardInputProcessor mainKeyboardIO;
	private Scanner inputScanner = new Scanner(System.in);
	private String plaintext = "";
	private String cyphertext = "";
	private RotorController rc = new RotorController();
	
	/*
	 * Set up rotors needed for encryption
	 */
	@Override
	public void configureRotors() {
		//TODO - Create logic to allow users to set the Rotors themselves
	}
	
	/*
	 * Set up Enigma to receive input
	 */
	@Override
	public void configureInput() {
		// Introduce the program
		System.out.println("Welcome to the Enigma!");
		
		// Ask the user to set the input mode to file or keyboard
		while (true) {
			System.out.println("Please enter 1 to type your message or 2 to read from a file: ");
			inputMode = inputScanner.nextInt();
			if (inputMode != 1 && inputMode != 2)
				continue;
			else
				// Advance the Scanner so we can read lines after reading ints above
				inputScanner.nextLine();
				break;
		}
		
		// Set up input processing based on inputMode
		if (inputMode == 1) {
			System.out.println("Please enter your message: ");
			mainKeyboardIO = new KeyboardInputProcessor();
			// Store off the message into the I/O object
			mainKeyboardIO.readKeyBoardIn();
			plaintext = mainKeyboardIO.getMessageIn();
		} 
		else {
			System.out.print("Please enter the file path: ");
			String filePath = inputScanner.nextLine();
			try { 
				mainFileIO = new FileInputProcessor(filePath);
				// Store off the message into the I/O object
				mainFileIO.readFileIn();
				plaintext = mainFileIO.getMessageIn();
			}
			catch (NullPointerException e) {
				// If file is inaccessible, offer to let the user type their message
				System.out.println("Please type your message: ");
				mainKeyboardIO = new KeyboardInputProcessor();
				// Store off the message into the I/O object
				mainKeyboardIO.readKeyBoardIn();
				plaintext = mainKeyboardIO.getMessageIn();
			}
		}
		
	}
	
	/*
	 * Encrypt/Decrypt input
	 */
	@Override
	public void processInput() {
		// encrypt the input message
		cyphertext = rc.encode(plaintext);		
		
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
		System.out.println("Encoding...");
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
		enigmaMachine.configureInput();
		enigmaMachine.processInput();
		enigmaMachine.configureOutput();
		enigmaMachine.publishResults();
	}

}