package com.doctorwork.union.module.doctor.dao;

import com.doctorwork.union.module.doctor.vo.DoctorRetVo;
import com.doctorwork.union.module.doctor.vo.DoctorVo;

import java.util.List;

/**
 * Created by apple on 2017/10/23.
 */
public interface DoctorExtMapper {

   List<DoctorRetVo> list(DoctorVo doctorVo);

   List<DoctorRetVo> clinicSelect(DoctorVo doctorVo);


}
