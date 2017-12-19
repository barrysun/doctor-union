package com.doctorwork.union.module.agent.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.doctorwork.union.common.utils.PssportUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengxingle on 2017/7/15.
 */
@Service
@Slf4j
public class UserCaptchaService {

    @Autowired
    private RedissonClient redisson;

    @Value("${passport.passportHost}")
    private String passportUrl;

    public Map<String,Object> add(String phone,String imgCaptcha) throws Exception{
        Map<String,Object> map = new HashMap<>();
        String captcha = String.valueOf((int)((Math.random()*(9999-1000+1))+1000));  //4位数字
        // 发送验证码
        String url = passportUrl+"/csec/send_sms_tpl?phone="+phone+"&vercode="+captcha;
        if (StringUtils.isNotBlank(imgCaptcha)) {
            url = url+"&im_code="+imgCaptcha;
        }
        String res = PssportUtil.doGet(url);
        JSONObject json = JSONObject.parseObject(res);
        if (json.getIntValue("errcode")!=0) {
            log.info("原始信息："+res);
            if (json.getIntValue("errcode")==1) {
                map.put("status",2);
                map.put("msg",json.getString("errmsg"));
                return  map;
            }
            if (json.getIntValue("errcode")==21){
                url = passportUrl+ "/csec/create_img_verify"+"?phone="+phone;
                res = PssportUtil.doGet(url);
                json = JSONObject.parseObject(res);
                if (json.getIntValue("errcode")!=0) {
                    log.error("获取图片验证码失败"+json.getString("errmsg"));
                    throw new Exception("发送验证码失败");
                }
                json = json.getJSONObject("data");
                map.put("status",1);
                map.put("captcha",json.getString("im_data"));
                return  map;
            }
            log.info(res);
            throw new Exception("发送验证码失败");
        }
        map.put("status",0);
        map.put("captcha",captcha);
        RMap<String, Object> map1  = redisson.getMap("doctor-union");
        map1.put("phone",captcha);
        return map;
    }

    public String verification(String phone) throws Exception{
        String url = passportUrl+ "/csec/create_img_verify"+"?phone="+phone;
        String res = PssportUtil.doGet(url);
        JSONObject json = JSONObject.parseObject(res);
        if (json.getIntValue("errcode")!=0) {
            log.error("获取图片验证码失败"+json.getString("errmsg"));
            throw new Exception("发送验证码失败");
        }
        json = json.getJSONObject("data");
        return json.getString("im_data");
    }


}
