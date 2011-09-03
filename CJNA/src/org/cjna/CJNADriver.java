package org.cjna;

import java.util.Timer;
import java.util.TimerTask;

/** @author Pree
 * Description:
 * This is the driver class of the program.
 */

public class CJNADriver {
	private TimerTask fetchRSS;
	private boolean done = false;
	private String listURI = "http://www.preet.sesolution.com/camtrss/news_list.txt";
	private GlobalData myData;
	
	public CJNADriver() {
		myData = new GlobalData();
		fetchRSS = new FetchRSS(this, listURI);
		Timer fetchTimer = new Timer();
		fetchTimer.schedule(fetchRSS, myData.getDelay(), myData.getPeriod());
	}
	public GlobalData getGlobalData() {
		return this.myData;
	}
	public void setDone(boolean d) {
		done = d;
	}
	
	public boolean getDone() {
		return done;
	}
}// end class CJNA


