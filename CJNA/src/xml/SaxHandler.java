package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Pree
 *
 */
public class SaxHandler extends DefaultHandler {
		@Override
		public void startDocument() throws SAXException {
			System.out.println("Document processing started");
		}
		@Override
		public void endDocument() throws SAXException {
			System.out.println("\nDocument processing finished.");
		}
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
			
	        for (int i = 0; i < attrs.getLength(); i++) {
	            System.out.print(attrs.getLocalName(i) + " => "
	                    + attrs.getValue(i));
	        }
		}
		
		@Override
		public void characters(char ch[], int start, int length) throws SAXException {
			
			System.out.println(new String(ch));
		}
		
		public void endElement(String uri, String localName, String qName) throws SAXException {
	        System.out.print("\n</" + qName + ">");
	    }

}// end class SaxHandler
