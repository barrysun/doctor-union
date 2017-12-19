package com.doctorwork.union.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by apple on 2017/10/20.
 */
@Setter
@Getter
@Component
@PropertySource("file:config/server.properties")
@ConfigurationProperties(prefix = "weixin")
public class WeiXinProperties {

//    weixin.appid: wx1aeacc0a08625d07
//    weixin.token: 124d0198d3ee2e212835e3d6b761e1c4
//    weixin.appsecret: ce8d2a2079f5e5856fd88af96e02c5ab
    private String appid;
    private String token;
    private String appsecret;
    private String toUrl;
    private String detail;
    private String msgTemplateId;
}
