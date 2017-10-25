/*
 * RotorController Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create an object which manages multiple-rotor encoding/decoding in the Enigma program
 * Version	0.0.1	10/4/17
 *          0.0.2   10/24/17 - add getActiveRotors() method
 */

package rotors;

import interfaces.RotationManager;

public class RotorController implements RotationManager{
	
	private Rotor[] activeRotors = new Rotor[5];
	private Rotor decoder = new Rotor();
	
	/*
	 * Constructor
	 * builds a pre-defined Rotor[5] as well as the decoder Rotor
	 */
	public RotorController() {
		buildRotorArray();
	}
	
	/*
	 * Constructor
	 * @param activeRotors - a pre-filled Rotor[]
	 * this is the constructor we will use in the main Enigma program using
	 * the Rotor[] stored in the Config class within the utilies package
	 * assumes the activeRotors already have their indexes set
	 */
	public RotorController(Rotor[] activeRotors) {
		this.activeRotors = activeRotors;
		setDecoder();		
	}
	
	/*
	 * Select the Rotors to be used and initialize them with the given indexes
	 */
	@Override
	public void setActiveRotors(Rotor rotor1, int index1, Rotor rotor2, int index2, Rotor rotor3, 
								int index3, Rotor rotor4, int index4, Rotor rotor5, int index5) {
		// TODO Set this up if we ever allow the user to manipulate the Rotor configuration	
	}
	
	/*
	 * Return an array of active rotors
	 */
	public Rotor[] getActiveRotors() {
		return activeRotors;
	}

	/*
	 * Correctly encode a String by using each of the available Rotors in series (1->5)
	 */
	@Override
	public String encode(String plaintext) {
		String output = "";
		for (char c: plaintext.toCharArray()) {
			char out = activeRotors[4].encode(activeRotors[3].encode(activeRotors[2].
						encode(activeRotors[1].encode(activeRotors[0].encode(c)))));
			output += out;
		}
		System.out.println("Encoding...");
		return output;
	}
	
	/*
	 * Correctly decode a String by using the complementary decoder Rotor
	 */
	@Override
	public String decode(String cyphertext) {
		String output = "";
		for (char c: cyphertext.toCharArray()) {
			char out = decoder.encode(c);
			output += out;
		}
		System.out.println("Decoding...");
		return output;
	}

	/*
	 * Reset the Rotors to the initial configuration given by the user
	 */
	@Override
	public void reset() {
		// TODO Set this up if we ever allow the user to manipulate the rotor configuration
		
	}
	
	/*
	 * Create a default Rotor[5] in case the default constructor is ever called
	 * also create the default decoder Rotor base on the initial Rotor indexes
	 */
	private void buildRotorArray() {
		// manually set each of the 5 Rotors
		Rotor r1 = new Rotor();
		r1.setIndex(3);
		activeRotors[0] = r1;
		Rotor r2 = new Rotor();
		r2.setIndex(17);
		activeRotors[1] = r2;
		Rotor r3 = new Rotor();
		r3.setIndex(31);
		activeRotors[2] = r3;
		Rotor r4 = new Rotor();
		r4.setIndex(37);
		activeRotors[3] = r4;
		Rotor r5 = new Rotor();
		r5.setIndex(43);
		activeRotors[4] = r5;
		// set the decoder
		setDecoder();
		
	}
	
	/*
	 * Calculate the correct offset needed to decode our messages
	 * offset is based on the total offset of the encoding Rotors
	 * as well as the length of the dictionary used in the Rotors
	 */
	private void setDecoder() {
		int totalOffset = 0;
		int decodeOffset;
		int dictionaryLength = activeRotors[0].getValidCharacters().length();
		// add up all of the shifts in the Rotor[]
		for (Rotor r: activeRotors) {
			totalOffset += r.getIndex();
		}
		// figure out the complementary offset
		decodeOffset = dictionaryLength - (totalOffset % dictionaryLength);
		// set the decoder with the correct offset
		decoder.setIndex(decodeOffset);
	}

}
