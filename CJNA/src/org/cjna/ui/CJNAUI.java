package org.cjna.ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;


import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import org.cjna.parser.FeedMessage;


public class CJNAUI extends JFrame {

	private JPanel contentPane;
	private CJNAHandler worker;
	private JTextField textField;
	private JLabel consoleLabel;
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
		setBounds(100, 100, 449, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBounds(0, 238, 441, 16);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		consoleLabel = new JLabel("");
		consoleLabel.setBounds(10, 0, 421, 14);
		panel_1.add(consoleLabel);
		
		textField = new JTextField();
		textField.setBounds(0, 0, 434, 237);
		contentPane.add(textField);
		textField.setColumns(10);
		
		worker = new CJNAHandler(this);
		worker.start();
	}
	
	public void setConsoleLabel(String t) {
		
		consoleLabel.setText(t);
	}
	
	public void setTextArea(String s) {
		System.out.println("calling setTextArea" + s);
		textField.setText(s);
	}
	
	private void start() {
		worker = new CJNAHandler(this);
	}
}
