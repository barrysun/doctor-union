package com.doctorwork.union.module.weixin.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by barry on 2017/10/20.
 */
@Setter
@Getter
public class WeiXinTemplateVo<T> implements Serializable {

    private String touser;
    private String template_id;
    private String url;
    private String topcolor="#FF0000";
    private T data;
}
