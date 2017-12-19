package com.doctorwork.union.module.shopkeeper.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by apple on 2017/11/2.
 */
@Getter
@Setter
public class ShopkeeperDoctorVo implements Serializable {

    private String account;
    private String name;
    private String phone;
    private String cellphone;
    private Integer passportId;

}
