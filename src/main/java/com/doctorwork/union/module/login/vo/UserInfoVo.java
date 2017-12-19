package com.doctorwork.union.module.login.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by zhengxingle on 2017/10/19.
 */
@Setter
@Getter
public class UserInfoVo implements Serializable{

    private String passportId;
    private String userName;
    private String pwd;
}
