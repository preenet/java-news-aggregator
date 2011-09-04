package org.cjna.ui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JList;

import org.cjna.Global;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CJNAUI extends JFrame {

	private JPanel contentPane;
	private final JList list = new JList();
	private CJNAHandler worker;
	private boolean consoleDone;

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
		
		setTitle(" CAMT News Reader");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		list.setBorder(null);
		list.setBounds(6, 32, 438, 240);
		JScrollPane sPane = new JScrollPane(list);
		contentPane.add(sPane);
		
		JToolBar toolBar = new JToolBar();
		sPane.setColumnHeaderView(toolBar);
		toolBar.setBounds(0, 0, 450, 20);
		
		JLabel lblConnectionSetting = new JLabel("<html><u>Connection Setting</u></html>");
		lblConnectionSetting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ConnectionUI frame = new ConnectionUI();
				frame.setVisible(true);
			}
		});
		toolBar.add(lblConnectionSetting);
		
		worker = new CJNAHandler(this);
		worker.start();
	}
	
	public void refresh() {
		list.setListData(Global.myFeed.getMessages().toArray());
	}
	
	public void setConsoleDone(boolean done) {
		this.consoleDone = done;
	}
}
