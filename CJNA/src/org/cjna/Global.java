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
	public static long delay = 10;
	public static long period = 100000;
	public static String msg = "";
	public static int timeout = 10000;
	public static String proxyFile = "proxy.ini";
	public static String version = " version 0.1.0173";

}// end interface Global
