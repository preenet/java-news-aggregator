package org.cjna.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

import org.cjna.Global;

public class CJNAUI extends JFrame {

	private JPanel contentPane;
	private CJNAHandler worker;
	private boolean consoleDone;
	private final JList list = new JList();

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
		
		setResizable(false);
		consoleDone = false;
		
		setTitle("CAMT Java News Aggregrator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 22);
		contentPane.add(menuBar);
		
		JMenu mnEdit = new JMenu("System");
		menuBar.add(mnEdit);
		
		JMenuItem mntmConnectionSetting = new JMenuItem("Connection Setting");
		mnEdit.add(mntmConnectionSetting);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnEdit.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		JScrollPane sPane = new JScrollPane();
		sPane.setBounds(0, 22, 450, 418);
		contentPane.add(sPane);
		sPane.setViewportView(list);
		
		worker = new CJNAHandler(this);
		worker.start();
	}
	
	public void refresh() {
		list.setListData(Global.myFeed.getMessages());
	}
	
	public void setConsoleDone(boolean done) {
		this.consoleDone = done;
	}
}

