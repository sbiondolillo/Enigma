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
 *                              Remove console writing methods
 */

package fileIO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

import interfaces.FileOutput;
import main.Config;
import utilities.Utilities;

public class OutputProcessor implements FileOutput {
	
	private String messageOut;
	private String outputFilePath;
	private final static Logger logger = LogManager.getLogger(OutputProcessor.class.getName());
	
	/*
	 * Interface Implementations
	 */
	@Override
	public String getMessageOut() {

		logger.debug("Running getMessageOut()");

		logger.debug("getMessageOut() completed successfully");
		return messageOut;

	}
	
	@Override
	public void setMessageOut(String messageOut) {

		logger.debug("Running setMessageOut()");

		this.messageOut = messageOut;

		logger.debug("setMessageOut() completed successfully");

	}
	
	@Override
	public String getOutputFilePath() {

		logger.debug("Running getOutputFilePath()");

		logger.debug("getOutputFilePath() completed successfully");
		return outputFilePath;
	}
	
	@Override
	public void setOutputFilePath(String outputFilePath) {

		logger.debug("Running setOutputFilePath({})", outputFilePath);

		this.outputFilePath = outputFilePath;

		logger.debug("setOutputFilePath({}) completed successfully", outputFilePath);

	}
	
	@Override
	public void writeMessageOutToFile() throws IOException {
		
		logger.debug("running writeMessageOutToFile");
		
		if (Config.getProgramMode() == 0) {
			
			logger.debug("Calling writeEncryptedMessageOutToFile()");
			writeEncryptedMessageOutToFile();
			
		}
		else {
			
			logger.debug("Calling writeDecryptedMessageOutToFile");
			writeDecryptedMessageOutToFile();
			
		}
		
		logger.debug("writeMessageOutToFile completed successfully");
		
	}
	
	/*
	 * Creates an HTML file with the encrypted message and writes it to file
	 */
	private void writeEncryptedMessageOutToFile() throws IOException {

		logger.debug("Running writeEncryptedMessageOutToFile()");

		String output;
		
		if (Utilities.getExtension(outputFilePath).equals("html")) {
			
			logger.debug("Calling buildEncryptedHTMLFile()");
			output = buildEncryptedHTMLFile();
			
		}
		else {
			
			logger.debug("Calling buildEncryptedTextFile()");
			output = buildEncryptedTextFile();
			
		}
		
		logger.debug("Writing to file");
		BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFilePath),Charset.forName("UTF-8"));
		writer.write(output);
		writer.flush();
		writer.close();

		logger.debug("writeEncryptedMessageOutToFile() completed successfully");

	}
	
	/*
	 * Creates an HTML file with the decrypted message and writes it to file
	 */
	private void writeDecryptedMessageOutToFile() throws IOException {

		logger.debug("Running writeDecryptedMessageOutToFile()");

		String output;
		
		if (Utilities.getExtension(outputFilePath).equals("html")) {
			
			logger.debug("Calling buildDecryptedHTMLFile()");
			output = buildDecryptedHTMLFile();
			
		}
		else {
			
			logger.debug("Calling buildDecryptedTextFile()");
			output = buildDecryptedTextFile();
			
		}
		
		logger.debug("Writing to file");
		BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFilePath),Charset.forName("UTF-8"));
		writer.write(output);
		writer.flush();
		writer.close();

		logger.debug("writeDecryptedMessageOutToFile() completed successfully");

	}

	/*
	 * Creates an HTML file with the encrypted message in the body
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
	 * Creates a .txt file populated with the encrypted message
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
	 * Creates an HTML file with the decrypted message in the body
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
	 * Creates a .txt file populated with the decrypted message
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
	 * Formats the encrypted message as five characters per line
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
	 * Formats the decrypted message as in the original message
	 */
	private String[] getDecryptedMessageOut() {

		logger.debug("Running getDecryptedMessageOut()");

		String[] input = messageOut.split("\n");

		logger.debug("getDecryptededMessageOut() completed successfully");
		return input;

	}

}
