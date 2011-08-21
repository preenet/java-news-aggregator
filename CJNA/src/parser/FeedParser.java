package parser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;


/**
 * @author Pree
 *
 */
public class FeedParser implements Runnable {
	private String URI;
	public FeedParser(String URI){
		this.URI = URI;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		SAXParserFactory factory = SAXParserFactory.newInstance();
	    SAXParser parser = null;
		try {
			parser = factory.newSAXParser();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    SaxHandler handler = new SaxHandler();
	    System.out.println("Parsing " + URI);
	    try {
			parser.parse(URI, handler);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}// end class FeedParser
