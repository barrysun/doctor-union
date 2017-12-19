package com.doctorwork.union.module.visit.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by apple on 2017/10/20.
 */
@Getter
@Setter
public class DayVo implements Serializable{

    private Long day;
    private TimeVo am;
    private TimeVo pm;

}
