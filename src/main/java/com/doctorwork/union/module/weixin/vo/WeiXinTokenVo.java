package com.doctorwork.union.module.weixin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by apple on 2017/10/20.
 */
@Getter
@Setter
public class WeiXinTokenVo implements Serializable{

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private Integer expiresIn;
}
