package org.cjna.ui;

import java.awt.AWTException;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.cjna.Global;

/**
 * @author Pree Thiengburanathum preenet@gmail.com
 *
 */
public class CJNATray {
	private CJNAUI ui;
	
	public CJNATray(final CJNAUI ui) {
		
		this.ui = ui;
		// check the SystemTray is supported
	    if (!SystemTray.isSupported()) {
	        System.out.println("Error: SystemTray is not supported");
	        return;
	    }
	    final PopupMenu popup = new PopupMenu();
	    final TrayIcon trayIcon =
	            new TrayIcon(Toolkit.getDefaultToolkit() 
						  .getImage("CAMTICON.JPG"), "CNJA Agent " + Global.version);
	    final SystemTray tray = SystemTray.getSystemTray();
	    
	    // create a popup menu components
	    MenuItem aboutItem = new MenuItem("About");
	    Menu displayMenu = new Menu("System");
	    MenuItem connectionSettingItem = new MenuItem("Connection Setting");
	    MenuItem exitItem = new MenuItem("Exit");
	    
	    // add components to popup menu
	    popup.add(aboutItem);
	    popup.addSeparator();
	    popup.add(displayMenu);
	    displayMenu.add(connectionSettingItem);
	    popup.add(exitItem);
	    
	    trayIcon.setPopupMenu(popup);
	    
	    try {
	        tray.add(trayIcon);
	    } catch (AWTException e) {
	        System.out.println("TrayIcon could not be added.");
	        return;
	    }
	    
	    trayIcon.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	ui.setLocationRelativeTo(null);
				ui.setVisible(true);
				 ui.setIconImage(Toolkit.getDefaultToolkit() 
						  .getImage("CAMTICON.JPG"));
	        }
	    });
	    
	    aboutItem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	AboutCNJADialog about = new AboutCNJADialog();
				about.setVisible(true);
	        }
	    });
	    
	  
	    
	    ActionListener listener = new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            MenuItem item = (MenuItem)e.getSource();
	            //TrayIcon.MessageType type = null;
	            System.out.println(item.getLabel());
	            if ("Error".equals(item.getLabel())) {
	                //type = TrayIcon.MessageType.ERROR;
	                trayIcon.displayMessage("CAMT Java News Aggregrator",
	                        "This is an error message", TrayIcon.MessageType.ERROR);
	                
	            } else if ("Warning".equals(item.getLabel())) {
	                //type = TrayIcon.MessageType.WARNING;
	                trayIcon.displayMessage("CAMT Java News Aggregrator",
	                        "This is a warning message", TrayIcon.MessageType.WARNING);
	                
	            } else if ("Info".equals(item.getLabel())) {
	                //type = TrayIcon.MessageType.INFO;
	                trayIcon.displayMessage("CAMT Java News Aggregrator",
	                        "This is an info message", TrayIcon.MessageType.INFO);
	                
	            } else if ("None".equals(item.getLabel())) {
	                //type = TrayIcon.MessageType.NONE;
	                trayIcon.displayMessage("CAMT Java News Aggregrator",
	                        "This is an ordinary message", TrayIcon.MessageType.NONE);
	            }
	        }
	    };
	    
	    connectionSettingItem.addActionListener(listener);
	    
	    exitItem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            tray.remove(trayIcon);
	            System.exit(0);
	        }
	    });
	}
}// end class CJNATray
