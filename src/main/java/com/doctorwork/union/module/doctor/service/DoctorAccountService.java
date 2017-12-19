package com.doctorwork.union.module.doctor.service;

import com.doctorwork.union.module.doctor.vo.DoctorAccountVo;


/**
 * Created by barry on 2017/10/16.
 */
public interface DoctorAccountService {

    int addAccount(DoctorAccountVo doctorAccountVo) throws Exception;
    int updateAccount(DoctorAccountVo doctorAccountVo) throws Exception;
    DoctorAccountVo queryAccount(DoctorAccountVo doctorAccountVo) throws Exception;
}
