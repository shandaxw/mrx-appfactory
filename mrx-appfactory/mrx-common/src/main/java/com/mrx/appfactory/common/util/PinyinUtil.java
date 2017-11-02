package com.mrx.appfactory.common.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
/**
 * 
 * @author xuwen
 *
 */
public class PinyinUtil {
    public static String getPinyin(String chinese) {
        if (chinese == null) {
            return "";
        }
        char[] t1 = null;
        t1 = chinese.toCharArray();
        String[] t2 = new String[t1.length];
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();

        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        String t4 = "";
        int t0 = t1.length;
        try {
            for (int i = 0; i < t0; i++) {
                // 判断是否为汉字字符
                if (java.lang.Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], format);
                    t4 += t2[0];
                } else if (java.lang.Character.toString(t1[i]).matches("[a-zA-Z0-9]+")) {
                    t4 += java.lang.Character.toString(t1[i]).toLowerCase();
                }

            }
            return t4;
        } catch (BadHanyuPinyinOutputFormatCombination e1) {
            e1.printStackTrace();
            return "";
        }
    }
    
}
