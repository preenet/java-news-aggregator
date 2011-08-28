import java.io.IOException;
import java.util.Vector;

import connection.HTTPProxyConnection;
import parser.FeedParser;
import cjna.GetNewsList;
import cjna.Global;

/**
 * @author Pree
 * Description:
 * This is the driver class of the program.
 */

public class CJNA {
	public static void main(String args[]) throws IOException, InterruptedException{
		System.out.println("Start CJNA Console.");
		
		// first getting the list from the URI site.
		GetNewsList myList = new GetNewsList();
		myList.execute();

		Vector<FeedParser> fps = new Vector<FeedParser>();
		
		// show the list to the console and parse each URI site.
		System.out.println("News List are as following: ");
		for(int i = 0; i < Global.URI.size(); i++) {
			System.out.println(i+1 + ". " +Global.URI.get(i));
			FeedParser fp = new FeedParser(Global.URI.get(i));
			fps.add(fp);
		}
		System.out.println();
		
		for(int i = 0; i < Global.URI.size(); i++) {
			try {
				
				fps.elementAt(i).run();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// show feed messages
			for(int j = 0; j < Global.myFeed.getSize(); j++) {
				System.out.println(Global.myFeed.getMessages().get(j));
			}
			System.out.println("CJNA Reader now has : " + Global.myFeed.getSize() + " messages.");
			System.out.println();
		
		}
		
		// finish the program and terminate 
	
		System.out.println("Done!");
	}
}// end class CJNA
