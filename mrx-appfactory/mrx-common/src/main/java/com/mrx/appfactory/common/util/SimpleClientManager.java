package com.mrx.appfactory.common.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;

/**
 * 
 * @author xuwen
 *
 */
public class SimpleClientManager {

    private static SimpleClientManager simple = new SimpleClientManager();

    static {
        Protocol myhttps443 = new Protocol("https443", new MySSLProtocolSocketFactory(), 443);
        Protocol myhttps10443 = new Protocol("https10443", new MySSLProtocolSocketFactory(), 10443);
        Protocol myhttps10444 = new Protocol("https10444", new MySSLProtocolSocketFactory(), 10444);
        Protocol.registerProtocol("https443", myhttps443);
        Protocol.registerProtocol("https10443", myhttps10443);
        Protocol.registerProtocol("https10444", myhttps10444);
    }
    
    private MultiThreadedHttpConnectionManager connectionManager;

    private static final int TIMEOUT = 30 * 1000;
    private static final int CONNECTTION_TIMEOUT = 5 * 1000;
    private static final int MAX_HTTP_CONNECTION = 500;
    private static final int MAX_CONNECTION_PER_HOST = 100;

    private SimpleClientManager() {
        connectionManager = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams httpConnectionManagerParams = new HttpConnectionManagerParams();
        httpConnectionManagerParams.setMaxTotalConnections(MAX_HTTP_CONNECTION);
        httpConnectionManagerParams.setDefaultMaxConnectionsPerHost(MAX_CONNECTION_PER_HOST);
        httpConnectionManagerParams.setSoTimeout(TIMEOUT);
        httpConnectionManagerParams.setConnectionTimeout(CONNECTTION_TIMEOUT);
        connectionManager.setParams(httpConnectionManagerParams);
        
    }

    public static SimpleClientManager getInstance() {
        return simple;
    }

    /**
     * 
     * @return
     */
    public HttpClient createHttpClient() {
        HttpClient httpClient = new HttpClient(connectionManager);
        return httpClient;
    }
}
