package parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Pree
 *
 */
public class SaxHandler extends DefaultHandler {
		private boolean title = false;
		private boolean description = false;
		
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
	        	System.out.print("<" + qName + ">");
				title = true;
			}
	        if (qName.equalsIgnoreCase("description")) {
	        	System.out.print("<" + qName + ">");
	        	description = true;
	        }
		}
		
		@Override
		public void characters(char ch[], int start, int length) throws SAXException {
			
			if(title) {
				System.out.print(new String(ch, start, length));
				title = false;
			}
			if(description) {
				System.out.print(new String(ch, start, length));
				description = false;	
			}
		}
		
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if (qName.equalsIgnoreCase("title")) {
				System.out.println("</" + qName + ">");
			}
			if (qName.equalsIgnoreCase("description")) {
		        System.out.println("</" + qName + ">");
		    }
	    }

}// end class SaxHandler
