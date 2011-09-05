package org.cjna;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Pree Thienburanathum preenet@gmail.com
 */

public class CJNADriver {
	private TimerTask fetchRSS;
	private boolean done = false;
	private String listURI = "http://www.preet.sesolution.com/camtrss/news_list.txt";

	public CJNADriver() {
		fetchRSS = new FetchRSS(this, listURI);
		Timer fetchTimer = new Timer();
		fetchTimer.schedule(fetchRSS, Global.delay, Global.period);
	}

	public void setDone(boolean d) {
		done = d;
	}

	public boolean getDone() {
		return done;
	}
}// end class CJNA

