package interfaces;

public interface RotaryEncryptor extends Encryptor {

	/** @return the current index of the RotoryEncryptor */
	int getIndex();
	
	/**
	 * Sets the RotoryEncryptor to a given index
	 * @param index	an int representing the desired setting
	 */
	void setIndex(int index);
	
	/**
	 * Uses the current index to encode a single character.
	 * @param	plaintext	a char to be encoded
	 * @return the encoded char or '#' if plaintext can't be encoded
	 */
	Character encode(Character plaintext);
}
