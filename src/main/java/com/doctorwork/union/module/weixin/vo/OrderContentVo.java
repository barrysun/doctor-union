package com.doctorwork.union.module.weixin.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by barry on 2017/10/20.
 */
@Setter
@Getter

public class OrderContentVo implements Serializable{

    @JSONField(name="first")
    private MsgText first;
    @JSONField(name="keyword1")
    private MsgText keyword1;
    @JSONField(name="keyword2")
    private MsgText keyword2;
    @JSONField(name="keyword3")
    private MsgText keyword3;

    @JSONField(name="keyword4")
    private MsgText keyword4;
    @JSONField(name="keyword5")
    private MsgText keyword5;
    @JSONField(name="remark")
    private MsgText remark;
}
