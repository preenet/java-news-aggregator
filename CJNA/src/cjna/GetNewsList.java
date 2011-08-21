package cjna;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import cjna.Global;


/**
 * @author Pree
 *
 */

@SuppressWarnings("unused")
public class GetNewsList {
	 	private URL url;


	    private URLConnection urlConn; 
	    private DataInputStream dis;
	    
		@SuppressWarnings("deprecation")
		public GetNewsList() {
			System.out.println("Connecting to news list server at " + Global.listURI);
		    try {
		    	url = new URL(Global.listURI);
		    	if(url.openConnection().getContentLength() > 0) {
		    		System.out.println("Connected to the server.");
				    urlConn = url.openConnection(); 
				    urlConn.setDoInput(true); 
				    urlConn.setUseCaches(false);
		    
				    dis = new DataInputStream(urlConn.getInputStream()); 
				    String s; 
			  
				    Global.URI.clear(); 
			  
				    while ((s = dis.readLine()) != null) {
				      Global.URI.add(s);
				    }
				      System.out.println("Retreived the news list URI...");
				      dis.close(); 
				      System.out.println("Disconnected to the news list server.");
		    	}
		    	  else {
		    		System.out.println("Error: Couldn't connect to the server.");
		  	    	System.exit(0);
		    	  }
		    }catch(Exception e) {}
	    }
}// end class GetNewsList
