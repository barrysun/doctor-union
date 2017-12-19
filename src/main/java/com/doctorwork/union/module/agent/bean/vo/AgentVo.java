package com.doctorwork.union.module.agent.bean.vo;

import com.doctorwork.union.common.rest.PageParamVo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class AgentVo extends PageParamVo implements Serializable {

    private String id;
    private String userName;
    private Integer sex;
    private String phone;

}