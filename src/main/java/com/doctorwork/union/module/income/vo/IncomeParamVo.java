package com.doctorwork.union.module.income.vo;

import com.doctorwork.union.common.rest.PageParamVo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class IncomeParamVo extends PageParamVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String clinicId;
	private String passportId;
}
