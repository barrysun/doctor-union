package com.doctorwork.union.common.utils;

public class EncodeUtil {
    public static String encode(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {                
            if (Integer.toHexString(0xFF & bytes[i]).length() == 1)    
                stringBuilder.append("0").append(Integer.toHexString(0xFF & bytes[i]));    
            else    
                stringBuilder.append(Integer.toHexString(0xFF & bytes[i]));    
        }    
        return stringBuilder.toString();
    }
}
