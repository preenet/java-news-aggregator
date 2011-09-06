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
	private String msg;

	public FetchNewsList(String URI, CJNADriver myDriver) {
		this.URI = URI;
		this.myDriver = myDriver;
		this.msg = "";
		myConnSelect = new HTTPConnectionSelection(this.URI);
	}

	/**
	 * This method will check if we via direct connection or via proxy, the it
	 * will read the list of rss URLs from the site to the URI collection for
	 * future parse.
	 */
	public void execute() {
		msg = "Connecting to news list server at " + this.URI;
		System.out.println(msg);
		myDriver.setSystemMsg(msg);
	
		try {
			if (!HTTPProxyData.getInstance().isProxy()) {
				myConnSelect.DirectConnect();
				reader = new BufferedReader(new InputStreamReader(myConnSelect
						.getURLConnection().getInputStream()));
				String s;

				while ((s = reader.readLine()) != null) {
					Global.URI.add(s);
				}
				close();
			} else if (HTTPProxyData.getInstance().isProxy()) {
				myConnSelect.ProxyConnect();
				reader = myConnSelect.getBufferedReader();
				String s;

				while ((s = reader.readLine()) != null) {
					Global.URI.add(s);
				}
				close();
			} else {
				msg = "Error: Can't connect to the list server.";
				System.out.println(msg);
				myDriver.setSystemMsg(msg);
			}
		} catch (Exception e) {
		}

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
