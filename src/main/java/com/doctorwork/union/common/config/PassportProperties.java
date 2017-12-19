package com.doctorwork.union.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by barry on 2017/10/18.
 */
@Setter
@Getter
@Component
@PropertySource("file:config/server.properties")
@ConfigurationProperties(prefix = "passport")
public class PassportProperties {

    private String passportHost;
    private String passportScret;
    private String platform;
    private String appid;
    private String tokenScret;
}
