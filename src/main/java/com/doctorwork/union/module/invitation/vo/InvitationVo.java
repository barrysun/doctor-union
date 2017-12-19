package com.doctorwork.union.module.invitation.vo;

import com.doctorwork.union.module.invitation.bean.Invitation;
import com.doctorwork.union.module.visit.vo.DayVo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by barry on 2017/10/23.
 */
@Getter
@Setter
public class InvitationVo extends Invitation implements Serializable {

    private String doctorName;
    private String title;
    private String hospital;
    private String department;
    private String doctorAvatar;
    private Integer invitationCount;
    private Long workPrice;
    private String specialty;
    private String note;
    private String clinicName;
    private String clinicAddr;
    private String telPhone;
    private String registerPhone;
    private String registerName;
    private Integer workCount;//工作次数
    private List<DayVo> list;
}
