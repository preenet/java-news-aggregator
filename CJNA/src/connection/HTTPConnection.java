package connection;
import java.net.*;

/**
 * @author Pree
 *
 */
public class HTTPConnection {
	
	private String listURI;
 	private URL url;
    private URLConnection urlConn; 
    
	public HTTPConnection(String listURI) {
		this.listURI = listURI;
		this.execute();
	}// end constructor
	
	public void execute() {
		try {
			System.out.println("Connecting without proxy.");
		  	url = new URL(this.listURI);
	    	
	    	if(url.openConnection().getContentLength() > 0) {
	    		System.out.println("Connected to the server.");
			    urlConn = url.openConnection(); 
			    urlConn.setDoInput(true); 
			    urlConn.setUseCaches(false);
	    	}
	    	else if(urlConn == null) {
	    		System.out.println("Connecting through proxy.");
	    		HTTPProxyConnection proxy = new HTTPProxyConnection();
	    		proxy.execute();
	    		System.out.println("Connected via the proxy");
	    		urlConn = url.openConnection(); 
				urlConn.setDoInput(true); 
				urlConn.setUseCaches(false);
	    	}
	    	// giving error for no connection
			else {
				System.out.println("Error: Couldn't connect to the server.");
				System.exit(0);
			}
	    }catch(Exception e) {}
    }// end method execute
	
	public URLConnection getURLConnection() {
		return this.urlConn;
	}// end method URLConnection
}// end class HTTPConnection
