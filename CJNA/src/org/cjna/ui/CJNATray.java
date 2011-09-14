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
	private TrayIcon trayIcon;
	private SystemTray tray;
	
	
	 
	public CJNATray(final CJNAUI ui) {
		
		this.ui = ui;
		// check the SystemTray is supported
	    if (!SystemTray.isSupported()) {
	        System.out.println("Error: SystemTray is not supported");
	        return;
	    }
	    PopupMenu popup = new PopupMenu();
	    trayIcon =
	            new TrayIcon(Toolkit.getDefaultToolkit() 
						  .getImage("CAMTICON.JPG"), "CNJA Agent " + Global.version);
	    tray = SystemTray.getSystemTray();
	    
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
	    
	    connectionSettingItem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	ConnectionUI frame = new ConnectionUI(getFrame());
	    		frame.setVisible(true);
	        }
	    });
	    
	    exitItem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	removeTrayIcon();
	            System.exit(0);
	        }
	    });
	}
	
	private CJNAUI getFrame() {
		return this.ui;
	}
	
	public void removeTrayIcon() {
		tray.remove(trayIcon);
	}
}// end class CJNATray
