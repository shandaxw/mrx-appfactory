package com.mrx.appfactory.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author xuwen
 *
 */
public class StringUtil {

    public static final String DELIM_DEFAULT = ".";

    private StringUtil() {
        // Cannot be instantiated
    }

    public static String getFirstNumber(String str) {
        if (str == null) {
            return "0";
        }
        Pattern numberPattern = Pattern.compile("[1-9][0-9]*");
        Matcher matcher = numberPattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return "0";
    }

    /**
     * 固定长度随机数字字符串，例如 0000-9999（长度为4）
     * @param length
     * @return
     */
    public static String randomNumber(int length) {
        return String
                .valueOf(Math.round(Math.random() * Math.pow(10, length) + Math.pow(10, length)))
                .substring(1);
    }

    /**
     * 
     * @param intStr
     * @return
     */
    public static int toInt(String intStr) {
        if (intStr.indexOf(DELIM_DEFAULT) > -1) {
            intStr = intStr.substring(0, intStr.indexOf(DELIM_DEFAULT));
        }
        return Integer.parseInt(intStr);
    }

    /**
     * 判断指定字符串是否等于null或空字符串
     * 
     * @param str
     *            指定字符串
     * @return 如果等于null或空字符串则返回true，否则返回false
     */
    public static boolean isBlank(String str) {
        return str == null || "".equals(str.trim());
    }

    /**
     * 判断指定字符串是否不等于null和空字符串
     * 
     * @param str
     *            指定字符串
     * @return 如果不等于null和空字符串则返回true，否则返回false
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 根据默认分隔符获取字符串前缀
     * 
     * @param str
     *            指定字符串
     * @return 返回前缀字符串
     */
    public static String getPrefix(String str) {
        return getPrefix(str, DELIM_DEFAULT);
    }

    /**
     * 根据指定分隔符获取字符串前缀
     * 
     * @param str
     *            指定字符串
     * @param delim
     *            指定分隔符
     * @return 返回字符串前缀
     */
    public static String getPrefix(String str, String delim) {
        String prefix = "";
        if (isNotBlank(str) && isNotBlank(delim)) {
            int pos = str.lastIndexOf(delim);
            if (pos > 0) {
                prefix = str.substring(0, pos);
            }
        }
        return prefix;
    }

    /**
     * 根据指定分隔符获取字符串前缀,并添加前缀的后缀
     * 
     * @param str
     *            指定字符串
     * @param delim
     *            指定分隔符
     * @return 返回字符串前缀
     */
    public static String addPrefix(String str, String delim, String addPrefix) {
        String newStr = str;
        if (isNotBlank(str) && isNotBlank(delim) && isNotBlank(addPrefix)) {
            int pos = str.lastIndexOf(delim);
            if (pos > 0) {
                String pre = getPrefix(str, delim);
                String suf = getSuffix(str, delim);
                newStr = pre + addPrefix + delim + suf;
            }
        }
        return newStr;
    }

    /**
     * 根据默认分隔符获取字符串后缀
     * 
     * @param str
     *            指定字符串
     * @return 返回字符串后缀
     */
    public static String getSuffix(String str) {
        return getSuffix(str, DELIM_DEFAULT);
    }

    /**
     * 根据指定分隔符获取字符串后缀
     * 
     * @param str
     *            指定字符串
     * @param delim
     *            指定分隔符
     * @return 返回字符串后缀
     */
    public static String getSuffix(String str, String delim) {
        String suffix = "";
        if (isNotBlank(str) && isNotBlank(delim)) {
            int pos = str.lastIndexOf(delim);
            if (pos > 0) {
                suffix = str.substring(pos + 1);
            }
        }
        return suffix;
    }

    /**
     * 根据指定字符串和重复次数生成新字符串
     * 
     * @param str
     *            指定字符串
     * @param repeatCount
     *            重复次数
     * @return 返回生成的新字符串
     */
    public static String newString(String str, int repeatCount) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < repeatCount; i++) {
            buf.append(str);
        }
        return buf.toString();
    }

    /**
     * 将指定字符串转换成大写
     * 
     * @param str
     *            指定字符串
     * @return 返回转换后的大写字符串
     */
    public static String toLowerCase(String str) {
        StringBuffer buffer = new StringBuffer(str);
        for (int i = 0; i < buffer.length(); i++) {
            char c = buffer.charAt(i);
            buffer.setCharAt(i, Character.toLowerCase(c));
        }
        return buffer.toString();
    }

    /**
     * 将指定字符串转换成大写
     * 
     * @param str
     *            指定字符串
     * @return 返回转换后的大写字符串
     */
    public static String toUpperCase(String str) {
        StringBuffer buffer = new StringBuffer(str);
        for (int i = 0; i < buffer.length(); i++) {
            char c = buffer.charAt(i);
            buffer.setCharAt(i, Character.toUpperCase(c));
        }
        return buffer.toString();
    }

    /**
     * 将指定字符串转换成驼峰命名方式
     * 
     * @param str
     *            指定字符串
     * @return 返回驼峰命名方式
     */
    public static String toCalmelCase(String str) {
        StringBuffer buffer = new StringBuffer(str);
        if (buffer.length() > 0) {
            // 将首字母转换成小写
            char c = buffer.charAt(0);
            buffer.setCharAt(0, Character.toLowerCase(c));
            Pattern p = Pattern.compile("_\\w");
            Matcher m = p.matcher(buffer.toString());
            while (m.find()) {
                String temp = m.group(); // 匹配的字符串
                int index = buffer.indexOf(temp); // 匹配的位置
                // 去除匹配字符串中的下划线，并将剩余字符转换成大写
                buffer.replace(index, index + temp.length(), temp.replace("_", "").toUpperCase());
            }
        }
        return buffer.toString();
    }

    /**
     * 将指定字符串转换成匈牙利命名方式
     * 
     * @param str
     *            指定字符串
     * @return 转换后的匈牙利命名方式
     */
    public static String toHungarianCase(String str) {
        StringBuffer buffer = new StringBuffer(str);
        if (buffer.length() > 0) {
            Pattern p = Pattern.compile("[A-Z]");
            Matcher m = p.matcher(buffer.toString());
            while (m.find()) {
                String temp = m.group(); // 匹配的字符串
                int index = buffer.indexOf(temp); // 匹配的位置
                // 在匹配的字符串前添加下划线，并将其余字符转换成大写
                buffer.replace(index, index + temp.length(),
                        (index > 0 ? "_" : "") + temp.toLowerCase());
            }
        }
        return buffer.toString();
    }

    /**
     * 将指定字符串首字母转换成大写字母
     * 
     * @param str
     *            指定字符串
     * @return 返回首字母大写的字符串
     */
    public static String firstCharUpperCase(String str) {
        StringBuffer buffer = new StringBuffer(str);
        if (buffer.length() > 0) {
            char c = buffer.charAt(0);
            buffer.setCharAt(0, Character.toUpperCase(c));
        }
        return buffer.toString();
    }

    /**
     * 将指定数组转换成字符串
     * 
     * @param objs
     *            指定数组
     * @return 返回转换后的字符串
     */
    public static String array2String(Object[] objs) {
        StringBuffer buffer = new StringBuffer();
        if (objs != null) {
            for (int i = 0; i < objs.length; i++) {
                buffer.append(objs[i]).append(",");
            }
        }
        buffer.deleteCharAt(buffer.length() - 1);
        return buffer.toString();
    }

    /**
     * regex, not allow empty
     * @param str
     * @param regex
     * @return
     */
    public static boolean regTest(String str, String regex) {
        return regTest(str, regex, false);
    }

    /**
     * regex
     * @param str
     * @param regex
     * @param allowEmpty
     * @return
     */
    public static boolean regTest(String str, String regex, boolean allowEmpty) {
        if (allowEmpty && isBlank(str)) {
            return true;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean isNumberString(String str) {
        return regTest(str, "\\d+");
    }

    public static boolean isNumberString(String str, int maxLength) {
        if (isBlank(str)) {
            return false;
        }
        return regTest(str, "\\d+") && str.length() <= maxLength;
    }

    /**
     * 
     * @param in
     * @return
     * @throws IOException
     */
    public static String inputStream2String(InputStream in) throws IOException {
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1;) {
            out.append(new String(b, 0, n));
        }
        return out.toString();
    }

    /**
     * concat strlist with sep
     * @param strList
     * @param sep
     * @return
     */
    public static String concat(List<String> strList, String sep) {
        StringBuilder sb = new StringBuilder();

        if (strList != null && strList.size() > 0) {
            for (int i = 0; i < strList.size(); i++) {
                sb.append(strList.get(i));
                if (i < strList.size() - 1) {
                    sb.append(sep);
                }
            }
        }

        return sb.toString();
    }

    /**
     * 
     * @param is
     * @return
     */
    public static String convertStreamToUTF8String(InputStream is) {
        StringBuffer sb1 = new StringBuffer();
        byte[] bytes = new byte[4096];
        int size = 0;

        try {
            while ((size = is.read(bytes)) > 0) {
                String str = new String(bytes, 0, size, "UTF-8");
                sb1.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb1.toString();
    }

    /**
     * 
     * @param is
     * @return
     */
    public static String convertStreamToGBKString(InputStream is) {
        StringBuffer sb1 = new StringBuffer();
        byte[] bytes = new byte[4096];
        int size = 0;

        try {
            while ((size = is.read(bytes)) > 0) {
                String str = new String(bytes, 0, size, "gbk");
                sb1.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb1.toString();
    }

    /**
     * UUID without "-"
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
