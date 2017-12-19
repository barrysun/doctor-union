package com.doctorwork.union.module.doctor.service.impl;

import com.doctorwork.common.result.PageResult;
import com.doctorwork.common.util.Md5Util;
import com.doctorwork.union.common.utils.Role;
import com.doctorwork.union.common.uuid.UuidUtil;
import com.doctorwork.union.module.doctor.bean.Doctor;
import com.doctorwork.union.module.doctor.bean.DoctorCriteria;
import com.doctorwork.union.module.doctor.dao.DoctorExtMapper;
import com.doctorwork.union.module.doctor.dao.DoctorMapper;
import com.doctorwork.union.module.doctor.service.DoctorService;
import com.doctorwork.union.module.doctor.vo.DoctorClinicVo;
import com.doctorwork.union.module.doctor.vo.DoctorPwdVo;
import com.doctorwork.union.module.doctor.vo.DoctorRetVo;
import com.doctorwork.union.module.doctor.vo.DoctorVo;
import com.doctorwork.union.module.passport.service.PassportService;
import com.doctorwork.union.module.passport.vo.PassportResultVo;
import com.doctorwork.union.module.passport.vo.UserParam;
import com.doctorwork.union.module.shopkeeper.service.ShopkeeperService;
import com.doctorwork.union.module.visit.bean.Visit;
import com.doctorwork.union.module.visit.bean.VisitCriteria;
import com.doctorwork.union.module.visit.dao.VisitMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
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
public class DoctorServiceImpl implements DoctorService {

    @Resource
    private DoctorMapper doctorMapper;

    @Autowired
    private PassportService passportService;

    @Resource
    private DoctorExtMapper doctorExtMapper;

    @Resource
    private VisitMapper visitMapper;

    @Autowired
    private ShopkeeperService shopkeeperService;

    private static final String DEFAULT_PWD="123456";

    @Override
    public Doctor selectByPrimaryKey(String id) throws Exception {
        return doctorMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Doctor> selectDoctorByPassId(String passportId) throws Exception {

        DoctorCriteria doctorCriteria=new DoctorCriteria();
        DoctorCriteria.Criteria criteria=doctorCriteria.createCriteria();
        criteria.andPassportIdEqualTo(passportId);
        return doctorMapper.selectByExample(doctorCriteria);
    }

    @Override
    @Transactional
    public int insertSelective(Doctor record) throws Exception {

        DoctorCriteria doctorCriteria=new DoctorCriteria();
        DoctorCriteria.Criteria criteria=doctorCriteria.createCriteria();
        criteria.andPhoneEqualTo(record.getPhone());
        List<Doctor> doctors=doctorMapper.selectByExample(doctorCriteria);
        if(doctors.size()>0){
            throw new RuntimeException("该手机好已经被注册");
        }
        UserParam userParam=new UserParam();
        userParam.setCellphone(record.getPhone());
        userParam.setPwd(Md5Util.encoderByMd5(DEFAULT_PWD));//
        userParam.setRole(Role.DOCTOR.getRoleId());
        Integer passportId=passportService.passportSyn(userParam);
        if(passportId==null ){
            throw  new RuntimeException("调用passport服务异常");
        }
        record.setPassportId(passportId+"");
        record.setId(UuidUtil.getUUID());
        record.setAccountStatus(1);//启用
        record.setCreateTime(System.currentTimeMillis());
        record.setModifyTime(System.currentTimeMillis());
        record.setIsDelete(0);
        record.setInvitationCount(0);
        shopkeeperService.synDoctorClinic(record);
        return doctorMapper.insertSelective(record);
    }



    @Override
    public PageResult<DoctorRetVo> selectByExample(DoctorVo req) throws Exception {
        req.setPhone(req.getSearch());
        Page<?> page= PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<DoctorRetVo> doctors=doctorExtMapper.list(req);
        PageResult<DoctorRetVo> ret=new PageResult<>(page.getTotal(),page.getPages(),page.getPageNum(),page.getPageSize(),doctors);
        return ret;
    }

    @Override
    public PageResult<DoctorRetVo> clinicSelect(DoctorVo req) throws Exception {
        req.setPhone(req.getSearch());
        Page<?> page= PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<DoctorRetVo> doctors=doctorExtMapper.clinicSelect(req);
        PageResult<DoctorRetVo> ret=new PageResult<>(page.getTotal(),page.getPages(),page.getPageNum(),page.getPageSize(),doctors);
        return ret;
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(DoctorPwdVo record) throws Exception {

        if(StringUtils.isNotBlank(record.getPwd())){
            //调用Passport重置密码
            Doctor doctor=doctorMapper.selectByPrimaryKey(record.getId());
            UserParam userParam=new UserParam();
            userParam.setPwd(Md5Util.encoderByMd5(record.getPwd()));
            userParam.setUserid(Integer.parseInt(doctor.getPassportId()));
            passportService.passportUpdatePwd(userParam);
        }
        record.setCreateTime(System.currentTimeMillis());
        record.setModifyTime(System.currentTimeMillis());
        return doctorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public PassportResultVo reSetPassword(Doctor record) throws Exception {
        //调用Passport重置密码
        Doctor doctor=doctorMapper.selectByPrimaryKey(record.getId());
        UserParam userParam=new UserParam();
        userParam.setPwd(Md5Util.encoderByMd5(DEFAULT_PWD));
        userParam.setUserid(Integer.parseInt(doctor.getPassportId()));
       return  passportService.login(userParam);
    }

    @Override
    public List<Doctor> selectAllDoctors() throws Exception {
        DoctorCriteria doctorCriteria=new DoctorCriteria();
        doctorCriteria.createCriteria().andIsDeleteEqualTo(0);
        return doctorMapper.selectByExample(doctorCriteria);
    }

    @Override
    public DoctorClinicVo queryInClinic(Doctor doctor) throws Exception{
        DoctorCriteria doctorCriteria=new DoctorCriteria();
        //启用状态
        doctorCriteria.createCriteria().andIsDeleteEqualTo(0).andPhoneEqualTo(doctor.getPhone()).andAccountStatusEqualTo(1);
        List<Doctor> list = doctorMapper.selectByExample(doctorCriteria);
        DoctorClinicVo doctorClinicVo=new DoctorClinicVo();
        doctorClinicVo.setIsHas(1);
        doctorClinicVo.setClinicId("");
        if (list==null||list.isEmpty()) {
            //throw new ServiceException("该医生不存在医生集团中");
            doctorClinicVo.setIsHas(0);
            return doctorClinicVo;
        }
        Doctor doctorRes = list.get(0);
        VisitCriteria visitCriteria = new VisitCriteria();
        long nowTime = System.currentTimeMillis();
        visitCriteria.createCriteria().andIsDeleteEqualTo(0).andDoctorIdEqualTo(doctorRes.getId())
                .andStartTimeLessThanOrEqualTo(nowTime).andEndTimeGreaterThanOrEqualTo(nowTime);
        List<Visit> visitList = visitMapper.selectByExample(visitCriteria);

        if (visitList==null||visitList.isEmpty()) {
            //throw new ServiceException("该医生当前时间没有排班");
            return doctorClinicVo;
        }
        Visit visit = visitList.get(0);
        doctorClinicVo.setClinicId(visit.getClinicId());
        return doctorClinicVo;
    }

    @Override
    public Doctor queryByPassportId(String passportId) throws Exception {
        DoctorCriteria doctorCriteria=new DoctorCriteria();
        doctorCriteria.createCriteria().andIsDeleteEqualTo(0).andPassportIdEqualTo(passportId);
        List<Doctor> list = doctorMapper.selectByExample(doctorCriteria);
        if(list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

}
