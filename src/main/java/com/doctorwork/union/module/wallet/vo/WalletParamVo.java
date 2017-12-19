package com.doctorwork.union.module.wallet.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by zhengxingle on 2017/10/23.
 */
@Getter
@Setter
public class WalletParamVo implements Serializable{

    private Integer userId;
    private Long amount;
    private String accountNo;
    private String outTradeNo;
    private String orderNo;
    private String reason;
}
