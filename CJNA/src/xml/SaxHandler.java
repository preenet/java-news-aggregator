package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Pree
 *
 */
public class SaxHandler extends DefaultHandler {
		private boolean title = false;
		
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
	
	        if (qName.equalsIgnoreCase("title")) {
				title = true;
			}
		}
		
		@Override
		public void characters(char ch[], int start, int length) throws SAXException {
			
			if(title) {
				System.out.println(new String(ch, start, length));
				title = false;
			}
		}
		
		public void endElement(String uri, String localName, String qName) throws SAXException {
	      
	    }

}// end class SaxHandler
