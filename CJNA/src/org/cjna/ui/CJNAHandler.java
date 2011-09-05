package org.cjna.ui;

import org.cjna.CJNADriver;

/**
 * @author Pree Thiengburanathum preenet@gmail.com
 * 
 */
public class CJNAHandler extends Thread {
	private CJNADriver worker;
	private CJNAUI ui;

	public CJNAHandler(CJNAUI ui) {
		this.ui = ui;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		worker = new CJNADriver();
		ui.setConsoleDone(worker.getDone());
		ui.refresh();

		while (true) {
			ui.setConsoleDone(worker.getDone());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
			ui.setConsoleDone(worker.getDone());
			ui.refresh();
		}
	}

	public boolean getConsoleDone() {
		return worker.getDone();
	}

	public void setConsoleDone(boolean d) {
		worker.setDone(d);
	}
}// end class CJNAHandler
