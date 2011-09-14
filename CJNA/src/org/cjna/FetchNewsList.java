package org.cjna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.cjna.net.HTTPConnectionSelection;
import org.cjna.net.HTTPProxyData;

/**
 * @author Pree Thiengburanathum preenet@gmail.com
 * 
 */

public class FetchNewsList {

	private BufferedReader reader;
	private HTTPConnectionSelection myConnSelect;
	private String URI;
	private CJNADriver myDriver;

	public FetchNewsList(String URI, CJNADriver myDriver) {
		this.URI = URI;
		this.myDriver = myDriver;
		myConnSelect = new HTTPConnectionSelection(this.URI);
	}

	/**
	 * This method will check if we via direct connection or via proxy, the it
	 * will read the list of rss URLs from the site to the URI collection for
	 * future parse.
	 * @throws IOException 
	 */
	public void execute() throws IOException {
		myDriver.setSystemMsg("Connecting to news list server");
		
			if (!HTTPProxyData.getInstance().isProxy()) {
				myDriver.setSystemMsg("Connecting via Direct Connection...");
				myConnSelect.DirectConnect();
				reader = new BufferedReader(new InputStreamReader(myConnSelect
						.getURLConnection().getInputStream()));
				String s;

				while ((s = reader.readLine()) != null) {
					Global.URI.add(s);
				}
				close();
			} else if (HTTPProxyData.getInstance().isProxy()) {
				myDriver.setSystemMsg("Connecting via Proxy Connection...");
				myConnSelect.ProxyConnect();
				reader = myConnSelect.getBufferedReader();
				String s;

				while ((s = reader.readLine()) != null) {
					Global.URI.add(s);
				}
				close();
			} else 
				myDriver.setSystemMsg("Error: Can't connect to the list server.");
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	private void close() throws IOException {
		System.out.println("Retreived the news list URI...");
		reader.close();
		System.out.println("Disconnected to the news list server.");
	}
}// end class GetNewsList
