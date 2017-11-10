/*
 * HTMLParser Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To create a class for converting html text into plain text suitable for encrypting
 * Version  0.0.1   11/9/17     
 */

package enigma;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.safety.Whitelist;

public class HTMLParser {

	private Document doc = null;
	private OutputSettings outputSettings = new Document.OutputSettings().prettyPrint(false);
	
	/*
	 * Convert plain HTML text into text for the Enigma
	 */
	public String parseHTMLString(String rawHTML) {
		
		String output = "";
		doc = Jsoup.parse(rawHTML);
		output = reformatHTML();
		return output;
		
	}
	
	/*
	 * Convert a full HTML file into text for the Enigma
	 */
	public String parseHTMLFile(File file) {
		
		String output = "";
		try {
			doc = Jsoup.parse(file, "UTF-8", "");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			output = reformatHTML();
		}
		return output;
	}
	
	/*
	 * Apply the desired parsing methods from Jsoup
	 */
	private String reformatHTML() {
		String output = "";
		doc.outputSettings(outputSettings);
		String cleanBody = doc.select("body").html();
		output = Jsoup.clean(cleanBody, "", Whitelist.none(), outputSettings);
		return output;
	}
}
