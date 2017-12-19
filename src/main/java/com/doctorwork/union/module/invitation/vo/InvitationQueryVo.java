package com.doctorwork.union.module.invitation.vo;

import com.doctorwork.union.common.rest.PageParamVo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by apple on 2017/10/20.
 */
@Getter
@Setter
public class InvitationQueryVo extends PageParamVo implements Serializable {

    private String agentId;
    private String search;
    private String clinicIds;
    private String clinicId;
    private String doctorId;
}
