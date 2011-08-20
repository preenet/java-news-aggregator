import cjna.GetNewsList;
import cjna.Global;
/**
 * @author Pree
 */

public class CJNA {
	public static void main(String args[]) {
		GetNewsList myList = new GetNewsList();
		for(int i = 0; i < Global.URI.size(); i++) {
			System.out.println(Global.URI.get(i));
		}
	}
}// end class CJNA
