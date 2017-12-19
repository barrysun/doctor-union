package com.doctorwork.union.module.agent.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by zhengxingle on 2017/10/24.
 */
@Setter
@Getter
public class AgentBindVo implements Serializable{

    private String phone;
    private String openId;
    private String captcha;
    private String imgCaptcha;
}
