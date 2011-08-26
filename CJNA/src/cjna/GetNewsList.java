package cjna;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import connection.HTTPConnectionSelection;
import connection.ProxyDectector;

/**
 * @author Pree
 *
 */

public class GetNewsList extends Thread {
		
		private BufferedReader reader;
		private ProxyDectector pd;
		private HTTPConnectionSelection myConnSelect;
	 
	    public GetNewsList() {
	    	pd = new ProxyDectector();
	    	myConnSelect = new HTTPConnectionSelection(Global.listURI);
	    }
	    
		@Override
		public void run() {
			System.out.println("Connecting to news list server at " + Global.listURI);
			  try {
				  if(!pd.isProxy()) {
					  myConnSelect.DirectConnect();
					  reader = new BufferedReader(new InputStreamReader
							  (myConnSelect.getURLConnection().getInputStream())); 
					  String s; 
				  
					    while ((s = reader.readLine()) != null) {
					      Global.URI.add(s);
					    }
					     close();
				  }
				  else if(pd.isProxy()) {
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
