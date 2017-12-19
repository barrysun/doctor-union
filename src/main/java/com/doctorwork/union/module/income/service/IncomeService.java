package com.doctorwork.union.module.income.service;

import com.doctorwork.common.result.PageResult;
import com.doctorwork.union.module.income.bean.Income;
import com.doctorwork.union.module.income.bean.IncomeRes;
import com.doctorwork.union.module.income.vo.IncomeParamVo;

public interface IncomeService {

    Income selectByPrimaryKey(String id) throws Exception;

    void add(Income income) throws Exception;

    PageResult<IncomeRes> selectIncomeList(IncomeParamVo incomeParamVo) throws Exception;
}
