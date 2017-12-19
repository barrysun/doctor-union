package com.doctorwork.union.module.login.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhengxingle on 2017/10/19.
 */
@Setter
@Getter
public class LoginResVo implements Serializable{

    private String agentId;
    private String userName;
    private String passportId;
    private List<String> role;
}
