package com.doctorwork.union.module.wallet.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by zhengxingle on 2017/10/23.
 */
@Getter
@Setter
public class WithdrawResVo implements Serializable{

    @JsonProperty("order_no")
    private String orderNo;
    private String platform;
    @JsonProperty("app_id")
    private String appId;
}
