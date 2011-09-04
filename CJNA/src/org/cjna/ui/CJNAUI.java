package org.cjna.ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JLabel;

import org.cjna.Global;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

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
		listbox.setCellRenderer(new CJNAListCellRenderer());
		JScrollPane pane = new JScrollPane(listbox);
		panel_1.add(pane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 333, 420, 33);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblConnectionSetting = new JLabel("<html><u>Connection Setting</u></html>");
	
		lblConnectionSetting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConnectionUI frame = new ConnectionUI();
				frame.setVisible(true);
			}
		});
		lblConnectionSetting.setBounds(10, 11, 400, 14);
		panel_2.add(lblConnectionSetting);
		
		worker = new CJNAHandler(this);
	    worker.start();
	}
	
	public void refresh () {
		
		if(consoleDone) {
			listbox.setListData(Global.myFeed.getMessages().toArray());
		}
	}
	
	public void setConsoleDone(boolean done) {
		this.consoleDone = done;
	}
}// end class CJNAUI
