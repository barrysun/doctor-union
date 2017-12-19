package com.doctorwork.union.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.*;

/**
 * Created by barry on 2017/10/18.
 */
@Slf4j
public class PssportUtil {

    public static String post(String scret,String url,Map<String, Object> map) {
        String params = convert2SignContent(map);
        String sign = md5(scret + params + scret);
        String paramQuery = "";
        if (map!=null && map.size() > 0) {
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iterator.next();
                if (entry.getValue() != null) {
                    paramQuery += entry.getKey() + "=" + entry.getValue() + "&";
                }
            }
        }
        paramQuery += "sign=" + sign;
        String content = doPost(url , paramQuery);
        log.info(content);
        return content;
    }

    public static String get(String scret,String url,Map<String,Object> map){
        String params = convert2SignContent(map);
        String sign = md5(scret + params + scret);
        String paramQuery = "";
        if (map!=null && map.size() > 0) {
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iterator.next();
                if (entry.getValue() != null) {
                    paramQuery += entry.getKey() + "=" + entry.getValue() + "&";
                }
            }
        }
        paramQuery += "sign=" + sign;
        String content = doGet(url+"?"+ paramQuery);
        log.info(content);
        return content;
    }

    public static String doGet(String url){
        log.info("url:{}",url);
        HttpURLConnection conn = null;
        BufferedReader rd = null ;
        StringBuilder sb = new StringBuilder ();
        String line = null ;
        String response = null;
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setReadTimeout(2000);
            conn.setConnectTimeout(2000);
            conn.setUseCaches(false);
            conn.connect();
            rd  = new BufferedReader( new InputStreamReader(conn.getInputStream(), "UTF-8"));
            while ((line = rd.readLine()) != null ) {
                sb.append(line);
            }
            response = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(rd != null){
                    rd.close();
                }
                if(conn != null){
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;

    }

    private static String doPost(String url, String param) {
        log.info(url);
        log.info(param);
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }



    public static String md5(String s) {
        char hexDigits[] = { '0', '1', '2', '3',
                '4', '5', '6', '7',
                '8', '9', 'a', 'b',
                'c', 'd', 'e', 'f'
        };
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");

            byte[] strTemp = s.getBytes();
            mdTemp.update(strTemp);

            byte[] md = mdTemp.digest();

            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }

            return new String(str);
        } catch (Exception e) {
            log.error("MD5 Fail", e);
            return null;
        }
    }

    public static String convert2SignContent(Map<String, Object> paramsMap) {
        if (paramsMap == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        List<String> keys = new ArrayList<>(paramsMap.keySet());
        Collections.sort(keys); // 字典顺序排序

        for (String key : keys) {
            Object valueObj = paramsMap.get(key);
            if ( ! isEmptyObject(valueObj)) { // 过滤空值
                builder.append(key).append(valueObj.toString());
            }
        }

        String signContent = builder.toString().replaceAll("\\s+", "");

        if (signContent.length() == 0) {
            return "";
        }

        return signContent;
    }

    private static boolean isEmptyObject(Object obj) {
        if (obj == null) {
            return true;
        }

        String objStr = obj.toString();

        return objStr == null || objStr.length() == 0 || objStr.trim().length() == 0;
    }

    public static boolean isBlankCharSequence(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ( ! Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
