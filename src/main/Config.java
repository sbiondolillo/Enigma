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
 *          0.0.4   10/31/17  Add default file paths for input/output
 *                            Add instance variable for OutputProcessor and outputMode
 *          0.0.5   11/2/17   Add default path constants for input/output files
 *          0.0.6   11/6/17   Remove unused availableRotors[] field     
 */

package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fileIO.InputProcessor;
import fileIO.OutputProcessor;

public class Config {
	
	private final static String DEFAULT_INPUT_FILE = "./resources/misc/input.txt";
	private final static String DEFAULT_OUTPUT_FILE = "./resources/misc/output.html";
	private static int programMode = 0;
	private static String inputFilePath = DEFAULT_INPUT_FILE;
	private static InputProcessor fileIn;
	private static String plainText = "";
	private static String outputFilePath = DEFAULT_OUTPUT_FILE;
	private static OutputProcessor fileOut;
	private static String cypherText = "";
	private final static Logger logger = LogManager.getLogger(Config.class.getName());
	
	/*
	 * Getters and setters for instance variables
	 */
	public static int getProgramMode() {
		
		logger.debug("Running getProgramMode()");
		
		logger.debug("getProgramMode() completed successfully, returning {}", programMode);
		return programMode;
		
	}
	static void setProgramMode(int programMode) {
		
		logger.debug("Running setProgramMode({})", programMode);
		
		Config.programMode = programMode;
		
		logger.debug("setProgramMode({}) completed successfully", programMode);
		
	}
	public static String getInputFilePath() {
		
		logger.debug("Running getInputFilePath()");
		
		logger.debug("getInputFilePath() completed successfully, returning {}", inputFilePath);
		return inputFilePath;
		
	}
	static void setInputFilePath(String input) {
		
		logger.debug("Running setInputFilePath({})", input);
		inputFilePath = input;
		
		logger.debug("setInputFilePath({}) completed successfully", input);
		
	}
	public static InputProcessor getFileIn() {
		
		logger.debug("Running getFileIn()");
		
		logger.debug("getfileIn() completed successfully returning {}", fileIn);
		return fileIn;
		
	}
	static void setFileIn(InputProcessor fileIn) {
		
		logger.debug("Running setFileIn({})", fileIn);
		
		Config.fileIn = fileIn;
		
		logger.debug("setFileIn({}) completed successfully", fileIn);
		
	}
	public static String getPlainText() {
		
		logger.debug("Running getPlainText()");
		
		logger.debug("getPlainText() completed successfully");
		return plainText;
		
	}
	static void setPlainText(String plainText) {
		
		logger.debug("Running setPlainText()");
		
		Config.plainText = plainText;
	
		logger.debug("setPlainText() completed successfully");
	
	}
	public static String getOutputFilePath() {
		
		logger.debug("Running getOutputFilePath()");
		
		logger.debug("getOutputFilePath() completed successfully, returning {}", outputFilePath);
		return outputFilePath;
		
	}
	static void setOutputFilePath(String output) {
		
		logger.debug("Running setOutputFilePath({})", output);
		
		outputFilePath = output;
		
		logger.debug("setOutputFilePath({}) completed successfully", output);
		
	}
	public static OutputProcessor getOutput() {
		
		logger.debug("Running getOutput()");
		
		logger.debug("getOutput() completed successfully, returning {}", fileOut);
		return fileOut;
		
	}
	static void setOutput(OutputProcessor output) {
		
		logger.debug("Running setOutput({})", output);
		
		Config.fileOut = output;
		
		logger.debug("setOutput({}) completed successfully", output);
		
	}
	public static String getCypherText() {
		
		logger.debug("Running getCypherText()");
		
		logger.debug("getCypherText() completed successfully");
		return cypherText;
		
	}
	static void setCypherText(String cypherText) {
		
		logger.debug("Running setCypherText()");
		
		Config.cypherText = cypherText;
		
		logger.debug("setCypherText() completed successfully");
		
	}
	public static String getDefaultInputFile() {
		
		logger.debug("Running getDefaultInputFile()");
		
		logger.debug("getDefaultInputFile() completed successfully, returning {}", DEFAULT_INPUT_FILE);
		return DEFAULT_INPUT_FILE;
		
	}
	public static String getDefaultOutputFile() {
		
		logger.debug("Running getDefaultOutputFile()");
		
		logger.debug("getDefaultOutputFile() completed successfully, returning {}", DEFAULT_OUTPUT_FILE);
		return DEFAULT_OUTPUT_FILE;
		
	}

}
