package com.doctorwork.union.module.invitation.vo;

import com.doctorwork.union.common.rest.PageParamVo;
import com.doctorwork.union.module.visit.bean.Visit;
import com.doctorwork.union.module.visit.vo.DayVo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by barry on 2017/10/16.
 */
@Getter
@Setter
public class InvitationDoctorVo implements Serializable{

    private String id;
    private String doctorName;
    private String title;
    private String hospital;
    private String department;
    private Integer invitationStatus;
    private String invitationId;
    private String doctorId;
    private String clinicId;
    private String agentId;
    private BigDecimal totalPrice;
    private Integer workCount;
    private BigDecimal onePrice;
    private String passportId;

    private String search;
    private Long createTime;
    private String clinicName;
    private String invitationUserName;
    private List<Visit> visits;
    private List<DayVo> list;
    private List<VisitSelectVo> selectVos;
    private List<String> selectIds;
}
