package org.cjna.ui;


import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import org.cjna.Global;
import org.cjna.parser.FeedMessage;
import org.cjna.util.ProxyReader;
import org.cjna.util.ProxyWriter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;
import java.net.URI;
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
	private ProxyWriter writer;
	private ProxyReader reader;
	private CJNATray tray;

	
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
					 frame.setIconImage(Toolkit.getDefaultToolkit() 
							  .getImage("CAMTICON.JPG"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CJNAUI() throws IOException {
		super();
		intiGUI();
	}
	
	/**
	 * Create the frame.
	 */
	public void intiGUI() {
		// set program into the user tray.
		tray = new CJNATray(this);
        
		// init proxy reader/writer
		writer = new ProxyWriter();
		reader = new ProxyReader();
		
		// now construct the ui components.
		setNativeLookAndFeel();
		setTitle("CAMT Java News Aggregrator");
		setResizable(false);

		setBounds(100, 100, 450, 470);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnSystem = new JMenu("System");
		mnSystem.setMnemonic('S');
		menuBar.add(mnSystem);

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
		list.addMouseListener(new MouseAdapter() {  
			 Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
		     
		        public void mouseClicked(MouseEvent me)  {  
		        	list.setCursor(handCursor);  
		           try {  
		        	   
		        	   FeedMessage selection = (FeedMessage) list.getSelectedValue();
		   
		        	openLinkFromBrowser(new URI(selection.getLink()));
		        
		           }
		             catch(Exception e) {  
		                System.out.println(e);  
		             }  
		        }  
		 	@Override
		 	public void mousePressed(MouseEvent e) {
		 		list.setCursor(handCursor );  
		 	}
		 	@Override
		 	public void mouseReleased(MouseEvent e) {
		 		list.setCursor(handCursor );  
		 	}
		       });  
		
		list.setCellRenderer(new CJNAListCellRenderer());
		JScrollPane scroll = new JScrollPane(list);
		contentPane.add(scroll, BorderLayout.CENTER);
		
	
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
	
		contentPane.add(toolBar, BorderLayout.SOUTH);

		lblSystemMessage = new JLabel("System Message");
		toolBar.add(lblSystemMessage);
		
		// we check the proxy configuration here before calling the driver.
		File findFile = new File(Global.proxyFile);
		if(findFile.canRead()) {
			
			System.out.println("Detect the proxy setting file, now reading the configuration...");
			try {
				reader.read();
			} catch (IOException e1) {e1.printStackTrace();}
		}
		else {
			System.out.println("Couldn't find the proxy setting find, now writting a default setting...");
			try {
				writer.write();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		

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
	
	 private static void openLinkFromBrowser(URI uri) {
	        if (Desktop.isDesktopSupported()) {
	                Desktop desktop = Desktop.getDesktop();
	                try {
	                        desktop.browse(uri);
	                } catch (IOException e) {
	                        // TODO: error handling
	                }
	        } else {
	                // TODO: error handling
	        }
	 }
	
	public void restartCJNA() throws InterruptedException {
		lblSystemMessage = new JLabel("System starting...");
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
