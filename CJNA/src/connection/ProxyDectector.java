package connection;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

/**
 * @author Pree
 */
import cjna.Global;

public class ProxyDectector {
	
	private String host;
	private int port;
	private boolean isProxy = false;
    
    public ProxyDectector(){
    	System.out.println("Detecting Proxy Type, Host and Port...");
    	this.execute();
    }
 
    public void execute() {
        try {
            
            System.setProperty("java.net.useSystemProxies","true");
            List<Proxy> proxyList = ProxySelector.getDefault().select(
                        new URI(Global.listURI));
            
            for (Iterator<Proxy> iter = proxyList.iterator(); iter.hasNext(); ) {
                
                Proxy proxy = (Proxy) iter.next();
                if (!proxyList.isEmpty()) {
                    switch (proxy.type()) {
                        case DIRECT:
                            System.out.println("Direct connection - no proxy.");
                            break;
                        case HTTP:
                            System.out.println("HTTP proxy: " + proxy.address());
                            isProxy = true;
                            break;
                        case SOCKS:
                            System.out.println("SOCKS proxy: " + proxy.address());
                            isProxy = true;
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getPort() {
    	return this.port;
    }
    
    public String getHost() {
    	return this.host;
    }
    
    public boolean isProxy() {
    	return this.isProxy;
    }
}// end class ProxtDectector