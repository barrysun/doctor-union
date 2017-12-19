package com.doctorwork.union.module.passport.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by barry on 2017/10/18.
 */
@Getter
@Setter

public class PassportResultVo<T> implements Serializable{

    private Integer errcode;
    private String errmsg;
    private T data;

}
