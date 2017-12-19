package com.doctorwork.union.module.doctor.service;

import com.doctorwork.common.result.PageResult;
import com.doctorwork.union.module.doctor.bean.Doctor;
import com.doctorwork.union.module.doctor.vo.DoctorClinicVo;
import com.doctorwork.union.module.doctor.vo.DoctorPwdVo;
import com.doctorwork.union.module.doctor.vo.DoctorRetVo;
import com.doctorwork.union.module.doctor.vo.DoctorVo;
import com.doctorwork.union.module.passport.vo.PassportResultVo;

import java.util.List;


/**
 * Created by barry on 2017/10/16.
 */
public interface DoctorService {

    Doctor selectByPrimaryKey(String id)throws Exception;

    List<Doctor> selectDoctorByPassId(String passportId) throws Exception;

    int insertSelective(Doctor record) throws Exception;

    PageResult<DoctorRetVo>  selectByExample(DoctorVo req) throws Exception;

    PageResult<DoctorRetVo>  clinicSelect(DoctorVo req) throws  Exception;

    int updateByPrimaryKey(DoctorPwdVo record) throws Exception;

    PassportResultVo reSetPassword(Doctor record) throws Exception;

    List<Doctor> selectAllDoctors()throws Exception;

    DoctorClinicVo queryInClinic(Doctor record)  throws Exception;

    Doctor queryByPassportId(String passportId) throws Exception;

}
