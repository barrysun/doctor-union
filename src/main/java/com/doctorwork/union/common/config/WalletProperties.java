package com.doctorwork.union.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by apple on 2017/10/18.
 */
@Setter
@Getter
@Component
@PropertySource("file:config/server.properties")
@ConfigurationProperties(prefix = "wallet")
public class WalletProperties {

    private String walletHost;
    private String paymentSignKey;
    private String walletUrl;
    private String walletScret;
    private Integer platAccount;
}
