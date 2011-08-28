package cjna;

import java.util.*;

import cjna.parser.Feed;

/**
 * @author Pree
 * Description
 * The class act as the interface for global variable that will be use for user from console/ui input.
 */
public interface Global {
	public static ArrayList<String> URI = new ArrayList<String>();
	public static Feed myFeed = new Feed();
	
	/**
	 * Set this variable for list of URI.
	 */
	public static String listURI = "http://www.preet.sesolution.com/camtrss/news_list.txt";

	
	/**
	 * Set this variable for proxy configuration.
	 */
	public static boolean isProxy = false;
	public static int proxyPort = 8080;
	public static String proxyHost = "192.168.11.1";
	public static String proxyDomain = "camt";
	public static String proxyUserName = "kanitta";
	public static String proxyPassword = "1";
	
}// end interface Global
