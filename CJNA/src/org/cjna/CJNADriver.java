package org.cjna;

import java.util.Timer;
import java.util.TimerTask;

/** @author Pree
 * Description:
 * This is the driver class of the program.
 */

public class CJNADriver {
	private boolean done;
	private String listURI = "http://www.preet.sesolution.com/camtrss/news_list.txt";
	
	public CJNADriver() {
		done = false;
		System.out.println("Start CJNA Console.");
		
		TimerTask fetchRSS = new FetchRSS(listURI);
		Timer fetchTimer = new Timer();
		fetchTimer.schedule(fetchRSS, Global.delay, Global.period);
	
		System.out.println("Done!");
		done = true;
	}
	
	public boolean getDone() {
		return this.done;
	}
	public static void main(String args[]) {
		new CJNADriver();
	}
}// end class CJNA


