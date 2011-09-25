package org.cjna;


import java.io.IOException;


import org.cjna.net.HTTPConnectionSelection;
import org.cjna.net.HTTPProxyData;

public class LogDump {
	private HTTPConnectionSelection myConnSelect;

	public LogDump() {
		myConnSelect = new HTTPConnectionSelection(Global.logURL + HTTPProxyData.getInstance().getProxyUserName());
	}
	
	public void connect() throws IOException {
		
		
		if (!HTTPProxyData.getInstance().isProxy()) {
		
			myConnSelect.DirectConnect();
	
		} else {
		
			myConnSelect.ProxyConnect();

		}
	}
}// end class LogDump
