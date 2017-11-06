/*
 * FileSelector Class
 * Samuel Biondolillo
 * CIS220M:HY1 Object Oriented Programming
 * Goal: To create a class for generating dialog boxes for picking files to open/save
 * Version  0.0.1   11/5/17                 
 */

package utilities;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileSelector {
	
	private String filePath = "";	
	private JFileChooser fileChooser = null;
	
	@SuppressWarnings("serial")
	public FileSelector(String defaultDirectory) {

		fileChooser = new JFileChooser(defaultDirectory){
			
		    @Override
		    public void approveSelection(){
		    	
		        File f = getSelectedFile();
		        
		        if(f.exists() && getDialogType() == SAVE_DIALOG){
		        	
		            int result = JOptionPane.showConfirmDialog(this,
		            		"The file exists, overwrite?","Existing file",
		            		JOptionPane.YES_NO_OPTION);
		            
		            switch(result){
		            
		                case JOptionPane.YES_OPTION:
		                    super.approveSelection();
		                    return;
		                case JOptionPane.CANCEL_OPTION:
		                    cancelSelection();
		                    return;
		                default:
		                    return;
		                    
		            }
		            
		        }
		        
		        super.approveSelection();
		        
		    }   
		};
	
	}

	public String getFilePath() {

		return filePath;

	}

	public String selectOpenFilePath() {

		String openFilePath = "";
		int openResult = fileChooser.showOpenDialog(null);
		
        	if (openResult == JFileChooser.APPROVE_OPTION){
        	
           		File openFile = fileChooser.getSelectedFile();
           		openFilePath = openFile.getPath();
            	System.out.println("You selected: " + openFilePath);
            	if (openFile.canRead()) {
            	
           			System.out.println("Great, you can read from this file!");
           		}
           		else {
            	
           			System.out.println("Sorry, you can't read from this file!");
            	
           		}
            
        	} else if (openResult == JFileChooser.CANCEL_OPTION) {
        	
        		System.out.println("You didn't select a file to open.");
        	
        	}

		return openFilePath;
	}

	public String selectSaveFilePath() {

		String saveFilePath = "";
		int saveResult = fileChooser.showSaveDialog(null);
        
    	if (saveResult == JFileChooser.APPROVE_OPTION){
    	
        	File saveFile = fileChooser.getSelectedFile();
        	saveFilePath = saveFile.getPath();
        	System.out.println("You selected: " + saveFilePath);
        	
        	if (saveFile.canWrite()) {
        	
        		System.out.println("Great, you can write to this file!");
        	}
       	 	else {
        	
        		if (saveFile.exists()) {
        	
        			System.out.println("Sorry, you don't have permission to write to this file!");
        		
        		} else {
        		
        			try {
        			
        				saveFile.createNewFile();
        				System.out.println("Great, you can write to this file!");
        			
        			}
        			catch (IOException e) {
        			
        				System.out.println("Sorry, there was an error trying to write to this file: " + e.getClass());
        			}
        		
        		}
        	
        	}
        
    	} else if (saveResult == JFileChooser.CANCEL_OPTION) {
    	
    		System.out.println("You didn't select a file to save.");
    	
    	} 
        	
        return saveFilePath;
        
	}

}
