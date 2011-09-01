package cjna.ui;

import cjna.CJNAConsole;

/**
 * @author Pree
 *
 */
public class CJNAHandler extends Thread {
	private CJNAConsole console;
	private CJNAUI ui;
	
	public CJNAHandler(CJNAUI ui) {
		this.ui = ui;
		this.console = new CJNAConsole();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		this.start();
		
		 while(true) {  
			 try {  
	                sleep(100);  
	            } catch(InterruptedException e) {}  
			ui.setConsoleLabel(this.console.getConsoleText());
			ui.repaint();
		 }
	}

}// end class CJNAHandler
