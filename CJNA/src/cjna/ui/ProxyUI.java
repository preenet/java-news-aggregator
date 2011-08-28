package cjna.ui;

import javax.swing.*;
import java.awt.*;

public class ProxyUI extends JFrame {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/**
 * @author Pree 
 */
public ProxyUI( ) {
	super("Proxy Setting");
	
    JTextField AddressTextField = new JTextField();
    JTextField PortTextField = new JTextField();
    JTextField DomainNameTextField = new JTextField();
    JTextField UserNameTextField = new JTextField();
    JTextField PassWordTextField = new JTextField();
       
       
  
    setSize(300,180);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container c1 = getContentPane();
    c1.setLayout(new GridLayout(0,2));
    c1.add(new JLabel(" Proxy Server "));
    
    JCheckBox proxyCheckBox = new JCheckBox();
    proxyCheckBox.setSelected(true);
    c1.add(proxyCheckBox);
    
    
    
    // container 2 for proxy setting
    Container c2 = getContentPane();
    c2.setLayout(new GridLayout(0,2));


   
    // add labels and text fields to the container
    c2.add(new JLabel(" Address "));
    c2.add(AddressTextField);
    c2.add(new JLabel(" Port "));
    c2.add(PortTextField);
    c2.add(new JLabel(" Domain Name "));
    c2.add(DomainNameTextField);
    c2.add(new JLabel(" User Name"));
    c2.add(UserNameTextField);
    c2.add(new JLabel(" Password "));
    c2.add(PassWordTextField);

    setVisible(true);
  }

  public static void main(String args[]) {
    new ProxyUI( );
  }
}// end class ProxyUI