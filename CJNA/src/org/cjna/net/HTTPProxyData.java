package org.cjna.net;

import java.io.IOException;

import org.cjna.util.ProxyReader;

/**
 * @author Pree Thiengburanathum preenet@gmail.com
 * 
 */
public class HTTPProxyData {

	private boolean isProxy;
	private int proxyPort;
	private String proxyHost;
	private String proxyDomain;
	private String proxyUserName;
	private String proxyPassword;

	private static class HTTPProxyDataHolder {
		private static final HTTPProxyData INSTANCE = new HTTPProxyData();

	}

	public HTTPProxyData() {
		// default configuration for the proxy setting if there is no previous setup
		this.isProxy = false;
		this.proxyDomain = "camt";
		this.proxyHost = "192.168.11.1";
		this.proxyUserName = "";
		this.proxyPassword = "";
		this.proxyPort = 8080;
	}

	/**
	 * 
	 * @return the instance
	 */
	public static HTTPProxyData getInstance() {
		return HTTPProxyDataHolder.INSTANCE;
	}

	/**
	 * 
	 * @param proxyPort
	 */
	public void setProxyPort(String proxyPort) {
		this.proxyPort = Integer.parseInt(proxyPort);
	}

	/*
	 * getter and setter methods.
	 */
	public int getProxyPort() {
		return proxyPort;
	}

	/**
	 * 
	 * @param proxyHost
	 */
	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	/**
	 * 
	 * @param isProxy
	 */
	public void setProxy(boolean isProxy) {
		this.isProxy = isProxy;
	}

	public boolean isProxy() {
		return isProxy;
	}

	/**
	 * 
	 * @param proxyUserName
	 */
	public void setProxyUserName(String proxyUserName) {
		this.proxyUserName = proxyUserName;
	}

	/**
	 * 
	 * @return proxyUserName
	 */
	public String getProxyUserName() {
		return proxyUserName;
	}

	/**
	 * 
	 * @param proxyDomain
	 */
	public void setProxyDomain(String proxyDomain) {
		this.proxyDomain = proxyDomain;
	}

	/**
	 * 
	 * @return proxyDomain
	 */
	public String getProxyDomain() {
		return proxyDomain;
	}

	/**
	 * 
	 * @param proxyPassword
	 */
	public void setProxyPassword(String proxyPassword) {
		this.proxyPassword = proxyPassword;
	}

	/**
	 * 
	 * @return proxyPassword
	 */
	public String getProxyPassword() {
		return proxyPassword;
	}

	public void resetProxyData() {
		this.isProxy = false;
		this.proxyDomain = "";
		this.proxyHost = "";
		this.proxyPassword = "";
		this.proxyPort = 0;
	}
}// end class HTTPProxyData
