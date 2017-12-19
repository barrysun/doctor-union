package com.doctorwork.union.module.invitation.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by barry on 2017/9/18.
 */
@Getter
@Setter
public class QrCodeVo implements Serializable {

    private String orderNumber; //订单号
    private String qrcode;      //二维码 64字符串
    private Integer orderId;    //订单id
}