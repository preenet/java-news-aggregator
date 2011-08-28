package cjna.net;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.*;

import org.apache.commons.httpclient.HttpException;



/**
 * @author Pree
 *
 */
public class HTTPConnectionSelection {
	
	private String URI;
    private URLConnection urlConn; 
    private BufferedReader reader;
    
	public HTTPConnectionSelection(String URI) {
		this.URI = URI;
	}
	/**
	 * Method calling to use the direct connection.
	 * @throws IOException
	 */
	public void DirectConnect() throws IOException {
		System.out.println("Connecting without proxy...");
		HTTPDirectConnection dc = new HTTPDirectConnection(this.URI);
		this.urlConn = dc.getURLConnection();
	}
	
	/**
	 * Method calling to use the proxy connection.
	 * @throws HttpException
	 * @throws IOException
	 */
	public void ProxyConnect() throws HttpException, IOException {
		System.out.println("Connecting with proxy...");
		HTTPProxyConnection proxy = new HTTPProxyConnection(this.URI);
		this.reader = proxy.getBufferedReader();
	}
	
	/**
	 * Return method returning url connection.
	 * @return urlConn
	 */
	public URLConnection getURLConnection() {
		return this.urlConn;
	}
	
	/**
	 * Return method return the buffered.
	 * @return reader
	 */
	public BufferedReader getBufferedReader() {
		return this.reader;
	}
}// end class HTTPConnection
