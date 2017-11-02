package com.mrx.appfactory.common.util;

import org.apache.commons.httpclient.methods.multipart.StringPart;

/**
 * 
 * @author xuwen
 *
 */
public class PostPart extends StringPart {

    public PostPart(String name, String value, String charset) {
        super(name, value, charset);
    }

    public PostPart(String name, String value) {
        super(name, value, Constant.POST_CHARSET);
    }

}
