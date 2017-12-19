package com.doctorwork.union.module.passport.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by apple on 2017/10/18.
 */
@Getter
@Setter
public class UserParam  implements Serializable{

//    platform string 第三方标识(medlinker, wechat, ali, weibo) 必传
//    sign string 签名 必传
//
//    pwd string 密码 选传//
//    cellphone string 手机号 选传 //cellphone 与 account openid 3选1 必传
//    account  string 账号 选传 //字母数字 sdfs12
//    appid string appid 必传
//
//    role string 角色 必传
//
//    openid string 第三方账号标识 选传
//
//    opensrc string 第三方账号标识(medlinker, wechat, ali, weibo) 选传//传了openid必传
    private String platform;
    private String sign;
    private String pwd;
    private String cellphone;
    private String account;
    private String appid;
    private String role;
    private String openid;
    private String opensrc;
    private Integer userid;
}
