package interfaces;

import java.io.IOException;

public interface FileOutput {
	
	/** @return the string set to be written out to file */
	String getMessageOut();
	
	/**
	 * Stores text to be written out to file at a later time
	 * @param messageOut	the String to be written
	 */
	void setMessageOut(String messageOut);
	
	/** @return the String representing the file path where program output will be written */
	String getOutputFilePath();
	
	/**
	 * Specifies where program output will be written
	 * @param outputFilePath	the String representing the absolute file path
	 */
	void setOutputFilePath(String outputFilePath);
	
	/**
	 * Takes the contents of messageOut and writes them to outputFilePath
	 * @exception IOException should be handled by the calling method
	 */
	void writeMessageOutToFile() throws IOException;
	

}
