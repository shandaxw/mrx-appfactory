/*
 * Project: cmcc-tpl
 * 
 * File Created at 2017年10月10日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.mrx.appfactory.common.core;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mrx.appfactory.common.util.TimeUtil;

/**
 * 
 * @author xuwen
 *
 */
public class DateJsonSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        String formatString = TimeUtil.FORMAT_DATE;
        if (value instanceof Timestamp) {
            formatString = TimeUtil.FORMAT_DATE_TIME;
        }
        String formattedDate = TimeUtil.getTimeString(value, formatString);
        jgen.writeString(formattedDate);
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年10月10日 zhangtx creat
 */
