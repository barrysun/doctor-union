package com.doctorwork.union.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * Created by barry on 2017/10/18.
 */
@Slf4j
public class SHA1 {

    public static String SHA1(String inStr) {
        MessageDigest md = null;
        String outStr = null;
        String signature = "";
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(inStr.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }catch (NoSuchAlgorithmException e)
        {
            log.error("没有这个方法",e);
        }
        catch (UnsupportedEncodingException e)
        {
            log.error("不支持编码类型",e);
        }

        return signature;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String bytetoString(byte[] digest) {
        String str = "";
        String tempStr = "";

        for (int i = 1; i < digest.length; i++) {
            tempStr = (Integer.toHexString(digest[i] & 0xff));
            if (tempStr.length() == 1) {
                str = str + "0" + tempStr;
            } else {
                str = str + tempStr;
            }
        }
        return str.toLowerCase();
    }

}