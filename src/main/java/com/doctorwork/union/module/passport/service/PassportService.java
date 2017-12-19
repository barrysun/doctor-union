package com.doctorwork.union.module.passport.service;

import com.doctorwork.union.module.passport.vo.PassportResultVo;
import com.doctorwork.union.module.passport.vo.TokenVo;
import com.doctorwork.union.module.passport.vo.UserParam;
import com.doctorwork.union.module.passport.vo.UserVo;

/**
 * Created by barry on 2017/10/18.
 */
public interface PassportService {

    Integer passportSyn(UserParam userParam) throws Exception;

    void passportUpdatePwd(UserParam userParam) throws Exception;

    //登录
    PassportResultVo<UserVo> login(UserParam userParam) throws Exception;

    TokenVo token() throws Exception;


}
