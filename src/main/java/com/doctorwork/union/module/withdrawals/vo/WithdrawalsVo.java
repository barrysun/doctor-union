package com.doctorwork.union.module.withdrawals.vo;

import com.doctorwork.union.common.rest.PageParamVo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by apple on 2017/10/16.
 */
@Getter
@Setter
public class WithdrawalsVo extends PageParamVo implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String id;
  	private String passportId;
    private Integer status;
    private String doctorName;
    private Integer isHistory;
    private Long startTime;
    private Long endTime;
    private String operUser;
    private String serialNumber;
    private String checkBatch;
}
