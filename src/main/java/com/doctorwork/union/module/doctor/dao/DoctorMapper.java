package com.doctorwork.union.module.doctor.dao;

import com.doctorwork.union.module.doctor.bean.Doctor;
import com.doctorwork.union.module.doctor.bean.DoctorCriteria;
import java.util.List;

public interface DoctorMapper {
    int countByExample(DoctorCriteria example);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    List<Doctor> selectByExample(DoctorCriteria example);

    Doctor selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);
}