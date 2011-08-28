package cjna.connection;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NTCredentials;
import org.apache.commons.httpclient.auth.AuthPolicy;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;

import cjna.Global;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Pree
 *
 */
public class HTTPProxyConnection {
	private BufferedReader reader;
	private String URI;
	public HTTPProxyConnection(String URI) throws HttpException, IOException {
		this.URI = URI;
		this.execute();
	}
	
	public void execute() throws HttpException, IOException {
		HttpClient proxyClient = new HttpClient();
		proxyClient.getHostConfiguration().setProxy(Global.proxyHost, Global.proxyPort);
		
		List<String> authPrefs = new ArrayList<String>();
		authPrefs.add(AuthPolicy.NTLM);

        proxyClient.getState().setProxyCredentials(
            new AuthScope(null, 8080, null),
            new NTCredentials(Global.proxyUserName, Global.proxyPassword, "", Global.proxyDomain));

        proxyClient.getParams().setParameter(AuthPolicy.AUTH_SCHEME_PRIORITY, authPrefs);

        HttpMethod get = new GetMethod(this.URI);
   
        int status = proxyClient.executeMethod(get);
        System.out.println("HTTP status is: " + status);
      
        reader = new BufferedReader(new InputStreamReader(get.getResponseBodyAsStream()));

	}
	public BufferedReader getBufferedReader() {
		return this.reader;
	}
}// end class HTTPProxyConnection
