package com.doctorwork.union.module.weixin.service.impl;

import com.alibaba.fastjson.JSON;
import com.doctorwork.common.exception.ServiceException;
import com.doctorwork.common.result.HttpResult;
import com.doctorwork.common.result.PageResult;
import com.doctorwork.union.common.config.WeiXinProperties;
import com.doctorwork.union.common.rest.Response;
import com.doctorwork.union.module.agent.bean.Agent;
import com.doctorwork.union.module.agent.bean.AgentCriteria;
import com.doctorwork.union.module.agent.dao.AgentMapper;
import com.doctorwork.union.module.invitation.bean.Invitation;
import com.doctorwork.union.module.invitation.bean.InvitationCriteria;
import com.doctorwork.union.module.invitation.dao.InvitationMapper;
import com.doctorwork.union.module.invitation.service.InvitationService;
import com.doctorwork.union.module.invitation.vo.InvitationDoctorVo;
import com.doctorwork.union.module.invitation.vo.InvitationQueryVo;
import com.doctorwork.union.module.weixin.service.WeiXinService;
import com.doctorwork.union.module.weixin.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by barry on 2017/10/20.
 */
@Service
@Slf4j
public class WeiXinServiceImpl implements WeiXinService {

    private static final String WEIXIN_SEND_MSG_URL="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
    private static final String WEIXIN_ACCESS_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";

//    private static final String TEMPLATE_ORDER_OVER_ID="wFETnJz8k4mPZh6r9m4UggM7OJpla3rZh4rcy67V-8s";//支付完成
//    private static final String TEMPLATE_INITATION_ID="wFETnJz8k4mPZh6r9m4UggM7OJpla3rZh4rcy67V-8s";//邀请提醒

    @Autowired
    private WeiXinProperties weiXinProperties;

    @Resource
    private AgentMapper agentMapper;

    @Autowired
    private InvitationService invitationService;

    @Resource
    private InvitationMapper invitationMapper;

    @Override
    public String sendRemind(String openId,String url,OrderContentVo orderContentVo) throws Exception {

        String getRet= doGet(WEIXIN_ACCESS_TOKEN_URL+"&appid="+weiXinProperties.getAppid()+"&secret="+weiXinProperties.getAppsecret());
        log.info("weixin access_toke:{}",getRet);
        WeiXinTokenVo weiXinTokenVo= JSON.parseObject(getRet,WeiXinTokenVo.class);
        WeiXinTemplateVo<OrderContentVo> tmplate=new WeiXinTemplateVo<>();
        tmplate.setTouser(openId);
        tmplate.setTemplate_id(weiXinProperties.getMsgTemplateId());
        tmplate.setUrl(url);
        tmplate.setData(orderContentVo);
        String ret=doPost(WEIXIN_SEND_MSG_URL+weiXinTokenVo.getAccessToken(),JSON.toJSONString(tmplate));
        return ret;
    }

    @Override
    public String sendDown(String openId,String url,OrderContentVo orderContentVo) throws Exception {
        String getRet= doGet(WEIXIN_ACCESS_TOKEN_URL+"&appid="+weiXinProperties.getAppid()+"&secret="+weiXinProperties.getAppsecret());
        log.info("weixin access_toke:{}",getRet);
        WeiXinTokenVo weiXinTokenVo= JSON.parseObject(getRet,WeiXinTokenVo.class);
        WeiXinTemplateVo<OrderContentVo> tmplate=new WeiXinTemplateVo<>();
        tmplate.setTouser(openId);
        tmplate.setTemplate_id(weiXinProperties.getMsgTemplateId());
        tmplate.setUrl(url);
        tmplate.setData(orderContentVo);
        String ret=doPost(WEIXIN_SEND_MSG_URL+weiXinTokenVo.getAccessToken(),JSON.toJSONString(tmplate));
        return ret;
    }

    @Override
    public HttpResult invitationList(WeiXinRequest weiXinRequest){
        if(weiXinRequest!=null && StringUtils.isNotBlank(weiXinRequest.getOpenId())){
            AgentCriteria agentCriteria=new AgentCriteria();
            agentCriteria.createCriteria().andOpenIdEqualTo(weiXinRequest.getOpenId());
            List<Agent> agents=agentMapper.selectByExample(agentCriteria);
            if(agents!=null && agents.size()>0){
                Agent agent=agents.get(0);
                InvitationQueryVo invitationQueryVo=new InvitationQueryVo();
                invitationQueryVo.setPageNum(1);
                invitationQueryVo.setPageSize(15);
                if(weiXinRequest.getPageNum()!=null && weiXinRequest.getPageNum()>0){
                    invitationQueryVo.setPageNum(weiXinRequest.getPageNum());
                }
                if(weiXinRequest.getPageSize()!=null && weiXinRequest.getPageSize()<=15){
                    invitationQueryVo.setPageSize(weiXinRequest.getPageSize());
                }
                invitationQueryVo.setAgentId(agent.getId());
                PageResult<InvitationDoctorVo> pageResult= invitationService.queryByAgentId(invitationQueryVo);
                return new HttpResult(Response.SUCCESS,"",pageResult);
            }else{
                return new HttpResult(Response.ERROR,"openId未绑定",null);
            }
        }else{
            return new HttpResult(Response.ERROR,"openId不能为空",null);
        }
    }

    @Override
    public void updateStatus(WeiXinRequest weiXinRequest) throws Exception {

        if(weiXinRequest!=null && StringUtils.isNotBlank(weiXinRequest.getOpenId()) && StringUtils.isNotBlank(weiXinRequest.getId())){
            Invitation entity=invitationService.profile(weiXinRequest.getId());
            if(!(entity!=null && StringUtils.isNotBlank(entity.getId()))){
                throw new ServiceException("id 不存在");
            }
            AgentCriteria agentCriteria=new AgentCriteria();
            agentCriteria.createCriteria().andOpenIdEqualTo(weiXinRequest.getOpenId());
            List<Agent> agents=agentMapper.selectByExample(agentCriteria);
            if(!(agents!=null && agents.size()>0)){
                throw  new ServiceException("该微信账号没有绑定 平台账号");
            }
            Invitation invitation=new Invitation();
            invitation.setId(weiXinRequest.getId());
            invitation.setInvitationStatus(weiXinRequest.getInvitationStatus());
            invitationService.updateStatus(invitation);
            return;
        }else{
            throw new ServiceException("参数不全");
        }


    }

    private static String doPost(String httpUrl,String json) throws Exception{
        String message="";
        URL url=new URL(httpUrl);
        HttpURLConnection http =(HttpURLConnection) url.openConnection();
        http.setRequestMethod("POST");
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        http.setDoOutput(true);
        http.setDoInput(true);
        http.setConnectTimeout(30000);
        http.setReadTimeout(30000);
        http.connect();
        OutputStream os=http.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.flush();
        os.close();
        InputStream is= http.getInputStream();
        int size = is.available();
        byte[] jsonBytes = new byte[size];
        is.read(jsonBytes);
        message=new String(jsonBytes,"UTF-8");
        return message;
    }

    private static String doGet(String url) throws Exception{
        HttpURLConnection conn = null;
        BufferedReader rd = null ;
        StringBuilder sb = new StringBuilder ();
        String line = null ;
        String response = null;
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setReadTimeout(2000);
            conn.setConnectTimeout(2000);
            conn.setUseCaches(false);
            conn.connect();
            rd  = new BufferedReader( new InputStreamReader(conn.getInputStream(), "UTF-8"));
            while ((line = rd.readLine()) != null ) {
                sb.append(line);
            }
            response = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(rd != null){
                    rd.close();
                }
                if(conn != null){
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;

    }
}
