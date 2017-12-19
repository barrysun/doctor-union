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
@ConfigurationProperties(prefix = "shopkeeper")
public class ShopkeeperProperties {

    private String url;
    private String secret;

}
