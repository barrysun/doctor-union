package com.doctorwork.union.module.weixin.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by apple on 2017/10/20.
 */
@Getter
@Setter
public class MsgText implements Serializable {

    private String value;
    private String color="#173177";
    public MsgText(){}
    public MsgText(String value){
        this.value=value;
    }
}
