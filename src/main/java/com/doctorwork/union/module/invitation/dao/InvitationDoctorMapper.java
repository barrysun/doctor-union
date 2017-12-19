package com.doctorwork.union.module.invitation.dao;

import com.doctorwork.union.module.invitation.vo.InvitationDoctorVo;
import com.doctorwork.union.module.invitation.vo.InvitationQueryVo;

import java.util.List;

/**
 * Created by barry on 2017/10/16.
 */
public interface InvitationDoctorMapper {

    //List<InvitationDoctorVo> list(String clinicId);
    List<InvitationDoctorVo> queryByAgentId(InvitationQueryVo invitationQueryVo);
    List<InvitationDoctorVo> queryByClinicId(InvitationQueryVo invitationQueryVo);
    List<InvitationDoctorVo> queryByDoctorId(InvitationQueryVo invitationQueryVo);
}
