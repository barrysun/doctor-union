package com.doctorwork.union.module.passport.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by apple on 2017/10/19.
 */
@Setter
@Getter
public class TokenVo implements Serializable{

    private String domain;
    private String token;
}
