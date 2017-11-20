/*
 * FileSelector Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To create a class for generating dialog boxes for picking files to open/save
 * Version  0.0.1   11/5/17     
 *          0.0.2   11/6/17     Made class package-private and updated documentation
 *                              Add log4j2 Logger into class
 *                              Add debugging statements for Logger
 *          0.0.3   11/9/17     Add FileFilter to select only .txt or .html files
 *          0.0.4   11/15/17    Minor text formatting adjustment for style reasons   
 *          0.0.5   11/20/17    Modify Open/Save file selection to reject invalid/inaccessible paths
 */

package utilities;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class FileSelector {
	
	private String filePath = "";	
	private JFileChooser fileChooser = null;
	private final static Logger logger = LogManager.getLogger(FileSelector.class.getName());
	
	/*
	 * Constructor
	 * Builds a new FileSelector with the current directory set per parameter
	 * @param defaultDirectory - a String representing the directory the FileSelector will display on launch
	 */
	@SuppressWarnings("serial")
	public FileSelector(String defaultDirectory) {

		logger.debug("Building new FileSelector()");
		fileChooser = new JFileChooser(defaultDirectory){
			
			/*
			 * Modifies the JFileChooser dialog to prompt for confirmation before overwriting files
			 */
		    @Override
		    public void approveSelection(){
		    	
		    	logger.debug("Running approveSelection()");
		    	
		        File f = getSelectedFile();
		        
		        if(f.exists() && getDialogType() == SAVE_DIALOG){
		        	
		        	logger.debug("Showing overwrite confirmation dialog");
		            int result = JOptionPane.showConfirmDialog(this,
		            		"The file exists, overwrite?","Existing file",
		            		JOptionPane.YES_NO_OPTION);
		            
		            switch(result){
		            
		                case JOptionPane.YES_OPTION:
		                	logger.debug("User approved overwrite");
		                    super.approveSelection();
		                    return;
		                case JOptionPane.CANCEL_OPTION:
		                	logger.debug("User canceled overwrite");
		                    cancelSelection();
		                    return;
		                default:
		                	logger.debug("User exited dialog");
		                    return;
		                    
		            }
		            
		        }
		        
		        super.approveSelection();
		        logger.debug("approveSelection() completed successfully");
		    }   
		    
		};
		fileChooser.addChoosableFileFilter(new TextHTMLFilter());
		fileChooser.setAcceptAllFileFilterUsed(false);
	
	}

	/*
	 * Getters/setters for instance variables
	 */
	public String getFilePath() {

		logger.debug("Running approveSelection()");
		
		logger.debug("approveSelection() completed successfully, returning {}", filePath);
		return filePath;

	}

	/*
	 * Shows a dialog box which allows the user to select a file to be read into the program
	 */
	public String selectOpenFilePath() {

		logger.debug("Running selectOpenFilePath()");
		
		String openFilePath = "";
		
		logger.debug("Launching Open dialog box");
		int openResult = fileChooser.showOpenDialog(null);
		
    	if (openResult == JFileChooser.APPROVE_OPTION){
    	
    		logger.debug("User selected a file");
    		
       		File openFile = fileChooser.getSelectedFile();
       		openFilePath = openFile.getPath();
       		System.out.println();
        	System.out.println("You selected: " + openFilePath);
        	
        	logger.debug("Testing if user selected file is readable");
        	if (openFile.canRead()) {
        	
        		logger.debug("User selected file is readable");
       			System.out.println("Great, you can read from this file!");
       			
       		}
       		else {
        	
       			logger.debug("User selected file is not readable. Using default path.");
       			System.out.println("Sorry, you can't read from this file! Setting program to read from the default input file.");
       			
       			logger.debug("selectOpenFilePath() completed successfully, returning {}", Config.getDefaultInputFile());
       			return Config.getDefaultInputFile();
        	
       		}
        
    	} else if (openResult == JFileChooser.CANCEL_OPTION) {
    	
    		logger.debug("User canceled file selection");
    		System.out.println("You didn't select a file to open.");
    	
    	}

        logger.debug("selectOpenFilePath() completed successfully, returning {}", openFilePath);
		return openFilePath;
		
	}

	/*
	 * Shows a dialog box which allows the user to select a file for saving program output
	 */
	public String selectSaveFilePath() {

		logger.debug("Running selectSaveFilePath()");
		
		String saveFilePath = "";
		
		logger.debug("Launching Save dialog box");
		int saveResult = fileChooser.showSaveDialog(null);
        
    	if (saveResult == JFileChooser.APPROVE_OPTION){
    	
    		logger.debug("User selected a file");
    		
        	File saveFile = fileChooser.getSelectedFile();
        	saveFilePath = saveFile.getPath();
        	System.out.println();
        	System.out.println("You selected: " + saveFilePath);
        	
        	logger.debug("Testing if user selected file is writeable");
        	if (saveFile.canWrite()) {
        	
        		logger.debug("User selected file is writeable");
        		System.out.println("Great, you can write to this file!");
        		
        	}
       	 	else {
        	
       	 		logger.debug("User selected file is not writeable");
       	 		
        		if (saveFile.exists()) {
        	
        			logger.debug("User selected file exists, user lacks write permission");
        			System.out.println("Sorry, you don't have permission to write to this file! Using default path.");
        			
        			logger.debug("selectSaveFilePath() completed successfully, returning {}", Config.getDefaultOutputFile());
           			return Config.getDefaultOutputFile();
        		
        		}
        		else {
        		
        			logger.debug("User selected file does not exist, attempting to create it");
        			try {
        			
        				if (!Utilities.getExtension(saveFile).equals("html")) {
        					
        					logger.debug("User supplied invalid save file extension.");
        					
        					logger.debug("Calling Utilities.formatFilePath({},txt)", filePath);
        					saveFilePath = Utilities.formatFilePath(saveFilePath, "txt");
        					System.out.println("In order to proceed, your file will be saved as: " + saveFilePath);
        					saveFile = new File(saveFilePath);
        					
        				}
        				
        				logger.debug("Calling createNewFile()");
        				saveFile.createNewFile();
        				
        				logger.debug("User selected file created successfully");
        				System.out.println("Great, you can write to this file!");
        			
        			}
        			catch (IOException e) {
        			
        				System.out.println();
        				logger.error("File error in selectSaveFilePath(): {}", e.getClass());
        	    		
        	    		logger.debug("Calling handleError(file)");
        	    		Utilities.handleError("file");
        	    		
        			}
        		
        		}
        	
        	}
        
    	} else if (saveResult == JFileChooser.CANCEL_OPTION) {
    	
    		logger.debug("User canceled file selection");
    		System.out.println("You didn't select a file to save.");
    	
    	} 
        	
    	logger.debug("selectSaveFilePath() completed successfully, returning {}", saveFilePath);
        return saveFilePath;
        
	}
	
	private class TextHTMLFilter extends FileFilter{

		@Override
		public boolean accept(File f) {
			if (f.isDirectory()) {
		        return true;
		    }
			
			String extension = Utilities.getExtension(f);
		    if (extension != null) {
		        if (extension.equals("html") ||
		            extension.equals("txt")) {
		                return true;
		        } else {
		            return false;
		        }
		    }
		    
			return false;
		}

		@Override
		public String getDescription() {
			return ".txt or .html only";
		}

	}

}
