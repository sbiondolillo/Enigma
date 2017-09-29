/*
 * CharacterSet Interface
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create a base interface for defining valid characters in the Enigma program
 * Version 0.0.1 - 9/22/17
 */

package interfaces;

public interface CharacterSet {
	
	/*
	 * Getter for instance variable dictionary
	 */
	Character[] getDictionary();
	
	/*
	 * Provide an appealing output format
	 */
	String toString();
	
	/*
	 * Identify whether or not a character is in the dictionary
	 */
	boolean contains(Character test);
	
	/*
	 * Return the length of the dictionary
	 */
	int length();
	
	/*
	 *  Return the location of a given character within the dictionary
	 */
	int indexOf(Character quarry);
	
	/*
	 *  Allow character lookup by direct indexing
	 */
	Character charAt(int index);

}
