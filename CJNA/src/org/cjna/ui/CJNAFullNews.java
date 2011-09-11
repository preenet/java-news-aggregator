package org.cjna.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

import org.cjna.parser.FeedMessage;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;

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
		textPane.setText(fm.toString());
	}

	  public void loadFont() throws FontFormatException, IOException{
	    String fontFileName = "Lucida Sans Unicode.ttf";
	   File f = new File(fontFileName);
	   FileInputStream in = new FileInputStream(f);

	    Font ttfBase = Font.createFont(Font.TRUETYPE_FONT, in);

	    Font ttfReal = ttfBase.deriveFont(Font.PLAIN, 24);
	    
	  }
}
