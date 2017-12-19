package com.doctorwork.union.common.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;

/**
 * Created by wk on 2017/7/23.
 */
public class SHA1Util {
    //微信公众号开发的随机字串
    public static String getNonceStr() throws Exception {
        Random random = new Random();
        return ecoderByMd5(String.valueOf(random.nextInt(10000)));
    }
    //微信公众号开发的获取时间戳
    public static String getTimeStamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }
    //创建签名SHA1
    public static String createSHA1Sign(SortedMap<String, String> signParams) throws Exception {
        StringBuffer sb = new StringBuffer();
        Set<Entry<String, String>> es = signParams.entrySet();
        Iterator<Entry<String, String>> it = es.iterator();
        while (it.hasNext()) {
            Entry<String, String> entry = it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            sb.append(k + "=" + v + "&");
            //要采用URLENCODER的原始值！
        }
        String params = sb.substring(0, sb.lastIndexOf("&"));
        return getSha1(params);
    }
    /**
     * 利用MD5进行加密
     * 　　* @param str  待加密的字符串
     * 　　* @return  加密后的字符串
     * 　　* @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
     * 　　 * @throws UnsupportedEncodingException
     *
     */
    private static String ecoderByMd5(String str) throws Exception {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
    //Sha1签名
    public static String getSha1(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };

        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }
}
