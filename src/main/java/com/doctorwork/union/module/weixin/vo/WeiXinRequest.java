package com.doctorwork.union.module.weixin.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by apple on 2017/10/24.
 */
@Getter
@Setter
public class WeiXinRequest implements Serializable{

    private String openId;
    private Integer pageNum;
    private Integer pageSize;
    private Integer invitationStatus;
    private String id;
}
