package cjna;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import connection.HTTPConnectionSelection;
import connection.ProxyDetector;


/**
 * @author Pree
 *
 */

public class GetNewsList {
		
		private BufferedReader reader;
		private HTTPConnectionSelection myConnSelect;
	 
	    public GetNewsList() {
	    	myConnSelect = new HTTPConnectionSelection(Global.listURI);
	    }
	  
		public void execute() {
			System.out.println("Connecting to news list server at " + Global.listURI);
			  try {
				  if(ProxyDetector.getInstance().directConnectionAvailable()) {
					  myConnSelect.DirectConnect();
					  reader = new BufferedReader(new InputStreamReader
							  (myConnSelect.getURLConnection().getInputStream())); 
					  String s; 
				  
					    while ((s = reader.readLine()) != null) {
					      Global.URI.add(s);
					    }
					     close();
				  }
				  else if(!ProxyDetector.getInstance().directConnectionAvailable()) {
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
