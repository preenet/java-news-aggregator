package org.cjna;

import java.util.TimerTask;
import java.util.Vector;

import org.cjna.parser.FeedParser;

/**
 * @author Pree
 *
 */
public class FetchRSS extends TimerTask {
	private String listURI;
	private CJNADriver myDriver;
	
	public FetchRSS(CJNADriver myDriver, String listURI) {
		this.listURI = listURI;
		this.myDriver = myDriver;
	}

	@Override
	public void run() {
		System.out.println("Fetching RSS News...");
		myDriver.setDone(false);
		// first getting the list from the URI site.
		FetchNewsList myList = new FetchNewsList(listURI, myDriver.getGlobalData());
		myList.execute();

		Vector<FeedParser> fps = new Vector<FeedParser>();
		
		// show the list to the console and parse each URI site.
		if(myDriver.getGlobalData().getURI().size() == 0) {
			System.out.println("Error: No sites to read.");
			System.exit(0);
		}
		else {
			System.out.println("News List are as following: ");
			for(int i = 0; i < myDriver.getGlobalData().getURI().size(); i++) {
				System.out.println(i+1 + ". " + myDriver.getGlobalData().getURI().get(i));
				FeedParser fp = new FeedParser(myDriver.getGlobalData().getURI().get(i), myDriver.getGlobalData());
				fps.add(fp);
			}
			System.out.println();
			
			// start the workers thread and wait for all of them to finish.
			for(int i = 0; i < myDriver.getGlobalData().getURI().size(); i++) {
				try {	
					fps.elementAt(i).join();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// show all collected feed messages from given sites.
			for(int j = 0; j < myDriver.getGlobalData().getFeed().getSize(); j++) {
				System.out.println(myDriver.getGlobalData().getFeed().getMessages().get(j));
			}
			System.out.println("CJNA Reader now has : " + myDriver.getGlobalData().getFeed().getSize() + " messages.");
			System.out.println();
			// finish the program and terminate 
			myDriver.setDone(true);
			System.out.println("Finished Fetching News.");
		}
	}
}// end class FetchRss
