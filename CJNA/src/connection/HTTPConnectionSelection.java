package connection;
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
 	private URL url;
    private URLConnection urlConn; 
    private BufferedReader reader;
    
	public HTTPConnectionSelection(String URI) {
		this.URI = URI;
	}
	
	public void DirectConnect() throws IOException {
		System.out.println("Connecting without proxy...");
		HTTPDirectConnection dc = new HTTPDirectConnection(this.URI);
		this.urlConn = dc.getURLConnection();
	}
	
	public void ProxyConnect() throws HttpException, IOException {
		System.out.println("Connecting with proxy...");
		HTTPProxyConnection proxy = new HTTPProxyConnection(this.URI);
		this.reader = proxy.getBufferedReader();
	}

	public URLConnection getURLConnection() {
		return this.urlConn;
	}
	
	public BufferedReader getBufferedReader() {
		return this.reader;
	}
}// end class HTTPConnection
