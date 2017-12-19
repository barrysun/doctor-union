package com.doctorwork.union.module.doctor.vo;

import com.doctorwork.union.module.doctor.bean.Doctor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by barry on 2017/10/19.
 */
@Getter
@Setter
public class DoctorPwdVo extends Doctor implements Serializable {

    private String pwd;
}
