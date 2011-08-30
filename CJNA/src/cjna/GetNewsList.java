package cjna;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cjna.net.HTTPConnectionSelection;
import cjna.net.HTTPProxyData;


/**
 * @author Pree
 *
 */

public class GetNewsList {
		
		private BufferedReader reader;
		private HTTPConnectionSelection myConnSelect;
		public String URI;
	    public GetNewsList(String URI) {
	    	this.URI = URI;
	    	myConnSelect = new HTTPConnectionSelection(this.URI);
	    }
	  
	    /**
	     * This method will check if we via direct connection or via proxy, the
	     * it will read the list of rss URLs from the site to the URI collection
	     * for future parse.
	     */
		public void execute() {
			System.out.println("Connecting to news list server at " + this.URI);
			  try {
				  if(!HTTPProxyData.getInstance().isProxy()) {
					  myConnSelect.DirectConnect();
					  reader = new BufferedReader(new InputStreamReader
							  (myConnSelect.getURLConnection().getInputStream())); 
					  String s; 
				  
					    while ((s = reader.readLine()) != null) {
					      Global.URI.add(s);
					    }
					     close();
				  }
				  else if(HTTPProxyData.getInstance().isProxy()) {
					  myConnSelect.ProxyConnect();
					  reader = myConnSelect.getBufferedReader();
					  String s; 
					  
					    while ((s = reader.readLine()) != null) {
					      Global.URI.add(s);
					    }
					      close();
				  }
				  else {
					  System.out.println("Error: Can't connect to the list server.");
				  }
			    }catch(Exception e) {}
			  
		}
		private void close() throws IOException {
			System.out.println("Retreived the news list URI...");
		    reader.close(); 
		    System.out.println("Disconnected to the news list server.");
		}
}// end class GetNewsList
