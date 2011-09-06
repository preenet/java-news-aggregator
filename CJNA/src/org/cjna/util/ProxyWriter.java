package org.cjna.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.cjna.net.HTTPProxyData;

public class ProxyWriter {
	public ProxyWriter() throws IOException {
		FileWriter fstream = new FileWriter("proxy.ini");
		  BufferedWriter out = new BufferedWriter(fstream);
		  
		  System.out.println("Start writing proxy configuration to file..");
		  if(HTTPProxyData.getInstance().isProxy()) {
			  out.write("true" + "\n");
			  out.write(HTTPProxyData.getInstance().getProxyHost() + "\n");
			  out.write(HTTPProxyData.getInstance().getProxyPort() + "\n");
			  out.write(HTTPProxyData.getInstance().getProxyDomain() + "\n");
			  out.write(HTTPProxyData.getInstance().getProxyUserName() + "\n");
			  out.write(HTTPProxyData.getInstance().getProxyPassword() + "\n");
		  }
		  else 
			  out.write("false");
		  
		  System.out.println("Done writing proxy configuration.");
		  //Close the output stream
		  out.close();
	}
}// end class ProxyWriter
