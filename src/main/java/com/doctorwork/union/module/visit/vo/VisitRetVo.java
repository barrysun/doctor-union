package com.doctorwork.union.module.visit.vo;

import com.doctorwork.union.module.visit.bean.Visit;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2017/10/20.
 */
@Getter
@Setter
public class VisitRetVo implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long startTime;
    private Long endTime;
    @NotEmpty(message="医生Id不能为空")
    private String doctorId;
    private Integer timeInterval;
    private List<DayVo> list;//设置时间段
}
