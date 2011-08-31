package cjna.ui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import cjna.CJNAConsole;
import cjna.net.HTTPProxyData;
import cjna.net.IPAddressValidator;
import cjna.net.PortValidator;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

/**
 * @author Pree
 *
 */
public class ConnectionUI2 extends javax.swing.JFrame {
	private JPasswordField passwordField;
	private JCheckBox proxyCheckBox;
	private JButton cancelButton;
	private JButton okButton;
	private JLabel ipaddresslbl;
	private JTextField ipaddressTextField;
	private JLabel portlbl;
	private JTextField portTextField;
	private JLabel usernameEglbl;
	private JLabel domainEglbl;
	private JLabel portEglbl;
	private JLabel ipaddressEglbl;
	private JSeparator sperator;
	private JLabel proxyPasswordlbl;
	private JCheckBox proxyPassword;
	private JLabel proxyConnect;
	private JLabel domainlbl;
	private JTextField domainTextField;
	private JLabel usernamelbl;
	private JTextField usernameTextField;
	private JLabel passwordlbl;
	private boolean isProxy;
	private boolean isPassword;
	private boolean hasInputError;
	private CJNAConsole myCJNA;
	private IPAddressValidator ipval;
	private PortValidator portval;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ConnectionUI2 inst = new ConnectionUI2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ConnectionUI2() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		isProxy = false;
		isPassword = false;
		hasInputError = false;
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Connection Setting");
			this.setResizable(false);
			this.setDefaultLookAndFeelDecorated(true);
			{
				usernameEglbl = new JLabel();
				getContentPane().add(usernameEglbl, new AnchorConstraint(627, 930, 688, 696, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				usernameEglbl.setText("e.g. \"john\"");
				usernameEglbl.setPreferredSize(new java.awt.Dimension(90, 16));
			}
			{
				domainEglbl = new JLabel();
				getContentPane().add(domainEglbl, new AnchorConstraint(517, 970, 578, 696, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				domainEglbl.setText("e.g. \"localhost\"");
				domainEglbl.setPreferredSize(new java.awt.Dimension(105, 16));
			}
			{
				portEglbl = new JLabel();
				getContentPane().add(portEglbl, new AnchorConstraint(406, 858, 467, 696, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				portEglbl.setText("e.g. \"80\"");
				portEglbl.setPreferredSize(new java.awt.Dimension(62, 16));
			}
			{
				ipaddressEglbl = new JLabel();
				getContentPane().add(ipaddressEglbl, new AnchorConstraint(295, 970, 356, 696, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				ipaddressEglbl.setText("e.g. \"127.0.0.1\"");
				ipaddressEglbl.setPreferredSize(new java.awt.Dimension(105, 16));
			}
			{
				sperator = new JSeparator();
				getContentPane().add(sperator, new AnchorConstraint(230, 951, 253, 50, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				sperator.setPreferredSize(new java.awt.Dimension(346, 6));
			}
			{
				proxyPasswordlbl = new JLabel();
				proxyPasswordlbl.setForeground(Color.gray);
				getContentPane().add(proxyPasswordlbl, new AnchorConstraint(131, 535, 192, 50, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				proxyPasswordlbl.setText("Proxy server requires password");
				proxyPasswordlbl.setPreferredSize(new java.awt.Dimension(186, 16));
			}
			{
				proxyPassword = new JCheckBox();
				proxyPassword.setEnabled(false);
				proxyPassword.setSelected(false);
				proxyPassword.addItemListener(
			    	    new ItemListener() {
			    	        public void itemStateChanged(ItemEvent e) {
			    	        	if(isProxy) {
			    	        	isPassword = (e.getStateChange() == ItemEvent.SELECTED);
			    	        	 if(!isPassword) {
			    	        		 usernameEglbl.setForeground(Color.gray);
			    	        		 passwordlbl.setForeground(Color.gray);
			    	        		 usernamelbl.setForeground(Color.gray);
			    	        		 usernameTextField.setEnabled(false);
			    	        		 passwordField.setEnabled(false);
			    	        		 
			    	        		 	
			    	        	 }
			    	        	 else {
			    	        		 usernameTextField.setEnabled(true);
			    	        		 passwordField.setEnabled(true);
			    	        		 usernamelbl.setForeground(Color.black);
			    	        		 usernameEglbl.setForeground(Color.black);
			    	        		 passwordlbl.setForeground(Color.black);
	
			    	        	 }
			    	        	}
			    	        }
			    	    }
			    	);
				getContentPane().add(proxyPassword, new AnchorConstraint(131, 634, 196, 582, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				proxyPassword.setPreferredSize(new java.awt.Dimension(20, 17));
				 proxyPassword.setSelected(false);
			}
			{
				proxyConnect = new JLabel();
				getContentPane().add(proxyConnect, new AnchorConstraint(47, 324, 108, 50, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				proxyConnect.setText("Connect via proxy");
				proxyConnect.setPreferredSize(new java.awt.Dimension(105, 16));
			}
			{
				proxyCheckBox = new JCheckBox();
				proxyCheckBox.setSelected(false);
				proxyCheckBox.addItemListener(
			    	    new ItemListener() {
			    	        public void itemStateChanged(ItemEvent e) {
			    	        	isProxy = (e.getStateChange() == ItemEvent.SELECTED);
			    	        	 if(!isProxy) {
			    	        		 proxyPasswordlbl.setForeground(Color.gray);
			    	        		 proxyPassword.setEnabled(false);
			    	        		 proxyPassword.setSelected(false);
			    	        		 ipaddressTextField.setEnabled(false);
			    	        		 portTextField.setEnabled(false);
			    	        		 domainTextField.setEnabled(false);
			    	        		 usernameTextField.setEnabled(false);
			    	        		 passwordField.setEnabled(false);
			    	        		 
			    	        		 //set JLable at proxy config to be less visible
			    	        		 ipaddresslbl.setForeground(Color.gray);
			    	        		 ipaddressEglbl.setForeground(Color.gray);
			    	        		 portlbl.setForeground(Color.gray);
			    	        		 portEglbl.setForeground(Color.gray); 
			    	        		 domainlbl.setForeground(Color.gray);
			    	        		 domainEglbl.setForeground(Color.gray);
			    	        		 usernameEglbl.setForeground(Color.gray);
			    	        		 usernamelbl.setForeground(Color.gray);
			    	        		 passwordlbl.setForeground(Color.gray);

			    	        	 }
			    	        	 else {
			    	        		 proxyPasswordlbl.setForeground(Color.black);
			    	        		 proxyPassword.setEnabled(true);
			    	        		 ipaddressTextField.setEnabled(true);
			    	        		 portTextField.setEnabled(true);
			    	        		 domainTextField.setEnabled(true);
			    	        		 
			    	        		 
			    	        		 //set JLable at proxy config to be more visible
			    	        		 ipaddresslbl.setForeground(Color.black);
			    	        		 ipaddressEglbl.setForeground(Color.black);
			    	        		 portlbl.setForeground(Color.black);
			    	        		 portEglbl.setForeground(Color.black); 
			    	        		 domainlbl.setForeground(Color.black);
			    	        		 domainEglbl.setForeground(Color.black);
			    	        		 
			    	        		 
			    	        	 }
			    	        }
			    	    }
			    	);
				getContentPane().add(proxyCheckBox, new AnchorConstraint(40, 634, 104, 582, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				proxyCheckBox.setPreferredSize(new java.awt.Dimension(20, 17));
				 proxyCheckBox.setSelected(false);
				    
			}
			{
				cancelButton = new JButton();
				 cancelButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							 dispose();
						}
				    });  
				getContentPane().add(cancelButton, new AnchorConstraint(880, 744, 972, 534, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				cancelButton.setText("Cancel");
				cancelButton.setPreferredSize(new java.awt.Dimension(83, 25));
			}
			{
				okButton = new JButton();
			    okButton.addActionListener(new ActionListener() {

					@SuppressWarnings("deprecation")
					@Override
					public void actionPerformed(ActionEvent e) {
						
						if(hasInputError) {
							initGUI();
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
								if(checkIP(ipaddressTextField.getText()) && checkPort(portTextField.getText())) {
									HTTPProxyData.getInstance().setProxyHost(ipaddressTextField.getText());
									HTTPProxyData.getInstance().setProxyPort(portTextField.getText());
									HTTPProxyData.getInstance().setProxyUserName(usernameTextField.getText());
									HTTPProxyData.getInstance().setProxyPassword(passwordField.getText());
									setMyCJNA(new CJNAConsole());
									
								}
								// incase that the ip address is not valid, we show the error dialog.
								else if(!checkIP(ipaddressTextField.getText())){
									JOptionPane.showMessageDialog(null, "Invalid IP Address", "Error", JOptionPane.ERROR_MESSAGE);
									HTTPProxyData.getInstance().resetProxyData();
									initGUI();
								
								}
								// incase that the port number is not valid, we show the erro dialog.
								else if(!checkPort(portTextField.getText())) {
									JOptionPane.showMessageDialog(null, "Invalid Port Number", "Error", JOptionPane.ERROR_MESSAGE);
									HTTPProxyData.getInstance().resetProxyData();
									initGUI();
								}
								
						}
						else {
							setMyCJNA(new CJNAConsole());
						}
					}
						
					}});  
				getContentPane().add(okButton, new AnchorConstraint(884, 473, 972, 260, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				okButton.setText("OK");
				okButton.setPreferredSize(new java.awt.Dimension(84, 24));
			}
			{
				ipaddresslbl = new JLabel();
				getContentPane().add(ipaddresslbl, new AnchorConstraint(295, 243, 356, 50, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				ipaddresslbl.setText("Address");
				ipaddresslbl.setPreferredSize(new java.awt.Dimension(74, 16));
			}
			{
				ipaddressTextField = new JTextField();
				getContentPane().add(ipaddressTextField, new AnchorConstraint(284, 647, 372, 360, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				ipaddressTextField.setText("192.168.11.1");
				ipaddressTextField.setPreferredSize(new java.awt.Dimension(110, 23));
			}
			{
				portlbl = new JLabel();
				getContentPane().add(portlbl, new AnchorConstraint(406, 225, 467, 50, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				portlbl.setText("Port");
				portlbl.setPreferredSize(new java.awt.Dimension(67, 16));
			}
			{
				portTextField = new JTextField();
				getContentPane().add(portTextField, new AnchorConstraint(395, 647, 482, 360, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				portTextField.setText("8080");
				portTextField.setPreferredSize(new java.awt.Dimension(110, 23));
			}
			{
				domainlbl = new JLabel();
				getContentPane().add(domainlbl, new AnchorConstraint(517, 243, 578, 50, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				domainlbl.setText("Domain");
				domainlbl.setPreferredSize(new java.awt.Dimension(74, 16));
			}
			{
				domainTextField = new JTextField();
				getContentPane().add(domainTextField, new AnchorConstraint(505, 647, 593, 360, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				domainTextField.setText("camt");
				domainTextField.setPreferredSize(new java.awt.Dimension(110, 23));
			}
			{
				usernamelbl = new JLabel();
				getContentPane().add(usernamelbl, new AnchorConstraint(627, 225, 688, 50, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				usernamelbl.setText("Username");
				usernamelbl.setPreferredSize(new java.awt.Dimension(67, 16));
			}
			{
				usernameTextField = new JTextField();
				getContentPane().add(usernameTextField, new AnchorConstraint(616, 647, 704, 360, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				usernameTextField.setPreferredSize(new java.awt.Dimension(110, 23));
			}
			{
				passwordlbl = new JLabel();
			
				getContentPane().add(passwordlbl, new AnchorConstraint(738, 259, 799, 50, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				passwordlbl.setText("Password");
				passwordlbl.setPreferredSize(new java.awt.Dimension(80, 16));
			}
			{
				passwordField = new JPasswordField();
				getContentPane().add(passwordField, new AnchorConstraint(727, 647, 814, 360, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				passwordField.setPreferredSize(new java.awt.Dimension(110, 23));
			}
			pack();
			setSize(400, 300);
			
			 ipaddressTextField.setEnabled(false);
    		 portTextField.setEnabled(false);
    		 domainTextField.setEnabled(false);
    		 usernameTextField.setEnabled(false);
    		 passwordField.setEnabled(false);
    		 
    		 //set JLable at proxy config to be less visible
    		 ipaddresslbl.setForeground(Color.gray);
    		 ipaddressEglbl.setForeground(Color.gray);
    		 portlbl.setForeground(Color.gray);
    		 portEglbl.setForeground(Color.gray); 
    		 domainlbl.setForeground(Color.gray);
    		 domainEglbl.setForeground(Color.gray);
    		 usernamelbl.setForeground(Color.gray);
    		 usernameEglbl.setForeground(Color.gray);
    		 passwordlbl.setForeground(Color.gray);
			
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
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

}// end class
