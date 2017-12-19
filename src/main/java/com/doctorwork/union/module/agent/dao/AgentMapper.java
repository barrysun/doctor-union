package com.doctorwork.union.module.agent.dao;

import com.doctorwork.union.module.agent.bean.Agent;
import com.doctorwork.union.module.agent.bean.AgentCriteria;
import java.util.List;

public interface AgentMapper {
    int countByExample(AgentCriteria example);

    int insert(Agent record);

    int insertSelective(Agent record);

    List<Agent> selectByExample(AgentCriteria example);

    Agent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Agent record);

    int updateByPrimaryKey(Agent record);
}