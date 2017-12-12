package interfaces;

public interface FileInput {
	
	/** @return the String read in from the file passed to the constructor */
	String getMessageIn();
	
	/**
	 * Reads the text from the file passed to the constructor<br />
	 * and stores it in messageIn
	 */
	void readInputFile();
	
}
