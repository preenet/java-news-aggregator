package cjna.ui;

import javax.swing.*;

import cjna.CJNAConsole;
import cjna.net.HTTPProxyData;
import cjna.net.IPAddressValidator;
import cjna.net.PortValidator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
/**
 * @author Pree 
 */
public class ConnectionUI extends JFrame {
private static final long serialVersionUID = 1L;
private boolean isProxy;
private boolean hasInputError;
private JPanel proxyCheckArea;
private JPanel proxyConfig;
private JPanel proxyButtons;
private JLabel addresslbl, addressEglbl, portlbl, portEglbl, domainlbl, domainEglbl, 
usernamelbl, usernameEglbl, passwordlbl;
private JTextField AddressTextField = new JTextField();
private JTextField PortTextField = new JTextField();
private JTextField DomainNameTextField = new JTextField();
private JTextField UserNameTextField = new JTextField();
private JPasswordField PasswordTextField = new JPasswordField(8);
private CJNAConsole myCJNA;
private IPAddressValidator ipval;
private PortValidator portval;

public ConnectionUI( ) {
	super("Connection Setting");
	isProxy = false;
	hasInputError = false;
	ipval = new IPAddressValidator();
	portval = new PortValidator();
	
    // set unable to text fields as default setting.
    AddressTextField.setText("192.168.11.1");
    AddressTextField.setEnabled(false);
    
    PortTextField.setText("8080");
	PortTextField.setEnabled(false);
	
	DomainNameTextField.setText("camt");
	DomainNameTextField.setEnabled(false);
	UserNameTextField.setEnabled(false);
	PasswordTextField.setEnabled(false);
	PasswordTextField.setEchoChar('*');
	
	// set Frame properties and layout
	setLocationRelativeTo(null);
    setSize(350,180);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container content = getContentPane();
    
    proxyCheckArea = new JPanel(new GridLayout(0, 2));
    GridLayout conf = new GridLayout(0,3);
    conf.setVgap(3);
    proxyConfig = new JPanel(conf);
    
    GridLayout bts = new GridLayout(0,2);
    bts.setHgap(5);
    proxyButtons = new JPanel(bts);
    
    JCheckBox proxyCheckBox = new JCheckBox();
    proxyCheckBox.setSelected(false);
    proxyCheckBox.addItemListener(
    	    new ItemListener() {
    	        public void itemStateChanged(ItemEvent e) {
    	        	isProxy = (e.getStateChange() == ItemEvent.SELECTED);
    	        	 if(!isProxy) {
    	        		 AddressTextField.setEnabled(false);
    	        		 PortTextField.setEnabled(false);
    	        		 DomainNameTextField.setEnabled(false);
    	        		 UserNameTextField.setEnabled(false);
    	        		 PasswordTextField.setEnabled(false);
    	        		 
    	        		 //set JLable at proxy config to be less visible
    	        		 addresslbl.setForeground(Color.gray);
    	        		 addressEglbl.setForeground(Color.gray);
    	        		 portlbl.setForeground(Color.gray);
    	        		 portEglbl.setForeground(Color.gray); 
    	        		 domainlbl.setForeground(Color.gray);
    	        		 domainEglbl.setForeground(Color.gray);
    	        		 usernamelbl.setForeground(Color.gray);
    	        		 usernameEglbl.setForeground(Color.gray);
    	        		 passwordlbl.setForeground(Color.gray);
    	        	 }
    	        	 else {
    	        		 AddressTextField.setEnabled(true);
    	        		 PortTextField.setEnabled(true);
    	        		 DomainNameTextField.setEnabled(true);
    	        		 UserNameTextField.setEnabled(true);
    	        		 PasswordTextField.setEnabled(true);
    	        		 
    	        		 //set JLable at proxy config to be more visible
    	        		 addresslbl.setForeground(Color.black);
    	        		 addressEglbl.setForeground(Color.black);
    	        		 portlbl.setForeground(Color.black);
    	        		 portEglbl.setForeground(Color.black); 
    	        		 domainlbl.setForeground(Color.black);
    	        		 domainEglbl.setForeground(Color.black);
    	        		 usernamelbl.setForeground(Color.black);
    	        		 usernameEglbl.setForeground(Color.black);
    	        		 passwordlbl.setForeground(Color.black);
    	        	 }
    	        }
    	    }
    	);
    
    proxyCheckArea.add(new JLabel(" Connect via proxy server"));
    proxyCheckArea.setBorder(BorderFactory.createEtchedBorder());
    proxyCheckArea.add(proxyCheckBox);
    content.add(proxyCheckArea, BorderLayout.NORTH);
   
   
    // add labels and text fields to the container
    addresslbl = new JLabel(" Address");
    addresslbl.setForeground(Color.gray);
    proxyConfig.add(addresslbl);
    proxyConfig.add(AddressTextField);
    addressEglbl = new JLabel(" e.g. \"127.0.0.1\"");
    addressEglbl.setForeground(Color.gray);
    proxyConfig.add(addressEglbl);
    
    portlbl = new JLabel(" Port ");
    portlbl.setForeground(Color.gray);
    proxyConfig.add(portlbl);
    proxyConfig.add(PortTextField);
    portEglbl = new JLabel(" e.g. \"8080\"");
    portEglbl.setForeground(Color.gray);
    proxyConfig.add(portEglbl);
    
    domainlbl = new JLabel( " Domain Name");
    domainlbl.setForeground(Color.gray);
    proxyConfig.add(domainlbl);
    proxyConfig.add(DomainNameTextField);
    domainEglbl = new JLabel(" e.g. \"localhost\"");
    domainEglbl.setForeground(Color.gray);
    proxyConfig.add(domainEglbl);
    
    usernamelbl = new JLabel( " User Name");
    usernamelbl.setForeground(Color.gray);
    proxyConfig.add(usernamelbl);
    proxyConfig.add(UserNameTextField);
    usernameEglbl = new JLabel(" e.g. \"John\"");
    usernameEglbl.setForeground(Color.gray);
    proxyConfig.add(usernameEglbl);
    
    passwordlbl = new JLabel(" Password");
    passwordlbl.setForeground(Color.gray);
    proxyConfig.add(passwordlbl);
    proxyConfig.add(PasswordTextField);
    proxyConfig.add(new JLabel (""));
  
    proxyConfig.setBorder(BorderFactory.createEtchedBorder());
   
  
    content.add(proxyConfig);
    content.add(proxyConfig, BorderLayout.CENTER);
    
    
    // add ok and cancel buttons
    JButton okButton = new JButton("OK");
    okButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(hasInputError) {
				createAndShowGUI();
				System.out.println("input error");
			}
			else if(!hasInputError){
			// TODO Auto-generated method stub
			dispose();
				if(isProxy) {
					// set proxy configuration
					HTTPProxyData.getInstance();
					HTTPProxyData.getInstance().setProxy(isProxy);
					HTTPProxyData.getInstance().setProxyDomain(DomainNameTextField.getText());
					
					// check input ip and port are valid
					if(checkIP(AddressTextField.getText()) && checkPort(PortTextField.getText())) {
						HTTPProxyData.getInstance().setProxyHost(AddressTextField.getText());
						HTTPProxyData.getInstance().setProxyPort(PortTextField.getText());
						HTTPProxyData.getInstance().setProxyUserName(UserNameTextField.getText());
						HTTPProxyData.getInstance().setProxyPassword(PasswordTextField.getText());
						setMyCJNA(new CJNAConsole());
						
					}
					else if(!checkIP(AddressTextField.getText())){
						JOptionPane.showMessageDialog(null, "Invalid IP Address", "Error", JOptionPane.ERROR_MESSAGE);
						HTTPProxyData.getInstance().resetProxyData();
						createAndShowGUI();
					
					}
					else if(!checkPort(PortTextField.getText())) {
						JOptionPane.showMessageDialog(null, "Invalid Port Number", "Error", JOptionPane.ERROR_MESSAGE);
						HTTPProxyData.getInstance().resetProxyData();
						createAndShowGUI();
					}
					
			}
			else {
				setMyCJNA(new CJNAConsole());
			}
		}
			
		}});  
    
    proxyButtons.add(okButton);
    
    JButton cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 dispose();
		}
    });  
    proxyButtons.add(cancelButton);
    content.add(proxyButtons, BorderLayout.SOUTH);
    
    setResizable(false);
    setVisible(true);
  }// end constructor

	private boolean checkIP(String IPAddress) {
		return (ipval.validate(IPAddress));	
	}
	
	private boolean checkPort(String port) {
		return  (portval.validate(port));
	}

	// setter and getter here.
	public String getAddress() {
		return this.AddressTextField.getText();
	}
	
	public String getPort() {
		return this.PortTextField.getText();
	}
	
	public String getDomain() {
		return this.DomainNameTextField.getText();
	}
	
	public String getUserNameTextField () {
		return this.UserNameTextField.getText();
	}
	
	@SuppressWarnings("deprecation")
	public String getPassWordTextField() {
		return this.PasswordTextField.getText();
	}
	
	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}

	protected static void createAndShowGUI() {
		new ConnectionUI();
		
	}

	public void setMyCJNA(CJNAConsole myCJNA) {
		this.myCJNA = myCJNA;
	}

	public CJNAConsole getMyCJNA() {
		return myCJNA;
	}
}// end class ProxyUI