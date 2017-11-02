package com.mrx.appfactory.common.util;

/**
 * 
 * @author xuwen
 *
 */
public class GMKUtil {

    public static int getKB(String gmkString) {
        if (StringUtil.isBlank(gmkString)) {
            return 0;
        }

        try {
            String unit = gmkString.substring(gmkString.length() - 2, gmkString.length());
            float num = Float.valueOf(gmkString.substring(0, gmkString.length() - 2));
            if ("GB".equalsIgnoreCase(unit)) {
                return (int) (num * 1024 * 1024);
            } else if ("MB".equalsIgnoreCase(unit)) {
                return (int) (num * 1024);
            } else if ("KB".equalsIgnoreCase(unit)) {
                return (int) num;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}

