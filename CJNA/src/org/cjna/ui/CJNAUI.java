package org.cjna.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.cjna.Global;
import javax.swing.JLabel;

public class CJNAUI extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CJNAHandler worker;
	private boolean consoleDone;
	private JList listbox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		CJNAUI frame = new CJNAUI();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public CJNAUI() {
		setResizable(false);
		consoleDone = false;
		
		// Set the frame characteristics
		setTitle( "CAMT Java News Aggregrator " );
		setSize(426, 404);
		setBackground( Color.gray );
		getContentPane().setLayout(null);
		setVisible(true);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 420, 335);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout());
		
		listbox = new JList();
		listbox.setBounds(0, 0, 420, 335);
		listbox.setVisibleRowCount(10);
		JScrollPane pane = new JScrollPane(listbox);
		panel_1.add(pane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 333, 420, 33);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("Console Label here.");
		label.setBounds(10, 11, 400, 14);
		panel_2.add(label);
		
		worker = new CJNAHandler(this);
	    worker.start();
				
	}
	
	public void paint(Graphics g) {
		
		if(consoleDone) {
			listbox.setListData(Global.myFeed.getMessages().toArray());
		}
	}
	
	public void setConsoleDone(boolean done) {
		this.consoleDone = done;
	}
}// end class CJNAUI
