package org.cjna;

import java.util.*;

import org.cjna.parser.Feed;


/**
 * @author Pree
 * Description
 * The class act as the interface for global variable that will be use for user from console/ui input.
 */
public interface Global {
	public static ArrayList<String> URI = new ArrayList<String>();
	public static Feed myFeed = new Feed();
	public static long delay = 1000;
	public static long period = 10000; // Fetching every 5 seconds
}// end interface Global
