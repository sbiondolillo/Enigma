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
	private Path inputFilePath;
	private Path outputFilePath;
	private Rotor[] availableRotors;
	
	/*
	 * Getters and setters for instance variables
	 */
	Path getInputFilePath() {
		return inputFilePath;
	}
	void setInputFilePath(Path input) {
		inputFilePath = input;
	}
	Path getOutputFilePath() {
		return outputFilePath;
	}
	void setOutputFilePath(Path output) {
		outputFilePath = output;
	}
	Rotor[] getAvailableRotors() {
		return availableRotors;
	}

}
