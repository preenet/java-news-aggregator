/**
 * @author Pree
 */


package xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class SaxDriver {
	private String URI;
	public SaxDriver(String URI) {
		this.URI = URI;
		try {
			parse();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void parse() throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
	    SAXParser parser = factory.newSAXParser();
	    SaxHandler handler = new SaxHandler();
	    parser.parse(URI, handler);
	}
}// end class SaxDriver