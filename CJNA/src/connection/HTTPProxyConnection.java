package connection;

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
	
	public HTTPProxyConnection() {
		
	}
	
	public void execute() throws HttpException, IOException {
		HttpClient proxyClient = new HttpClient();
		proxyClient.getHostConfiguration().setProxy(Global.proxyHost, Global.proxyPort);
		
		List<String> authPrefs = new ArrayList<String>(3);
		authPrefs.add(AuthPolicy.BASIC);
		authPrefs.add(AuthPolicy.NTLM);

        proxyClient.getState().setProxyCredentials(
            new AuthScope(null, 8080, null),
            new NTCredentials(Global.proxyUserName, Global.proxyPassword, "", Global.proxyDomain));

        proxyClient.getParams().setParameter(AuthPolicy.AUTH_SCHEME_PRIORITY, authPrefs);

        HttpMethod get = new GetMethod(Global.listURI);
        int status = proxyClient.executeMethod(get);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(get.getResponseBodyAsStream()));
        
        int count = 0;
        int read = 0;
        char[] body = new char[2048];
        do {
        	count = reader.read(body);
        	read += count;
        	System.out.println(body);
        	
        }while(count != -1);
        System.out.println("Read " + read + " bytes");
	}
}
