package com.doctorwork.union.module.doctor.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by barry on 2017/11/2.
 */

@Setter
@Getter
public class DoctorClinicVo implements Serializable {
    private String clinicId; //clinicId
    private Integer isHas; // 是否存在

}
