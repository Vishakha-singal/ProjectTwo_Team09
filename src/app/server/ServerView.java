package app.server;

import app.server.ServerController;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * @author Janani Thiagarajan
 * @author Nelson Tran
 * @version 1.0
 * 
 * Class to create a Server UI as per the user requirements - User story 2.1.1
 */
public class ServerView {
	
	/* The view needs a reference to the controller in order to attach
    	 * controller event handlers to GUI events.
	 */
	private ServerController controller;

    	// Graphical User Interface Components.
	private JFrame mainFrame;
	private StatusPanel statusPanel;
	private JTextField maxValueField;
	private JTextField minValueField;
	private JTextField frequencyField;
    	private JTextArea consoleOutput;
    	private JButton toggleButton;
	
	Font FONT = new Font("Courier New", Font.BOLD, 17);
	Color LIGHTPINK = new Color(255, 228, 225);
    	Color LIGHTBLUE = new Color(240, 248, 255);
    	Color LIGHTGREY = new Color(245, 245, 245);

	/**
	 * ServerView constructor.
	 */
	public ServerView() {
        	initialize();
        	register();
    	}

    	/*
     	* Parse the server option text fields and return the options.
     	*/
    public ServerOptions getOptions() throws Exception {
        int minimum = Integer.parseInt(minValueField.getText());
        int maximum = Integer.parseInt(maxValueField.getText());
	int frequency = Integer.parseInt(frequencyField.getText());
		
	if (minimum > maximum) {
		throw new Exception("The highest value must be greater than or equal to the lowest value.");
	}

        return new ServerOptions(minimum, maximum, frequency);
    }

    /**
     * Appends a message to the console output TextArea.
     */
    public void log(String message) {
        consoleOutput.append(message);
        consoleOutput.append("\n");
    }
	
    /*
     * Set the server status indicator.
     */
    public void setStatus(boolean status) {
	statusPanel.setBlinking(status);
    }

    /**
     * Set the reference to the ServerController.
     */
    public void setController(ServerController controller) {
		this.controller = controller;
	}

	/**
	 * Initialize and display the contents of the ServerView.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setFont(new Font("Courier New", Font.PLAIN, 17));
		mainFrame.getContentPane().setFont(new Font("Courier New", Font.PLAIN, 10));
		mainFrame.getContentPane().setBackground(LIGHTBLUE);
		mainFrame.getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(LIGHTGREY);
		mainPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainPanel.setBounds(10, 56, 758, 379);
		mainFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		statusPanel = new StatusPanel();
		statusPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		statusPanel.setBounds(23, 22, 414, 335);
		mainPanel.add(statusPanel);
		
		JLabel maxValueLabel = new JLabel("<html>Highest<br>Value:</html>");
		maxValueLabel.setBackground(LIGHTBLUE);
		maxValueLabel.setOpaque(true);
		maxValueLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		maxValueLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		maxValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		maxValueLabel.setFont(new Font("Courier New", Font.BOLD, 17));
		maxValueLabel.setBounds(462, 34, 131, 68);
		mainPanel.add(maxValueLabel);
		
		JLabel minValueLabel = new JLabel("<html>Lowest<br>Value:</html>");
		minValueLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		minValueLabel.setOpaque(true);
		minValueLabel.setBackground(LIGHTPINK);
		minValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		minValueLabel.setFont(FONT);
		minValueLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		minValueLabel.setBounds(462, 119, 131, 68);
		mainPanel.add(minValueLabel);
		
		JLabel frequencyLabel = new JLabel("<html>Frequency<br>(Hz):</html>");
		frequencyLabel.setOpaque(true);
		frequencyLabel.setBackground(LIGHTBLUE);
		frequencyLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		frequencyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frequencyLabel.setFont(FONT);
		frequencyLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frequencyLabel.setBounds(462, 202, 131, 68);
		mainPanel.add(frequencyLabel);
		
		maxValueField = new JTextField();
		maxValueField.setBackground(LIGHTPINK);
		maxValueField.setHorizontalAlignment(SwingConstants.CENTER);
		maxValueField.setFont(new Font("Courier New", Font.BOLD, 17));
		maxValueField.setBorder(new LineBorder(new Color(0, 0, 0)));
		maxValueField.setBounds(620, 34, 117, 68);
		mainPanel.add(maxValueField);
		maxValueField.setColumns(10);
		
		minValueField = new JTextField();
		minValueField.setBackground(LIGHTBLUE);
		minValueField.setHorizontalAlignment(SwingConstants.CENTER);
		minValueField.setFont(FONT);
		minValueField.setColumns(10);
		minValueField.setBorder(new LineBorder(new Color(0, 0, 0)));
		minValueField.setBounds(620, 119, 117, 68);
		mainPanel.add(minValueField);
		
		frequencyField = new JTextField();
		frequencyField.setBackground(LIGHTPINK);
		frequencyField.setHorizontalAlignment(SwingConstants.CENTER);
		frequencyField.setFont(FONT);
		frequencyField.setColumns(10);
		frequencyField.setBorder(new LineBorder(new Color(0, 0, 0)));
		frequencyField.setBounds(620, 202, 117, 68);
		mainPanel.add(frequencyField);
        
        	consoleOutput = new JTextArea();
        	consoleOutput.setEditable(false);
        	consoleOutput.setBackground(LIGHTGREY);
        	consoleOutput.setFont(new Font("Courier New", Font.PLAIN, 15));
		
		toggleButton = new JButton("Start / Stop");
		toggleButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		toggleButton.setHorizontalTextPosition(SwingConstants.CENTER);
		toggleButton.setFont(FONT);
		toggleButton.setBounds(578, 6, 187, 40);
		toggleButton.setForeground(new Color(0, 0, 0));
		toggleButton.setBackground(LIGHTPINK);

        	JScrollPane consolePane = new JScrollPane(consoleOutput);
		consolePane.setBorder(new TitledBorder(null, "Console", 
        		TitledBorder.LEADING, TitledBorder.TOP, 
        		FONT, null));
		consolePane.setBackground(LIGHTGREY);
        	consolePane.setBounds(10, 445, 758, 138);
		mainFrame.getContentPane().add(consolePane);
		
		mainFrame.setTitle("Server");
		mainFrame.setBounds(100, 100, 800, 629);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().add(toggleButton);
		mainFrame.setVisible(true);
    }
    
    /**
     * Register the event handlers.
     */
    private void register() {
        toggleButton.addActionListener(event -> { controller.toggleButtonClickHandler(); });
    }

}