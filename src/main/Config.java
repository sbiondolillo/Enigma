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
