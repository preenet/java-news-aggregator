package cjna;

import java.util.*;

import parser.Feed;
/**
 * @author Pree
 *
 */
public interface Global {
	
	// link of the rss lists.
	public static String listURI = "http://www.preet.sesolution.com/camtrss/news_list.txt";
	public static ArrayList<String> URI = new ArrayList<String>();
	public static Feed myFeed = new Feed();
	
	// Proxy Configuration
	public static int proxyPort = 8080;
	public static String proxyHost = "192.168.11.1";
	public static String proxyDomain = "camt";
	public static String proxyUserName = "kanitta";
	public static String proxyPassword = "1";
	
}// end class
