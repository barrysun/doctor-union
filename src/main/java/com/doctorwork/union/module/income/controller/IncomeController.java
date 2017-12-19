package com.doctorwork.union.module.income.controller;

import com.doctorwork.common.controller.BaseController;
import com.doctorwork.common.result.HttpResult;
import com.doctorwork.union.module.income.service.IncomeService;
import com.doctorwork.union.module.income.vo.IncomeParamVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/income")
public class IncomeController extends BaseController{

	@Autowired
	private IncomeService incomeService;
	/**
	 * 查询收入列表
	 * @param incomeParamVo
	 * @return
	 */
	@PostMapping("/list")
	public @ResponseBody HttpResult list(@RequestBody IncomeParamVo incomeParamVo) throws Exception{

		incomeParamVo.setPassportId(incomeParamVo.getPassportId());
		return success(incomeService.selectIncomeList(incomeParamVo));
	}

}
