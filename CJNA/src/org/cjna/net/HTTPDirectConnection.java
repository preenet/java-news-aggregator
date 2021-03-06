package org.cjna.net;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.cjna.Global;

/**
 * @author Pree Thiengburanathum preenet@gmail.com
 *
 */
public class HTTPDirectConnection {
	private String URI;
 	private URL url;
    private URLConnection urlConn; 
    
    /**
     * 
     * @param URI
     * @throws IOException
     */
	public HTTPDirectConnection(String URI) throws IOException {
		this.URI = URI;
		this.execute();
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	private void execute() throws IOException {
		System.out.println("Open Direct Connection to: " + this.URI);
		url = new URL(this.URI);
		HttpMethod get = new GetMethod(this.URI);
		urlConn = url.openConnection();
		urlConn.setConnectTimeout(Global.timeout);
		urlConn.setDoInput(true); 
		urlConn.setUseCaches(false);
	}
	
	/**
	 * 
	 * @return URLConnection urlConn
	 */
	public URLConnection getURLConnection() {
		return this.urlConn;
	}
}// end class HTTPDirectConnection
