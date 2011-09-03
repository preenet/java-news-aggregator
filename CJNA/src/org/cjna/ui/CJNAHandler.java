package org.cjna.ui;

import org.cjna.CJNAConsole;



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
		ui.setConsoleDone(console.getDone());
		 while(true) {  
			 ui.setConsoleDone(console.getDone());
			 ui.repaint();
			 try {   
	                sleep(10000);  
	            } catch(InterruptedException e) {} 
			ui.setConsoleDone(console.getDone());
			ui.repaint();
		 }
	}

}// end class CJNAHandler
