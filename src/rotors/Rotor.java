/*
 * Rotor Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To provide encryption functionality by emulation of a physical Enigma rotor
 * Version 0.0.1	9/11/17
 *         0.0.2	9/18/17		Added automatic rotation to the encode() method
 *         0.0.3	9/22/17		Set up as implementation of EnryptionWheel
 *         0.0.4	9/24/17		Added a variable to store the notch position for use in multi-rotor setups
 *         					 	Added a constructor which sets the notch position
 *         0.0.5	10/4/17		Removed rotate() from encode() method logic
 *         0.0.6    10/26/17    Adjusted encode() to cache dictionary length and plaintext index
 *                              Add log4j2 Logger into class
 *                              Add debugging statements for Logger
 */

package rotors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import enigma.Dictionary;
import interfaces.RotaryEncryptor;

public class Rotor implements RotaryEncryptor {

	/*
	 * Set up each rotor with an array of characters, an initial index, and a notch position
	 */
	private Dictionary validCharacters;
	private int index = 0;
	private int notch = 9;
	private final static Logger logger = LogManager.getLogger(Rotor.class.getName());
	
	/*
	 * Constructor
	 * Default constructor gets the default character set
	 */
	public Rotor() {
		
		logger.debug("Running Rotor()");
		
		logger.debug("Calling Dictionary()");
		validCharacters = new Dictionary();
		
		logger.debug("Rotor() completed successfully");
		
	}
	
	/*
	 * Constructor
	 * @param completeCodex - Users can enter their own array of characters for a custom rotor
	 */
	public Rotor(Character[] completeCodex) {
		
		logger.debug("Running Rotor(Character[] completeCodex)");
		
		logger.debug("Calling Dictionary(Character[] completeCodex)");
		validCharacters = new Dictionary(completeCodex);
		
		logger.debug("Rotor(Character[] completeCodex) completed successfully");
		
	}
	
	/*
	 * Constructor
	 * @param completeCodex - Users can enter their own array of characters for a custom rotor
	 * @param notch - an int indicating the notch position where the rotor would cause 
	 * 				  a rotation in the next rotor in series
	 */
	public Rotor(Character[] completeCodex, int notch) {
		
		logger.debug("Running Rotor(Character[] completeCodex, int notch)");
		
		logger.debug("Calling Dictionary(Character[] completeCodex, int notch)");
		validCharacters = new Dictionary(completeCodex);
		this.notch = notch;
		
		logger.debug("Rotor(Character[] completeCodex, int notch) completed successfully");
		
	}
	
	/*
	 * Getters and Setters
	 */
	@Override
	public int getIndex() {
		
		logger.debug("Running getIndex()");
		
		logger.debug("getIndex() completed successfully, returning {}", index);
		return index;
		
	}
	@Override
	public void setIndex(int index) {
		
		logger.debug("Running setIndex({})", index);
		
		this.index = index;
		
		logger.debug("setIndex({}) completed successfully", index);
		
	}
	@Override
	public Dictionary getValidCharacters() {
		
		logger.debug("Running getValidCharacters()");
		
		logger.debug("getValidCharacters() completed successfully");
		return validCharacters;
		
	}
	@Override 
	public int getNotch() {
		
		logger.debug("Running getNotch()");
		
		logger.debug("getNotch() completed successfully");
		return notch;
		
	}
	
	/*
	 * Advances the index by 1 and wraps around the end, emulating a mechanical rotor
	 */
	private void rotate() {
		
		logger.debug("Running rotate()");
		
		logger.debug("Calling Dictionary.length()");
		index = (index + 1) % validCharacters.length();
		
		logger.debug("rotate() completed successfully, index at {}", index);
	}
	
	/* 
	 * Uses the current index to encode a single character.
	 * Returns the encoded character or '#' if the encoding cannot be completed
	 */
	@Override
	public Character encode(Character plaintext) {
		
		logger.debug("Running encode({})", plaintext);
		
		logger.debug("Calling Dictionary.contains({})", plaintext);
		if (validCharacters.contains(plaintext)) {
			
			int currentIndex = index;
			
			logger.debug("Calling Dictionary.length()");
			int dictionaryLength = validCharacters.length();
			
			logger.debug("Finding encoded character");
			
			logger.debug("Calling Dictionary.indexOf({})", plaintext);
			int plaintextIndex = validCharacters.indexOf(plaintext);
			
			logger.debug("Adding Rotor index of {} to plaintext index of {} to set finalIndex", currentIndex, plaintextIndex);
			int finalIndex = (currentIndex + plaintextIndex) % dictionaryLength;
			logger.debug("Encoded character at index {}", finalIndex);
			
			logger.debug("Calling Dictionary.charAt({})", finalIndex);
			Character cyphertext = validCharacters.charAt(finalIndex);
			
			logger.debug("encode({}) completed successfully, returning {}", plaintext, cyphertext);
			return cyphertext;
			
		} else {
			
			logger.debug("encode({}) completed successfully, returning '#'", plaintext);
			return '#';
			
		}
	}	
}