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
    	System.out.println("Detecting Proxy Server and Port...");
    	this.execute();
    }
    
 
    public void execute() {
        try {
            
            System.setProperty("java.net.useSystemProxies","true");
            List<Proxy> l = ProxySelector.getDefault().select(
                        new URI(Global.listURI));
            
            for (Iterator<Proxy> iter = l.iterator(); iter.hasNext(); ) {
                
                Proxy proxy = (Proxy) iter.next();
                
                System.out.println("proxy hostname : " + proxy.type());
                
                InetSocketAddress addr = (InetSocketAddress)
                    proxy.address();
                
                if(addr == null) {
                    
                    System.out.println("No Proxy");
                    
                } else {
                    
                    System.out.println("proxy hostname : " + addr.getHostName());
                    
                    System.out.println("proxy port : " + addr.getPort());
                    isProxy = true;
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