package com.doctorwork.union.module.agent.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.doctorwork.common.exception.ServiceException;
import com.doctorwork.common.result.PageResult;
import com.doctorwork.common.util.Md5Util;
import com.doctorwork.union.common.utils.Role;
import com.doctorwork.union.common.uuid.UuidUtil;
import com.doctorwork.union.module.agent.bean.Agent;
import com.doctorwork.union.module.agent.bean.AgentCriteria;
import com.doctorwork.union.module.agent.bean.vo.AgentPwdVo;
import com.doctorwork.union.module.agent.bean.vo.AgentVo;
import com.doctorwork.union.module.agent.dao.AgentMapper;
import com.doctorwork.union.module.agent.service.AgentService;
import com.doctorwork.union.module.agent.vo.AgentBindVo;
import com.doctorwork.union.module.passport.service.PassportService;
import com.doctorwork.union.module.passport.vo.UserParam;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by barry on 2017/10/16.
 */
@Slf4j
@Service
public class AgentServiceImpl implements AgentService {
    @Autowired
    private RedissonClient redisson;

    @Resource
    private AgentMapper agentMapper;

    @Autowired
    private PassportService passportService;

    private static final String DEFAULT_PWD="123456";

    @Override
    public Agent selectByPrimaryKey(String id) throws Exception {
        return agentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Agent> selectAllAgent() throws Exception {
        AgentCriteria agentCriteria = new AgentCriteria();
        AgentCriteria.Criteria criteria = agentCriteria.createCriteria();
        criteria.andIsDeleteEqualTo(0).andAccountStatusEqualTo(1);
        return agentMapper.selectByExample(agentCriteria);
    }

    @Override
    public List<Agent> selectAgentByPassId(String passportId) throws Exception {
        AgentCriteria agentCriteria = new AgentCriteria();
        AgentCriteria.Criteria criteria = agentCriteria.createCriteria();
        criteria.andIsDeleteEqualTo(0).andAccountStatusEqualTo(1);
        criteria.andPassportIdEqualTo(passportId);
        return agentMapper.selectByExample(agentCriteria);
    }

    @Override
    public PageResult<Agent> selectAgents(AgentVo agent) {
        AgentCriteria agentCriteria = new AgentCriteria();
        AgentCriteria.Criteria criteria = null;
        if (StringUtils.isNotBlank(agent.getUserName())) {
            criteria = agentCriteria.createCriteria();
            criteria.andIsDeleteEqualTo(0);
            criteria.andUserNameLike("%"+agent.getUserName()+"%");
        }
        if (StringUtils.isNotBlank(agent.getPhone())) {
            AgentCriteria.Criteria criteria1 = agentCriteria.createCriteria();
            criteria1.andPhoneLike("%"+agent.getPhone()+"%");
            criteria1.andIsDeleteEqualTo(0);
            if (criteria!=null) {
                agentCriteria.or(criteria1);
            }
        }
        agentCriteria.setOrderByClause("modify_time desc");
        Page page= PageHelper.startPage(agent.getPageNum(),agent.getPageSize());
        List<Agent> list = agentMapper.selectByExample(agentCriteria);
        PageResult pageResult = new PageResult<Agent>(page.getTotal(),page.getPages(),page.getPageNum(),page.getPageSize(),list);
        return pageResult;
    }

    @Override
    @Transactional
    public int insertAgent(Agent agent) throws Exception {
        //判断手机号是否重复，重复就提示
        AgentCriteria agentCriteria = new AgentCriteria();
        AgentCriteria.Criteria criteria = agentCriteria.createCriteria();
        criteria.andIsDeleteEqualTo(0);
        criteria.andPhoneEqualTo(agent.getPhone());
        int count = agentMapper.countByExample(agentCriteria);
        if (count > 0) {
            throw new ServiceException("手机号重复");
        }
        //调用passport
        UserParam userParam=new UserParam();
        //userParam.setAccount(agent.getPhone());
        userParam.setRole(Role.AGENT.getRoleId());
        userParam.setCellphone(agent.getPhone());
        userParam.setPwd(Md5Util.encoderByMd5(DEFAULT_PWD));//
        Integer passportId=passportService.passportSyn(userParam);
        if(passportId==null ){
            throw  new RuntimeException("调用passport服务异常");
        }
        agent.setPassportId(passportId+"");
        agent.setId(UuidUtil.getUUID());
        agent.setIsDelete(0);
        agent.setCreateTime(new Date().getTime());
        agent.setModifyTime(new Date().getTime());
        return agentMapper.insert(agent);
    }

    @Override
    @Transactional
    public int updateAgent(AgentPwdVo agent) throws Exception {
        if(StringUtils.isNoneBlank(agent.getPwd())){
            Agent entity = agentMapper.selectByPrimaryKey(agent.getId());
            UserParam userParam=new UserParam();
            userParam.setUserid(Integer.parseInt(entity.getPassportId()));
            userParam.setPwd(Md5Util.encoderByMd5(agent.getPwd()));
            passportService.passportUpdatePwd(userParam);
        }
        agent.setModifyTime(new Date().getTime());
        return agentMapper.updateByPrimaryKeySelective(agent);

    }

    @Override
    @Transactional
    public void resetPwd(Agent agent) throws Exception {
        Agent entity = agentMapper.selectByPrimaryKey(agent.getId());
        UserParam userParam=new UserParam();
        userParam.setUserid(Integer.parseInt(entity.getPassportId()));
        userParam.setPwd(Md5Util.encoderByMd5(DEFAULT_PWD));
        passportService.passportUpdatePwd(userParam);
    }

    @Override
    public void agentBind(AgentBindVo agentBindVo) throws Exception {
        log.info("请求参数：{}", JSONObject.toJSONString(agentBindVo));
        String captcha = (String)redisson.getMap("doctor-union").get("phone");
        if (!agentBindVo.getCaptcha().equals(captcha)) {
            throw  new ServiceException("验证码错误");
        }
        AgentCriteria agentCriteria = new AgentCriteria();
        AgentCriteria.Criteria criteria = agentCriteria.createCriteria();
        criteria.andIsDeleteEqualTo(0).andPhoneEqualTo(agentBindVo.getPhone());
        List<Agent> list = agentMapper.selectByExample(agentCriteria);
        if (list==null||list.isEmpty()) {
            throw  new ServiceException("请先让管理员添加该用户");
        }
        Agent agent = list.get(0);
        Agent agentParam = new Agent();
        agentParam.setId(agent.getId());
        agentParam.setOpenId(agentBindVo.getOpenId());
        agentMapper.updateByPrimaryKeySelective(agentParam);
    }

    @Override
    public int queryBind(String openId) throws Exception {
        AgentCriteria agentCriteriaOpenId = new AgentCriteria();
        AgentCriteria.Criteria criteriaOpenId = agentCriteriaOpenId.createCriteria();
        criteriaOpenId.andIsDeleteEqualTo(0).andOpenIdEqualTo(openId);
        List<Agent> list = agentMapper.selectByExample(agentCriteriaOpenId);
        if (list==null||list.isEmpty()) {
            return 0;
        } else {
            return 1;
        }
    }
}
