package com.doctorwork.union.module.invitation.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by barry on 2017/10/23.
 */
@Getter
@Setter

public class ClinicVo implements Serializable {

    private String name;
    private String id;
    private String telPhone;
    private String registerName;//联系人名称
    private String registerPhone;//联系人电话
    private Integer passportId;
    private String provinceName;
    private String cityName;
    private String areaName;
    private String addr;

}
