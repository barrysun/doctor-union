package com.doctorwork.union.module.agent.controller;

import com.alibaba.fastjson.JSONObject;
import com.doctorwork.common.controller.BaseController;
import com.doctorwork.common.exception.ServiceException;
import com.doctorwork.union.common.utils.AssertUtil;
import com.doctorwork.union.module.agent.service.impl.UserCaptchaService;
import com.doctorwork.union.module.agent.vo.AgentBindVo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * Created by apple on 2017/7/7.
 * 验证码
 */

@RestController
@RequestMapping("/captcha")
@Slf4j
public class UserCaptchaController extends BaseController{
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(UserCaptchaController.class);

    @Value("${captcha.validTime}")
    private int validTime;
    @Autowired
    private UserCaptchaService userCaptchaService;
    
    @RequestMapping("sendCode")
    @ResponseBody
    public Object sendCode(@RequestBody AgentBindVo agentBindVo, HttpSession session)throws Exception {
        AssertUtil.notNull(agentBindVo.getPhone(),"手机号不能为空");
        Date timeStamp = (Date) session.getAttribute("timestamp");
        if (timeStamp==null){
            session.setAttribute("timestamp",new Date());
        } else {
            if ((new Date().getTime()-timeStamp.getTime())<1000*validTime){
                throw new ServiceException("发送验证码太频繁");
            }
        }
       try {
           Map<String,Object> captcha = userCaptchaService.add(agentBindVo.getPhone(),agentBindVo.getImgCaptcha());
           log.info("返回的map:" +JSONObject.toJSONString(captcha));
           if (2==(int)captcha.get("status")){
               return error(206,(String)captcha.get("msg"));
           } else if (1==(int)captcha.get("status")) {
               return success(205,(String)captcha.get("captcha"));
           }
       } catch (Exception e){
           throw new ServiceException("发送验证码失败");
       }
        return success();
    }

    @RequestMapping("/verification")
    @ResponseBody
    public Object verification(@RequestBody AgentBindVo agentBindVo)throws Exception {
        AssertUtil.notNull(agentBindVo.getPhone(),"手机号不能为空");
        String captcha = "";
        try {
           captcha = userCaptchaService.verification(agentBindVo.getPhone());
        } catch (Exception e){
            throw new ServiceException("发送验证码失败");
        }
        return success(captcha);
    }
    
}
