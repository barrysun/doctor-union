package com.doctorwork.union.common.utils;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 用作基础订单参数签名
 * @author cwy
 *
 */
public class SignUtils {
    private static Logger logger = LoggerFactory.getLogger(SignUtils.class);
    
    
    public static Map<String, String> getSignPairs(Object object) throws Exception{
        Map<String, String> pairs = Maps.newTreeMap();
        
        Class<?> clazz = object.getClass();
        
        while(!Object.class.equals(clazz)) {
            Field[] fields = clazz.getDeclaredFields();
            for(Field field : fields) {
                SignField signField;
                if(null != (signField = field.getAnnotation(SignField.class))) {
                    field.setAccessible(true);
                    pairs.put(StringUtils.isBlank(signField.signName())?field.getName():signField.signName(), String.valueOf(field.get(object)));
                }
            }
            clazz = clazz.getSuperclass();
        }
        logger.info("用作签名的字段 {}",pairs);
        
        return pairs;
    }
    /**
     * 参数按照key值正序排列后，首尾加上signStr,再进行sha1加密
     * @param
     * @param signStr
     * @return
     */
    public static String sign(Map<String, String> pairs,String signStr) throws Exception{
        StringBuilder stringBuilder = new StringBuilder();
        if(!pairs.isEmpty()) {
            for(Entry<String, String> pair : pairs.entrySet()) {
                stringBuilder.append(pair.getKey()).append("=").append(pair.getValue()).append("&");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        stringBuilder.insert(0, signStr);
        stringBuilder.append(signStr);
        logger.info("sign str is {}", stringBuilder.toString());
        return SHA1Util.getSha1(stringBuilder.toString());
    }
    
}
