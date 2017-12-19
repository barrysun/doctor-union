package com.doctorwork.union.module.invitation.controller;

import com.alibaba.fastjson.JSON;
import com.doctorwork.common.result.HttpResult;
import com.doctorwork.union.common.annotation.Auth;
import com.doctorwork.union.common.rest.Response;
import com.doctorwork.union.module.doctor.bean.Doctor;
import com.doctorwork.union.module.doctor.service.DoctorService;
import com.doctorwork.union.module.invitation.bean.Invitation;
import com.doctorwork.union.module.invitation.service.InvitationService;
import com.doctorwork.union.module.invitation.vo.InvitationDoctorVo;
import com.doctorwork.union.module.invitation.vo.InvitationQueryVo;
import com.doctorwork.union.module.invitation.vo.PayMentCallVo;
import com.doctorwork.union.module.login.vo.LoginResVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.QueryParam;

/**
 * Created by barry on 2017/10/16.
 */
@Slf4j
@RestController
@RequestMapping("/invitation")
public class InvitationController {

    @Autowired
    private InvitationService invitationService;

    @Autowired
    private DoctorService doctorService;

    private static final String TYPE="type";
    private static final String ORDER_ID="order_id";
    private static final String PRODUCT_ID="product_id";
    private static final String PAY_ORDER_NUMBER = "pay_order_number";
    private static final String ORDER_MONEY="order_money";
    private static final String CREATE_TIME="create_time";

    /**
     * 支付成功回调
     * @param
     * @return
     */
    @PostMapping("/payment-success-call")
    public String paymentSuccessCall(HttpServletRequest params, HttpServletResponse response) throws Exception{
        PayMentCallVo vo=new PayMentCallVo();
        vo.setCreateTime(params.getParameter(CREATE_TIME));
        vo.setOrderId(params.getParameter(ORDER_ID));
        vo.setOrderMoney(params.getParameter(ORDER_MONEY));
        vo.setPayOrderNumber(params.getParameter(PAY_ORDER_NUMBER));
        vo.setProductId(params.getParameter(PRODUCT_ID));
        vo.setType(params.getParameter(TYPE));
        invitationService.paymentSuccessCall(vo);
        return "SUCCESS" ;
    }

    @GetMapping("/{id}")
    public @ResponseBody HttpResult profile(@PathVariable String id){
        try{
            return new HttpResult(Response.SUCCESS,"",invitationService.profile(id));
        }catch(Exception e){
            e.printStackTrace();
            return new HttpResult(Response.ERROR,e.getMessage(),null);
        }
    }


    /**
     * 设置邀请状态
     * @param invitation
     * @return
     */
    @RequestMapping("/status")
    public @ResponseBody HttpResult updateStatus(@RequestBody Invitation invitation){
        try{
            invitationService.updateStatus(invitation);
            return new HttpResult(Response.SUCCESS,"",null);
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage(),e);
            return new HttpResult(Response.ERROR,e.getMessage(),null);
        }
    }

    /**
     * 邀请添加
     * @param invitationDoctorVo
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody HttpResult save(@RequestBody @Valid InvitationDoctorVo invitationDoctorVo){
        //邀请
        try{
            if(StringUtils.isNotBlank(invitationDoctorVo.getPassportId())){
                Doctor doctor=doctorService.queryByPassportId(invitationDoctorVo.getPassportId());
                if(!(doctor!=null && StringUtils.isNotBlank(doctor.getId()))){
                    return new HttpResult(Response.ERROR,"该医生不存在",null);
                }
                invitationDoctorVo.setDoctorId(doctor.getId());
            }
            invitationService.save(invitationDoctorVo);
            return new HttpResult(Response.SUCCESS,"",null);
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage(),e);
            return new HttpResult(Response.ERROR,e.getMessage(),null);
        }
    }

    /**
     * 查询邀请记录
     * @param clinicId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/query_by_clinic_id")
    public @ResponseBody HttpResult queryByClinicId(@QueryParam("clinicId") String clinicId,@QueryParam("pageNum") Integer pageNum,@QueryParam("pageSize") Integer pageSize){
        InvitationQueryVo invitationQueryVo=new InvitationQueryVo();
        if(!StringUtils.isNotBlank(clinicId)){
            return new HttpResult(Response.ERROR,"clinicId不能为空",null);
        }
        invitationQueryVo.setClinicId(clinicId);
        //invitationQueryVo.setPageNum(1);
        //invitationQueryVo.setPageSize(15);
        if(pageNum!=null && pageNum>0){
            invitationQueryVo.setPageNum(pageNum);
        }else{
            invitationQueryVo.setPageNum(1);
        }
        if(pageSize!=null && pageSize>0){
            invitationQueryVo.setPageSize(pageSize);
        }else{
            invitationQueryVo.setPageSize(10);
        }
        return new HttpResult(Response.SUCCESS,"",invitationService.queryByClinicId(invitationQueryVo));
    }

    @GetMapping("/query_by_doctor_id")
    public @ResponseBody HttpResult queryByDoctorId(@QueryParam("passportId") String passportId,@QueryParam("doctorId") String doctorId,@QueryParam("pageNum") Integer pageNum,@QueryParam("pageSize") Integer pageSize,@QueryParam("search") String search){
        InvitationQueryVo invitationQueryVo=new InvitationQueryVo();
        if(!StringUtils.isNotBlank(doctorId) && !StringUtils.isNotBlank(passportId) ){
            return new HttpResult(Response.ERROR,"参数不能为空",null);
        }try{
            Doctor doctor=doctorService.queryByPassportId(passportId);
            doctorId=doctor.getId();
            invitationQueryVo.setDoctorId(doctorId);
            invitationQueryVo.setPageNum(1);
            invitationQueryVo.setPageSize(15);
            if(pageNum!=null && pageNum>0){
                invitationQueryVo.setPageNum(pageNum);
            }
            if(pageSize!=null && pageSize<=15){
                invitationQueryVo.setPageSize(15);
            }

            invitationQueryVo.setSearch(search);
            return new HttpResult(Response.SUCCESS,"",invitationService.queryByDoctorId(invitationQueryVo));

        }catch(Exception e){
        e.printStackTrace();
        log.error(e.getMessage(),e);
        return new HttpResult(Response.ERROR,e.getMessage(),null);
        }


    }

    /**
     * 查询邀请记录
     * @param
     * @return
     */
    @GetMapping("/query_by_agent_id")
    @Auth
    public @ResponseBody HttpResult queryByAgentId(@QueryParam("agentId") String agentId,@QueryParam("pageNum") Integer pageNum,@QueryParam("pageSize") Integer pageSize,@QueryParam("search") String search,HttpSession httpSession){

        InvitationQueryVo invitationQueryVo=new InvitationQueryVo();
       LoginResVo loginResVo= (LoginResVo) httpSession.getAttribute("login");
       log.info("session login data:{}",JSON.toJSON(loginResVo));
        if(loginResVo!=null && StringUtils.isNotBlank(loginResVo.getAgentId())){
           agentId=loginResVo.getAgentId();
        }
//        if(!StringUtils.isNotBlank(agentId)){
//            return new HttpResult(Response.ERROR,"agentId不能为空",null);
//        }
        invitationQueryVo.setAgentId(StringUtils.isNotBlank(agentId)?agentId:null);
        invitationQueryVo.setPageNum(0);
        invitationQueryVo.setPageSize(15);
        if(pageNum!=null && pageNum>0){
            invitationQueryVo.setPageNum(pageNum);
        }
        if(pageSize!=null && pageSize<=0){
            invitationQueryVo.setPageSize(15);
        }
        invitationQueryVo.setSearch(search);
        return new HttpResult(Response.SUCCESS,"",invitationService.queryByAgentId(invitationQueryVo));
    }

    @PostMapping("/qr")
    public @ResponseBody HttpResult qr(@RequestBody @Valid InvitationDoctorVo invitationDoctorVo){
        try{
            Invitation invitation=new Invitation();
            invitation.setId(invitationDoctorVo.getId());
            return new HttpResult(Response.SUCCESS,"",invitationService.qr(invitation));
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage(),e);
            return new HttpResult(Response.ERROR,e.getMessage(),null);
        }

    }

}
