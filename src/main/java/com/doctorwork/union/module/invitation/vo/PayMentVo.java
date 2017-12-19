package com.doctorwork.union.module.invitation.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by barry on 2017/9/18.
 */
@Getter
@Setter
public class PayMentVo  implements Serializable{

    private Integer code;
    private String errmsg;
    private QrCodeVo data;

}
