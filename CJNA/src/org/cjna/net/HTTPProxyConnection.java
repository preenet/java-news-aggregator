package org.cjna.net;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NTCredentials;
import org.apache.commons.httpclient.auth.AuthPolicy;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.cjna.Global;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pree Thiengburanathum preenet@gmail.com
 * 
 */
public class HTTPProxyConnection {
	private BufferedReader reader;
	private String URI;

	/**
	 * 
	 * @param URI
	 * @throws HttpException
	 * @throws IOException
	 */
	public HTTPProxyConnection(String URI) throws HttpException, IOException {
		this.URI = URI;
		this.execute();
	}

	/**
	 * 
	 * @throws HttpException
	 * @throws IOException
	 */
	public void execute() throws HttpException, IOException {
		HttpClient proxyClient = new HttpClient();
		proxyClient.getHostConfiguration().setProxy(
				HTTPProxyData.getInstance().getProxyHost(),
				HTTPProxyData.getInstance().getProxyPort());

		List<String> authPrefs = new ArrayList<String>();
		authPrefs.add(AuthPolicy.NTLM);

		proxyClient.getState().setProxyCredentials(
				new AuthScope(null, 8080, null),
				new NTCredentials(HTTPProxyData.getInstance()
						.getProxyUserName(), HTTPProxyData.getInstance()
						.getProxyPassword(), "", HTTPProxyData.getInstance()
						.getProxyDomain()));

		proxyClient.setTimeout(Global.timeout);
		
		proxyClient.getParams().setParameter(AuthPolicy.AUTH_SCHEME_PRIORITY,
				authPrefs);

		HttpMethod get = new GetMethod(this.URI);
		int status = proxyClient.executeMethod(get);
		System.out.println("HTTP status is: " + status);

		reader = new BufferedReader(new InputStreamReader(
				get.getResponseBodyAsStream(), "UTF-8"));

	}

	/**
	 * 
	 * @return BufferedReader reader
	 */
	public BufferedReader getBufferedReader() {
		return this.reader;
	}
}// end class HTTPProxyConnection
