/*
 * Config Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To create a package-private class for storing configuration data and methods
 * Version  0.0.1   9/29/17
 *          0.0.2   10/24/17  Added most of the instance variables from Enigma class
 *                            Added getters and setter for new instance variables
 *          0.0.3   10/26/17  Add log4j2 Logger into class
 *                            Add debugging statements for Logger
 */

package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import enigma.FileInputProcessor;
import enigma.KeyboardInputProcessor;
import enigma.OutputProcessor;
import rotors.Rotor;

class Config {
	
	// TODO - fill these with default values
	private static String inputFilePath = "./resources/misc/input.txt";
	private static String outputFilePath = "./resources/misc/output.txt";
	private static Rotor[] availableRotors;
	private static int inputMode = 1;
	private static int programMode = 1;
	private static int outputMode = 1;
	private static KeyboardInputProcessor keyboardIn;
	private static FileInputProcessor fileIn;
	private static OutputProcessor output;
	private static String plainText = "";
	private static String cypherText = "";
	private final static Logger logger = LogManager.getLogger(Config.class.getName());
	
	/*
	 * Getters and setters for instance variables
	 */
	static String getInputFilePath() {
		
		logger.debug("Running getInputFilePath()");
		
		logger.debug("getInputFilePath() completed successfully, returning {}", inputFilePath);
		return inputFilePath;
		
	}
	static void setInputFilePath(String input) {
		
		logger.debug("Running setInputFilePath({})", input);
		inputFilePath = input;
		
		logger.debug("setInputFilePath({}) completed successfully", input);
		
	}
	static String getOutputFilePath() {
		
		logger.debug("Running getOutputFilePath()");
		
		logger.debug("getOutputFilePath() completed successfully, returning {}", outputFilePath);
		return outputFilePath;
		
	}
	static void setOutputFilePath(String output) {
		
		logger.debug("Running setOutputFilePath({})", output);
		
		outputFilePath = output;
		
		logger.debug("setOutputFilePath({}) completed successfully", output);
		
	}
	static Rotor[] getAvailableRotors() {
		
		logger.debug("Running getAvailableRotors()");
		
		logger.debug("getAvailableRotors() completed successfully, returning {}", (Object)availableRotors);
		return availableRotors;
		
	}
	static int getInputMode() {
		
		logger.debug("Running getInputMode()");
		
		logger.debug("getInputMode() completed successfully, returning {}", inputMode);
		return inputMode;
		
	}
	static void setInputMode(int inputMode) {
		
		logger.debug("Calling setInputMode({})", inputMode);
		
		Config.inputMode = inputMode;
		
		logger.debug("setInputMode({}) completed successfully", inputMode);
	
	}
	public static KeyboardInputProcessor getKeyboardIn() {
		
		logger.debug("Running getKeyboardIn()");
		
		logger.debug("getKeyboardIn() completed successfully, returning {}", keyboardIn);
		return keyboardIn;
		
	}
	public static void setKeyboardIn(KeyboardInputProcessor keyboardIn) {
		
		logger.debug("Running setKeyboardIn({})", keyboardIn);
		
		Config.keyboardIn = keyboardIn;
		
		logger.debug("setKeyboardIn({}) completed successfully", keyboardIn);
		
	}
	public static String getPlainText() {
		
		logger.debug("Running getPlainText()");
		
		logger.debug("getPlainText() completed successfully");
		return plainText;
		
	}
	public static void setPlainText(String plainText) {
		
		logger.debug("Running setPlainText()");
		
		Config.plainText = plainText;
	
		logger.debug("setPlainText() completed successfully");
	
	}
	public static FileInputProcessor getFileIn() {
		
		logger.debug("Running getFileIn()");
		
		logger.debug("getfileIn() completed successfully returning {}", fileIn);
		return fileIn;
		
	}
	public static void setFileIn(FileInputProcessor fileIn) {
		
		logger.debug("Running setFileIn({})", fileIn);
		
		Config.fileIn = fileIn;
		
		logger.debug("setFileIn({}) completed successfully", fileIn);
		
	}
	public static int getProgramMode() {
		
		logger.debug("Running getProgramMode()");
		
		logger.debug("getProgramMode() completed successfully, returning {}", programMode);
		return programMode;
		
	}
	public static void setProgramMode(int programMode) {
		
		logger.debug("running setProgramMode({})", programMode);
		
		Config.programMode = programMode;
		
		logger.debug("setProgramMode({}) completed successfully", programMode);
		
	}
	public static String getCypherText() {
		
		logger.debug("Running getCypherText()");
		
		logger.debug("getCypherText() completed successfully");
		return cypherText;
		
	}
	public static void setCypherText(String cypherText) {
		
		logger.debug("running setCypherText()");
		
		Config.cypherText = cypherText;
		
		logger.debug("setCypherText() completed successfully");
		
	}
	public static OutputProcessor getOutput() {
		
		logger.debug("running getOutput()");
		
		logger.debug("getOutput() completed successfully");
		return output;
		
	}
	public static void setOutput(OutputProcessor output) {
		
		logger.debug("Running setOutput({})", output);
		
		Config.output = output;
		
		logger.debug("setOutput({}) completed successfully", output);
		
	}
	public static int getOutputMode() {
		
		logger.debug("Running getOutputMode()");
		
		logger.debug("getOutputMode() completed successfully");
		return outputMode;
		
	}
	public static void setOutputMode(int outputMode) {
		
		logger.debug("Running setOutputMode({})", outputMode);
		
		Config.outputMode = outputMode;
		
		logger.debug("setOutputMode({}) completed succesfully", outputMode);
		
	}

}
