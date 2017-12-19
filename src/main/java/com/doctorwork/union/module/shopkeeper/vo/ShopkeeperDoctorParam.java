package com.doctorwork.union.module.shopkeeper.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by barry on 2017/11/2.
 */
@Getter
@Setter
public class ShopkeeperDoctorParam<T> implements Serializable{

    private String thirdSignature;
    private Long time;
    private T data;
    private String source;
}
