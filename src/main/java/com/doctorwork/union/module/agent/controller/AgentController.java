package com.doctorwork.union.module.agent.controller;

import com.doctorwork.common.controller.BaseController;
import com.doctorwork.common.result.HttpResult;
import com.doctorwork.union.common.annotation.Auth;
import com.doctorwork.union.common.utils.AssertUtil;
import com.doctorwork.union.module.agent.bean.Agent;
import com.doctorwork.union.module.agent.bean.vo.AgentPwdVo;
import com.doctorwork.union.module.agent.bean.vo.AgentVo;
import com.doctorwork.union.module.agent.service.AgentService;
import com.doctorwork.union.module.agent.vo.AgentBindVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


/**
 * Created by barry on 2017/10/16.
 */
@Slf4j
@RestController
@RequestMapping("/agent")
public class AgentController extends BaseController {

    @Autowired
    private AgentService agentService;

    @GetMapping("/queryAgentById")
    public HttpResult queryById(@Param("id") String id) throws Exception {

        return success(agentService.selectByPrimaryKey(id));
    }

    @RequestMapping("/selectAllAgent")
    @Auth
    public HttpResult selectAllAgent() throws Exception {

        return success(agentService.selectAllAgent());
    }

    @PostMapping("/getAgents")
    @Auth
    public HttpResult getAgents(@RequestBody AgentVo agent) throws Exception {

        return success(agentService.selectAgents(agent));
    }

    @PostMapping("/insertAgent")
    @Auth
    public HttpResult insertAgent(@RequestBody Agent agent) throws Exception {

        return success(agentService.insertAgent(agent));
    }

    @PostMapping("/updateAgent")
    @Auth
    public HttpResult updateAgent(@RequestBody AgentPwdVo agent) throws Exception {
        AssertUtil.notNull(agent.getId(),"id不能为空");
        return success(agentService.updateAgent(agent));
    }

    @PostMapping("/reset_password")
    @Auth
    public HttpResult resetPwd(@RequestBody Agent agent) throws Exception{
        AssertUtil.notNull(agent.getId(),"id不能为空");
        agentService.resetPwd(agent);
        return success();
    }

    @PostMapping("/agentBind")
    public HttpResult agentBind(@RequestBody AgentBindVo agentBindVo, HttpSession httpSession) throws Exception{
        AssertUtil.notNull(agentBindVo.getPhone(),"phone不能为空");
        AssertUtil.notNull(agentBindVo.getOpenId(),"openId不能为空");
        AssertUtil.notNull(agentBindVo.getCaptcha(),"captcha不能为空");
//        log.info("session原始：{}",JSONObject.toJSONString(httpSession));
//        String captcha = (String)httpSession.getAttribute("captcha");
//        log.info("session:"+captcha);
//        log.info("param:"+agentBindVo.getCaptcha());
//        if (!agentBindVo.getCaptcha().equals(captcha)) {
//            throw new ServiceException("验证码不正确");
//        }
        agentService.agentBind(agentBindVo);
        httpSession.removeAttribute("captcha");
        httpSession.invalidate();
        return success();
    }
    @PostMapping("/queryBind")
    public HttpResult queryBind(@RequestBody AgentBindVo agentBindVo, HttpSession httpSession) throws Exception{
        AssertUtil.notNull(agentBindVo.getOpenId(),"openId不能为空");
        int i = agentService.queryBind(agentBindVo.getOpenId());
        if (i==0) {
            return error(204,"请绑定手机号");
        }
        return success();
    }

}
