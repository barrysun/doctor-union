package com.doctorwork.union.module.agent.service;


import com.doctorwork.common.result.PageResult;
import com.doctorwork.union.module.agent.bean.Agent;
import com.doctorwork.union.module.agent.bean.vo.AgentPwdVo;
import com.doctorwork.union.module.agent.bean.vo.AgentVo;
import com.doctorwork.union.module.agent.vo.AgentBindVo;

import java.util.List;

/**
 * Created by barry on 2017/10/16.
 */
public interface  AgentService {

    Agent selectByPrimaryKey(String id)throws Exception;

    List<Agent> selectAllAgent() throws Exception;

    List<Agent> selectAgentByPassId(String passportId) throws Exception;

    PageResult<Agent> selectAgents(AgentVo agent);

    int insertAgent(Agent agent) throws Exception;

    int updateAgent(AgentPwdVo agent) throws Exception;

    void resetPwd(Agent agent) throws Exception;

    void agentBind(AgentBindVo agentBindVo) throws Exception;

    int queryBind(String openId) throws Exception;
}
