package com.doctorwork.union.common.rest;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Created by barry on 2017/10/16.
 */
@Getter
@Setter
public class PageParamVo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Min(value=0,message="开始页数不能小于0")
    private Integer pageNum;

    @Min(value=1,message="每页数据不能小于1")
    @Max(value=50,message="每页数据不能大于50条")
    private Integer pageSize;

    


}
