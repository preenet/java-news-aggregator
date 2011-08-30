package cjna.ui;

import javax.swing.*;

import cjna.CJNAConsole;
import cjna.net.HTTPProxyData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
/**
 * @author Pree 
 */
public class ProxyUI extends JFrame {
private static final long serialVersionUID = 1L;
private boolean isProxy = false;
private JPanel proxyCheckArea;
private JPanel proxyConfig;
private JPanel proxyButtons;
private JTextField AddressTextField = new JTextField();
private JTextField PortTextField = new JTextField();
private JTextField DomainNameTextField = new JTextField();
private JTextField UserNameTextField = new JTextField();
private JPasswordField PasswordTextField = new JPasswordField(8);
private CJNAConsole myCJNA;

public ProxyUI( ) {
	super("Proxy Setting");
	
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
    setSize(300,180);
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
    	        	 }
    	        	 else {
    	        		 AddressTextField.setEnabled(true);
    	        		 PortTextField.setEnabled(true);
    	        		 DomainNameTextField.setEnabled(true);
    	        		 UserNameTextField.setEnabled(true);
    	        		 PasswordTextField.setEnabled(true);
    	        	 }
    	        }
    	    }
    	);
    
    proxyCheckArea.add(new JLabel("Proxy Server"));
    proxyCheckArea.setBorder(BorderFactory.createEtchedBorder());
    proxyCheckArea.add(proxyCheckBox);
    content.add(proxyCheckArea, BorderLayout.NORTH);
   
   
    // add labels and text fields to the container
    proxyConfig.add(new JLabel(" Address "));
    proxyConfig.add(AddressTextField);
    proxyConfig.add(new JLabel (" e.g. 127.0.0.1"));
    
    proxyConfig.add(new JLabel(" Port "));
    proxyConfig.add(PortTextField);
    proxyConfig.add(new JLabel (" e.g. 8080"));
    
    proxyConfig.add(new JLabel(" Domain Name "));
    proxyConfig.add(DomainNameTextField);
    proxyConfig.add(new JLabel (" e.g. localhost"));
    
    proxyConfig.add(new JLabel(" User Name"));
    proxyConfig.add(UserNameTextField);
    proxyConfig.add(new JLabel (" e.g. John"));
    
    proxyConfig.add(new JLabel(" Password "));
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
			// TODO Auto-generated method stub
			dispose();
			if(isProxy) {
				// set proxy configuration
				HTTPProxyData.getInstance();
				HTTPProxyData.getInstance().setProxy(isProxy);
				HTTPProxyData.getInstance().setProxyDomain(DomainNameTextField.getText());
				HTTPProxyData.getInstance().setProxyHost(AddressTextField.getText());
				HTTPProxyData.getInstance().setProxyPort(PortTextField.getText());
				HTTPProxyData.getInstance().setProxyUserName(UserNameTextField.getText());
				HTTPProxyData.getInstance().setProxyPassword(PasswordTextField.getText());
				setMyCJNA(new CJNAConsole());
			}
			else {
				setMyCJNA(new CJNAConsole());
			}
		}
    });  
    
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
    
    setVisible(true);
  }// end constructor

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
		new ProxyUI();
		
	}

	public void setMyCJNA(CJNAConsole myCJNA) {
		this.myCJNA = myCJNA;
	}

	public CJNAConsole getMyCJNA() {
		return myCJNA;
	}
}// end class ProxyUI