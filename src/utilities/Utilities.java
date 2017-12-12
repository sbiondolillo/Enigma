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
