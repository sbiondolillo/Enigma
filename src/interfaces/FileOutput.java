/*
 * FileOutput Interface
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create an interface for output processing to files in the Enigma program
 * Version 0.0.1 - 9/23/17
 */

package interfaces;

import java.io.IOException;
import java.nio.file.Path;

public interface FileOutput {
	
	/*
	 * Getters/Setters for instance variables
	 */
	String getMessageOut();
	void setMessageOut(String messageOut);
	String getOutputFilePath();
	void setOutputFilePath(String outputFilePath);
	
	/*
	 * Takes the contents of messageOut String and writes them to outputFilePath
	 */
	void writeMessageOutToFile() throws IOException;
	

}
