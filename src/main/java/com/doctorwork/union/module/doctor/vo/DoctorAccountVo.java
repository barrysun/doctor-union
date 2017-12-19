package com.doctorwork.union.module.doctor.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * Created by apple on 2017/10/16.
 */
@Getter
@Setter
public class DoctorAccountVo implements Serializable {

    private String Id;
    private String cardUserName;
    private String idCard;
    private String cardNumber;
    private String cardBank;
    private String passportId;
    private Long balance;
}
