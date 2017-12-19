package com.doctorwork.union.common.rest;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by apple on 2017/10/16.
 */
@Slf4j
@Getter
@Setter
public class Response implements Serializable{

    public static final Integer ERROR = -1;
    public  static final Integer SUCCESS = 0;


    public Response(){}

    public Response(Object data){
        this.code=0;
        this.msg="";
        this.data=data;
    }

    public Response(int code,String msg,Object data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    private int code;
    private String msg;
    private Object data;

}
