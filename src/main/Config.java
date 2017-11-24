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

public class Config {
	
	private static int programMode;
	private static String inputFilePath;
	private static String plainText;
	private static String outputFilePath;
	private static String cypherText;
	private final static Logger logger = LogManager.getLogger(Config.class.getName());
	
	/** @return the most recent Select Program Mode... selection */
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
	/** @return the most recent Select Input File... selection */
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
	/** @return the text of the file read into memory */
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
	/** @return the most recent Select Output File... selection */
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
	/** @return the encoded text set to be written out to file */
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

}
