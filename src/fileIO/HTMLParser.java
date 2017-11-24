/*
 * HTMLParser Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To create a class for converting html text into plain text suitable for encrypting
 * Version  0.0.1   11/9/17     
 */

package fileIO;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.safety.Whitelist;

public class HTMLParser {

	private Document doc = null;
	private OutputSettings outputSettings = new Document.OutputSettings().prettyPrint(false);
	private final static Logger logger = LogManager.getLogger(HTMLParser.class.getName());
	
	/**
	 * Convert formatted HTML text into plain text
	 * @param	rawHTML	a String containing formatted HTML text
	 * @return a String containing text scraped from rawHTML
	 */
	public String parseHTMLString(String rawHTML) {
		
		logger.debug("Running parseHTMLString()");
		
		String output = "";
		doc = Jsoup.parse(rawHTML);
		
		logger.debug("Calling reformatHTML()");
		output = reformatHTML();
		
		logger.debug("parseHTMLString() completed successfully");
		return output;
		
	}
	
	/**
	 * Converts a full HTML File into plain text
	 * @param	file	an HTML File
	 * @return a String containing text scraped from file
	 */
	public String parseHTMLFile(File file) {
		
		logger.debug("Running parseHTMLFile()");
		
		String output = "";
		try {
			
			doc = Jsoup.parse(file, "UTF-8", "");
			
		}
		catch (IOException e) {
			
			e.printStackTrace();
			
		}
		finally {
			
			logger.debug("Calling reformatHTML()");
			output = reformatHTML();
			
		}
		
		logger.debug("parseHTMLFile() completed successfully");
		return output;
		
	}
	
	/*
	 * Apply the desired parsing methods from Jsoup
	 */
	private String reformatHTML() {
		
		logger.debug("Running reformatHTML()");
		
		logger.debug("Formatting text");
		String output = "";
		doc.outputSettings(outputSettings);
		String cleanBody = doc.select("body").html();
		output = Jsoup.clean(cleanBody, "", Whitelist.none(), outputSettings);
		
		logger.debug("reformatHTML() completed successfully");
		return output;
		
	}
	
}
