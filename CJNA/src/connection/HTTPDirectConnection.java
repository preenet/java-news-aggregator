package connection;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Pree
 *
 */
public class HTTPDirectConnection {
	private String URI;
 	private URL url;
    private URLConnection urlConn; 
    
	public HTTPDirectConnection(String URI) throws IOException {
		this.URI = URI;
		this.execute();
	}
	
	private void execute() throws IOException {
		url = new URL(this.URI);
		urlConn = url.openConnection();
		urlConn.setDoInput(true); 
		urlConn.setUseCaches(false);
	}
	
	public URLConnection getURLConnection() {
		return this.urlConn;
	}
}// end class HTTPDirectConnection
