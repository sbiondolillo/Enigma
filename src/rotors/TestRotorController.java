package rotors;

import java.util.Scanner;

public class TestRotorController {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		RotorController rc = new RotorController();
		System.out.print("Please enter 1 to encode or 2 to decode: ");
		int mode = input.nextInt();
		input.nextLine();
		if (mode == 1) {
			System.out.println("Please enter the text to encode: ");
			String plaintext = input.nextLine();
			String cyphertext = rc.encode(plaintext);
			System.out.println("Plaintext : " + plaintext);
			System.out.println("Cyphertext: " + cyphertext);
		}
		else if (mode == 2) {
			System.out.println("Please enter the text to decode: ");
			String cyphertext = input.nextLine();
			String plaintext = rc.decode(cyphertext);
			System.out.println("Cyphertext: " + cyphertext);
			System.out.println("Plaintext : " + plaintext);
		}
		input.close();
	}

}
