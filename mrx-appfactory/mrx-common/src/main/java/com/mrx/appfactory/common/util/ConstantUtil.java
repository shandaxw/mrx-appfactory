package com.mrx.appfactory.common.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 
 * @author xuwen
 *
 */
public class ConstantUtil {

    private final static long UPDATE_TIME = 2 * 1000;

    private static class MyResourceBundleControl extends ResourceBundle.Control {

        @Override
        public long getTimeToLive(String baseName, Locale locale) {
            return UPDATE_TIME;
        }
    }

    private static final MyResourceBundleControl MY_CTL = new MyResourceBundleControl();

    /**
     * use MyResourceBundleControl
     * @param propFile conf/java
     * @param key
     * @return
     */
    public static String getConstant(String propFile, String key) {
        ResourceBundle bundle = ResourceBundle.getBundle(propFile, Locale.getDefault(), MY_CTL);
        return bundle.getString(key);
    }
}

