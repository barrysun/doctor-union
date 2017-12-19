package com.doctorwork.union.module.invitation.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by apple on 2017/10/23.
 */
@Getter
@Setter
public class ClinicRetVo<T> implements Serializable {

   private String  status;
   private String desc;
   private T data;
}
