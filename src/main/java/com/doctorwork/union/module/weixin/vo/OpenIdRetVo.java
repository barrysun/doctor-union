package com.doctorwork.union.module.weixin.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by barry on 2017/10/20.
 */
@Setter
@Getter
public class OpenIdRetVo implements Serializable {
    private Integer total;
    private Integer count;
    private OpenId data;
    private String next_opendid;
    //{"total":2,"count":2,"data":{"openid":["","OPENID1","OPENID2"]},"next_openid":"NEXT_OPENID"}
}
