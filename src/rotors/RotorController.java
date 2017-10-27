/*
 * RotorController Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create an object which manages multiple-rotor encoding/decoding in the Enigma program
 * Version	0.0.1	10/4/17
 *          0.0.2   10/24/17 Add getActiveRotors() method
 *          0.0.3   10/27/17 Add log4j2 Logger into class
 *                           Add debugging statements for Logger
 *                           Refactor initialization
 */

package rotors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import interfaces.RotationManager;

public class RotorController implements RotationManager{
	
	private Rotor[] activeRotors;
	private Rotor decoder;
	private final static Logger logger = LogManager.getLogger(RotorController.class.getName());
	
	/*
	 * Constructor
	 * builds a pre-defined Rotor[5] as well as the decoder Rotor
	 */
	public RotorController() {
		
		logger.debug("Running RotorController()");
		
		logger.debug("Calling buildRotorArray()");
		buildRotorArray();
		
		logger.debug("RotorController() completed successfully");
		
	}
	
	/*
	 * Constructor
	 * @param activeRotors - a pre-filled Rotor[]
	 * this is the constructor we will use in the main Enigma program using
	 * the Rotor[] stored in the Config class within the utilies package
	 * assumes the activeRotors already have their indexes set
	 */
	public RotorController(Rotor[] activeRotors) {
		
		logger.debug("Running RotorController(Rotor[] activeRotors)");
		
		this.activeRotors = activeRotors;
		
		logger.debug("Calling buildDecoder()");
		buildDecoder();
		
		logger.debug("RotorController(Rotor[] activeRotors) completed successfully");
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
		
		logger.debug("Running getActiveRotors()");
		
		logger.debug("getActiveRotors() completed successfully, returning {}", (Object)activeRotors);
		return activeRotors;
		
	}

	/*
	 * Correctly encode a String by using each of the available Rotors in series (1->5)
	 */
	@Override
	public String encode(String plaintext) {
		
		logger.debug("Running encode(plaintext)");
		
		logger.debug("Building output String");
		String output = "";
		
		logger.debug("Encoding plaintext using activeRotors[]");
		for (char c: plaintext.toCharArray()) {
			
			char out = activeRotors[4].encode(activeRotors[3].encode(activeRotors[2].
						encode(activeRotors[1].encode(activeRotors[0].encode(c)))));
			output += out;
			
		}
		logger.debug("Encoding plaintext using activeRotors[] completed successfully");
		
		System.out.println("Encoding...");
		
		logger.debug("encode(plaintext) completed successfully");
		return output;
		
	}
	
	/*
	 * Correctly decode a String by using the complementary decoder Rotor
	 */
	@Override
	public String decode(String cyphertext) {
		
		logger.debug("Running decode(cyphertext)");
		
		logger.debug("Building output String");
		String output = "";
		
		logger.debug("Decoding cyphertext using decoder");
		for (char c: cyphertext.toCharArray()) {
			
			char out = decoder.encode(c);
			output += out;
			
		}
		logger.debug("Decoding cyphertext using decoder completed successfully");
		
		System.out.println("Decoding...");
		
		logger.debug("decode(cyphertext) completed successfully");
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
		
		logger.debug("Running buildRotorArray()");
		
		logger.debug("Building activeRotors[]");
		activeRotors = new Rotor[5];
		
		logger.debug("Calling new Rotor()");
		Rotor r1 = new Rotor();
		
		logger.debug("Calling setIndex(3)");
		r1.setIndex(3);
		
		logger.debug("Assigning new Rotor() to activeRotors[]");
		activeRotors[0] = r1;
		
		logger.debug("Calling new Rotor()");
		Rotor r2 = new Rotor();
		
		logger.debug("Calling setIndex(17)");
		r2.setIndex(17);
		
		logger.debug("Assigning new Rotor() to activeRotors[]");
		activeRotors[1] = r2;
		
		logger.debug("Calling new Rotor()");
		Rotor r3 = new Rotor();
		
		logger.debug("Calling setIndex(31)");
		r3.setIndex(31);
		
		logger.debug("Assigning new Rotor() to activeRotors[]");
		activeRotors[2] = r3;
		
		logger.debug("Calling new Rotor()");
		Rotor r4 = new Rotor();
		
		logger.debug("Calling setIndex(37)");
		r4.setIndex(37);
		
		logger.debug("Assigning new Rotor() to activeRotors[]");
		activeRotors[3] = r4;
		
		logger.debug("Calling new Rotor()");
		Rotor r5 = new Rotor();
		
		logger.debug("Calling setIndex(43)");
		r5.setIndex(43);
		
		logger.debug("Assigning new Rotor() to activeRotors[]");
		activeRotors[4] = r5;
		
		logger.debug("Calling buildDecoder()");
		buildDecoder();
		
		logger.debug("buildRotorArray() completed successfully");
		
	}
	
	/*
	 * Calculate the correct offset needed to decode our messages
	 * offset is based on the total offset of the encoding Rotors
	 * as well as the length of the dictionary used in the Rotors
	 */
	private void buildDecoder() {
		
		logger.debug("Running buildDecoder()");
		
		logger.debug("Calling new Rotor()");
		decoder = new Rotor();
		
		int totalOffset = 0;
		int decodeOffset;
		
		logger.debug("Caching dictionary length");
		int dictionaryLength = activeRotors[0].getValidCharacters().length();
		
		logger.debug("Summing Rotor indexes");
		for (Rotor r: activeRotors) {
			totalOffset += r.getIndex();
		}
		
		logger.debug("Calculating decoder index");
		decodeOffset = dictionaryLength - (totalOffset % dictionaryLength);
		
		logger.debug("Calling setIndex({})", decodeOffset);
		decoder.setIndex(decodeOffset);
		
		logger.debug("buildDecoder() completed successfully");
		
	}

}
