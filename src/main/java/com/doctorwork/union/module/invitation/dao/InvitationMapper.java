package com.doctorwork.union.module.invitation.dao;

import com.doctorwork.union.module.invitation.bean.Invitation;
import com.doctorwork.union.module.invitation.bean.InvitationCriteria;
import java.util.List;

public interface InvitationMapper {
    int countByExample(InvitationCriteria example);

    int insert(Invitation record);

    int insertSelective(Invitation record);

    List<Invitation> selectByExample(InvitationCriteria example);

    Invitation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Invitation record);

    int updateByPrimaryKey(Invitation record);
}