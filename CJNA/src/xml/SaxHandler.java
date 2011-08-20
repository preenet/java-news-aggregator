/**
 * @author Pree
 */
package xml;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
		public void startDocument() throws SAXException {
			System.out.println("Document processing started");
		}
	  
		public void endDocument() throws SAXException {
			System.out.println("Document processing finished");
		}
}// end class SaxHandler
