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
		@SuppressWarnings("deprecation")
		public GetNewsList() {
	    URL                url; 
	    URLConnection      urlConn; 
	    DataInputStream    dis;
	    
	    try {
	    url = new URL("http://preet.sesolution.com/camtrss/news_list.txt");

		    urlConn = url.openConnection(); 
		    urlConn.setDoInput(true); 
		    urlConn.setUseCaches(false);
	    
	    
	    dis = new DataInputStream(urlConn.getInputStream()); 
	    String s; 
	  
	    Global.URI.clear(); 
	  
	    while ((s = dis.readLine()) != null)
	      Global.URI.add(s);
	      dis.close(); 
	    }
		catch(Exception e) {}
		}
}// end class GetNewsList
