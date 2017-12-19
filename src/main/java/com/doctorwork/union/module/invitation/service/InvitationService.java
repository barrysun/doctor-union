package com.doctorwork.union.module.invitation.service;

import com.doctorwork.common.result.HttpResult;
import com.doctorwork.common.result.PageResult;
import com.doctorwork.union.module.invitation.bean.Invitation;
import com.doctorwork.union.module.invitation.vo.*;

/**
 * Created by barry on 2017/10/16.
 */
public interface InvitationService {

    PageResult<InvitationDoctorVo> queryByClinicId(InvitationQueryVo invitationQueryVo);

    PageResult<InvitationDoctorVo> queryByAgentId(InvitationQueryVo invitationQueryVo);

    PageResult<InvitationDoctorVo> queryByDoctorId(InvitationQueryVo invitationQueryVo);

    void updateStatus(Invitation invitation) throws Exception;

    PayMentVo qr(Invitation invitation) throws Exception;

    void save(InvitationDoctorVo invitationDoctorVo) throws  Exception;

    void paymentSuccessCall(PayMentCallVo vo) throws Exception;

    InvitationVo profile(String id) throws Exception;
}
