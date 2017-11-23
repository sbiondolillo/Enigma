/*
 * OutputProcessor Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To provide an object to handle the output of our encoded messages in the Enigma
 * Version 	0.0.1 - 10/31/17
 *          0.0.2 - 11/1/17     Split Encryption/Decryption output processing into separate methods
 *          0.0.3 - 11/2/17     Fix formatting in displayDecryptedMessageOutToConsole()
 *          0.0.4 - 11/3/17     Minor fix to buildDecryptedHTMLFile(), should not have any '^' chars to strip
 *          0.0.5 - 11/9/17     Remove unnecessary newline characters from encrypted html file
 *                              to allow for proper parsing when encrypted html files are used as input
 *          0.0.6 - 11/10/17    Create methods for writing to .txt files
 *          0.0.7 - 11/23/17    Add flush() and close() buffer after writing to file
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
	 * Show the encrypted message on the console, properly formatted
	 */
	public void displayEncryptedMessageOutToConsole() {
		
		logger.debug("Running displayEncryptedMessageOutToConsole()");
		
		System.out.println("Here is your encrypted message:");
		String[] output = getEncryptedMessageOut();
		for (String line: output) {
			System.out.println(line);
		}
		
		logger.debug("displayEncryptedMessageOutToConsole() completed successfully");
		
	}
	
	/*
	 * Show the decrypted message on the console, properly formatted
	 */
	public void displayDecryptedMessageOutToConsole() {
		
		logger.debug("Running displayDecryptedMessageOutToConsole()");
		
		System.out.println("Here is your decrypted message:");
		String[] output = getDecryptedMessageOut();
		for (String line: output) {
			line = line.replaceAll("\\^", "");
			System.out.println(line);
		}
		
		logger.debug("displayDecryptedMessageOutToConsole() completed successfully");
		
	}
	
	/*
	 * Create an HTML file with the encrypted message and write it to file
	 */
	public void writeEncryptedMessageOutToFile() throws IOException {

		logger.debug("Running writeEncryptedMessageOutToFile()");

		String output;
		
		if (Utilities.getExtension(outputFilePath.toString()).equals("html")) {
			
			logger.debug("Calling buildEncryptedHTMLFile()");
			output = buildEncryptedHTMLFile();
			
		}
		else {
			
			logger.debug("Calling buildEncryptedTextFile()");
			output = buildEncryptedTextFile();
			
		}
		
		logger.debug("Writing to file");
		BufferedWriter writer = Files.newBufferedWriter(outputFilePath,Charset.forName("UTF-8"));
		writer.write(output);
		writer.flush();
		writer.close();

		logger.debug("writeEncryptedMessageOutToFile() completed successfully");

	}
	
	/*
	 * Create an HTML file with the decrypted message and write it to file
	 */
	public void writeDecryptedMessageOutToFile() throws IOException {

		logger.debug("Running writeDecryptedMessageOutToFile()");

		String output;
		
		if (Utilities.getExtension(outputFilePath.toString()).equals("html")) {
			
			logger.debug("Calling buildDecryptedHTMLFile()");
			output = buildDecryptedHTMLFile();
			
		}
		else {
			
			logger.debug("Calling buildDecryptedTextFile()");
			output = buildDecryptedTextFile();
			
		}
		
		logger.debug("Writing to file");
		BufferedWriter writer = Files.newBufferedWriter(outputFilePath,Charset.forName("UTF-8"));
		writer.write(output);
		writer.flush();
		writer.close();

		logger.debug("writeDecryptedMessageOutToFile() completed successfully");

	}

	/*
	 * Create an HTML file populated with our encrypted message
	 */
	private String buildEncryptedHTMLFile() {

		logger.debug("Running buildEncryptedHTMLFile()");

		logger.debug("Building HTML Header");
		String output = "";
		output += "<!DOCTYPE html><html>";
		output += "<head><title>Your private message</title></head>";
		output += "<body>";

		logger.debug("Calling getEncryptedMessageOut() and adding lines to HTML file");
		for (String line: getEncryptedMessageOut()) {
			output += line;
			output += "<br>";
		}

		logger.debug("Building HTML Footer");
		output += "</body></html>";

		logger.debug("buildEncryptedHTMLFile() completed successfully");
		return output;

	}
	
	/*
	 * Create an .txt file populated with our encrypted message
	 */
	private String buildEncryptedTextFile() {

		logger.debug("Running buildEncryptedTextFile()");
		
		String output = "";

		logger.debug("Calling getEncryptedMessageOut() and adding lines to .txt file");
		for (String line: getEncryptedMessageOut()) {
			output += line;
			output += "\n";
		}

		logger.debug("buildEncryptedTextFile() completed successfully");
		return output;

	}
	
	/*
	 * Create an HTML file populated with our decrypted message
	 */
	private String buildDecryptedHTMLFile() {

		logger.debug("Running buildDecryptedHTMLFile()");

		logger.debug("Building HTML Header");
		String output = "";
		output += "<!DOCTYPE html><html>";
		output += "<head><title>Your private message</title></head>";
		output += "<body>";

		logger.debug("Calling getDecryptedMessageOut() and adding lines to HTML file");
		for (String line: getDecryptedMessageOut()) {
			output += line;
			output += "<br>\n";
		}

		logger.debug("Building HTML Footer");
		output += "</body></html>";

		logger.debug("buildDecryptedHTMLFile() completed successfully");
		return output;

	}
	
	/*
	 * Create an .txt file populated with our decrypted message
	 */
	private String buildDecryptedTextFile() {

		logger.debug("Running buildDecryptedTextFile()");

		String output = "";

		logger.debug("Calling getDecryptedMessageOut() and adding lines to .txt file");
		for (String line: getDecryptedMessageOut()) {
			output += line;
			output += "\n";
		}

		logger.debug("buildDecryptedTextFile() completed successfully");
		return output;

	}

	/*
	 * Format the encrypted message per project specs
	 */
	private String[] getEncryptedMessageOut() {

		logger.debug("Running getEncryptedMessageOut()");

		String input = messageOut;

		logger.debug("Splitting input into tokens");
		String[] tokens = Iterables.toArray(
							Splitter
							.fixedLength(5)
							.split(input),
							String.class
							);

		logger.debug("getEncryptededMessageOut() completed successfully");
		return tokens;

	}
	
	/*
	 * Format the decrypted message per project specs
	 */
	private String[] getDecryptedMessageOut() {

		logger.debug("Running getDecryptedMessageOut()");

		String[] input = messageOut.split("\n");

		logger.debug("getDecryptededMessageOut() completed successfully");
		return input;

	}

}
