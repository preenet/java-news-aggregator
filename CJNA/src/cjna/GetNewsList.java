package cjna;
import java.io.DataInputStream;
import connection.HTTPConnectionSelection;
import connection.ProxyDectector;

/**
 * @author Pree
 *
 */

public class GetNewsList extends Thread {
		
		private DataInputStream dis;
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
					  dis = new DataInputStream(myConnSelect.getURLConnection().getInputStream()); 
					  String s; 
				  
					    while ((s = dis.readLine()) != null) {
					      Global.URI.add(s);
					    }
					      System.out.println("Retreived the news list URI...");
					      dis.close(); 
					      System.out.println("Disconnected to the news list server.");
				  }
				  else if(pd.isProxy()) {
					  myConnSelect.ProxyConnect();
					  // TODO Convert bufferedReader to InputStream
				  }
				  else {
					  System.out.println("Error: Can't connect to the list server.");
				  }
			    }catch(Exception e) {}
			  
		}
}// end class GetNewsList
