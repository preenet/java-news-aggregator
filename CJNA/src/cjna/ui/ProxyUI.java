package cjna.ui;

import javax.swing.*;

import cjna.CJNAConsole;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
/**
 * @author Pree 
 */
public class ProxyUI extends JFrame {
private static final long serialVersionUID = 1L;
private boolean isProxy = false;
private JTextField AddressTextField = new JTextField();
private JTextField PortTextField = new JTextField();
private JTextField DomainNameTextField = new JTextField();
private JTextField UserNameTextField = new JTextField();
private JTextField PassWordTextField = new JTextField();

public ProxyUI( ) {
	super("Proxy Setting");
	
    // set unable to text fields as default setting.
    AddressTextField.setEnabled(false);
	PortTextField.setEnabled(false);
	DomainNameTextField.setEnabled(false);
	UserNameTextField.setEnabled(false);
	PassWordTextField.setEnabled(false);
	
	// set Frame properties and layout
  
    setSize(300,180);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container c1 = getContentPane();
    c1.setLayout(new GridLayout(0,2));
    c1.add(new JLabel(" Proxy Server "));
    
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
    	        		 PassWordTextField.setEnabled(false);
    	        	 }
    	        	 else {
    	        		 AddressTextField.setEnabled(true);
    	        		 PortTextField.setEnabled(true);
    	        		 DomainNameTextField.setEnabled(true);
    	        		 UserNameTextField.setEnabled(true);
    	        		 PassWordTextField.setEnabled(true);
    	        	 }
    	        }
    	    }
    	);
    
    c1.add(proxyCheckBox);
    
    c1.setLayout(new GridLayout(0,2));
   
    // add labels and text fields to the container
    c1.add(new JLabel(" Address "));
    c1.add(AddressTextField);
    c1.add(new JLabel(" Port "));
    c1.add(PortTextField);
    c1.add(new JLabel(" Domain Name "));
    c1.add(DomainNameTextField);
    c1.add(new JLabel(" User Name"));
    c1.add(UserNameTextField);
    c1.add(new JLabel(" Password "));
    c1.add(PassWordTextField);

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
	
	public String getPassWordTextField() {
		return this.PassWordTextField.getText();
	}
	
	public static void main(String args[]) {
		
		new ProxyUI();
	}
}// end class ProxyUI