package com.doctorwork.union.module.shopkeeper.service;

import com.doctorwork.union.module.doctor.bean.Doctor;
import com.doctorwork.union.module.invitation.vo.ClinicVo;

import java.util.Map;
import java.util.Set;

/**
 * Created by apple on 2017/10/20.
 */
public interface ShopkeeperService {


    //获取诊所名称
    Map<String,ClinicVo> getClinicNames(Set<String> keys);

    void synDoctorClinic(Doctor doctor) throws Exception;
}
