/*
 * Config Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To create a package-private class for storing configuration data and methods
 * Version  0.0.1   9/29/17
 */

package utilities;

import java.nio.file.Path;
import rotors.Rotor;

class Config {
	
	// TODO - fill these with default values
	private static String inputFilePath;
	private static String outputFilePath;
	private static Rotor[] availableRotors;
	
	/*
	 * Getters and setters for instance variables
	 */
	static String getInputFilePath() {
		return inputFilePath;
	}
	static void setInputFilePath(String input) {
		inputFilePath = input;
	}
	static String getOutputFilePath() {
		return outputFilePath;
	}
	static void setOutputFilePath(String output) {
		outputFilePath = output;
	}
	Rotor[] getAvailableRotors() {
		return availableRotors;
	}

}
