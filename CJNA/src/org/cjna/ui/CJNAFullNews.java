package org.cjna.ui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

import org.cjna.parser.FeedMessage;

public class CJNAFullNews extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public CJNAFullNews(FeedMessage fm) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setContentType("text/html");
		contentPane.add(textPane, BorderLayout.CENTER);
	    textPane.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		textPane.setText(fm.toString());

	}
}
