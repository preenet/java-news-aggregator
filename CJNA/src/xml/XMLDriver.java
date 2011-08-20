
package xml;

/**
 * @author Pree
 *
 */
public class XMLDriver {
	public static void main(String args[]) {
		SaxDriver sax = new SaxDriver("http://preet.sesolution.com/camtrss/news.xml");
		System.out.println("Done!");
	}
}// end class XMLDriver
