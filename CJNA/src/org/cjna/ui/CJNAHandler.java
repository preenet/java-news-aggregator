package org.cjna.ui;
import org.cjna.CJNADriver;


/**
 * @author Pree
 *
 */
public class CJNAHandler extends Thread {
	private CJNADriver worker;
	private CJNAUI ui;
	
	public CJNAHandler(CJNAUI ui) {
		this.ui = ui;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		worker =  new CJNADriver();
		ui.setConsoleDone(worker.getDone());
		 ui.repaint();
		
		 while(true) {  
			 ui.setConsoleDone(worker.getDone());
			 ui.repaint();
			 try {   
	                sleep(1000);  
	            } catch(InterruptedException e) {} 
			ui.setConsoleDone(worker.getDone());
			ui.refresh();
		 }
	}
}// end class CJNAHandler
