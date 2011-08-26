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
	}
	
	public void execute() {
		try {
			ProxyDectector pd = new ProxyDectector();
			if(!pd.isProxy()) {
				System.out.println("Connecting without proxy...");
				url = new URL(this.listURI);
				urlConn = url.openConnection();
				urlConn.setDoInput(true); 
				urlConn.setUseCaches(false);
			}
			else if(pd.isProxy()) {
				System.out.println("Connecting through proxy...");
	    		HTTPProxyConnection proxy = new HTTPProxyConnection();
	    		proxy.execute();	
			}
			else {
				System.out.println("Error: No internet Connection.");
			}
			    		
	    }catch(Exception e) {}
    }
	
	public URLConnection getURLConnection() {
		return this.urlConn;
	}
}// end class HTTPConnection
