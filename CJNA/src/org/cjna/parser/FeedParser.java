package org.cjna.parser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.cjna.GlobalData;
import org.cjna.net.HTTPProxyConnection;
import org.cjna.net.HTTPProxyData;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;



/**
 * @author Pree
 *
 */
public class FeedParser extends Thread {
	private String URI;
	private HTTPProxyConnection tempConn;
	private GlobalData myData;
	public FeedParser(String URI, GlobalData myData)  {
		this.URI = URI;
		this.myData = myData;
		this.start();
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
	    SaxHandler handler = new SaxHandler(myData);
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
