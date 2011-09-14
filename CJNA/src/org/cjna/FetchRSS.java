package org.cjna;

import java.io.IOException;
import java.util.TimerTask;
import java.util.Vector;

import org.cjna.parser.FeedParser;

/**
 * @author Pree Thiengburanathum preenet@gmail.com
 * 
 */
public class FetchRSS extends TimerTask {
	private String listURI;
	private CJNADriver myDriver;
	private String msg;

	/**
	 * 
	 * @param myDriver
	 * @param listURI
	 */
	public FetchRSS(CJNADriver myDriver, String listURI) {
		this.listURI = listURI;
		this.myDriver = myDriver;
		this.msg = "";
	}

	@Override
	public void run() {
		msg = "Fetching RSS News...";
		System.out.println(msg);
		myDriver.setSystemMsg(msg);
		
		myDriver.setDone(false);
		// first getting the list from the URI site.
		FetchNewsList myList = new FetchNewsList(listURI, myDriver);
		try {
			myList.execute();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Vector<FeedParser> fps = new Vector<FeedParser>();

		// show the list to the console and parse each URI site.
		if (Global.URI.size() == 0) {
			myDriver.setSystemMsg("Unable to connect, please check the connection setting.");
		} else {
			System.out.println("News List are as following: ");
			for (int i = 0; i < Global.URI.size(); i++) {
				myDriver.setSystemMsg("Fetchig news...");
				System.out.println(i + 1 + ". " + Global.URI.get(i));
				FeedParser fp = new FeedParser(Global.URI.get(i));
				fps.add(fp);
			}
			System.out.println();

			// start the workers thread and wait for all of them to finish.
			for (int i = 0; i < Global.URI.size(); i++) {
				try {
					fps.elementAt(i).join();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// show all collected feed messages from given sites.
			for (int j = 0; j < Global.myFeed.getSize(); j++) {
				System.out.println(Global.myFeed.getMessages().get(j));
			}
			System.out.println("CJNA Reader now has : "
					+ Global.myFeed.getSize() + " messages.");
			System.out.println();

			// finish the program and terminate
			myDriver.setDone(true);
			msg = "Finished Fetching News.";
			System.out.println(msg);
			myDriver.setSystemMsg(msg + ", Total message(s) (" + Global.myFeed.getSize()+")");
		}
	}
}// end class FetchRss
