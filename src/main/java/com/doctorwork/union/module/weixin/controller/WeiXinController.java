package com.doctorwork.union.module.weixin.controller;

import com.alibaba.fastjson.JSON;
import com.doctorwork.common.result.HttpResult;
import com.doctorwork.common.util.HttpUtil;
import com.doctorwork.union.common.config.WeiXinProperties;
import com.doctorwork.union.common.rest.Response;
import com.doctorwork.union.module.invitation.service.InvitationService;
import com.doctorwork.union.module.weixin.service.WeiXinService;
import com.doctorwork.union.module.weixin.vo.WeiXinRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import java.net.URLEncoder;

/**
 * Created by barry on 2017/10/24.
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeiXinController {

    @Autowired
    private WeiXinService weiXinService;

    @Autowired
    private InvitationService invitationService;


    @Autowired
    private WeiXinProperties weiXinProperties;

    @GetMapping("/auth")
    public String  auth(HttpServletResponse response) throws Exception{
        log.info("auth....");
        String url="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+weiXinProperties.getAppid()+"&redirect_uri="+ URLEncoder.encode(weiXinProperties.getToUrl())+"&response_type=code&scope=snsapi_base#wechat_redirect";
        response.sendRedirect(url);
        return url;
    }

    @GetMapping("/appid/{code}")
    public String openId(@PathVariable("code") String code) throws Exception{
        String url ="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+weiXinProperties.getAppid()+"&secret="+weiXinProperties.getAppsecret()+"&code="+code+"&grant_type=authorization_code";
        String ret= HttpUtil.httpGet(url).toJSONString();
        log.info(ret);
        return ret;
    }

    @PostMapping("/invitation/list")
    public @ResponseBody HttpResult invitationList(@RequestBody WeiXinRequest weiXinRequest){
        log.info("req json:{}", JSON.toJSON(weiXinRequest));
        return weiXinService.invitationList(weiXinRequest);
    }

    @GetMapping("/invitation_detail")
    public @ResponseBody HttpResult invitationDetail(@QueryParam("openId") String openId,@QueryParam("id") String id){
        try{
            return new HttpResult(Response.SUCCESS,"",invitationService.profile(id));
        }catch(Exception e){
            e.printStackTrace();
            return new HttpResult(Response.ERROR,e.getMessage(),null);
        }
    }

    @PostMapping("/invitation/status")
    public @ResponseBody HttpResult status(@RequestBody WeiXinRequest weiXinRequest){
        try{
            log.info("param:{}",JSON.toJSON(weiXinRequest));
            weiXinService.updateStatus(weiXinRequest);
            return new HttpResult(Response.SUCCESS,"",null);
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage(),e);
            return new HttpResult(Response.ERROR,e.getMessage(),null);
        }

    }




}
