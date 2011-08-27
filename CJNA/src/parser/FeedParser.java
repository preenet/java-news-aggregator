package parser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.httpclient.HttpException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import connection.HTTPProxyConnection;
import connection.ProxyDetector;


/**
 * @author Pree
 *
 */
public class FeedParser implements Runnable {
	private String URI;
	private HTTPProxyConnection tempConn;
	private ProxyDetector pd;
	public FeedParser(String URI, ProxyDetector pd)  {
		this.URI = URI;
		this.pd = pd;
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
	    	if(pd.isProxy()) {
	    		System.out.println("PD IS PROXY");
			tempConn = new HTTPProxyConnection(URI);

			parser.parse(new InputSource(tempConn.getBufferedReader()), handler);
			
	    	}
	    	else if(!pd.isProxy()){
	    		System.out.println("PD IS NOT PROXY");
	    		parser.parse(URI, handler);
	    	}
	    	 
	    }catch (SAXException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
		
	    
	}
}// end class FeedParser
