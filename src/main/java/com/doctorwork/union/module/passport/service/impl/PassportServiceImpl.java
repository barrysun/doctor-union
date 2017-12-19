package com.doctorwork.union.module.passport.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.doctorwork.common.exception.ServiceException;
import com.doctorwork.union.common.config.PassportProperties;
import com.doctorwork.union.common.utils.PssportUtil;
import com.doctorwork.union.module.passport.service.PassportService;
import com.doctorwork.union.module.passport.vo.PassportResultVo;
import com.doctorwork.union.module.passport.vo.TokenVo;
import com.doctorwork.union.module.passport.vo.UserParam;
import com.doctorwork.union.module.passport.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by barry on 2017/10/18.
 */
@Service
@Slf4j
public class PassportServiceImpl implements PassportService {

    @Autowired
    private PassportProperties passportProperties;

    private static final String CREATE_USER_URL="/user/third/create_by_third";
    private static final String UPDATE_PWD_URL="/user/third/update_pwd";
    private static final String LOGIN_URL="/user/third/login_check";
    private static final String TOKEN_URL="/qiniu/get_token";
    private static final Integer PASSPORT_SUCCESS=0;


    @Override
    public Integer passportSyn(UserParam userParam) throws Exception {
        Map<String,Object> param=new HashMap<String,Object>();
        //param.put("account",userParam.getAccount());
        param.put("platform",passportProperties.getPlatform());
        param.put("account",userParam.getCellphone());
        param.put("pwd",userParam.getPwd());
        param.put("appid",passportProperties.getAppid());
        param.put("role",userParam.getRole());
        param.put("acttype",1);

        String content= PssportUtil.post(passportProperties.getPassportScret(),passportProperties.getPassportHost()+CREATE_USER_URL,param);
        if (StringUtils.isNoneBlank(content)) {
            PassportResultVo<UserVo> ret = JSON.parseObject(content, new TypeReference<PassportResultVo<UserVo>>(){});
            if (ret.getErrcode().equals(PASSPORT_SUCCESS)) {
                log.info("userId:{}",ret.getData().getUserId());
                return ret.getData().getUserId();
            }else{
                throw new ServiceException(ret.getErrmsg());
            }
        }
        throw  new ServiceException("调用passport失败");
    }

    @Override
    public void passportUpdatePwd(UserParam userParam) throws Exception {
        Map<String,Object> param=new HashMap<String,Object>();
        param.put("platform",passportProperties.getPlatform());
        param.put("userid",userParam.getUserid());
        param.put("pwd",userParam.getPwd());
        param.put("appid",passportProperties.getAppid());
        String content=PssportUtil.post(passportProperties.getPassportScret(),passportProperties.getPassportHost()+UPDATE_PWD_URL,param);
        if (StringUtils.isNoneBlank(content)) {
            PassportResultVo<UserVo> ret = JSON.parseObject(content, new TypeReference<PassportResultVo<UserVo>>(){});
            if (ret.getErrcode().equals(PASSPORT_SUCCESS)) {
                log.info("userId:{}",ret.getData().getUserId());
                return;
            }else{
                throw  new ServiceException(ret.getErrmsg());
            }
        }
        throw  new ServiceException("调用passport失败");
    }

    @Override
    public PassportResultVo<UserVo> login(UserParam userParam) throws Exception {
        Map<String,Object> param=new HashMap<String,Object>();
        param.put("platform",passportProperties.getPlatform());
        param.put("account",userParam.getCellphone());
        param.put("pwd",userParam.getPwd());
        param.put("appid",passportProperties.getAppid());
        param.put("acttype","1");//1.手机号 2.openId
        param.put("type","login");//login 不校验平台 check 平台一起校验
        String content=PssportUtil.post(passportProperties.getPassportScret(),passportProperties.getPassportHost()+LOGIN_URL,param);
        log.info("ret:{}",content);
        if (StringUtils.isNoneBlank(content)) {
            PassportResultVo<UserVo> ret = JSON.parseObject(content, new TypeReference<PassportResultVo<UserVo>>(){});
            if (ret.getErrcode().equals(PASSPORT_SUCCESS)) {
                //log.info("userId:{}",ret.getData().getUserId());
                return ret;
            }else{
                throw  new ServiceException(ret.getErrmsg());
            }
        }
        throw  new ServiceException("调用passport失败");
    }

    @Override
    public TokenVo token() throws Exception {
        String content=PssportUtil.get(passportProperties.getTokenScret(),passportProperties.getPassportHost()+TOKEN_URL,null);
        if(StringUtils.isNoneBlank(content)){
            PassportResultVo<TokenVo> ret=JSON.parseObject(content,new TypeReference<PassportResultVo<TokenVo>>(){});
            if(ret.getErrcode().equals(PASSPORT_SUCCESS)){
                return  (TokenVo) ret.getData();
            }else{
                throw  new ServiceException(ret.getErrmsg());
            }
        }
        throw  new ServiceException("调用passport失败");
    }


}
