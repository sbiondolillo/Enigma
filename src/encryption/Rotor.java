package encryption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import interfaces.RotaryEncryptor;

public class Rotor implements RotaryEncryptor {

	private Dictionary validCharacters;
	private int dictionaryLength;
	private int index = 0;
	private final static Logger logger = LogManager.getLogger(Rotor.class.getName());
	
	/**
	 * Constructor<br />
	 * <br />
	 * Sets up the default {@link Dictionary} and sets dictionaryLength accordingly
	 */
	public Rotor() {
		
		logger.debug("Running Rotor()");
		
		logger.debug("Calling Dictionary()");
		validCharacters = new Dictionary();
		
		dictionaryLength = validCharacters.getLength();
		
		logger.debug("Rotor() completed successfully");
		
	}
	
	/**
	 * Constructor<br />
	 * <br />
	 * Builds a custom {@link Dictionary} and sets dictionaryLength accordingly
	 * @param completeCodex a Character[] containing all of the characters to be supported
	 */
	public Rotor(Character[] completeCodex) {
		
		logger.debug("Running Rotor(Character[] completeCodex)");
		
		logger.debug("Calling Dictionary(Character[] completeCodex)");
		validCharacters = new Dictionary(completeCodex);
		
		dictionaryLength = validCharacters.getLength();
		
		logger.debug("Rotor(Character[] completeCodex) completed successfully");
		
	}
	
	/*
	 * Interface Implementations
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
	public int getDictionaryLength() {
		
		logger.debug("Running getDictionaryLength()");
		
		logger.debug("getDictionaryLength() completed successfully");
		return dictionaryLength;
	}
	@Override
	public Character encode(Character plaintext) {
		
		logger.debug("Running encode({})", plaintext);
		
		if (plaintext.equals('\n')) {
			
			logger.debug("encode({}) completed successfully, returning '^'", plaintext);
			return '^';
			
		} else if (plaintext.equals('^')) {
			
			logger.debug("encode({}) completed successfully, returning '\n'", plaintext);
			return '\n';
			
		} else if (plaintext.equals(' ')) {
			
			logger.debug("encode({}) completed successfully, returning '~", plaintext);
			return '~';
			
		} else if (plaintext.equals('~')) {
			
			logger.debug("encode({}) completed successfully, returning ' '", plaintext);
			return ' ';
			
		} else if (validCharacters.contains(plaintext)) {
			
			int currentIndex = index;
						
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

	/*
	 * Advances the index by 1 and wraps around the end, emulating a mechanical rotor
	 */
	void rotate() {
		
		logger.debug("Running rotate()");
		
		index = (index + 1) % dictionaryLength;
		
		logger.debug("rotate() completed successfully, index at {}", index);
	}
	
}
