package com.doctorwork.union.module.visit.vo;

import com.doctorwork.union.common.rest.PageParamVo;
import com.doctorwork.union.module.visit.bean.Visit;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2017/10/16.
 */
@Getter
@Setter
public class VisitVo extends PageParamVo implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long startTime;
    private Long endTime;
   // @NotEmpty(message="医生Id不能为空")
    private String doctorId;
    private String passportId;
    private Integer timeInterval;
    private List<VisitVo> list;//设置时间段

}
