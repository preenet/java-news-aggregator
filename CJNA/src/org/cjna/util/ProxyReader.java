package org.cjna.util;

import java.io.IOException;
import java.util.Vector;

import org.cjna.Global;
import org.cjna.net.HTTPProxyData;

/**
 * @author Pree Thiengburanathum preenet@gmail.com
 *
 */
public class ProxyReader {
	private ExternalFile exFile;
	private Vector<String> dataLine;
	
	public ProxyReader() {
		
	}
	/**
	 * @throws IOException
	 */
	public void read() throws IOException {
		System.out.println("Reading proxy setting from file...");
		exFile = new ExternalFile(Global.proxyFile);
		
		dataLine = new Vector<String>();
		
		while(!exFile.havehitEOF()) {
			dataLine.add(exFile.getLine());
		}
		
		if(!dataLine.isEmpty() && dataLine.size() == 6){
			HTTPProxyData.getInstance().setProxy(isProxy(dataLine.elementAt(0)));
			HTTPProxyData.getInstance().setProxyHost(dataLine.elementAt(1));
			HTTPProxyData.getInstance().setProxyPort(dataLine.elementAt(2));
			HTTPProxyData.getInstance().setProxyDomain(dataLine.elementAt(3));
			HTTPProxyData.getInstance().setProxyUserName(dataLine.elementAt(4));
			HTTPProxyData.getInstance().setProxyPassword(dataLine.elementAt(5));
		}
	}
	/**
	 * 
	 * @param p
	 * @return boolean true or false
	 */
	private boolean isProxy(String p) {
		if(p.equals("true"))
			return true;
		return false;
	}

}// end class ProxyReader
