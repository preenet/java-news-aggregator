package org.cjna;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.cjna.net.HTTPConnectionSelection;
import org.cjna.net.HTTPProxyData;



/**
 * @author Pree
 *
 */

public class FetchNewsList {
		
		private BufferedReader reader;
		private HTTPConnectionSelection myConnSelect;
		private String URI;
		private GlobalData myData;

		
	    public FetchNewsList(String URI, GlobalData myData) {
	    	this.URI = URI;
	    	this.myData = myData;
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
					      myData.getURI().add(s);
					    }
					     close();
				  }
				  else if(HTTPProxyData.getInstance().isProxy()) {
					  myConnSelect.ProxyConnect();
					  reader = myConnSelect.getBufferedReader();
					  String s; 
					  
					    while ((s = reader.readLine()) != null) {
					    	myData.getURI().add(s);
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
