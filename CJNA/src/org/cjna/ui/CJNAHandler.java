package org.cjna.ui;
import org.cjna.CJNADriver;
import org.cjna.GlobalData;



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
		 while(true) {  
			 ui.setConsoleDone(worker.getDone());
			 ui.repaint();
			 try {   
	                sleep(10000);  
	            } catch(InterruptedException e) {} 
			ui.setConsoleDone(worker.getDone());
			ui.refresh();
		 }
	}
	
	public GlobalData getGlobalData() {
		return this.worker.getGlobalData();
	}

}// end class CJNAHandler
