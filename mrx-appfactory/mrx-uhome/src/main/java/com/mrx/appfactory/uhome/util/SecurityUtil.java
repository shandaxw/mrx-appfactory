package com.mrx.appfactory.uhome.util;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Date;

import com.mrx.appfactory.common.core.APIException;
import com.mrx.appfactory.common.core.APIResults;
import com.mrx.appfactory.uhome.entity.SignEntity;

/**
 * @Type SecurityUtil.java
 * @Desc 
 * @author xuwen
 * @date 2017年11月8日 下午5:13:39
 * @version 
 */
public class SecurityUtil {
    public final static String UHOME = "UHOME_";

    /**
     * 〈一句话功能简述〉生成token
     * 〈功能详细描述〉
     *
     * @param key
     * @return
     * @throws Exception 
     */
    public static String createToken(String key) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String token = UHOME + key + String.valueOf(new Date().getTime());
        token = URLEncoder.encode(token, "UTF-8");
        token = new String(md5.digest(token.getBytes("UTF-8")), "UTF-8");
        return token;
    }

    /**
     * 〈一句话功能简述〉sign解密
     * 〈功能详细描述〉
     *
     * @param sign
     * @return
     * @throws Exception 
     */
    public static SignEntity decodeSign(String sign) throws Exception {
        //appId=435324&time=3254624234&token=asdasd
        SignEntity signEntity = new SignEntity();
        try {
            String[] params = sign.split("&");
            signEntity.setAppId(params[0].split("=")[1]);
            signEntity.setTime(Long.parseLong(params[1].split("=")[1]));
            signEntity.setToken(params[2].split("=")[1]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new APIException(APIResults.PARAM_INVALID, "sign格式错误");
        }
        return signEntity;
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年11月8日 xuwen create
 */