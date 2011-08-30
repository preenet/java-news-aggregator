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
	
}// end interface Global
