package interfaces;

public interface CharacterSet {
	
	/** @return the CharacterSet built in the constructor */
	Character[] getDictionary();
	
	/** @return the number of characters in the CharacterSet */
	int getLength();
	
	/**
	 * Provide an appealing text output format
	 */
	String toString();
	
	/**
	 * Identify whether or not a character is in the CharacterSet
	 * @param target	the char for which we search
	 * @return true if char is found, false otherwise
	 */
	boolean contains(Character target);
	
	/**
	 * Find the location of a given character within the CharacterSet
	 * @param	target	the char for which we search
	 * @return an int representing the char's location in the set, -1 if char not found
	 */
	int indexOf(Character target);
	
	/**
	 * Allow character lookup by direct indexing
	 * @param	index	an int representing the location of the desired character in the set
	 * @return the char at the given index
	 */
	Character charAt(int index);

}
