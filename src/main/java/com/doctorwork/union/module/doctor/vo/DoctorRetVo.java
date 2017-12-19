package com.doctorwork.union.module.doctor.vo;

import com.doctorwork.union.module.doctor.bean.Doctor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by barry on 2017/10/23.
 */
@Getter
@Setter
public class DoctorRetVo extends Doctor implements Serializable {

    private String agentName;
}
