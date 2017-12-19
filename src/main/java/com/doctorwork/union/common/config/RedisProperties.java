package com.doctorwork.union.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@PropertySource("file:config/server.properties")
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {

    private String sentinelAddress;
    private String password;
    private Integer database;
    private String masterName;
    private Integer connectionTimeout;
    private Integer masterConnectionPoolSize;

    private Integer masterConnectionMinimumIdleSize;

    private Integer retryAttempts;

    private Integer retryInterval;
    private String applicationName;
}
