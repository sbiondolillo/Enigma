/*
 * TestRotorController Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create a test driver class for multiple-rotor encoding/decoding in the Enigma program
 * Version	0.0.1	10/4/17
 */

package rotors;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestRotorController {
	
	public static void main(String[] args) {
		
		// let the user set the mode to encode/decode
		Scanner input = new Scanner(System.in);
		RotorController rc = new RotorController();
		int mode = 0;
		while (mode != 1 && mode != 2) {
			try {
				System.out.print("Please enter 1 to encode or 2 to decode: ");
				mode = (int) input.nextInt();
				input.nextLine();
			}
			catch (InputMismatchException e) {
				input.nextLine();
				System.out.println("You must enter an integer.");
				continue;
			}
		}
		if (mode == 1) {
			// get text from user
			System.out.println("Please enter the text to encode: ");
			String plaintext = input.nextLine();
			// encode
			String cyphertext = rc.encode(plaintext);
			// display results
			System.out.println("Plaintext : " + plaintext);
			System.out.println("Cyphertext: " + cyphertext);
		}
		else {
			// get text from user
			System.out.println("Please enter the text to decode: ");
			String cyphertext = input.nextLine();
			// decode
			String plaintext = rc.decode(cyphertext);
			// display results
			System.out.println("Cyphertext: " + cyphertext);
			System.out.println("Plaintext : " + plaintext);
		}
		input.close();
	}

}
