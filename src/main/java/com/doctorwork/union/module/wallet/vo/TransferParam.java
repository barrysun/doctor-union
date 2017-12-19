package com.doctorwork.union.module.wallet.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by barry on 2017/10/24.
 */
@Getter
@Setter
public class TransferParam implements Serializable {

    private String appid;
    private String platform;
    private String sign;
    private Integer userid;
    private Integer payuserid;
    private Integer recuserid;
    private Integer amount;
    private String tag;
    private String body;
    private String outTradeNo;
    private String remark;
    private Integer payType=1;
    private Integer arriveType=1;

}
