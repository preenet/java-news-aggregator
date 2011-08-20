
package xml;

import cjna.Global;

/**
 * @author Pree
 *
 */
public class XMLDriver {
	public static void main(String args[]) {
		System.out.println("URI size is : " + Global.URI.size());
		//SaxDriver sax = new SaxDriver(Global.URI.get(0));
		System.out.println("Done!");
	}
}// end class XMLDriver
