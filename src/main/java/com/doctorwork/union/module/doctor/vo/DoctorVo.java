package com.doctorwork.union.module.doctor.vo;

import com.doctorwork.union.common.rest.PageParamVo;
import jdk.nashorn.internal.ir.RuntimeNode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * Created by apple on 2017/10/16.
 */
@Getter
@Setter
public class DoctorVo extends PageParamVo implements Serializable {

    private String doctorName;
    private String phone;
    private String agentId;
    private String search;
    private String hospital;
    private String title;




}
