package connection;
import java.net.*;

/**
 * @author Pree
 *
 */
public class HTTPConnectionSelection {
	
	private String URI;
 	private URL url;
    private URLConnection urlConn; 
    
	public HTTPConnectionSelection(String URI) {
		this.URI = URI;
		this.execute();
	}
	
	public void execute() {
		try {
			ProxyDectector pd = new ProxyDectector();
			if(!pd.isProxy()) {
				System.out.println("Connecting without proxy...");
				HTTPDirectConnection dc = new HTTPDirectConnection(this.URI);
				this.urlConn = dc.getURLConnection();
			}
			else if(pd.isProxy()) {
				System.out.println("Connecting with proxy...");
	    		HTTPProxyConnection proxy = new HTTPProxyConnection(this.URI);
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
