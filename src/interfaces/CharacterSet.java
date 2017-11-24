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
	 * Getters and setters for instance variables
	 */
	Character[] getDictionary();
	int getLength();
	
	/*
	 * Provide an appealing output format
	 */
	String toString();
	
	/*
	 * Identify whether or not a character is in the dictionary
	 */
	boolean contains(Character target);
	
	/*
	 *  Return the location of a given character within the dictionary
	 */
	int indexOf(Character target);
	
	/*
	 *  Allow character lookup by direct indexing
	 */
	Character charAt(int index);

}
