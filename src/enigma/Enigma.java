/*
 * Enigma Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To manage the control logic for all of the constituent parts of our Enigma machine
 * Version 0.0.1 - 9/18/17
 * 		   0.0.2 - 9/23/17	Add logic to user input to scale to size of Rotor dictionary
 * 							refactor user input to include correct methods from InputProcessor
 */

package enigma;

import java.util.Scanner;

public class Enigma {
	
	/*
	 * Everything is set up as static for now, easy to change this going forward, makes testing easier
	 */
	private static int inputMode;
	private static int offset;
	private static InputProcessor mainIO;
	private static Rotor rotor1 = new Rotor();
	
	/*
	 *  Main - Sets up a very basic routine for taking in a plaintext message and printing
	 *  out cyphertext to the console. Only 1 Rotor with the default CharSet is used.
	 */
	public static void main(String[] args) {
		
		// Introduce the program
		System.out.println("Welcome to the Enigma!");
		Scanner input = new Scanner(System.in);
		
		// Get the initial rotor setting from the user
		while (true) {
			System.out.println("Please enter an initial setting for your rotor from 0 to " + 
					(rotor1.getValidCharacters().length() - 1) + ": ");
			offset = input.nextInt();
			if (offset < 0 || offset > rotor1.getValidCharacters().length()-1) {
				continue;
			}
			else {
				rotor1.setIndex(offset);
				break;
			}
		}
		
		// Ask the user to set the input mode to file or keyboard
		while (true) {
			System.out.println("Please enter 1 to type your message or 2 to read from a file: ");
			inputMode = input.nextInt();
			if (inputMode != 1 && inputMode != 2)
				continue;
			else
				break;
		}
		
		// Advance the Scanner so we can read lines after reading ints above
		input.nextLine();
		
		// Set up input functionality based on user-selected keyboard or file input
		if (inputMode == 1) {
			System.out.println("Please enter your message: ");
			mainIO = new InputProcessor();
			// Store off the message into the I/O object
			mainIO.getKeyBoardIn();
		} 
		else {
			System.out.print("Please enter the file path: ");
			String filePath = input.nextLine();
			try { 
				mainIO = new InputProcessor(filePath);
				// Store off the message into the I/O object
				mainIO.getFileIn();
			}
			catch (NullPointerException e) {
				// If file is inaccessible, offer to let the user type their message
				System.out.println("Please type your message: ");
				mainIO = new InputProcessor();
				// Store off the message into the I/O object
				mainIO.getKeyBoardIn();
			}
		}
		
		// Encode the message using the rotor, output cyphertext
		// TODO - put this into a helper method or refactor this into I/O class
		System.out.println("Your original message:" + mainIO.getMessageIn());
		System.out.println("Encoding...");
		System.out.print("Your encoded message: ");
		for (int i = 0; i < mainIO.getMessageIn().length(); i++) {
			System.out.print(rotor1.encode(mainIO.getMessageIn().charAt(i)));
		}
		input.close();
		
	}

}