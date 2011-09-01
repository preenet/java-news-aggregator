package cjna.ui;

import cjna.CJNAConsole;
import cjna.Global;

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
			ui.repaint();
		 }
	}

}// end class CJNAHandler