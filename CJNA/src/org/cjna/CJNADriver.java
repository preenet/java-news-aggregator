package org.cjna;

import java.util.Timer;

import java.util.TimerTask;

/**
 * @author Pree Thienburanathum preenet@gmail.com
 */

public class CJNADriver {
	private String systemMsg = "";
	private TimerTask fetchRSS;
	private boolean done = false;
	private String listURI = "http://preet.sesolution.com/camtrss/news_list.txt";

	public CJNADriver() {
		fetchRSS = new FetchRSS(this, listURI);
		Timer fetchTimer = new Timer();
		fetchTimer.schedule(fetchRSS, Global.delay, Global.period);
	}
	
	/**
	 * 
	 * @param d boolean true of false
	 */
	public void setDone(boolean d) {
		done = d;
	}
	
	/**
	 * 
	 * @return boolean true of false
	 */
	public boolean getDone() {
		return done;
	}
	
	/**
	 * 
	 * @return String as the system message
	 */
	public String getSystemMsg() {
		return this.systemMsg;
	}
	
	/**
	 * 
	 * @param s String as message
	 */
	public void setSystemMsg(String s) {
		this.systemMsg = s;
	}
}// end class CJNA

