package org.cjna;

import java.util.*;

import org.cjna.parser.Feed;


/**
 * @author Pree
 * Description
 * The class act as the interface for global variable that will be use for user from console/ui input.
 */
public class GlobalData {
	public static ArrayList<String> URI;
	public static Feed myFeed;
	public static long delay;
	public static long period;
	
	public GlobalData() {
		 URI = new ArrayList<String>();
		 myFeed = new Feed();
		 delay = 5000;
		 period = 10000;
	}
	
	public synchronized ArrayList<String> getURI() {
		return this.URI;
	}
	
	public synchronized Feed getFeed() {
		return this.myFeed;
	}
	
	public synchronized long getDelay() {
		return this.delay;
	}
	
	public synchronized long getPeriod() {
		return this.period;
	}
	
	
}// end interface Global
