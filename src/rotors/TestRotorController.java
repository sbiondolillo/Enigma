package rotors;

import java.util.Scanner;

public class TestRotorController {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		RotorController rc = new RotorController();
		System.out.println("Please enter a string to encode.");
		String plaintext = input.nextLine();
		String cyphertext = rc.encode(plaintext);
		System.out.println("Plaintext : " + plaintext);
		System.out.println("Cyphertext: " + cyphertext);
		input.close();
	}

}
