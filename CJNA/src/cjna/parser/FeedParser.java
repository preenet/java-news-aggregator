package cjna.parser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import cjna.Global;
import cjna.net.HTTPProxyConnection;
import cjna.net.HTTPProxyData;

/**
 * @author Pree
 *
 */
public class FeedParser implements Runnable {
	private String URI;
	private HTTPProxyConnection tempConn;
	public FeedParser(String URI)  {
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
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	    SaxHandler handler = new SaxHandler();
	    System.out.println("Parsing " + URI);
	    
	    try {
	    	if(HTTPProxyData.getInstance().isProxy()) {
			tempConn = new HTTPProxyConnection(URI);

			parser.parse(new InputSource(tempConn.getBufferedReader()), handler);
			
	    	}
	    	else if(!HTTPProxyData.getInstance().isProxy()){
	    		parser.parse(URI, handler);
	    	}
	    	 
	    }catch (SAXException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
		
	}
}// end class FeedParser
