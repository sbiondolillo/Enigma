/*
 * FileInput Interface
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: Create an interface for output processing to files in the Enigma program
 * Version 0.0.1 - 9/23/17
 */

package interfaces;

import java.nio.file.Path;

public interface FileOutput extends Output{
	
	/*
	 * Getter for instance variable outputFilePath
	 * returns the complete file path 
	 * e.g. "C:\Users\User\foo.txt"
	 */
	Path getOutputFilePath();
	
	/*
	 * Setter for instance variable outputFilePath
	 */
	void setOutputFilePath(Path outputFilePath);
	
	/*
	 * Getter for instance variable outputFileName
	 * returns the file name only 
	 * e.g. file C:\Users\User\foo.txt would return "foo.txt"
	 */
	Path getOutputFileName();
	
	/*
	 * Setter for instance variable outputFileName
	 */
	void setOutputFileName(String outputFileName);
	
	/*
	 * Getter for instance variable outputFileType
	 * returns the file type extension
	 * e.g. file C:\Users\User\foo.txt would return ".txt"
	 */
	String getOutputFileType();
	
	/*
	 * Setter for instance variable outputFileType
	 */
	void setOutputFileType(String outputFileType);
	
	/*
	 * Takes the contents of messageOut and writes them to outputFilePath
	 */
	void writeMessageOutToFile();
	

}
