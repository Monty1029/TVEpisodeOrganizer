import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
	private static JTextField pathField;
	private static JTextField nameField;
	private static JTextField extField;
	private static JTextArea textArea;
	private static JButton startButton;

	public static void addComponentsToPane(Container pane) {
		pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		Color textColor = new Color(255, 255, 255);

		JLabel pathLabel = new JLabel("Enter file path:");
		pathLabel.setForeground(textColor);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(pathLabel, c);

		pathField = new JTextField();
		pathField.setColumns(8);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 3.0;
		c.gridx = 1;
		c.gridy = 0;
		pane.add(pathField, c);

		JLabel nameLabel = new JLabel("Enter name of TV show:");
		nameLabel.setForeground(textColor);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		pane.add(nameLabel, c);

		nameField = new JTextField();
		nameField.setColumns(8);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 3.0;
		c.gridx = 1;
		c.gridy = 1;
		pane.add(nameField, c);

		JLabel extLabel = new JLabel("Enter file extension (e.g. mkv   avi   mp4):");
		extLabel.setForeground(textColor);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		pane.add(extLabel, c);

		extField = new JTextField();
		extField.setColumns(8);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		pane.add(extField, c);

		startButton = new JButton("<html><font color=#0000CD>Start</font></html>");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 4;
		startButton.setBackground(new Color(214, 255, 255));
		pane.add(startButton, c);
		startButton.setEnabled(false);

		textArea = new JTextArea();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 5;
		textArea.setBackground(new Color(235, 255, 255));
		textArea.setEditable(false);
		pane.add(textArea, c);
		
		extField.addKeyListener(new KeyAdapter() {
	        public void keyReleased(KeyEvent e) {
	            super.keyReleased(e);
	            if(pathField.getText().length() > 0 && nameField.getText().length() >= 0 && extField.getText().length() > 0)
	                startButton.setEnabled(true);
	            else
	            	startButton.setEnabled(false);
	        }
	    });

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initiateTVEO();
			}
		});
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("TV Episode Organizer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 130);
		frame.getContentPane().setBackground(new Color(0, 127, 255));
		frame.setResizable(false);
		frame.setVisible(true);

		// Set up the content pane.
		addComponentsToPane(frame.getContentPane());

	}

	private static void initiateTVEO() {
		TVEpisodeOrganizer eo = new TVEpisodeOrganizer(pathField.getText());
		eo.rename(pathField.getText(), nameField.getText(), extField.getText());
		textArea.append("Done!");
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}