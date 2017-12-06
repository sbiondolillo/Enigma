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
	private JMenuItem FileMenuItemExit;
	private JMenu HelpMenu;
	private JMenuItem HelpMenuItemHelp;
	private JMenuItem HelpMenuItemValidChars;
	private JMenu AboutMenu;
	private JMenuItem AboutMenuItemAbout;
	private JLabel SettingsMenuPromptLabel;
	private JLabel ProgramModeHeaderLabel;
	private JLabel InputFileHeaderLabel;
	private JButton RunButton;
	private JLabel OutputFileLabel;
	private JLabel RunButtonPromptLabel;
	private JLabel ProgramModeValueLabel;
	private JLabel InputFileValueLabel;
	private JLabel OutputFileValueLabel;
	private JButton ProgramModeSelectButton;
	private JButton InputFileSelectButton;
	private JButton OutputFileSelectButton;
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

	private void FileMenuItemHelpActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	

	private void FileMenuItemAboutActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void SettingsMenuItemValidCharsActionPerformed(ActionEvent e) {
		// TODO add your code here
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
		FileMenuItemExit = new JMenuItem();
		HelpMenu = new JMenu();
		HelpMenuItemHelp = new JMenuItem();
		HelpMenuItemValidChars = new JMenuItem();
		AboutMenu = new JMenu();
		AboutMenuItemAbout = new JMenuItem();
		SettingsMenuPromptLabel = new JLabel();
		ProgramModeHeaderLabel = new JLabel();
		InputFileHeaderLabel = new JLabel();
		RunButton = new JButton();
		OutputFileLabel = new JLabel();
		RunButtonPromptLabel = new JLabel();
		ProgramModeValueLabel = new JLabel();
		InputFileValueLabel = new JLabel();
		OutputFileValueLabel = new JLabel();
		ProgramModeSelectButton = new JButton();
		InputFileSelectButton = new JButton();
		OutputFileSelectButton = new JButton();

		//======== MainMenu ========
		{
			MainMenu.setTitle("Welcome to the Enigma!");
			MainMenu.setForeground(Color.white);
			MainMenu.setResizable(false);
			MainMenu.setAlwaysOnTop(true);
			MainMenu.setIconImage(new ImageIcon(getClass().getResource("/enigmaicon.png")).getImage());
			MainMenu.setFont(new Font("Dialog", Font.PLAIN, 20));
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
					FileMenu.setBackground(UIManager.getColor("Button.background"));
					FileMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));

					//---- FileMenuItemExit ----
					FileMenuItemExit.setText("Exit");
					FileMenuItemExit.setToolTipText("Exit the Enigma");
					FileMenuItemExit.setBackground(UIManager.getColor("Button.background"));
					FileMenuItemExit.setFont(new Font("Segoe UI", Font.PLAIN, 20));
					FileMenuItemExit.addActionListener(e -> FileMenuItemExitActionPerformed(e));
					FileMenu.add(FileMenuItemExit);
				}
				MainMenuBar.add(FileMenu);

				//======== HelpMenu ========
				{
					HelpMenu.setText("Help");
					HelpMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));

					//---- HelpMenuItemHelp ----
					HelpMenuItemHelp.setText("Help");
					HelpMenuItemHelp.setBackground(UIManager.getColor("Button.background"));
					HelpMenuItemHelp.setFont(new Font("Segoe UI", Font.PLAIN, 20));
					HelpMenuItemHelp.addActionListener(e -> {
			FileMenuItemHelpActionPerformed(e);
			FileMenuItemHelpActionPerformed(e);
			HelpMenuItemHelpActionPerformed(e);
		});
					HelpMenu.add(HelpMenuItemHelp);

					//---- HelpMenuItemValidChars ----
					HelpMenuItemValidChars.setText("Valid Characters...");
					HelpMenuItemValidChars.setBackground(UIManager.getColor("Button.background"));
					HelpMenuItemValidChars.setFont(new Font("Segoe UI", Font.PLAIN, 20));
					HelpMenuItemValidChars.addActionListener(e -> {
			SettingsMenuItemValidCharsActionPerformed(e);
			HelpMenuItemValidCharsActionPerformed(e);
		});
					HelpMenu.add(HelpMenuItemValidChars);
				}
				MainMenuBar.add(HelpMenu);

				//======== AboutMenu ========
				{
					AboutMenu.setText("About");
					AboutMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));

					//---- AboutMenuItemAbout ----
					AboutMenuItemAbout.setText("About");
					AboutMenuItemAbout.setBackground(UIManager.getColor("Button.background"));
					AboutMenuItemAbout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
					AboutMenuItemAbout.addActionListener(e -> {
			FileMenuItemAboutActionPerformed(e);
			AboutMenuItemAboutActionPerformed(e);
		});
					AboutMenu.add(AboutMenuItemAbout);
				}
				MainMenuBar.add(AboutMenu);
			}
			MainMenu.setJMenuBar(MainMenuBar);

			//---- SettingsMenuPromptLabel ----
			SettingsMenuPromptLabel.setText("Make your selections below...");
			SettingsMenuPromptLabel.setHorizontalAlignment(SwingConstants.CENTER);
			SettingsMenuPromptLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 28));
			SettingsMenuPromptLabel.setBackground(Color.white);

			//---- ProgramModeHeaderLabel ----
			ProgramModeHeaderLabel.setText("Program Mode");
			ProgramModeHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
			ProgramModeHeaderLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
			ProgramModeHeaderLabel.setBackground(Color.white);

			//---- InputFileHeaderLabel ----
			InputFileHeaderLabel.setText("Input File");
			InputFileHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
			InputFileHeaderLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
			InputFileHeaderLabel.setBackground(Color.white);

			//---- RunButton ----
			RunButton.setText("Run!");
			RunButton.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 28));
			RunButton.setHorizontalTextPosition(SwingConstants.CENTER);
			RunButton.setBackground(UIManager.getColor("Button.background"));
			RunButton.addActionListener(e -> RunButtonActionPerformed(e));

			//---- OutputFileLabel ----
			OutputFileLabel.setText("Output File");
			OutputFileLabel.setHorizontalAlignment(SwingConstants.CENTER);
			OutputFileLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
			OutputFileLabel.setBackground(Color.white);

			//---- RunButtonPromptLabel ----
			RunButtonPromptLabel.setText("Click Run! to process your message.");
			RunButtonPromptLabel.setHorizontalAlignment(SwingConstants.CENTER);
			RunButtonPromptLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 28));
			RunButtonPromptLabel.setBackground(Color.white);

			//---- ProgramModeValueLabel ----
			ProgramModeValueLabel.setText("<Program Mode>");
			ProgramModeValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
			ProgramModeValueLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));

			//---- InputFileValueLabel ----
			InputFileValueLabel.setText("<Input File>");
			InputFileValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
			InputFileValueLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));

			//---- OutputFileValueLabel ----
			OutputFileValueLabel.setText("<Output File>");
			OutputFileValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
			OutputFileValueLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));

			//---- ProgramModeSelectButton ----
			ProgramModeSelectButton.setText("Select...");
			ProgramModeSelectButton.setFont(new Font("Segoe UI", Font.ITALIC, 18));
			ProgramModeSelectButton.setHorizontalTextPosition(SwingConstants.CENTER);
			ProgramModeSelectButton.setToolTipText("Select whether to encrypt or decrypt");
			ProgramModeSelectButton.addActionListener(e -> ProgramModeSelectButtonActionPerformed(e));

			//---- InputFileSelectButton ----
			InputFileSelectButton.setText("Select...");
			InputFileSelectButton.setFont(new Font("Segoe UI", Font.ITALIC, 18));
			InputFileSelectButton.setHorizontalTextPosition(SwingConstants.CENTER);
			InputFileSelectButton.setToolTipText("Select which file should be read");
			InputFileSelectButton.addActionListener(e -> InputFileSelectButtonActionPerformed(e));

			//---- OutputFileSelectButton ----
			OutputFileSelectButton.setText("Select...");
			OutputFileSelectButton.setFont(new Font("Segoe UI", Font.ITALIC, 18));
			OutputFileSelectButton.setHorizontalTextPosition(SwingConstants.CENTER);
			OutputFileSelectButton.setToolTipText("Select where the output should be written");
			OutputFileSelectButton.addActionListener(e -> OutputFileSelectButtonActionPerformed(e));

			GroupLayout MainMenuContentPaneLayout = new GroupLayout(MainMenuContentPane);
			MainMenuContentPane.setLayout(MainMenuContentPaneLayout);
			MainMenuContentPaneLayout.setHorizontalGroup(
				MainMenuContentPaneLayout.createParallelGroup()
					.addGroup(MainMenuContentPaneLayout.createSequentialGroup()
						.addGroup(MainMenuContentPaneLayout.createParallelGroup()
							.addGroup(MainMenuContentPaneLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(MainMenuContentPaneLayout.createParallelGroup()
									.addComponent(SettingsMenuPromptLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
									.addComponent(ProgramModeHeaderLabel, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
									.addComponent(InputFileHeaderLabel, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
									.addComponent(InputFileValueLabel, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
									.addComponent(OutputFileLabel, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
									.addComponent(OutputFileValueLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
									.addComponent(ProgramModeValueLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
							.addComponent(RunButtonPromptLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
							.addGroup(MainMenuContentPaneLayout.createSequentialGroup()
								.addGroup(MainMenuContentPaneLayout.createParallelGroup()
									.addGroup(MainMenuContentPaneLayout.createSequentialGroup()
										.addGap(351, 351, 351)
										.addComponent(RunButton))
									.addGroup(MainMenuContentPaneLayout.createSequentialGroup()
										.addGap(352, 352, 352)
										.addComponent(ProgramModeSelectButton)))
								.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap())
					.addGroup(GroupLayout.Alignment.TRAILING, MainMenuContentPaneLayout.createSequentialGroup()
						.addContainerGap(355, Short.MAX_VALUE)
						.addGroup(MainMenuContentPaneLayout.createParallelGroup()
							.addComponent(InputFileSelectButton, GroupLayout.Alignment.TRAILING)
							.addComponent(OutputFileSelectButton, GroupLayout.Alignment.TRAILING))
						.addGap(352, 352, 352))
			);
			MainMenuContentPaneLayout.setVerticalGroup(
				MainMenuContentPaneLayout.createParallelGroup()
					.addGroup(MainMenuContentPaneLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(SettingsMenuPromptLabel)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(ProgramModeHeaderLabel)
						.addGap(1, 1, 1)
						.addComponent(ProgramModeSelectButton)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(ProgramModeValueLabel)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(InputFileHeaderLabel)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(InputFileSelectButton)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(InputFileValueLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(18, 18, 18)
						.addComponent(OutputFileLabel)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(OutputFileSelectButton)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(OutputFileValueLabel)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(RunButtonPromptLabel)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(RunButton)
						.addGap(26, 26, 26))
			);
			MainMenu.pack();
			MainMenu.setLocationRelativeTo(MainMenu.getOwner());
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
		
		MainMenu.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 20));
		UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 18));
		logger.debug("initComponents() completed successfully");
	}

	/*
	 * MainMenu show events
	 */
	private void MainMenuWindowOpened(WindowEvent e) {
		
		logger.debug("Running MainMenuWindowOpened()");
		
		logger.debug("Calling initializeTextFields()");
		initializeLabels();
		
		logger.debug("initComponents() completed successfully");
		
	}
	
	/*
	 * Set the labels of the MainMenu to show current Config settings
	 */
	private void initializeLabels() {
		
		logger.debug("Running initializeLabels()");
		
		logger.debug("Setting labels based on Config values");
		
		logger.debug("Calling determineProgramMode()");
		String mode = determineProgramMode();
		ProgramModeValueLabel.setText(mode);
		
		logger.debug("Calling getInputFilePath()");
		InputFileValueLabel.setText(Config.getInputFilePath());
		
		logger.debug("Calling getOutputFilePath()");
		OutputFileValueLabel.setText(Config.getOutputFilePath());
		
		logger.debug("initializeLabels() completed successfully");
		
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
	 * File -> Exit
	 */
	private void FileMenuItemExitActionPerformed(ActionEvent e) {
		
		logger.debug("User selected FileMenu>Exit");
		
		logger.debug("Confirming program exit");
		confirmProgramExit();
		
		logger.debug("Returning to MainMenu");
	}

	/*
	 * Help -> Help
	 */
	private void HelpMenuItemHelpActionPerformed(ActionEvent e) {

		logger.debug("User selected HelpMenu>Help");
		
		logger.debug("Showing Help Dialog");
		JOptionPane.showMessageDialog(MainMenu, ScreenManager.getHelpText(),
										"Help", JOptionPane.PLAIN_MESSAGE);
	
		logger.debug("Returning to MainMenu");
		
	}
	
	/*
	 * Help -> Valid Characters...
	 */
	private void HelpMenuItemValidCharsActionPerformed(ActionEvent e) {

		logger.debug("User selected SettingsMenu>Valid Characters...");
		
		logger.debug("Showing Valid Characters dialog");
		JOptionPane.showMessageDialog(MainMenu, ScreenManager.getValidChars(),
				"Valid Characters", JOptionPane.PLAIN_MESSAGE);
		
		logger.debug("Returning to MainMenu");
		
	}
	
	/*
	 * About -> About
	 */
	private void AboutMenuItemAboutActionPerformed(ActionEvent e) {
		
		logger.debug("User selected AboutMenu>About");
		
		logger.debug("Showing About Dialog");
		JOptionPane.showMessageDialog(MainMenu, ScreenManager.getAboutText(),
				"About", JOptionPane.PLAIN_MESSAGE);
		
		logger.debug("Returning to MainMenu");
		
	}	
	
	private void ProgramModeSelectButtonActionPerformed(ActionEvent e) {

		logger.debug("User clicked Select Program Mode...");
		
		logger.debug("Calling showProgramSelectForm()");
		ScreenManager.showProgramModeSelectForm(MainMenu);
		
		logger.debug("Setting label to user supplied value");
		ProgramModeValueLabel.setText(determineProgramMode());
		
		logger.debug("Returning to MainMenu");
		
	}

	private void InputFileSelectButtonActionPerformed(ActionEvent e) {

		logger.debug("User clicked Select Input File...");
		
		logger.debug("Calling selectInputFile()");
		ScreenManager.selectInputFile(MainMenu);
		
		logger.debug("Setting label to user supplied value");
		InputFileValueLabel.setText(Config.getInputFilePath());
		
		logger.debug("Returning to MainMenu");
		
	}

	private void OutputFileSelectButtonActionPerformed(ActionEvent e) {
		
		logger.debug("User clicked Select Output File...");
		
		logger.debug("Calling selectOutputFile()");
		ScreenManager.selectOutputFile(MainMenu);
		
		logger.debug("Setting label to user supplied value");
		OutputFileValueLabel.setText(Config.getOutputFilePath());
		
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
