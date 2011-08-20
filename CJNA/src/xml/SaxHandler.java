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
			System.out.println("Document processing finished.");
		}
		
		public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
			 System.out.println();
		        System.out.print("<" + qName + "");
		        if (attrs.getLength() == 0) {
		            System.out.print(">");
		        } 
		        else {
		            System.out.print(" ");
		            for (int i = 0; i < attrs.getLength(); i++) {
		                System.out.print(attrs.getLocalName(i) + " => "
		                        + attrs.getValue(i));
		            }
		            System.out.print(">");
		        }
		}

		public void endElement(String uri, String localName, String qName) throws SAXException {
	        System.out.print("\n</" + qName + ">");
	    }

}// end class SaxHandler
