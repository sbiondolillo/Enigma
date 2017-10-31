/*
 * OutputProcessor Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To provide an object to handle the output of our encoded messages in the Enigma
 * Version 	0.0.1 - 10/31/17
 */

package enigma;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

import utilities.Utilities;

public class OutputProcessor {
	
	private String messageOut = "";
	private Path outputFilePath;
	private final static Logger logger = LogManager.getLogger(OutputProcessor.class.getName());
	
	/*
	 *  Getters and setters for instance variables
	 */
	public String getMessageOut() {

		logger.debug("Running getMessageOut()");

		logger.debug("getMessageOut() completed successfully");
		return messageOut;

	}
	public void setMessageOut(String messageOut) {

		logger.debug("Running setMessageOut()");

		this.messageOut = messageOut;

		logger.debug("setMessageOut() completed successfully");

	}
	public Path getOutputFilePath() {

		logger.debug("Running getOutputFilePath()");

		logger.debug("getOutputFilePath() completed successfully");
		return outputFilePath;
	}
	public void setOutputFilePath(Path outputFilePath) {

		logger.debug("Running setOutputFilePath({})", outputFilePath);

		this.outputFilePath = outputFilePath;

		logger.debug("setOutputFilePath({}) completed successfully", outputFilePath);

	}

	/*
	 * Show the encoded message on the console, properly formatted
	 */
	public void displayMessageOutToConsole() {
		
		logger.debug("Running displayMessageOutToConsole()");
		
		System.out.println("Here is your processed message:");
		String[] output = getFormattedMessageOut();
		for (String line: output) {
			System.out.println(line);
		}
		
		logger.debug("displayMessageOutToConsole() completed successfully");
		
	}
	/*
	 * Create an HTML file with the encoded message and write it to file
	 */
	public void writeMessageOutToFile() {

		logger.debug("Running writeMessageOutToFile()");

		logger.debug("Calling buildHTMLFile()");
		String output = buildHTMLFile();

		
		logger.debug("Writing to file");
		try  (BufferedWriter writer = Files.newBufferedWriter(outputFilePath,Charset.forName("UTF-8"))){
			writer.write(output);
		}
		catch (IOException e) {
			logger.error("File error in writeMessageOutToFile(): " + e);
			logger.error("Calling Errors.handleError(file)");
			Utilities.handleError("file");
		}

		logger.debug("writeMessageOutToFile() completed successfully");

	}

	/*
	 * Create an HTML file populated with our encoded message
	 */
	private String buildHTMLFile() {

		logger.debug("Running buildHTMLFile()");

		logger.debug("Building HTML Header");
		String output = "";
		output += "<!DOCTYPE html>\n<html>\n";
		output += "<head>\n<title>Your private message</title>\n</head>\n";
		output += "<body>\n<p>\n";

		logger.debug("Calling getFormattedMessageOut() and adding lines to HTML file");
		for (String line: getFormattedMessageOut()) {
			output += line;
			output += "<br>\n";
		}

		logger.debug("Building HTML Footer");
		output += "</p>\n</body>\n</html>";

		logger.debug("buildHTMLFile() completed successfully");
		return output;

	}

	/*
	 * Format the encoded message per project specs
	 */
	private String[] getFormattedMessageOut() {

		logger.debug("Running getFormattedMessageOut()");

		String input= messageOut;

		logger.debug("Splitting input into tokens");
		String[] tokens = Iterables.toArray(
							Splitter
							.fixedLength(5)
							.split(input),
							String.class
							);

		logger.debug("getFormattedMessageOut() completed successfully");
		return tokens;

	}

}
