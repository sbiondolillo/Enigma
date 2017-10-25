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
 *                          Add runMainMenu() method and related functionality
 *                          Move all other functionality out of this main class
 */

package enigma;

import interfaces.EnigmaApparatus;
import utilities.Utilities;

public class Enigma implements EnigmaApparatus {
	
	private Utilities utility = new Utilities();
	
	/*
	 * Introduce the program
	 */
	private void introduceProgram() {
		utility.load(0);
	}
	
	/*
	 * Display the Main Menu which directs the flow of the program
	 */
	private void runMainMenu() {
		utility.load(2);
	}
	
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
		// TODO - implement this or scrap it	
	}
	
	/*
	 * Encrypt/Decrypt input
	 */
	@Override
	public void processInput() {
		// TODO - implement this or scrap it	
	}
	
	/*
	 * Set up apparatus to transmit message
	 */
	@Override
	public void configureOutput() {
		// TODO - implement this or scrap it	
	}
	
	/*
	 * Send the final results out
	 */
	@Override
	public void publishResults() {
		// TODO - implement this or scrap it		
	}
	
	/*
	 *  Main - Sequentially call the input,processing,output routines
	 *  	   to yield a final encrypted/decrypted message
	 */
	public static void main(String[] args) {
		
		// Initialize a new Enigma
		Enigma enigmaMachine = new Enigma();
		
		// Run the program introduction
		enigmaMachine.introduceProgram();
		
		// Allow the user to navigate the menus until they quit
		while (true) {
			enigmaMachine.runMainMenu();
		}
	}

}