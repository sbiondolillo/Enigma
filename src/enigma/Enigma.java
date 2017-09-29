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

public class Enigma implements EnigmaApparatus {
	
	private int inputMode;
	private int offset;
	private InputProcessor mainIP;
	private Rotor rotor1 = new Rotor();
	private Rotor rotor2 = new Rotor();
	private Rotor rotor3 = new Rotor();
	private Scanner inputScanner = new Scanner(System.in);
	
	/*
	 * Set up rotors needed for encryption
	 */
	@Override
	public void configureRotors() {
		// Introduce the program
		System.out.println("Welcome to the Enigma!");
		
		// Get the initial rotor setting from the user
		while (true) {
			System.out.println("Please enter an initial setting for the first rotor from 0 to " + 
					(rotor1.getValidCharacters().length() - 1) + ": ");
			offset = inputScanner.nextInt();
			if (offset < 0 || offset > rotor1.getValidCharacters().length()-1) {
				continue;
			}
			else {
				rotor1.setIndex(offset);
				break;
			}
		}
		while (true) {
			System.out.println("Please enter an initial setting for the second rotor from 0 to " + 
					(rotor2.getValidCharacters().length() - 1) + ": ");
			offset = inputScanner.nextInt();
			if (offset < 0 || offset > rotor2.getValidCharacters().length()-1) {
				continue;
			}
			else {
				rotor2.setIndex(offset);
				break;
			}
		}
		while (true) {
			System.out.println("Please enter an initial setting for the third rotor from 0 to " + 
					(rotor3.getValidCharacters().length() - 1) + ": ");
			offset = inputScanner.nextInt();
			if (offset < 0 || offset > rotor3.getValidCharacters().length()-1) {
				continue;
			}
			else {
				rotor3.setIndex(offset);
				break;
			}
		}
	}
	
	/*
	 * Set up Enigma to receive input
	 */
	@Override
	public void configureInput() {
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
	}
	
	/*
	 * Encrypt/Decrypt input
	 */
	@Override
	public void processInput() {
		// TODO move setup dialog to configureInput()
		/* TODO trim routine to be limited to reading the input,
				encoding using rotor, converting using base converter */
		
		// Set up mainIP based on inputMode
		if (inputMode == 1) {
			System.out.println("Please enter your message: ");
			mainIP = new InputProcessor();
			// Store off the message into the I/O object
			mainIP.getKeyBoardIn();
		} 
		else {
			System.out.print("Please enter the file path: ");
			String filePath = inputScanner.nextLine();
			try { 
				mainIP = new InputProcessor(filePath);
				// Store off the message into the I/O object
				mainIP.getFileIn();
			}
			catch (NullPointerException e) {
				// If file is inaccessible, offer to let the user type their message
				System.out.println("Please type your message: ");
				mainIP = new InputProcessor();
				// Store off the message into the I/O object
				mainIP.getKeyBoardIn();
			}
		}
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
		// TODO - break this into parts, move into appropriate methods
		// TODO - add logic to use OutputProcessor to publish results
		
		// Encode the message using the rotors, output cyphertext
		System.out.println("Your original message:" + mainIP.getMessageIn());
		System.out.println("Encoding...");
		System.out.print("Your encoded message: ");
		for (int i = 0; i < mainIP.getMessageIn().length(); i++) {
			System.out.print(rotor3.encode(rotor2.encode(rotor1.encode(mainIP.getMessageIn().charAt(i)))));
		}
		inputScanner.close();
	}
	
	/*
	 *  Main - Sequentially call the input,processing,output routines
	 *  	   to yield a final encrypted/decrypted message
	 */
	public static void main(String[] args) {
		Enigma enigmaMachine = new Enigma();
		enigmaMachine.configureRotors();
		enigmaMachine.configureInput();
		enigmaMachine.processInput();
		enigmaMachine.configureOutput();
		enigmaMachine.publishResults();
	}

}