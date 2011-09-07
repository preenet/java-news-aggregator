package org.cjna.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import org.cjna.Global;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

/**
 * @author Pree Thiengburanathum preenet@gmail.com
 * 
 */
public class CJNAUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList list;
	private CJNAHandler worker;
	private JLabel lblSystemMessage;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CJNAUI frame = new CJNAUI();
					frame.setLocationRelativeTo(null);
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
		setNativeLookAndFeel();
		setTitle("CAMT Java News Aggregrator");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 470);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnSystem = new JMenu("System");
		mnSystem.setMnemonic('S');
		menuBar.add(mnSystem);

		JMenuItem mntmAddRss = new JMenuItem("Add RSS");
		mntmAddRss.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.Event.CTRL_MASK));
		mnSystem.add(mntmAddRss);

		JMenuItem mntmConnectionSetting = new JMenuItem("Connection Setting", 'C');
		mntmConnectionSetting.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.Event.CTRL_MASK));
		mntmConnectionSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openConnectionSetting();
			}
		});
		mnSystem.add(mntmConnectionSetting);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.Event.CTRL_MASK));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnSystem.add(mntmExit);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic('H');
		menuBar.add(mnHelp);

		JMenuItem mntmAboutCjna = new JMenuItem("About CJNA");
		mntmAboutCjna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutCNJADialog about = new AboutCNJADialog();
				about.setVisible(true);
			}
		});
		mnHelp.add(mntmAboutCjna);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		list = new JList();
		list.setCellRenderer(new CJNAListCellRenderer());
		JScrollPane scroll = new JScrollPane(list);
		contentPane.add(scroll, BorderLayout.CENTER);

		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.SOUTH);

		lblSystemMessage = new JLabel("System Message");
		toolBar.add(lblSystemMessage);

		worker = new CJNAHandler(this);
		worker.start();
	}

	public static void setNativeLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}
	}
	
	public void setMessage(String s) {
		lblSystemMessage.setText(s);
	}
	
	private void openConnectionSetting() {
		ConnectionUI frame = new ConnectionUI(this);
		frame.setVisible(true);
	}
	
	public void restartCJNA() throws InterruptedException {
		lblSystemMessage = new JLabel("System Message");
		this.worker = new CJNAHandler(this);
		worker.start();
	}

	public void setConsoleDone(boolean d) {
		worker.setConsoleDone(d);
	}

	public void refresh() {
		Runnable  doRefresh = new Runnable() {
		    public void run() {
		    	if (worker.getConsoleDone()) {
					list.setListData(Global.myFeed.getMessages());
					setConsoleDone(false);
				}
		    }
		};
		doRefresh.run();
		
	}
}// end class CJNAUI
