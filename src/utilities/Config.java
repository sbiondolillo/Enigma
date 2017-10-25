/*
 * Config Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To create a package-private class for storing configuration data and methods
 * Version  0.0.1   9/29/17
 *          0.0.2   10/24/17 - Added most of the instance variables from Enigma class
 *                             Added getters and setter for new instance variables
 */

package utilities;

import enigma.FileInputProcessor;
import enigma.KeyboardInputProcessor;
import rotors.Rotor;

class Config {
	
	// TODO - fill these with default values
	private static String inputFilePath;
	private static String outputFilePath;
	private static Rotor[] availableRotors;
	private static int inputMode = 1;
	private static int programMode = 1;
	private static KeyboardInputProcessor keyboardIn;
	private static FileInputProcessor fileIn;
	private static String plainText = "";
	private static String cypherText = "";
	
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
	static Rotor[] getAvailableRotors() {
		return availableRotors;
	}
	static int getInputMode() {
		return inputMode;
	}
	static void setInputMode(int inputMode) {
		Config.inputMode = inputMode;
	}
	public static KeyboardInputProcessor getKeyboardIn() {
		return keyboardIn;
	}
	public static void setKeyboardIn(KeyboardInputProcessor keyboardIn) {
		Config.keyboardIn = keyboardIn;
	}
	public static String getPlainText() {
		return plainText;
	}
	public static void setPlainText(String plainText) {
		Config.plainText = plainText;
	}
	public static FileInputProcessor getFileIn() {
		return fileIn;
	}
	public static void setFileIn(FileInputProcessor fileIn) {
		Config.fileIn = fileIn;
	}
	public static int getProgramMode() {
		return programMode;
	}
	public static void setProgramMode(int programMode) {
		Config.programMode = programMode;
	}
	public static String getCypherText() {
		return cypherText;
	}
	public static void setCypherText(String cypherText) {
		Config.cypherText = cypherText;
	}

}
