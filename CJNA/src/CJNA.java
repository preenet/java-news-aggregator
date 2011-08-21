import parser.FeedParser;
import cjna.GetNewsList;
import cjna.Global;

/**
 * @author Pree
 */

public class CJNA {
	public static void main(String args[]) {
		GetNewsList myList = new GetNewsList();
		FeedParser fp;
		
		System.out.println("News List are as following: ");
		for(int i = 0; i < Global.URI.size(); i++) {
			System.out.println(Global.URI.get(i));
		}
		System.out.println();
		
		// loop through news list
		for(int i = 0; i < Global.URI.size(); i++)
			fp = new FeedParser(Global.URI.get(i));
		System.out.println("Done!");
	}
}// end class CJNA
