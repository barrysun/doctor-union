package com.doctorwork.union.module.agent.bean.vo;

import com.doctorwork.union.module.agent.bean.Agent;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by apple on 2017/10/19.
 */
@Getter
@Setter
public class AgentPwdVo extends Agent implements Serializable {

    private String pwd;
}
