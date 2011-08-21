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
public class FeedParser {
	public FeedParser(String URI) throws SAXException, IOException, ParserConfigurationException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
	    SAXParser parser = factory.newSAXParser();
	    SaxHandler handler = new SaxHandler();
	    System.out.println("Parsing " + URI);
	    parser.parse(URI, handler);
	}
}// end class FeedParser
