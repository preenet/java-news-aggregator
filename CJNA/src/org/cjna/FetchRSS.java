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
	
	public FetchRSS(String listURI) {
		this.listURI = listURI;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// first getting the list from the URI site.
		FetchNewsList myList = new FetchNewsList(listURI);
		myList.execute();

		Vector<FeedParser> fps = new Vector<FeedParser>();
		
		// show the list to the console and parse each URI site.
		if(Global.URI.size() == 0) {
			System.out.println("Error: No sites to read.");
			System.exit(0);
		}
		else {
			System.out.println("News List are as following: ");
			for(int i = 0; i < Global.URI.size(); i++) {
				System.out.println(i+1 + ". " +Global.URI.get(i));
				FeedParser fp = new FeedParser(Global.URI.get(i));
				fps.add(fp);
			}
			System.out.println();
			
			// start the workers thread and wait for all of them to finish.
			for(int i = 0; i < Global.URI.size(); i++) {
				try {	
					fps.elementAt(i).join();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// show all collected feed messages from given sites.
			for(int j = 0; j < Global.myFeed.getSize(); j++) {
				System.out.println(Global.myFeed.getMessages().get(j));
			}
			System.out.println("CJNA Reader now has : " + Global.myFeed.getSize() + " messages.");
			System.out.println();
			// finish the program and terminate 
	
		}
	}
}