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
 *          0.0.6   11/22/17    Remove console print statements
 */

package forms;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.Config;
import utilities.Utilities;

@SuppressWarnings("serial")
public class FileSelector {
	
	private Font font = new Font("Segoe UI", Font.PLAIN, 18);
	private String filePath = "";	
	private JFileChooser fileChooser = null;
	private final static Logger logger = LogManager.getLogger(FileSelector.class.getName());
	
	/**
	 * Constructor<br />
	 * <br />
	 * Builds a new FileSelector for a given directory
	 * @param defaultDirectory - a String representing the initial directory
	 */
	public FileSelector(String defaultDirectory) {

		logger.debug("Building new FileSelector()");
		
		logger.debug("Building new JFileChooser({})", defaultDirectory);
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
		
		logger.debug("Adding file filters to JFileChooser");
		fileChooser.addChoosableFileFilter(new TextHTMLFilter());
		fileChooser.setAcceptAllFileFilterUsed(false);
		setFileChooserFont(fileChooser.getComponents());
		
		logger.debug("new FileSelector() completed successfully");
	
	}

	/** @return a String representing the file chosen by the user */
	public String getFilePath() {

		logger.debug("Running approveSelection()");
		
		logger.debug("approveSelection() completed successfully, returning {}", filePath);
		return filePath;

	}

	/**
	 * Shows a dialog box for selecting a file to be read into the program
	 * @param parent the {@link Component} from which the FileSelector was launched
	 */
	public String selectOpenFilePath(Component parent) {

		logger.debug("Running selectOpenFilePath()");
		
		String openFilePath = Config.getInputFilePath();
		
		logger.debug("Launching Open dialog box");
		int openResult = fileChooser.showOpenDialog(parent);
		
    	if (openResult == JFileChooser.APPROVE_OPTION){
    	
    		logger.debug("User selected a file");
    		
       		File openFile = fileChooser.getSelectedFile();
       		openFilePath = openFile.getPath();
        	
        	logger.debug("Testing if user selected file is readable");
        	if (openFile.canRead()) {
        	
        		logger.debug("User selected file is readable");
       			
       		}
       		else {
        	
       			logger.debug("User selected file is not readable. Using current path.");
       			
       			logger.debug("selectOpenFilePath() completed successfully, returning {}", Config.getInputFilePath());
       			return Config.getInputFilePath();
        	
       		}
        
    	} else if (openResult == JFileChooser.CANCEL_OPTION) {
    	
    		logger.debug("User canceled file selection");
    	
    	}

        logger.debug("selectOpenFilePath() completed successfully, returning {}", openFilePath);
		return openFilePath;
		
	}

	/**
	 * Shows a dialog box which allows the user to select a file for saving program output
	 * @param parent the {@link Component} from which the FileSelector was launched
	 */
	public String selectSaveFilePath(Component parent) {

		logger.debug("Running selectSaveFilePath()");
		
		String saveFilePath = Config.getOutputFilePath();
		
		logger.debug("Launching Save dialog box");
		int saveResult = fileChooser.showSaveDialog(parent);
        
    	if (saveResult == JFileChooser.APPROVE_OPTION){
    	
    		logger.debug("User selected a file");
    		
        	File saveFile = fileChooser.getSelectedFile();
        	saveFilePath = saveFile.getPath();
        	
        	logger.debug("Testing if user selected file is writeable");
        	if (saveFile.canWrite()) {
        	
        		logger.debug("User selected file is writeable");
        		
        	}
       	 	else {
        	
       	 		logger.debug("User selected file is not writeable");
       	 		
        		if (saveFile.exists()) {
        	
        			logger.debug("User selected file exists, user lacks write permission");
        			
        			logger.debug("selectSaveFilePath() completed successfully, returning {}", Config.getOutputFilePath());
           			return Config.getOutputFilePath();
        		
        		}
        		else {
        		
        			logger.debug("User selected file does not exist, attempting to create it");
        			try {
        			
        				if (!Utilities.getExtension(saveFile).equals("html")) {
        					
        					logger.debug("User supplied invalid save file extension.");
        					
        					logger.debug("Calling Utilities.formatFilePath({},txt)", filePath);
        					saveFilePath = Utilities.formatFilePath(saveFilePath, "txt");
        					saveFile = new File(saveFilePath);
        					
        				}
        				
        				logger.debug("Calling createNewFile()");
        				saveFile.createNewFile();
        				
        				logger.debug("User selected file created successfully");
        			
        			}
        			catch (IOException e) {
        			
        				logger.error("File error in selectSaveFilePath(): {}", e.getClass());
        	    		
        			}
        		
        		}
        	
        	}
        
    	} else if (saveResult == JFileChooser.CANCEL_OPTION) {
    	
    		logger.debug("User canceled file selection");
    	
    	} 
        	
    	logger.debug("selectSaveFilePath() completed successfully, returning {}", saveFilePath);
        return saveFilePath;
        
	}
	
	/*
	 * Recursively update the components of the FileSelector with the preferred font
	 */
	private void setFileChooserFont(Component[] comp) {
		
		for(int x = 0; x < comp.length; x++) {
			
			if(comp[x] instanceof Container)
		    	
		    	setFileChooserFont(((Container)comp[x]).getComponents()); 
		    
		    try {
		    	
		    	comp[x].setFont(font);
		    	
		    }  
		    catch(Exception e) {
		    	
		    	// do nothing
		    	
		    } 
		}  
    } 
	
	/**
	 * 
	 * Builds a custom FileFilter for use in JFileChoosers<br />
	 * allows only .txt and .html files
	 */
	private class TextHTMLFilter extends FileFilter{

		/**
		 * Specifies the acceptable file extensions
		 */
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

		/**
		 * Adds descriptive text to the JFileChooser dialog
		 */
		@Override
		public String getDescription() {
			return ".txt or .html only";
		}

	}

}
