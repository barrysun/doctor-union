package com.doctorwork.union.module.login.controller;

import com.doctorwork.common.controller.BaseController;
import com.doctorwork.common.exception.ServiceException;
import com.doctorwork.common.result.HttpResult;
import com.doctorwork.union.common.utils.AssertUtil;
import com.doctorwork.union.common.utils.Role;
import com.doctorwork.union.module.admin.bean.Admin;
import com.doctorwork.union.module.admin.service.AdminService;
import com.doctorwork.union.module.agent.bean.Agent;
import com.doctorwork.union.module.agent.service.AgentService;
import com.doctorwork.union.module.login.vo.LoginResVo;
import com.doctorwork.union.module.login.vo.UserInfoVo;
import com.doctorwork.union.module.passport.service.PassportService;
import com.doctorwork.union.module.passport.vo.PassportResultVo;
import com.doctorwork.union.module.passport.vo.UserParam;
import com.doctorwork.union.module.passport.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by barry on 2017/10/16.
 */

@Slf4j
@RestController
@RequestMapping("/")
public class LoginController extends BaseController{

    @Autowired
    private PassportService passportService;

    @Autowired
    private AgentService agentService;

    @Autowired
    private AdminService adminService;

    @PostMapping(value ="/login")
    public @ResponseBody HttpResult login(@RequestBody UserInfoVo userInfoVo, HttpSession httpSession) throws Exception{
        AssertUtil.notNull(userInfoVo.getUserName(),"用户名不能为空");
        AssertUtil.notNull(userInfoVo.getPwd(),"密码不能为空");
        UserParam userParam =new UserParam();
        userParam.setCellphone(userInfoVo.getUserName());
        userParam.setPwd(com.doctorwork.common.util.Md5Util.encoderByMd5(userInfoVo.getPwd()));
        PassportResultVo passportResultVo = passportService.login(userParam);
        if (passportResultVo.getErrcode()!=0) {
            if (passportResultVo.getErrcode()==5||passportResultVo.getErrcode()==9) {
                return error(202,"用户名或密码错误");
            } else {
                throw new RuntimeException("调用passport返回异常："+passportResultVo.getErrmsg());
            }
        }
        //验证账号是否存在
        UserVo userVo = (UserVo)passportResultVo.getData();
        List<String> rellRoles = new ArrayList<>();
        String agentId = "";
        List<Admin> listAdmin = adminService.selectAdminByPassId(userVo.getUserId().toString());
        if (listAdmin!=null&&listAdmin.size()>0) {
            rellRoles.add(Role.ADMIN.getRoleId());
        }
        List<Agent> listAgent= agentService.selectAgentByPassId(userVo.getUserId().toString());
        if (listAgent!=null&&listAgent.size()>0) {
            rellRoles.add(Role.AGENT.getRoleId());
            Agent agent = listAgent.get(0);
            agentId = agent.getId();
        }
        if (rellRoles.size()<1) {
            throw new ServiceException("该用户不存在或已禁用");
        }
        LoginResVo loginResVo = new LoginResVo();
        loginResVo.setUserName(userInfoVo.getUserName());
        loginResVo.setRole(rellRoles);
        loginResVo.setPassportId(userVo.getUserId().toString());
        loginResVo.setAgentId(agentId);
        httpSession.setAttribute("login",loginResVo);
        return success(loginResVo);
    }

    @RequestMapping("login/error")
    public @ResponseBody HttpResult loginError(HttpServletRequest req, HttpServletResponse res){
       return error(201,"请重新登录");
    }

    @RequestMapping("/isLogin")
    public @ResponseBody HttpResult isLogin(HttpSession httpSession){
        LoginResVo obj = (LoginResVo)httpSession.getAttribute("login");
        if (obj ==null) {
            return error(201,"请重新登录");
        } else {
            return success(obj);
        }

    }

    @RequestMapping("/updatePwd")
    public @ResponseBody HttpResult updatePwd(@RequestBody UserInfoVo userInfoVo,HttpSession httpSession) throws Exception{
        UserParam userParam = new UserParam();
        userParam.setPwd(userInfoVo.getPwd());
        userParam.setUserid(Integer.valueOf(userInfoVo.getPassportId()));
        passportService.passportUpdatePwd(userParam);
        return success();
    }

    @RequestMapping("/loginOut")
    public @ResponseBody HttpResult loginOut(HttpSession httpSession) throws Exception{
        httpSession.removeAttribute("login");
        httpSession.invalidate();
        return success();
    }
}
