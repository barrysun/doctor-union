package com.doctorwork.union.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by barry on 2017/9/29.
 */

@Setter
@Getter
@Component
@PropertySource("file:config/server.properties")
@ConfigurationProperties(prefix = "druid")
public class DruidProperties {
    /**
     * MYSQL_DB config
     */
    private String url;
    private String user;
    private String password;

    private int     maxActive;
    private int     minIdle;
    private int     initialSize;
    private boolean testOnBorrow;
    private int maxWait;
}
