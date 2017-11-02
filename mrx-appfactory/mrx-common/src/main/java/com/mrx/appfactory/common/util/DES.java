package com.mrx.appfactory.common.util;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.Key;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.xerces.impl.dv.util.Base64;

import com.mrx.appfactory.common.core.APIException;
import com.mrx.appfactory.common.core.APIResults;

/**
 * 
 * @author xuwen
 *
 */
public class DES {

    /**
     * PLAIN　不加密
     */
    public static String PLAIN = "PLAIN";

    /**
     * DES 加密
     */
    public static String DES = "DES";

    //private static byte[] iv = { 1, 2, 3, 4, 5, 6, 7, 8 };
    private final static String IV = "01234567";
    private final static String ENCODING = "utf-8";

    /**
     * 
     * @param encryptString
     * @param encryptKey
     * @return
     */
    public static String encryptDES(String encryptString, String encryptKey) {
        try {
            encryptString = URLEncoder.encode(encryptString, "UTF-8").replace("+", "%20");
            return pEncryptDES(encryptString, encryptKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 
     * @param decryptString
     * @param decryptKey
     * @return
     */
    public static String decryptDES(String decryptString, String decryptKey) {
        try {
            String ciphertext = pDecryptDES(decryptString, decryptKey);
            ciphertext = ciphertext.replace("+", "%2B");
            ciphertext = URLDecoder.decode(ciphertext, "UTF-8");
            return ciphertext;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 
     * @param encryptString
     * @param encryptKey
     * @return
     * @throws Exception
     */
    public static String pEncryptDES(String encryptString, String encryptKey) throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(encryptKey.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);

        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
        byte[] encryptData = cipher.doFinal(encryptString.getBytes(ENCODING));
        return Base64.encode(encryptData);
    }

    /**
     * 
     * @param decryptString
     * @param decryptKey
     * @return
     * @throws Exception
     */
    public static String pDecryptDES(String decryptString, String decryptKey) throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(decryptKey.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);

        byte[] decryStr = Base64.decode(decryptString);
        byte[] decryptData = cipher.doFinal(decryStr);

        return new String(decryptData, ENCODING);
    }

    /**
     * 
     * @param key
     * @return
     * @throws Exception
     */
    public static String createSecretKey(String key) throws Exception {
        String md5Token = getMD5(key);
        String secretKey = md5Token.substring(1, 4);
        secretKey += md5Token.substring(5, 9);
        secretKey += md5Token.substring(11, 14);
        secretKey += md5Token.substring(15, 20);
        secretKey += md5Token.substring(21, 26);
        secretKey += md5Token.substring(27, 30);
        secretKey += md5Token.substring(31, 32);
        return secretKey;
    }

    /***
     * MD5编码
     * @param sourceStr
     * @return
     * @throws APIException
     */
    public static String getMD5(String sourceStr) throws APIException {
        String resultStr = "";
        try {
            byte[] temp = sourceStr.getBytes("utf-8");
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(temp);
            byte[] b = md5.digest();
            for (int i = 0; i < b.length; i++) {
                char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
                        'D', 'E', 'F' };
                char[] ob = new char[2];
                ob[0] = digit[(b[i] >>> 4) & 0X0F];
                ob[1] = digit[b[i] & 0X0F];
                resultStr += new String(ob);
            }
            return resultStr;
        } catch (Exception e) {
            e.printStackTrace();
            throw new APIException(APIResults.ELSE, "服务器错误");
        }
    }

    public static void main(String[] args) throws APIException {
        System.out.println(StringUtil.toLowerCase(getMD5("Ims10086@PWD")));
    }
}
