package cjna;

import java.util.*;

import parser.Feed;
/**
 * @author Pree
 *
 */
public interface Global {
	// link of the rss lists.
	public static String listURI = "http://preet.sesolution.com/camtrss/news_list.txt";
	public static ArrayList<String> URI = new ArrayList<String>();
	public static Feed myFeed = new Feed();
}// end class
