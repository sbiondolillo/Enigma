package encryption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import interfaces.RotationManager;

public class RotorController implements RotationManager{
	
	private Rotor[] activeRotors;
	private Rotor decoder;
	private final int[] startingRotorIndexes = new int[6];
	private final static Logger logger = LogManager.getLogger(RotorController.class.getName());
	
	/**
	 * Constructor.<br />
	 * <br />
	 * Builds the pre-defined default Rotor[5] and complementary decoder Rotor
	 * @see	Rotor
	 */
	public RotorController() {
		
		logger.debug("Running RotorController()");
		
		logger.debug("Calling buildRotorArray()");
		buildRotorArray();
		
		logger.debug("RotorController() completed successfully");
		
	}
	
	/**
	 * Constructor.<br />
	 * <br />
	 * Assumes the user-supplied Rotors already have their indexes set. <br />
	 * Builds an appropriate decoder Rotor based on those indexes.
	 * @param 	activeRotors	a pre-filled Rotor[5]
	 * @see		Rotor
	 */
	public RotorController(Rotor[] activeRotors) {
		
		logger.debug("Running RotorController(Rotor[] activeRotors)");
		
		this.activeRotors = activeRotors;
		
		logger.debug("Calling buildDecoder()");
		buildDecoder();
		
		logger.debug("Calling setStartingIndexes()");
		setStartingIndexes();
		
		logger.debug("RotorController(Rotor[] activeRotors) completed successfully");
	}

	/*
	 * Interface Implementations
	 */
	@Override
	public Rotor[] getActiveRotors() {
		
		logger.debug("Running getActiveRotors()");
		
		logger.debug("getActiveRotors() completed successfully, returning {}", (Object)activeRotors);
		return activeRotors;
		
	}
	@Override
	public String encode(String plaintext) {
		
		logger.debug("Running encode(plaintext)");
		
		logger.debug("Building output String");
		String output = "";
		int count = 1;
		
		logger.debug("Encoding plaintext using activeRotors[]");
		for (char c: plaintext.toCharArray()) {
			
			char out = activeRotors[4]
					   .encode(activeRotors[3]
					   .encode(activeRotors[2]
					   .encode(activeRotors[1]
					   .encode(activeRotors[0]
					   .encode(c)))));
			output += out;
			
			logger.debug("calling rotateRotors({})", count);
			rotateRotors(count);

			count++;
			
		}
		logger.debug("Encoding plaintext using activeRotors[] completed successfully");
		
		logger.debug("Calling reset()");
		reset();
		
		logger.debug("encode(plaintext) completed successfully");
		return output;
		
	}
	@Override
	public String decode(String cyphertext) {
		
		logger.debug("Running decode(cyphertext)");
		
		logger.debug("Building output String");
		String output = "";
		
		// We don't care about preserving formatting of the encrypted source file
		// proper formatting is embedded in the encrypted message text itself
		cyphertext = cyphertext.replaceAll("\n", "");
		
		logger.debug("Passing cyphertext through decoder Rotor");
		for (int i = 1; i < cyphertext.length() + 1; i++) {
			
			logger.debug("Calling setDecoderIndex()");
			setDecoderIndex();
			
			char in = cyphertext.charAt(i-1);
			
			logger.debug("Calling decoder.encode({})", in);
			char out = decoder.encode(in);
			
			output += out;
			
			logger.debug("Calling rotateRotors({})", i);
			rotateRotors(i);
				
			
		}

		logger.debug("Decoding cyphertext using decoder completed successfully");
		
		logger.debug("Calling reset()");
		reset();
		
		logger.debug("decode(cyphertext) completed successfully");
		return output;
	}

	/*
	 * Reset all Rotors, including the decoder, to the initial configuration
	 */
	private void reset() {
		
		logger.debug("Running reset()");
		
		logger.debug("Resetting activeRotors");
		for (int i = 0; i < activeRotors.length; i++) {
			activeRotors[i].setIndex(startingRotorIndexes[i]);
		}
		
		logger.debug("Resetting decoder");
		decoder.setIndex(startingRotorIndexes[5]);
		
		logger.debug("reset() completed successfully");
		
	}
	
	/*
	 * Create a default Rotor[5] in case the default constructor is ever called
	 * also create the default decoder Rotor based on the initial Rotor indexes
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
		
		logger.debug("Calling setStartingIndexes()");
		setStartingIndexes();
		
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
		
		logger.debug("Calling setDecoderIndex()");
		setDecoderIndex();
		
		logger.debug("buildDecoder() completed successfully");
		
	}
	
	/*
	 * Calculates the necessary index to properly decode a character
	 * Sets the decoder to that index
	 */
	private void setDecoderIndex() {
		
		int totalOffset = 0;
		int decodeOffset;
		
		logger.debug("Caching dictionary length");
		int dictionaryLength = activeRotors[0].getDictionaryLength();
		
		logger.debug("Summing Rotor indexes");
		for (Rotor r: activeRotors) {
			totalOffset += r.getIndex();
		}
		
		logger.debug("Calculating decoder index");
		decodeOffset = dictionaryLength - (totalOffset % dictionaryLength);
		
		logger.debug("Calling setIndex({})", decodeOffset);
		decoder.setIndex(decodeOffset);
		
	}
	
	/*
	 * Store off the initial indexes of each Rotor so we can reset them after encryption/decryption
	 */
	private void setStartingIndexes() {
		
		logger.debug("Running setStartingIndexes()");
		for (int i = 0; i < activeRotors.length; i++) {
			
			logger.debug("Calling getIndex()");
			startingRotorIndexes[i] = activeRotors[i].getIndex();
		}
		
		logger.debug("Calling getIndex()");
		startingRotorIndexes[5] = decoder.getIndex();
		
		logger.debug("setStartingIndexes() completed successfully");
		
	}
	
	/*
	 * Rotate the even Rotors three clicks on the even numbered characters
	 * Rotate the odd Rotors one click on the odd numbered characters
	 */
	private void rotateRotors(int plaintextCharacterCount) {

		logger.debug("Running rotateRotors({})", plaintextCharacterCount);
		
		if (plaintextCharacterCount % 2 == 0) {
		
			for (int i = 0; i < 3; i++) {
				
				logger.debug("Calling activeRotors[1].rotate()");
				activeRotors[1].rotate();
				
				logger.debug("Calling activeRotors[3].rotate()");
				activeRotors[3].rotate();
			}

		} else {

			logger.debug("Calling activeRotors[0].rotate()");
			activeRotors[0].rotate();
			
			logger.debug("Calling activeRotors[2].rotate()");
			activeRotors[2].rotate();
			
			logger.debug("Calling activeRotors[4].rotate()");
			activeRotors[4].rotate();

		}
		
		logger.debug("rotateRotors({}) completed successfully", plaintextCharacterCount);
		
	}

}
