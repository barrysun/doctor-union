package com.doctorwork.union.module.invitation.service.impl;

import com.alibaba.fastjson.JSON;
import com.doctorwork.common.exception.ServiceException;
import com.doctorwork.common.result.PageResult;
import com.doctorwork.union.common.config.WalletProperties;
import com.doctorwork.union.common.config.WeiXinProperties;
import com.doctorwork.union.module.wallet.vo.PayType;
import com.doctorwork.union.common.utils.SHA1;
import com.doctorwork.union.common.uuid.UuidUtil;
import com.doctorwork.union.module.agent.bean.Agent;
import com.doctorwork.union.module.agent.dao.AgentMapper;
import com.doctorwork.union.module.doctor.bean.Doctor;
import com.doctorwork.union.module.doctor.dao.DoctorMapper;
import com.doctorwork.union.module.income.bean.Income;
import com.doctorwork.union.module.income.service.IncomeService;
import com.doctorwork.union.module.invitation.bean.Invitation;
import com.doctorwork.union.module.invitation.bean.InvitationStatus;
import com.doctorwork.union.module.invitation.dao.InvitationDoctorMapper;
import com.doctorwork.union.module.invitation.dao.InvitationMapper;
import com.doctorwork.union.module.invitation.service.InvitationService;
import com.doctorwork.union.module.invitation.vo.*;
import com.doctorwork.union.module.shopkeeper.service.ShopkeeperService;
import com.doctorwork.union.module.visit.bean.Visit;
import com.doctorwork.union.module.visit.bean.VisitCriteria;
import com.doctorwork.union.module.visit.dao.VisitMapper;
import com.doctorwork.union.module.visit.vo.DayVo;
import com.doctorwork.union.module.visit.vo.TimeVo;
import com.doctorwork.union.module.wallet.service.WalletService;
import com.doctorwork.union.module.wallet.vo.ApplyParam;
import com.doctorwork.union.module.wallet.vo.TransferParam;
import com.doctorwork.union.module.weixin.service.WeiXinService;
import com.doctorwork.union.module.weixin.vo.MsgText;
import com.doctorwork.union.module.weixin.vo.OrderContentVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by barry on 2017/10/16.
 */
@Slf4j
@Service
public class InvitationServiceImpl  implements InvitationService{

    @Autowired
    private ShopkeeperService shopkeeperService;

    @Resource
    private InvitationDoctorMapper invitationDoctorMapper;

    @Resource
    private VisitMapper visitMapper;

    @Resource
    private DoctorMapper doctorMapper;

    @Resource
    private AgentMapper agentMapper;

    @Autowired
    private WalletProperties walletProperties;

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private WalletService walletService;
    @Autowired
    private WeiXinService weiXinService;

    @Resource
    private InvitationMapper invitationMapper;

    @Autowired
    private WeiXinProperties weiXinProperties;


    private static final String PAY_CREATE_ORDER="pay/create-order";

    @Override
    public PageResult<InvitationDoctorVo> queryByClinicId(InvitationQueryVo invitationQueryVo) {
        Page page= PageHelper.startPage(invitationQueryVo.getPageNum(),invitationQueryVo.getPageSize());
        List<InvitationDoctorVo> list=invitationDoctorMapper.queryByClinicId(invitationQueryVo);
        PageResult<InvitationDoctorVo> ret=new PageResult<>(page.getTotal(),page.getPages(),page.getPageNum(),page.getPageSize(),list);
        List<InvitationDoctorVo> array=ret.getList();
        Map<String,Object> param = new HashMap<String,Object>();
        if(array!=null && array.size()>0){
            for(InvitationDoctorVo vo:array){
                VisitCriteria visitCriteria=new VisitCriteria();
//                //visitCriteria.createCriteria()
//                visitCriteria.createCriteria().andIsDeleteEqualTo(0);
//                VisitCriteria visitCriteria=new VisitCriteria();
                //visitCriteria.createCriteria()
                visitCriteria.createCriteria().andIsDeleteEqualTo(0).andInvitationIdEqualTo(vo.getId());
                List<Visit> visits=visitMapper.selectByExample(visitCriteria);
                List<DayVo> arr=new ArrayList<>();
                vo.setWorkCount(0);
                if(visits!=null && visits.size()>0){
                    vo.setWorkCount(visits.size());
                    for(Visit visit:visits){
                        DayVo tmp =null;
                        if(arr.size()==0){
                            arr.add(new DayVo());
                        }
                        tmp=arr.get(arr.size()-1);
                        if(tmp.getDay()==null ||tmp.getDay()<=0D||(getDayStartTime(new Date(tmp.getDay())).equals(getDayStartTime(new Date(visit.getStartTime()))))){

                        }else{
                            arr.add(new DayVo());
                            tmp=arr.get(arr.size()-1);
                        }
                        tmp.setDay(getDayStartTime(new Date(visit.getStartTime())));
                        if(visit.getTimeInterval()==1){
                            TimeVo timeVo=new TimeVo();
                            timeVo.setStartTime(visit.getStartTime());
                            timeVo.setEndTime(visit.getEndTime());
                            tmp.setAm(timeVo);

                        }else if(visit.getTimeInterval()==2){
                            TimeVo timeVo=new TimeVo();
                            timeVo.setStartTime(visit.getStartTime());
                            timeVo.setEndTime(visit.getEndTime());
                            tmp.setPm(timeVo);
                        }
                    }
                }

//                if (!map.isEmpty() && map.get(vo.getClinicId())!=null) {
//                    ClinicVo clinicVo=map.get(vo.getClinicId());
//                    vo.setClinicName(clinicVo.getName());
//                    vo.setInvitationUserName(clinicVo.getRegisterName());
//                }
                vo.setList(arr);

            }
        }
        return ret;
    }

    @Override
    public PageResult<InvitationDoctorVo> queryByAgentId(InvitationQueryVo invitationQueryVo) {
        Page<?> page= PageHelper.startPage(invitationQueryVo.getPageNum(),invitationQueryVo.getPageSize());
        List<InvitationDoctorVo> list=invitationDoctorMapper.queryByAgentId(invitationQueryVo);
        PageResult<InvitationDoctorVo> ret=new PageResult<>(page.getTotal(),page.getPages(),page.getPageNum(),page.getPageSize(),list);
        List<InvitationDoctorVo> array=ret.getList();
        //Map<String,Object> param = new HashMap<String,Object>();
        if(array!=null && array.size()>0){
            Set<String> keys=new HashSet<String>();
            for(InvitationDoctorVo invitation:array){
                keys.add(invitation.getClinicId());
            }
           Map<String,ClinicVo> clinicMap = shopkeeperService.getClinicNames(keys);
            for(InvitationDoctorVo vo:array){
                VisitCriteria visitCriteria=new VisitCriteria();
                //visitCriteria.createCriteria()
                visitCriteria.createCriteria().andInvitationIdEqualTo(vo.getId());
                List<Visit> visits=visitMapper.selectByExample(visitCriteria);
                List<DayVo> arr=new ArrayList<>();
                if(visits!=null && visits.size()>0){
                    for(Visit visit:visits){
                        DayVo tmp =null;
                        if(arr.size()==0){
                            arr.add(new DayVo());
                        }
                        tmp=arr.get(arr.size()-1);
                        if(tmp.getDay()==null ||tmp.getDay()<=0D||(getDayStartTime(new Date(tmp.getDay())).equals(getDayStartTime(new Date(visit.getStartTime()))))){

                        }else{
                            arr.add(new DayVo());
                            tmp=arr.get(arr.size()-1);
                        }
                        tmp.setDay(getDayStartTime(new Date(visit.getStartTime())));
                        if(visit.getTimeInterval()==1){
                            TimeVo timeVo=new TimeVo();
                            timeVo.setStartTime(visit.getStartTime());
                            timeVo.setEndTime(visit.getEndTime());
                            tmp.setAm(timeVo);

                        }else if(visit.getTimeInterval()==2){
                            TimeVo timeVo=new TimeVo();
                            timeVo.setStartTime(visit.getStartTime());
                            timeVo.setEndTime(visit.getEndTime());
                            tmp.setPm(timeVo);
                        }
                    }
                }
                if (!clinicMap.isEmpty() && clinicMap.get(vo.getClinicId())!=null) {
                    ClinicVo clinicVo=clinicMap.get(vo.getClinicId());
                    vo.setClinicName(clinicVo.getName());
                    vo.setInvitationUserName(clinicVo.getRegisterName());
                }
                vo.setList(arr);
            }
        }
        return ret;
    }

    @Override
    public PageResult<InvitationDoctorVo> queryByDoctorId(InvitationQueryVo invitationQueryVo) {
        Page<?> page= PageHelper.startPage(invitationQueryVo.getPageNum(),invitationQueryVo.getPageSize());
        List<InvitationDoctorVo> list=invitationDoctorMapper.queryByDoctorId(invitationQueryVo);
        PageResult<InvitationDoctorVo> ret=new PageResult<>(page.getTotal(),page.getPages(),page.getPageNum(),page.getPageSize(),list);
        List<InvitationDoctorVo> array=ret.getList();

        if(array!=null && array.size()>0){
            for(InvitationDoctorVo vo:array){
                Doctor doctor=doctorMapper.selectByPrimaryKey(vo.getDoctorId());
                if(doctor!=null &&  doctor.getWorkPrice()!=null){
                    vo.setOnePrice(new BigDecimal(doctor.getWorkPrice().intValue()));
                }
                VisitCriteria visitCriteria=new VisitCriteria();
                //visitCriteria.createCriteria()
                visitCriteria.createCriteria().andIsDeleteEqualTo(0).andInvitationIdEqualTo(vo.getId());

                List<Visit> visits=visitMapper.selectByExample(visitCriteria);
                List<DayVo> arr=new ArrayList<>();
                vo.setWorkCount(0);
                if(visits!=null && visits.size()>0){
                    vo.setWorkCount(visits.size());
                    for(Visit visit:visits){
                        DayVo tmp =null;
                        if(arr.size()==0){
                            arr.add(new DayVo());
                        }
                        tmp=arr.get(arr.size()-1);
                        if(tmp.getDay()==null ||tmp.getDay()<=0D||(getDayStartTime(new Date(tmp.getDay())).equals(getDayStartTime(new Date(visit.getStartTime()))))){

                        }else{
                            arr.add(new DayVo());
                            tmp=arr.get(arr.size()-1);
                        }
                        tmp.setDay(getDayStartTime(new Date(visit.getStartTime())));
                        if(visit.getTimeInterval()==1){
                            TimeVo timeVo=new TimeVo();
                            timeVo.setStartTime(visit.getStartTime());
                            timeVo.setEndTime(visit.getEndTime());
                            timeVo.setId(visit.getInvitationId());
                            //timeVo.setInvitationStatus(invitation.getInvitationStatus());
                            tmp.setAm(timeVo);

                        }else if(visit.getTimeInterval()==2){
                            TimeVo timeVo=new TimeVo();
                            timeVo.setStartTime(visit.getStartTime());
                            timeVo.setEndTime(visit.getEndTime());
                            tmp.setPm(timeVo);
                        }
                    }
                }
                vo.setList(arr);
            }
        }
        return ret;
    }

    // 获取某个日期的开始时间
    private static Long getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d)
            calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0,
                0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    @Override
    public void updateStatus(Invitation invitation) throws Exception {

        if(invitation!=null && StringUtils.isNotBlank(invitation.getId())){
            if(invitation.getInvitationStatus()== InvitationStatus.AGREE){//同意
                agree(invitation);
            }else if(invitation.getInvitationStatus()==InvitationStatus.REFUSE){//拒绝
                refuse(invitation);
            }else if(invitation.getInvitationStatus()==InvitationStatus.PAYDOWN){//支付完成
                //
                invitationMapper.updateByPrimaryKeySelective(invitation);
            }
            return;
        }
        throw new RuntimeException("id 不能为空");
    }

    @Override
    @Transactional
    public PayMentVo qr(Invitation invitation) throws Exception {
        Integer platForm =1;//支付平台 1.表示微信，2.表示支付宝 目前只有微信支付，必传
        Integer appId=11;//各个项目的APPId
        String desc ="订单描述";//订单描述，必须传递 必传
        //Integer totalFree=1;//订单金额，单位为分 必传
        String tag="订单tag";//
        String tradeType="NATIVE";//
        Integer totalFree=1;
        Invitation invitation1=invitationMapper.selectByPrimaryKey(invitation.getId());
        totalFree=invitation1.getTotalPrice().intValue();
        String product_id=invitation.getId();//商品ID,tradeType为NATIVE时必传
        //获取
        Map<String,Object> map=new HashMap<>();
        map.put("platForm",platForm);
        map.put("appId",appId);
        map.put("desc",desc);
        map.put("totalFree",totalFree);
        map.put("tag",tag);
        map.put("tradeType",tradeType);
        map.put("product_id",product_id);
        List<String> keys = new ArrayList<>(map.keySet());
        StringBuilder builder=new StringBuilder();
        Collections.sort(keys);
        for (String key : keys) {
            Object valueObj = map.get(key);
            builder.append(key).append("=").append(valueObj.toString()).append("&");
        }
        String param = builder.substring(0,builder.length()-1);
        String shaStr= SHA1.SHA1(walletProperties.getPaymentSignKey()+param+walletProperties.getPaymentSignKey());
        log.info("param:{}",param);
        log.info("SHA1:{}", shaStr);
        String result = doPost(walletProperties.getWalletHost()+PAY_CREATE_ORDER,param+"&sign="+shaStr);
        log.info("result:{}",result);
        PayMentVo vo= JSON.parseObject(result, PayMentVo.class);
        return vo;
    }

    @Override
    @Transactional
    public void save(InvitationDoctorVo invitationDoctorVo) throws Exception {

        List<String> visits =invitationDoctorVo.getSelectIds();
        if(visits!=null && visits.size()>0){
            if(StringUtils.isNotBlank(invitationDoctorVo.getId())){
                //修改
            }else{
                Doctor doctor=doctorMapper.selectByPrimaryKey(invitationDoctorVo.getDoctorId());
                if(doctor==null || !StringUtils.isNotBlank(doctor.getId())){
                    throw new RuntimeException("医生不存在");
                }
                Invitation invitation=new Invitation();
                invitation.setId(UuidUtil.getUUID());
                invitation.setDoctorId(invitationDoctorVo.getDoctorId());
                invitation.setIsDelete(0);
                invitation.setClinicId(invitationDoctorVo.getClinicId());
                invitation.setModifyTime(System.currentTimeMillis());
                invitation.setCreateTime(System.currentTimeMillis());
                invitation.setInvitationStatus(0);
                invitation.setReason("");
                invitation.setAgentId(doctor.getAgentId());
                invitation.setPassortId(doctor.getPassportId());
                invitation.setPayStatus(0);
                invitation.setPayMethod(1);//1是微信2 是支付宝
                Long totalPrice=0L;
                for(String id :visits){
                    Visit entity = new Visit();
                        entity.setId(id);
                        entity.setClinicId(invitation.getClinicId());
                        entity.setInvitationId(invitation.getId());
                        entity.setInvitationStatus(1);
                        entity.setModifyTime(invitation.getModifyTime());
                        entity.setOnePrice(doctor.getWorkPrice());
                        totalPrice+=doctor.getWorkPrice();
//                    if(visit.getSelected()==1){
//                        entity.setId(visit.getId());
//                        entity.setClinicId(invitation.getClinicId());
//                        entity.setInvitationId(invitation.getId());
//                        entity.setInvitationStatus(1);
//                        entity.setModifyTime(invitation.getModifyTime());
//                        entity.setOnePrice(doctor.getWorkPrice());
//                        totalPrice+=doctor.getWorkPrice();
//                    }else{
//                        entity.setId(visit.getId());
//                        entity.setInvitationStatus(0);
//                        entity.setInvitationId("");
//                        entity.setModifyTime(invitation.getModifyTime());
//                        entity.setOnePrice(doctor.getWorkPrice());
//                    }
                    visitMapper.updateByPrimaryKeySelective(entity);
                }
                //
                invitation.setOnePrice(doctor.getWorkPrice());
                invitation.setTotalPrice(totalPrice);
                invitationMapper.insertSelective(invitation);
                //发送提醒消息
                //推送提醒消息
                //推送成功 消息
                Agent agent=agentMapper.selectByPrimaryKey(doctor.getAgentId());
                OrderContentVo orderOverVo=new OrderContentVo();
                orderOverVo.setFirst(new MsgText("预约提醒"));
                orderOverVo.setKeyword1(new MsgText("DH-"+invitation.getCreateTime()+""));//预约单号
                orderOverVo.setKeyword2(new MsgText(doctor.getDoctorName()+""));//预约医生
                if(visits!=null && visits.size()>0){
                    Visit tmp=visitMapper.selectByPrimaryKey(visits.get(0));
                    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    orderOverVo.setKeyword3(new MsgText(String.format("%s %s",simpleDateFormat.format(tmp.getStartTime()),tmp.getTimeInterval()==1?"上午":"下午")));//预约时间
                }
                orderOverVo.setKeyword4(new MsgText("微信支付"));//微信支付
                orderOverVo.setKeyword5(new MsgText("待处理"));//
                orderOverVo.setRemark(new MsgText(String.format("您好，请您在30分钟内处理该订单")));
                weiXinService.sendRemind(agent.getOpenId(),weiXinProperties.getDetail()+"?id="+invitation.getId()+"&openId="+agent.getOpenId(),orderOverVo);
            }
        }else{
            throw  new RuntimeException("没有可设置的参数");
        }
    }

    @Override
    @Transactional
    public void paymentSuccessCall(PayMentCallVo vo) throws Exception {
        Invitation invitation=invitationMapper.selectByPrimaryKey(vo.getProductId());
        //判断是否
        if(!(invitation!=null && StringUtils.isNotBlank(invitation.getId()))){
            log.error("该productID:{} 不存在系统中",vo.getProductId());
            return;
        }
        //邀请记录+1
        Doctor doctor=doctorMapper.selectByPrimaryKey(invitation.getDoctorId());
        Doctor record=new Doctor();
        record.setInvitationCount(doctor.getInvitationCount()+1);
        record.setId(doctor.getId());
        doctorMapper.updateByPrimaryKeySelective(record);

        //修改状态
        Invitation entity = new Invitation();
        entity.setId(invitation.getId());
        entity.setPayMethod(1);
        entity.setPayStatus(1);
        entity.setInvitationStatus(InvitationStatus.PAYDOWN);//支付成功
        entity.setModifyTime(System.currentTimeMillis());
        updateStatus(entity);
        //计算费用抽成
        Income income=new Income();
        income.setClinicId(invitation.getClinicId());
        income.setIncomeDate(System.currentTimeMillis());
        income.setCreateTime(income.getIncomeDate());
        income.setModifyTime(income.getIncomeDate());
        income.setIsDelete(0);
        income.setPassportId(invitation.getPassortId());
        income.setSerialNumber(vo.getOrderId());
        income.setDoctorId(invitation.getDoctorId());

        income.setPayMoney(new BigDecimal(invitation.getTotalPrice()));//支付金额
        income.setBalance(new BigDecimal(0));//余额
        income.setInvitationId(invitation.getId());
        //Doctor doctor=doctorMapper.selectByPrimaryKey(invitation.getDoctorId());
        income.setPlatformMoney(new BigDecimal(invitation.getTotalPrice().doubleValue()/100.0D*doctor.getPlatformRebate().doubleValue()));//平台收入
        income.setIncomonMoney(new BigDecimal(invitation.getTotalPrice().doubleValue()-income.getPlatformMoney().doubleValue()));//收入 用户收入
        income.setServiceMoney(new BigDecimal(0));
        income.setId(UuidUtil.getUUID());
        incomeService.add(income);

        //查询诊所id
        Set<String> ids=new HashSet<>();
        ids.add(invitation.getClinicId());
        ClinicVo clinicVo=shopkeeperService.getClinicNames(ids).get(invitation.getClinicId());
        ApplyParam applyParam=new ApplyParam();
        applyParam.setOutTradeNo(invitation.getId());
        applyParam.setAmount(invitation.getTotalPrice().intValue());
        applyParam.setPayType(PayType.WX_PAY);
        applyParam.setTag("医生集团预约支付");
        applyParam.setBody("医生集团预约支付");
        applyParam.setUserid(clinicVo.getPassportId());

        walletService.rechargeApply(applyParam);
        //转帐给医生
        doctor.getPassportId();
        TransferParam transferParam = new TransferParam();
        transferParam.setAmount(income.getIncomonMoney().intValue());
        transferParam.setUserid(clinicVo.getPassportId());
        transferParam.setPayuserid(clinicVo.getPassportId());
        transferParam.setRecuserid(Integer.parseInt(doctor.getPassportId()));
        transferParam.setArriveType(1);//实时到账
        transferParam.setOutTradeNo(income.getInvitationId());
        walletService.transfer(transferParam);
        //转账给平台
        TransferParam platTransferParam=new TransferParam();
        platTransferParam.setAmount(income.getPlatformMoney().intValue());
        platTransferParam.setPayuserid(clinicVo.getPassportId());
        platTransferParam.setUserid(clinicVo.getPassportId());
        platTransferParam.setRecuserid(walletProperties.getPlatAccount());
        platTransferParam.setArriveType(1);
        platTransferParam.setOutTradeNo(income.getInvitationId());
        walletService.transfer(platTransferParam);

        //推送成功 消息
        Agent agent=agentMapper.selectByPrimaryKey(doctor.getAgentId());
        OrderContentVo orderOverVo=new OrderContentVo();
        orderOverVo.setFirst(new MsgText("支付完成"));
        orderOverVo.setKeyword1(new MsgText("DH-"+invitation.getCreateTime()+""));//预约时间
        orderOverVo.setKeyword2(new MsgText(doctor.getDoctorName()+""));//预约医生
        VisitCriteria visitCriteria=new VisitCriteria();
        visitCriteria.createCriteria().andInvitationIdEqualTo(invitation.getId());
        visitCriteria.setOrderByClause(" create_time desc ");
        List<Visit> visits=visitMapper.selectByExample(visitCriteria);
        if(visits!=null && visits.size()>0){
            Visit tmp=visits.get(0);
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            orderOverVo.setKeyword3(new MsgText(String.format("%s %s",simpleDateFormat.format(tmp.getStartTime()),tmp.getTimeInterval()==1?"上午":"下午")));//预约时间
        }
        orderOverVo.setKeyword4(new MsgText("微信支付"));//微信支付
        orderOverVo.setKeyword5(new MsgText("支付完成"));//
        orderOverVo.setRemark(new MsgText(""));
        weiXinService.sendDown(agent.getOpenId(),weiXinProperties.getDetail()+"?id="+invitation.getId()+"&openId="+agent.getOpenId(),orderOverVo);
    }

    @Override
    public InvitationVo profile(String id) throws Exception {
        if(StringUtils.isNotBlank(id)){
            Invitation invitation=invitationMapper.selectByPrimaryKey(id);
            InvitationVo ret=new InvitationVo();
            BeanUtils.copyProperties(ret,invitation);
            Set<String> keys=new HashSet<>();
            keys.add(invitation.getClinicId());
            Map<String,ClinicVo> map=shopkeeperService.getClinicNames(keys);

            Doctor doctor=doctorMapper.selectByPrimaryKey(invitation.getDoctorId());

            ret.setDepartment(doctor.getDepartment());
            ret.setTitle(doctor.getTitle());
            ret.setDoctorName(doctor.getDoctorName());
            ret.setDoctorAvatar(doctor.getDoctorAvatar());
            ret.setHospital(doctor.getHospital());
            ret.setInvitationCount(doctor.getInvitationCount());
            ret.setWorkPrice(doctor.getWorkPrice());
            ret.setSpecialty(doctor.getSpecialty());
            ret.setNote(doctor.getNote());
            if(map!=null && map.containsKey(invitation.getClinicId()) && map.get(invitation.getClinicId())!=null){
                ClinicVo clinicVo= map.get(invitation.getClinicId());
                String clinicAddr ="";
                if(StringUtils.isNotBlank(clinicVo.getProvinceName()) && !"null".equals(clinicVo.getProvinceName())){
                    clinicAddr+=clinicVo.getProvinceName();
                }
                if(StringUtils.isNotBlank(clinicVo.getCityName()) && !"null".equals(clinicVo.getCityName())){
                    clinicAddr+=clinicVo.getCityName();
                }
                if(StringUtils.isNotBlank(clinicVo.getAreaName()) && !"null".equals(clinicVo.getAreaName())){
                    clinicAddr+=clinicVo.getAreaName();
                }
                if(StringUtils.isNotBlank(clinicVo.getAddr()) && !"null".equals(clinicVo.getAddr())){
                    clinicAddr+=clinicVo.getAddr();
                }
                ret.setClinicAddr(clinicAddr);
                ret.setClinicName(clinicVo.getName());
                ret.setRegisterName(clinicVo.getRegisterName());
                ret.setTelPhone(clinicVo.getRegisterPhone());
                ret.setRegisterPhone(clinicVo.getRegisterPhone());
            }

            VisitCriteria visitCriteria=new VisitCriteria();
            //visitCriteria.createCriteria()
            visitCriteria.createCriteria().andInvitationIdEqualTo(invitation.getId());
            List<Visit> visits=visitMapper.selectByExample(visitCriteria);

            List<DayVo> arr=new ArrayList<>();
            if(visits!=null && visits.size()>0){
                ret.setWorkCount(visits.size());
                for(Visit visit:visits){
                    DayVo tmp =null;
                    if(arr.size()==0){
                        arr.add(new DayVo());
                    }
                    tmp=arr.get(arr.size()-1);
                    if(tmp.getDay()==null ||tmp.getDay()<=0D||(getDayStartTime(new Date(tmp.getDay())).equals(getDayStartTime(new Date(visit.getStartTime()))))){

                    }else{
                        arr.add(new DayVo());
                        tmp=arr.get(arr.size()-1);
                    }
                    tmp.setDay(getDayStartTime(new Date(visit.getStartTime())));
                    if(visit.getTimeInterval()==1){
                        TimeVo timeVo=new TimeVo();
                        timeVo.setStartTime(visit.getStartTime());
                        timeVo.setEndTime(visit.getEndTime());
                        timeVo.setInvitationStatus(invitation.getInvitationStatus());
                        tmp.setAm(timeVo);

                    }else if(visit.getTimeInterval()==2){
                        TimeVo timeVo=new TimeVo();
                        timeVo.setStartTime(visit.getStartTime());
                        timeVo.setEndTime(visit.getEndTime());
                        timeVo.setInvitationStatus(invitation.getInvitationStatus());
                        tmp.setPm(timeVo);
                    }
                }
            }
            ret.setList(arr);
            return ret;
        }
        throw  new ServiceException("id不能为空");
    }

    private void agree(Invitation invitation) throws Exception{
        Invitation entity=new Invitation();
        entity.setId(invitation.getId());
        entity.setInvitationStatus(invitation.getInvitationStatus());
        entity.setModifyTime(System.currentTimeMillis());
        invitationMapper.updateByPrimaryKeySelective(entity);
    }

    @Transactional
    private void refuse(Invitation invitation) throws Exception {
        Invitation entity=new Invitation();
        entity.setId(invitation.getId());
        entity.setInvitationStatus(invitation.getInvitationStatus());
        entity.setModifyTime(System.currentTimeMillis());

        invitationMapper.updateByPrimaryKeySelective(entity);
        //查询Id
        VisitCriteria visitCriteria=new VisitCriteria();
        visitCriteria.createCriteria().andInvitationIdEqualTo(invitation.getId());
        List<Visit> visits= visitMapper.selectByExample(visitCriteria);
        if(visits!=null && visits.size()>0){
            for(Visit visit:visits){
                Visit tmp=new Visit();
                tmp.setId(visit.getId());
                tmp.setVisitStatus(0);
                tmp.setInvitationStatus(0);
                tmp.setInvitationId("");
                tmp.setClinicId("");
                visitMapper.updateByPrimaryKeySelective(tmp);//回退之前的 排班
                visit.setId(UuidUtil.getUUID());
                visit.setIsDelete(1);
                visitMapper.insertSelective(visit); //记录排班日志
            }
        }
    }

    private  static String doPost(String url, String param) {
        log.info(url);
        log.info(param);
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

}
