/*
 * Utilities Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To create a public class for managing access to sensitive program utilities
 * Version  0.0.1   9/29/17
 * 			0.0.2	10/2/17		fill in load() method, add handleError() method
 *          0.0.2   10/24/17    adjusted load() method to prioritize most used methods
 *          0.0.3   10/25/17    Add log4j2 Logger into class
 *                              Add debugging statements for Logger
 *          0.0.4   10/26/17    Converted handleError() to static
 *          0.0.5   11/5/17     Add method for formatting file paths to .html
 *          0.0.6   11/6/17     Add method to initialize Config with default files
 *                              Add default constructor which calls the new Config initializer
 *                              Add method to create files in the file system
 *          0.0.7   11/9/17     Add method for extracting file extensions
 *          0.0.8   11/10/17    Convert formatHTMLFilePath into more generic foramtFilePath for more utility
 *          0.0.9   11/22/17    Remove unused load() method and Screens instance variable
 */

package utilities;

import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Utilities {        
	
	private final static Logger logger = LogManager.getLogger(Utilities.class.getName());
	
    /**
     * Adds specified extension to file names without an extension<br />
     * Changes existing file extensions to specified extension
     * @param	filePath	a String representing the absolute file path
     * @param	extension	a String containing a file extension without a leading dot (.)
     * @return				a String with the properly formatted file path, including extension
     */
    public static String formatFilePath(String filePath, String extension) {
    		
		logger.debug("Running formatFilePath({},{})", filePath, extension);
		
		String formattedFilePath;
		
		/*
		 * Regex:
		 * Starts with - ^
		 * Any number of any type of characters - (.+)
		 * Followed by a dot character - (\\.)
		 * Followed by extension - + extension + )
		 */
		if (!filePath.matches("^(.+)(\\." + extension + ")")) {
			
			logger.debug("Current file path not formatted correctly");
			
			/*
			 * Regex:
			 * Starts with - ^
			 * Any number of any type of characters - (.+)
			 * Followed by a dot character - (\\.)
			 * Followed by any number of any type of characters - (.+)
			 */
			if (filePath.matches("^(.+)(\\.)(.+)")) {
				
				logger.debug("Changing file extension to .{}", extension);
				formattedFilePath = filePath.substring(0, filePath.lastIndexOf("."));
				formattedFilePath += "." + extension;
				
			}
			else {
				
				logger.debug("Adding .{} file extension", extension);
				formattedFilePath = filePath + "." + extension;
				
			}
		}
		else {
			
			logger.debug("Current file path formatted correctly");
			formattedFilePath = filePath;
			
		}
		
		logger.debug("formatFilePath({},{}) completed successfully, returning {}", filePath, extension, formattedFilePath);
		return formattedFilePath;
		
	}
    
    /**
     * Creates a file on the client file system, including parent directories if necessary
     * @param	filePath	a String representing an absolute file path
     */
    public static void createFile(String filePath) {
    	
    	logger.debug("Running createFile()");
    	
    	logger.debug("Building new File({})", filePath);
    	File newFile = new File(filePath);
    	
    	logger.debug("Checking for existence of parent directory {}", newFile.getParent());
    	if (newFile.getParentFile().exists()) {
    		
	    	try {
	    		
	    		logger.debug("Parent directory {} exists, calling File.createNewFile()", newFile.getParent());
	    		newFile.createNewFile();
	    		
	    	}
	    	catch (IOException e) {
	    		
	    		logger.error("File error in createFile(): {}", e.getClass());
	    		
	    	}
	    	
    	}
    	else {
    		
    		try {
    			
    			logger.debug("Parent directory {} does not exist, creating directory", newFile.getParent());
    			newFile.getParentFile().mkdirs();
    			
    		}
    		catch (SecurityException e) {
    			
    			logger.error("File error in createFile(): {}", e.getClass());
    			
    		}
    		finally {
    			
    			try {
    				
    				logger.debug("Creating new file: {}", newFile.getName());
					newFile.createNewFile();
					
				}
    			catch (IOException e) {
    		
    				logger.error("File error in createFile(): {}", e.getClass());
		    		
				}
    			
    		}
    		
    	}
    	
    }
    
    /**
     * Identifies the file extension of a given {@link File}
     * @param	f	the File to be examined
     * @return		the file extension, omitting the dot (.) character
     */
    public static String getExtension(File f) {
    	
    	logger.debug("running getExtension({})", f);
    	
        String ext = "";
        String s = f.getName();
        
        if (s.contains(".")) {
        	
        	logger.debug("File has an extension");
	        int i = s.lastIndexOf('.');
	
	        if (i > 0 &&  i < s.length() - 1) {
	            ext = s.substring(i+1).toLowerCase();
	        }
        }
        else {
        	
        	logger.debug("File does not have an extension");
        	
        }
        
        logger.debug("getExtension({}) completed successfully returning {}", f, ext);
        return ext;
    }
    
    /**
     * Identifies the file extension of a given String
     * @param	f	the String to be examined, representing a path in a file system
     * @return		the file extension, omitting the dot (.) character
     */
    public static String getExtension(String f) {
    	
    	logger.debug("running getExtension({})", f);
    	
        String ext = "";
        
        if (f.contains(".")) {
        	
        	logger.debug("File has an extension");
	        int i = f.lastIndexOf('.');
	
	        if (i > 0 &&  i < f.length() - 1) {
	            ext = f.substring(i+1).toLowerCase();
	        }
        }
        else {
        	
        	logger.debug("File does not have an extension");
        	
        }
        
        logger.debug("getExtension({}) completed successfully returning {}", f, ext);
        return ext;
    }
    
}
