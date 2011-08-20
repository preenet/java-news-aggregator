/**
 * @author Pree
 */
package xml;

import org.xml.sax.Attributes;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
		public void startDocument() throws SAXException {
			System.out.println("Document processing started");
		}
	  
		public void endDocument() throws SAXException {
			System.out.println("Document processing finished");
		}
		
		public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
	
		}

		public void endElement(String uri, String localName, String qName) throws SAXException {
		}
}// end class SaxHandler
