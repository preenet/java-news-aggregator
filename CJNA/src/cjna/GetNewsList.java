package cjna;
import java.io.DataInputStream;
import connection.HTTPConnectionSelection;

/**
 * @author Pree
 *
 */

public class GetNewsList extends Thread {
		
		private DataInputStream dis;
		private HTTPConnectionSelection myConn;
	 
	    public GetNewsList() {
	    	myConn = new HTTPConnectionSelection(Global.listURI);
	    }
	    
		@Override
		public void run() {
			System.out.println("Connecting to news list server at " + Global.listURI);
			  try {
				  dis = new DataInputStream(myConn.getURLConnection().getInputStream()); 
				  String s; 
				  
					    while ((s = dis.readLine()) != null) {
					      Global.URI.add(s);
					    }
					      System.out.println("Retreived the news list URI...");
					      dis.close(); 
					      System.out.println("Disconnected to the news list server.");
			    	 
			    }catch(Exception e) {}
		}
}// end class GetNewsList
