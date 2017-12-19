package com.doctorwork.union.module.wallet.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by apple on 2017/10/24.
 */
@Getter
@Setter
public class ApplyParam implements Serializable {

    private String appid;
    private String platform;
    private String sign;
    private Integer userid;
    private Integer amount;
    private String payType="WX_PAY";
    private String accountNo;//提现账号
    private String tag;
    private String body;
    private String outTradeNo;
    private String remark;
}
