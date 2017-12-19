package com.doctorwork.union.module.visit.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by barry on 2017/10/20.
 */
@Getter
@Setter
public class TimeVo implements Serializable{
    private Long startTime;
    private Long endTime;
    private String clinicName;
    private String addr;
    private String id;
    private String invitationId;
    private Integer invitationStatus;
}
