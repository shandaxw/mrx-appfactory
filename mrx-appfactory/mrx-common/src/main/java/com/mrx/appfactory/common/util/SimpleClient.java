package com.mrx.appfactory.common.util;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.mrx.appfactory.common.core.APIException;
import com.mrx.appfactory.common.core.APIResults;

/**
 * 
 * @author xuwen
 *
 */
public class SimpleClient {

    public static enum MethodType {
        POST,
        GET
    }

    static Logger log = LoggerFactory.getLogger(SimpleClient.class);

    private static HttpClient httpClient;

    static {
        SimpleClientManager clientManager = SimpleClientManager.getInstance();
        httpClient = clientManager.createHttpClient();
    }

    /**
     * post application/json
     * @param url
     * @param mapParam
     * @return
     * @throws Exception
     */
    public static String postJsonMap(String url, Map<String, String> mapParam) throws Exception {

        String jsonString = JSON.toJSONString(mapParam);

        return postJson(url, jsonString);
    }

    /**
     * post application/json
     * @param url
     * @param object
     * @return
     * @throws Exception
     */
    public static String postJsonObject(String url, Object object) throws Exception {

        String jsonString = JSON.toJSONString(object);

        return postJson(url, jsonString);
    }

    /**
     * post multipart.Part
     * @param url
     * @param postObject
     * @return
     * @throws Exception
     */
    public static String postObject(String url, Object postObject) throws Exception {

        List<PostPart> postParts = new ArrayList<PostPart>();

        Field[] fs = postObject.getClass().getDeclaredFields();
        for (Field f : fs) {
            try {
                f.setAccessible(true);
                Object value = f.get(postObject);
                if (value != null) {
                    PostPart part = new PostPart(f.getName(), String.valueOf(value));
                    postParts.add(part);
                }

            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return post(url, postParts);
    }

    /**
     * post multipart.Part
     * @param url
     * @param postParts
     * @return
     * @throws Exception
     */
    public static String post(String url, List<PostPart> postParts) throws Exception {
        return post(url, null, null, postParts);
    }

    /**
     * post String body text/html
     * @param url
     * @param param
     * @return
     * @throws Exception
     */
    public static String postString(String url, String param) throws Exception {

        PostMethod method = new PostMethod(url);
        if (StringUtil.isNotBlank(param)) {
            RequestEntity enty = new StringRequestEntity(param, "text/html", "UTF-8");
            method.setRequestEntity(enty);
        }
        httpClient.executeMethod(method);

        return getResponseString(method);
    }

    /**
     * 〈一句话功能简述〉application/x-www-form-urlencoded
     * 〈功能详细描述〉
     *
     * @param url
     * @param param
     * @return
     * @throws Exception
     */
    public static String postForm(String url, String param) throws Exception {

        PostMethod method = new PostMethod(url);
        if (StringUtil.isNotBlank(param)) {
            RequestEntity enty = new StringRequestEntity(param, "application/x-www-form-urlencoded",
                    "UTF-8");
            method.setRequestEntity(enty);
        }
        httpClient.executeMethod(method);

        return getResponseString(method);
    }

    /**
     * post application/json
     * @param url
     * @param jsonString
     * @return
     * @throws Exception
     */
    public static String postJson(String url, String jsonString) throws Exception {

        PostMethod method = new PostMethod(url);
        RequestEntity enty = new StringRequestEntity(jsonString, "application/json", "UTF-8");
        method.setRequestEntity(enty);
        httpClient.executeMethod(method);

        return getResponseString(method);
    }

    /**
     * post application/json
     * @param url
     * @param headerMap
     * @param jsonString
     * @return
     * @throws Exception
     */
    public static String postJson(String url, Map<String, String> headerMap, String jsonString)
            throws Exception {

        PostMethod method = new PostMethod(url);
        RequestEntity enty = new StringRequestEntity(jsonString, "application/json", "UTF-8");
        method.setRequestEntity(enty);
        if (headerMap != null) {
            for (Entry<String, String> header : headerMap.entrySet()) {
                method.setRequestHeader(header.getKey(), header.getValue());
            }
        }
        httpClient.executeMethod(method);

        return getResponseString(method);
    }

    /**
     * post multipart.Part and file
     * @param url
     * @param fileFieldName
     * @param file
     * @param postParts
     * @return
     * @throws Exception
     */
    public static String post(String url, String fileFieldName, File file, List<PostPart> postParts)
            throws Exception {
        PostMethod post = new PostMethod(url);

        List<Part> parts = new ArrayList<Part>();

        if (postParts != null) {
            parts.addAll(postParts);
        }
        if (file != null && fileFieldName != null) {
            parts.add(new FilePart(fileFieldName, file));
        }

        post.setRequestEntity(
                new MultipartRequestEntity(parts.toArray(new Part[0]), post.getParams()));

        httpClient.executeMethod(post);

        return getResponseString(post);
    }

    public static String getString(String uri, String queryString) throws Exception {
        return getString(uri, queryString, null);
    }
    
    public static String getString(String uri, String queryString, Map<String, String> headers) throws Exception {
        GetMethod get = new GetMethod(uri);

        if (queryString != null) {
            get.setQueryString(queryString);
        }
        if(headers!=null && headers.size()>0){
            for(Map.Entry<String, String> header: headers.entrySet()){
                get.setRequestHeader(header.getKey(), header.getValue());
            }
        }

        httpClient.executeMethod(get);

        return getResponseString(get);
    }

    public static String getMap(String uri, Map<String, String> queryParamMap) throws Exception {
        GetMethod get = new GetMethod(uri);

        if (queryParamMap != null) {
            List<NameValuePair> nvList = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : queryParamMap.entrySet()) {
                nvList.add(new NameValuePair(entry.getKey(), entry.getValue()));
            }
            get.setQueryString(nvList.toArray(new NameValuePair[0]));
        }

        httpClient.executeMethod(get);

        return getResponseString(get);
    }
    
    /**
     * soap request
     * @param url
     * @param action
     * @param object
     * @return
     * @throws Exception
     */
    public static String postSoapObject(String url, String action, Object object)
            throws Exception {
        PostMethod post = new PostMethod(url);

        Header contentTypeHeader = new Header("Content-Type", "text/xml; charset=utf-8");

        post.addRequestHeader(contentTypeHeader);

        Header actionHeader = new Header("SOAPAction", action);

        post.addRequestHeader(actionHeader);

        String requestString = XMLUtil.bean2XML(object);

        if (StringUtil.isNotBlank(requestString)) {
            RequestEntity requestEntity = new StringRequestEntity(requestString, "text/xml", "UTF-8");
            post.setRequestEntity(requestEntity);
        }

        httpClient.executeMethod(post);

        return getResponseString(post);
    }

    public static String getResponseString(PostMethod method) throws Exception {
        if (method.getStatusCode() == 200) {
            String str = StringUtil.convertStreamToUTF8String(method.getResponseBodyAsStream());
            log.info("返回的数据：" + str);
            return str;
        } else {
            log.error("!!!network error code {}", method.getStatusCode());
            throw new APIException(APIResults.ELSE);
        }
    }

    public static String getResponseString(GetMethod method) throws Exception {
        if (method.getStatusCode() == 200) {
            String str = StringUtil.convertStreamToUTF8String(method.getResponseBodyAsStream());
            log.info(str);
            return str;
        } else {
            log.error("!!!network error code {}", method.getStatusCode());
            throw new APIException(APIResults.ELSE);
        }
    }

    /**
     * 〈一句话功能简述〉
     * 〈功能详细描述〉
     *
     * @param apiUrl
     * @param paramMap
     * @return
     * @throws Exception 
     */
    public static String postJsonObjectGBK(String apiUrl, Map<String, Object> paramMap)
            throws Exception {
        String jsonString = JSON.toJSONString(paramMap);

        return postJsonGBK(apiUrl, jsonString);
    }

    private static String postJsonGBK(String apiUrl, String jsonString) throws Exception {

        PostMethod method = new PostMethod(apiUrl);
        RequestEntity enty = new StringRequestEntity(jsonString, "application/json", "gbk");
        method.setRequestEntity(enty);
        httpClient.executeMethod(method);

        return getResponseStringGBK(method);
    }

    private static String getResponseStringGBK(PostMethod method) throws Exception {
        if (method.getStatusCode() == 200) {
            String str = StringUtil.convertStreamToGBKString(method.getResponseBodyAsStream());
            log.info("返回的数据：" + str);
            return str;
        } else {
            log.error("!!!network error code {}", method.getStatusCode());
            throw new APIException(APIResults.ELSE);
        }
    }

}
