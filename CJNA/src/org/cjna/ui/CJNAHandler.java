package org.cjna.ui;

import org.cjna.CJNAConsole;
import org.cjna.Global;


/**
 * @author Pree
 *
 */
public class CJNAHandler extends Thread {
	private CJNAConsole console;
	private CJNAUI ui;
	
	public CJNAHandler(CJNAUI ui) {
		this.ui = ui;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		console=  new CJNAConsole();
		 while(true) {  
			
			 try {   
	                sleep(100);  
	            } catch(InterruptedException e) {}  
			ui.setConsoleLabel(this.console.getConsoleText());
			String s = "";
			for(int i = 0; i < Global.myFeed.getMessages().size(); i++) 
				s += Global.myFeed.getMessages().get(i).toString() + "\n";
			ui.setTextArea(s);
			ui.repaint();
		 }
	}

}// end class CJNAHandler
