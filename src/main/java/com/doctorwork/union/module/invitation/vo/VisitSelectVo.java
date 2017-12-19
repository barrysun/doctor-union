package com.doctorwork.union.module.invitation.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by apple on 2017/10/18.
 */
@Getter
@Setter
public class VisitSelectVo implements Serializable {

    private String id;
    private Integer selected; //1 选中 0未选中
}
