package com.doctorwork.union.module.wallet.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by barry on 2017/10/30.
 */
@Getter
@Setter
public class RechargeApplyVo implements Serializable{

    @JSONField(name="order_no")
    private String orderNo;
    @JSONField(name="app_id")
    private String appId;
    private String platform;
}
