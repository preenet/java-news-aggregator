package cjna.ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;


public class CJNAUI extends JFrame {

	private JPanel contentPane;
	private JLabel consoleLabel;
	private CJNAHandler worker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CJNAUI frame = new CJNAUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CJNAUI() {
		setTitle("CJNA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 248, 438, 24);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		consoleLabel = new JLabel("");
		consoleLabel.setBounds(6, 6, 426, 16);
		panel_1.add(consoleLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(435, 6, -424, 235);
		contentPane.add(textArea);
		start();
	}
	
	public void setConsoleLabel(String t) {
		consoleLabel.setText(t);
	}
	
	private void start() {
		worker = new CJNAHandler(this);
	}
}
