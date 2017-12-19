package com.doctorwork.union.module.weixin.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by barry on 2017/10/20.
 */
@Getter
@Setter
public class OpenId implements Serializable{
    private List<String> openid;
}
