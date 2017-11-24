/*
 * CharacterSet Interface
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create a base interface for defining valid characters in the Enigma program
 * Version 0.0.1 - 9/22/17
 */

package interfaces;

public interface CharacterSet {
	
	/** @returns the CharacterSet built in the constructor */
	Character[] getDictionary();
	
	/** @returns the number of characters in the CharacterSet */
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
