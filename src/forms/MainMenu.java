/*
 * Created by JFormDesigner on Wed Nov 22 14:15:59 EST 2017
 */

package forms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.Config;
import main.ScreenManager;

/**
 * @author Samuel Biondolillo
 */
public class MainMenu  {
	
	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Samuel Biondolillo
	private JFrame MainMenu;
	private JMenuBar MainMenuBar;
	private JMenu FileMenu;
	private JMenuItem FileMenuItemHelp;
	private JMenuItem FileMenuItemAbout;
	private JMenuItem FileMenuItemExit;
	private JMenu SettingsMenu;
	private JMenuItem SettingsMenuItemProgramMode;
	private JMenuItem SettingsMenuItemInputFile;
	private JMenuItem SettingsMenuItemOutputFile;
	private JMenuItem SettingsMenuItemValidChars;
	private JLabel SettingsMenuPromptLabel;
	private JLabel ProgramModeLabel;
	private JLabel InputFileLabel;
	private JTextField InputFileTextField;
	private JTextField OutputFileTextField;
	private JButton RunButton;
	private JTextField ProgramModeTextField;
	private JLabel OutputFileLabel;
	private JLabel RunButtonPromptLabel;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	private final static Logger logger = LogManager.getLogger(MainMenu.class.getName());

	/** Launch the Main Program Menu */
	public void show() {
		
		logger.debug("Running show()");
		
		logger.debug("Calling initComponents()");
		initComponents();
		
		logger.debug("Setting MainMenu to visible");
		MainMenu.setVisible(true);
		
		logger.debug("show() completed successfully");
		
	}

	/*
	 * Set up all the parts of the MainMenu
	 */
	private void initComponents() {
		
		logger.debug("Running initComponents()");
		
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Samuel Biondolillo
		MainMenu = new JFrame();
		MainMenuBar = new JMenuBar();
		FileMenu = new JMenu();
		FileMenuItemHelp = new JMenuItem();
		FileMenuItemAbout = new JMenuItem();
		FileMenuItemExit = new JMenuItem();
		SettingsMenu = new JMenu();
		SettingsMenuItemProgramMode = new JMenuItem();
		SettingsMenuItemInputFile = new JMenuItem();
		SettingsMenuItemOutputFile = new JMenuItem();
		SettingsMenuItemValidChars = new JMenuItem();
		SettingsMenuPromptLabel = new JLabel();
		ProgramModeLabel = new JLabel();
		InputFileLabel = new JLabel();
		InputFileTextField = new JTextField();
		OutputFileTextField = new JTextField();
		RunButton = new JButton();
		ProgramModeTextField = new JTextField();
		OutputFileLabel = new JLabel();
		RunButtonPromptLabel = new JLabel();

		//======== MainMenu ========
		{
			MainMenu.setTitle("Welcome to the Enigma!");
			MainMenu.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			MainMenu.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					MainMenuWindowClosing(e);
				}
				@Override
				public void windowOpened(WindowEvent e) {
					MainMenuWindowOpened(e);
				}
			});
			Container MainMenuContentPane = MainMenu.getContentPane();

			//======== MainMenuBar ========
			{

				//======== FileMenu ========
				{
					FileMenu.setText("File");

					//---- FileMenuItemHelp ----
					FileMenuItemHelp.setText("Help");
					FileMenuItemHelp.addActionListener(e -> FileMenuItemHelpActionPerformed(e));
					FileMenu.add(FileMenuItemHelp);

					//---- FileMenuItemAbout ----
					FileMenuItemAbout.setText("About");
					FileMenuItemAbout.addActionListener(e -> FileMenuItemAboutActionPerformed(e));
					FileMenu.add(FileMenuItemAbout);

					//---- FileMenuItemExit ----
					FileMenuItemExit.setText("Exit");
					FileMenuItemExit.setToolTipText("Exit the Enigma");
					FileMenuItemExit.addActionListener(e -> FileMenuItemExitActionPerformed(e));
					FileMenu.add(FileMenuItemExit);
				}
				MainMenuBar.add(FileMenu);

				//======== SettingsMenu ========
				{
					SettingsMenu.setText("Settings");

					//---- SettingsMenuItemProgramMode ----
					SettingsMenuItemProgramMode.setText("Select Program Mode...");
					SettingsMenuItemProgramMode.addActionListener(e -> SettingsMenuItemProgramModeActionPerformed(e));
					SettingsMenu.add(SettingsMenuItemProgramMode);

					//---- SettingsMenuItemInputFile ----
					SettingsMenuItemInputFile.setText("Select Input File...");
					SettingsMenuItemInputFile.addActionListener(e -> SettingsMenuItemInputFileActionPerformed(e));
					SettingsMenu.add(SettingsMenuItemInputFile);

					//---- SettingsMenuItemOutputFile ----
					SettingsMenuItemOutputFile.setText("Select Output File...");
					SettingsMenuItemOutputFile.addActionListener(e -> SettingsMenuItemOutputFileActionPerformed(e));
					SettingsMenu.add(SettingsMenuItemOutputFile);

					//---- SettingsMenuItemValidChars ----
					SettingsMenuItemValidChars.setText("Valid Characters...");
					SettingsMenuItemValidChars.addActionListener(e -> SettingsMenuItemValidCharsActionPerformed(e));
					SettingsMenu.add(SettingsMenuItemValidChars);
				}
				MainMenuBar.add(SettingsMenu);
			}
			MainMenu.setJMenuBar(MainMenuBar);

			//---- SettingsMenuPromptLabel ----
			SettingsMenuPromptLabel.setText("Use the Settings menu above to change these settings...");

			//---- ProgramModeLabel ----
			ProgramModeLabel.setText("Program Mode:");

			//---- InputFileLabel ----
			InputFileLabel.setText("Input File:");

			//---- InputFileTextField ----
			InputFileTextField.setEnabled(false);
			InputFileTextField.setDisabledTextColor(new Color(153, 153, 153));

			//---- OutputFileTextField ----
			OutputFileTextField.setEnabled(false);
			OutputFileTextField.setDisabledTextColor(new Color(153, 153, 153));

			//---- RunButton ----
			RunButton.setText("Run!");
			RunButton.addActionListener(e -> RunButtonActionPerformed(e));

			//---- ProgramModeTextField ----
			ProgramModeTextField.setEnabled(false);
			ProgramModeTextField.setDisabledTextColor(new Color(153, 153, 153));

			//---- OutputFileLabel ----
			OutputFileLabel.setText("Output File:");

			//---- RunButtonPromptLabel ----
			RunButtonPromptLabel.setText("Click the Run! button when you are ready to process your message -->");

			GroupLayout MainMenuContentPaneLayout = new GroupLayout(MainMenuContentPane);
			MainMenuContentPane.setLayout(MainMenuContentPaneLayout);
			MainMenuContentPaneLayout.setHorizontalGroup(
				MainMenuContentPaneLayout.createParallelGroup()
					.addGroup(GroupLayout.Alignment.TRAILING, MainMenuContentPaneLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(MainMenuContentPaneLayout.createParallelGroup()
							.addComponent(SettingsMenuPromptLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(MainMenuContentPaneLayout.createSequentialGroup()
								.addComponent(RunButtonPromptLabel)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(RunButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
							.addGroup(MainMenuContentPaneLayout.createSequentialGroup()
								.addComponent(ProgramModeLabel)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(ProgramModeTextField, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))
							.addGroup(MainMenuContentPaneLayout.createSequentialGroup()
								.addGroup(MainMenuContentPaneLayout.createParallelGroup()
									.addComponent(OutputFileLabel)
									.addComponent(InputFileLabel))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(MainMenuContentPaneLayout.createParallelGroup()
									.addComponent(InputFileTextField)
									.addComponent(OutputFileTextField))))
						.addContainerGap())
			);
			MainMenuContentPaneLayout.setVerticalGroup(
				MainMenuContentPaneLayout.createParallelGroup()
					.addGroup(MainMenuContentPaneLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(SettingsMenuPromptLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(MainMenuContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(ProgramModeLabel)
							.addComponent(ProgramModeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(MainMenuContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(InputFileLabel)
							.addComponent(InputFileTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(MainMenuContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(OutputFileLabel)
							.addComponent(OutputFileTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(MainMenuContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(RunButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addComponent(RunButtonPromptLabel))
						.addContainerGap(15, Short.MAX_VALUE))
			);
			MainMenu.pack();
			MainMenu.setLocationRelativeTo(MainMenu.getOwner());
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
		logger.debug("initComponents() completed successfully");
	}

	/*
	 * MainMenu show events
	 */
	private void MainMenuWindowOpened(WindowEvent e) {
		
		logger.debug("Running MainMenuWindowOpened()");
		
		logger.debug("Calling initializeTextFields()");
		initializeTextFields();
		
		logger.debug("initComponents() completed successfully");
		
	}
	
	/*
	 * Set the text fields of the MainMenu to show current Config settings
	 */
	private void initializeTextFields() {
		
		logger.debug("Running initializeTextFields()");
		
		logger.debug("Setting text fields based on Config values");
		
		logger.debug("Calling determineProgramMode()");
		String mode = determineProgramMode();
		ProgramModeTextField.setText(mode);
		
		logger.debug("Calling getInputFilePath()");
		InputFileTextField.setText(Config.getInputFilePath());
		
		logger.debug("Calling getOutputFilePath()");
		OutputFileTextField.setText(Config.getOutputFilePath());
		
		logger.debug("initializeTextFields() completed successfully");
		
	}
	
	/* @return the current programMode in Config */
	private String determineProgramMode() {
		
		logger.debug("Running determinProgramMode()");
		
		String mode;
		
		logger.debug("Calling getProgramMode()");
		if (Config.getProgramMode() == 0)
			mode = "Encrypt";
		else
			mode = "Decrypt";
		
		logger.debug("determinProgramMode() completed successfully");
		return mode;
		
	}
	
	/*
	 * MainMenu close
	 */
	private void MainMenuWindowClosing(WindowEvent e) {
		
		logger.debug("Running MainMenuWindowClosing()");
		
		logger.debug("User clicked X button to close program");
		
		logger.debug("Calling confirmProgramExit()");
		confirmProgramExit();
		
		logger.debug("MainMenuWindowClosing() completed successfully");
		
	}
	
	/* Launch a dialog allowing the user to choose whether or not to exit */
	private void confirmProgramExit() {
		
		logger.debug("Running confirmProgramExit()");
		
		if (JOptionPane.showConfirmDialog(MainMenu, 
	            "Are you sure to exit the Enigma?", "Please Confirm", 
	            JOptionPane.YES_NO_OPTION,
	            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
				logger.debug("User confirmed, exiting application");
	            System.exit(0);
	        }
		
		logger.debug("User canceled");
		
		logger.debug("confirmProgramExit() completed successfully");
		
	}
	
	/*
	 * MenuItem Event Handlers
	 */
	
	/*
	 * File -> Help
	 */
	private void FileMenuItemHelpActionPerformed(ActionEvent e) {
		
		logger.debug("User selected FileMenu>Help");
		
		logger.debug("Showing Help Dialog");
		JOptionPane.showMessageDialog(MainMenu, ScreenManager.getHelpText(),
										"Help", JOptionPane.PLAIN_MESSAGE);
	
		logger.debug("Returning to MainMenu");
		
	}
	
	/*
	 * File -> About
	 */
	private void FileMenuItemAboutActionPerformed(ActionEvent e) {
		
		logger.debug("User selected FileMenu>About");
		
		logger.debug("Showing About Dialog");
		JOptionPane.showMessageDialog(MainMenu, ScreenManager.getAboutText(),
				"About", JOptionPane.PLAIN_MESSAGE);
		
		logger.debug("Returning to MainMenu");
		
	}
	
	/*
	 * File -> Exit
	 */
	private void FileMenuItemExitActionPerformed(ActionEvent e) {
		
		logger.debug("User selected FileMenu>Exit");
		
		logger.debug("Confirming program exit");
		confirmProgramExit();
		
		logger.debug("Returning to MainMenu");
	}
	
	/*
	 * Settings -> Select Program Mode...
	 */
	private void SettingsMenuItemProgramModeActionPerformed(ActionEvent e) {
		
		logger.debug("User selected SettingsMenu>Select Program Mode...");
		
		logger.debug("Calling showProgramSelectForm()");
		ScreenManager.showProgramModeSelectForm(MainMenu);
		
		logger.debug("Setting text field to user supplied value");
		ProgramModeTextField.setText(determineProgramMode());
		
		logger.debug("Returning to MainMenu");
		
	}
	
	/*
	 * Settings -> Select Input File...
	 */
	private void SettingsMenuItemInputFileActionPerformed(ActionEvent e) {
		
		logger.debug("User selected SettingsMenu>Select Input File...");
		
		logger.debug("Calling selectInputFile()");
		ScreenManager.selectInputFile(MainMenu);
		
		logger.debug("Setting text field to user supplied value");
		InputFileTextField.setText(Config.getInputFilePath());
		
		logger.debug("Returning to MainMenu");
		
	}
	
	/*
	 * Settings -> Select Output File...
	 */
	private void SettingsMenuItemOutputFileActionPerformed(ActionEvent e) {
		
		logger.debug("User selected SettingsMenu>Select Output File...");
		
		logger.debug("Calling selectOutputFile()");
		ScreenManager.selectOutputFile(MainMenu);
		
		logger.debug("Setting text field to user supplied value");
		OutputFileTextField.setText(Config.getOutputFilePath());
		
		logger.debug("Returning to MainMenu");
		
	}
	
	/*
	 * Settings -> Valid Characters...
	 */
	private void SettingsMenuItemValidCharsActionPerformed(ActionEvent e) {
		
		logger.debug("User selected SettingsMenu>Valid Characters...");
		
		logger.debug("Showing Valid Characters dialog");
		JOptionPane.showMessageDialog(MainMenu, ScreenManager.getValidChars(),
				"Valid Characters", JOptionPane.PLAIN_MESSAGE);
		
		logger.debug("Returning to MainMenu");
		
	}
	
	/*
	 * Run! Button
	 */
	private void RunButtonActionPerformed(ActionEvent e) {
		
		logger.debug("User selected Run!");
		
		if (ScreenManager.processResults()) {
			
			logger.debug("Showing success dialog");
			JOptionPane.showMessageDialog(MainMenu, 
							"Your message was processed successfully", 
							"Success", 
							JOptionPane.INFORMATION_MESSAGE);
			
		}
		else {
			
			logger.debug("Showing failure dialog");
			JOptionPane.showMessageDialog(MainMenu, 
							"There was a problem processing your message. " + 
							"Please check all of your settings and try again.", 
							"Error", 
							JOptionPane.ERROR_MESSAGE);
			
		}
	}

}
