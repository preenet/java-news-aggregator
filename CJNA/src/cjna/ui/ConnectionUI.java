package cjna.ui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import cjna.CJNAConsole;
import cjna.net.HTTPProxyData;
import cjna.net.IPAddressValidator;
import cjna.net.PortValidator;
/**
 * 
 * @author Pree
 *
 */

public class ConnectionUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField addressTextField;
	private JTextField portTextField;
	private JTextField domainTextField;
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private JButton okButton, cancelButton;
	private JLabel lblAddress, lblAddressEg, lblPort, lblPortEg, lblUsername, lblUsernameEg, lblPassword, lblDomain, lblDomainEg;
	private boolean isProxy;
	private boolean hasInputError;
	private CJNAConsole myCJNA;
	private IPAddressValidator ipval;
	private PortValidator portval;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectionUI frame = new ConnectionUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ConnectionUI() {
		super();
		intiGUI();
	}
	

	/**
	 * Create the frame.
	 */
	public void intiGUI() {
		isProxy = false;
		hasInputError = false;
		
		
		setTitle("Connection Setting");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		okButton = new JButton("OK");
		okButton.setBounds(109, 243, 117, 29);
		okButton.addActionListener(new ActionListener() {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			
			if(hasInputError) {
				
				System.out.println("input error");
			}
			else if(!hasInputError){
			// TODO Auto-generated method stub
			dispose();
				if(isProxy) {
					// set proxy configuration
					HTTPProxyData.getInstance();
					HTTPProxyData.getInstance().setProxy(isProxy);
					HTTPProxyData.getInstance().setProxyDomain(domainTextField.getText());
					
					// check input ip and port are valid
					if(checkIP(addressTextField.getText()) && checkPort(portTextField.getText())) {
						HTTPProxyData.getInstance().setProxyHost(addressTextField.getText());
						HTTPProxyData.getInstance().setProxyPort(portTextField.getText());
						HTTPProxyData.getInstance().setProxyUserName(usernameTextField.getText());
						HTTPProxyData.getInstance().setProxyPassword(passwordField.getText());
						setMyCJNA(new CJNAConsole());
						
					}
					// incase that the ip address is not valid, we show the error dialog.
					else if(!checkIP(addressTextField.getText())){
						JOptionPane.showMessageDialog(null, "Invalid IP Address", "Error", JOptionPane.ERROR_MESSAGE);
						HTTPProxyData.getInstance().resetProxyData();
						intiGUI();
					
					}
					// incase that the port number is not valid, we show the erro dialog.
					else if(!checkPort(portTextField.getText())) {
						JOptionPane.showMessageDialog(null, "Invalid Port Number", "Error", JOptionPane.ERROR_MESSAGE);
						HTTPProxyData.getInstance().resetProxyData();
						intiGUI();
					}
					
			}
			else {
				setMyCJNA(new CJNAConsole());
			}
		}
			
		}
		});  
		contentPane.add(okButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(226, 243, 117, 29);
		
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 dispose();
			}
	    });  
		
		contentPane.add(cancelButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(6, 9, 438, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JCheckBox proxyCheckBox = new JCheckBox("Connect via proxy server");
		proxyCheckBox.setBounds(6, 6, 212, 23);
		proxyCheckBox.setSelected(false);
		proxyCheckBox.addItemListener(
	    	    new ItemListener() {
	    	        /* (non-Javadoc)
	    	         * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	    	         */
	    	        public void itemStateChanged(ItemEvent e) {
	    	        	isProxy = (e.getStateChange() == ItemEvent.SELECTED);
	    	        	 if(!isProxy) {
	    	        		 lblPassword.setForeground(Color.gray);
	    	        		 passwordField.setEnabled(false);
	    	        		 addressTextField.setEnabled(false);
	    	        		 portTextField.setEnabled(false);
	    	        		 domainTextField.setEnabled(false);
	    	        		 usernameTextField.setEnabled(false);
	    	        		 passwordField.setEnabled(false);
	    	        		 
	    	        		 //set JLable at proxy config to be less visible
	    	        		 lblAddress.setForeground(Color.gray);
	    	        		 lblAddressEg.setForeground(Color.gray);
	    	        		 lblPort.setForeground(Color.gray);
	    	        		 lblPortEg.setForeground(Color.gray); 
	    	        		 lblDomain.setForeground(Color.gray);
	    	        		 lblDomainEg.setForeground(Color.gray);
	    	        		 lblUsernameEg.setForeground(Color.gray);
	    	        		 lblUsername.setForeground(Color.gray);
	    	        		 lblPassword.setForeground(Color.gray);

	    	        	 }
	    	        	 else {
	    	        		 lblPassword.setForeground(Color.black);
	    	        		 passwordField.setEnabled(true);
	    	        		 addressTextField.setEnabled(true);
	    	        		 portTextField.setEnabled(true);
	    	        		 domainTextField.setEnabled(true);
	    	        		 
	    	        		 
	    	        		 //set JLable at proxy config to be more visible
	    	        		 lblAddress.setForeground(Color.black);
	    	        		 lblAddressEg.setForeground(Color.black);
	    	        		 lblPort.setForeground(Color.black);
	    	        		 lblPortEg.setForeground(Color.black); 
	    	        		 lblDomain.setForeground(Color.black);
	    	        		 lblDomainEg.setForeground(Color.black);
	    	        		 lblUsername.setForeground(Color.black);
	    	        		 lblUsernameEg.setForeground(Color.black);
	    	        	 }
	    	        }
	    	    }
	    	);
		
		panel.add(proxyCheckBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(6, 64, 438, 178);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblAddress = new JLabel("Address");
		lblAddress.setBounds(6, 17, 100, 16);
		panel_1.add(lblAddress);
		
		addressTextField = new JTextField();
		addressTextField.setText("192.168.11.1");
		addressTextField.setBounds(148, 11, 134, 28);
		panel_1.add(addressTextField);
		addressTextField.setColumns(10);
		
		lblPort = new JLabel("Port");
		lblPort.setBounds(6, 45, 61, 16);
		panel_1.add(lblPort);
		
		portTextField = new JTextField();
		portTextField.setText("8080");
		portTextField.setBounds(148, 39, 134, 28);
		panel_1.add(portTextField);
		portTextField.setColumns(10);
		
		lblDomain = new JLabel("Domain");
		lblDomain.setBounds(6, 73, 61, 16);
		panel_1.add(lblDomain);
		
		domainTextField = new JTextField();
		domainTextField.setText("camt");
		domainTextField.setBounds(148, 67, 134, 28);
		panel_1.add(domainTextField);
		domainTextField.setColumns(10);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(6, 101, 87, 16);
		panel_1.add(lblUsername);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(148, 95, 134, 28);
		panel_1.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(6, 129, 61, 16);
		panel_1.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(148, 129, 134, 22);
		panel_1.add(passwordField);
		
		lblAddressEg = new JLabel("e.g. \"127.0.0.1\"");
		lblAddressEg.setBounds(294, 17, 138, 16);
		panel_1.add(lblAddressEg);
		
		lblPortEg = new JLabel("e.g. \"8080\"");
		lblPortEg.setBounds(294, 45, 138, 16);
		panel_1.add(lblPortEg);
		
		lblDomainEg = new JLabel("e.g. \"localhost\"");
		lblDomainEg.setBounds(294, 73, 138, 16);
		panel_1.add(lblDomainEg);
		
		lblUsernameEg = new JLabel("e.g. \"john\"");
		lblUsernameEg.setBounds(294, 101, 138, 16);
		panel_1.add(lblUsernameEg);
		

		lblPassword.setForeground(Color.gray);
		 passwordField.setEnabled(false);
		 addressTextField.setEnabled(false);
		 portTextField.setEnabled(false);
		 domainTextField.setEnabled(false);
		 usernameTextField.setEnabled(false);
		 passwordField.setEnabled(false);
		 
		 //set JLable at proxy config to be less visible
		 lblAddress.setForeground(Color.gray);
		 lblAddressEg.setForeground(Color.gray);
		 lblPort.setForeground(Color.gray);
		 lblPortEg.setForeground(Color.gray); 
		 lblDomain.setForeground(Color.gray);
		 lblDomainEg.setForeground(Color.gray);
		 lblUsernameEg.setForeground(Color.gray);
		 lblUsername.setForeground(Color.gray);
		 lblPassword.setForeground(Color.gray);
		
	}

	private boolean checkIP(String IPAddress) {
		return (ipval.validate(IPAddress));	
	}
	
	private boolean checkPort(String port) {
		return  (portval.validate(port));
	}
	
	public void setMyCJNA(CJNAConsole myCJNA) {
		this.myCJNA = myCJNA;
	}
	
	public CJNAConsole getMyCJNA() {
		return myCJNA;
	}
}// end class ConnectionUI
