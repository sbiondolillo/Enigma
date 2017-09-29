/*
 * EncryptionDecryptionApparatus Interface
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create a base interface for a message cypher machine
 * Version 0.0.1 - 9/24/17
 */

package interfaces;

public interface EncryptionDecryptionApparatus {
	
	/*
	 * Set up apparatus to receive input
	 */
	void configureInput();
	
	/*
	 * Encrypt/Decrypt input
	 */
	void processInput();
	
	/*
	 * Set up apparatus to transmit message
	 */
	void configureOutput();
	
	/*
	 * Send the final results out
	 */
	void publishResults();

}
