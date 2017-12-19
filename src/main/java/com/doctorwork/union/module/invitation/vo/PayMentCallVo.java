package com.doctorwork.union.module.invitation.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by apple on 2017/10/19.
 */
@Getter
@Setter
public class PayMentCallVo implements Serializable {

    private String orderId;
    private String orderMoney;
    private String createTime;
    private String payOrderNumber;
    private String productId;
    private String type;
}
