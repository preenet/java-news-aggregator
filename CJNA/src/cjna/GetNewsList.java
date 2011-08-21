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
	   
		    try {
		    	url = new URL(Global.listURI);
		    	if(url.openConnection().getContentLength() > 0) {
				    urlConn = url.openConnection(); 
				    urlConn.setDoInput(true); 
				    urlConn.setUseCaches(false);
		    
				    dis = new DataInputStream(urlConn.getInputStream()); 
				    String s; 
			  
				    Global.URI.clear(); 
			  
				    while ((s = dis.readLine()) != null) {
				      Global.URI.add(s);
				    }
				      dis.close(); 
		    	}
		    	  else {
		    		System.out.println("Error: Couldn't connect to the server.");
		  	    	System.exit(0);
		    	  }
		    }catch(Exception e) {}
	    }
}// end class GetNewsList
