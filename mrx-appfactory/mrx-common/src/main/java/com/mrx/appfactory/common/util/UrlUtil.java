package com.mrx.appfactory.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author xuwen
 *
 */
public class UrlUtil {

    public static String getQueryString(Map<String, String> kvmap) {

        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(
                kvmap.entrySet());

        StringBuilder sb = new StringBuilder();

        int kcount = list.size();
        
        for (int i = 0; i < kcount; i++) {
            Entry<String, String> entry = list.get(i);
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            if (i < list.size() - 1) {
                sb.append("&");
            }
        }
        return sb.toString();
    }
    
    public static String getOrderQueryString(Map<String, String> kvmap) {

        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(
                kvmap.entrySet());

        StringBuilder sb = new StringBuilder();

        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Entry<String, String> o1, Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (int i = 0; i < list.size(); i++) {
            Entry<String, String> entry = list.get(i);
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            if (i < list.size() - 1) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

}

