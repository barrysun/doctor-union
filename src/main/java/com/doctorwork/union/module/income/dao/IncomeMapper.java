package com.doctorwork.union.module.income.dao;

import com.doctorwork.union.module.income.bean.Income;
import com.doctorwork.union.module.income.bean.IncomeCriteria;
import java.util.List;

public interface IncomeMapper {
    int countByExample(IncomeCriteria example);

    int insert(Income record);

    int insertSelective(Income record);

    List<Income> selectByExample(IncomeCriteria example);

    Income selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Income record);

    int updateByPrimaryKey(Income record);
}