package com.mrx.appfactory.common.util;

/**
 * 
 * @author xuwen
 *
 */
public class ValidConstraint {

    public static final String PHONE = "^1\\d{10}$";

    public static final String TIME_HHMM = "^([0-1]{1}\\d|2[0-3]):([0-5]\\d)$";

    public static final String TIME_YYYYMMDD_HHMMSS = "^(\\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[0-1])\\s([0-1]{1}\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$";

    public static final String IMAGE_SUFFIX = "^jpg|jpeg|gif|bmp|png$";

}
