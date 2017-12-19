package com.doctorwork.union.module.withdrawals.dao;

import com.doctorwork.union.module.withdrawals.bean.Withdrawals;
import com.doctorwork.union.module.withdrawals.bean.WithdrawalsCriteria;
import java.util.List;

public interface WithdrawalsMapper {
    int countByExample(WithdrawalsCriteria example);

    int insert(Withdrawals record);

    int insertSelective(Withdrawals record);

    List<Withdrawals> selectByExample(WithdrawalsCriteria example);

    Withdrawals selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Withdrawals record);

    int updateByPrimaryKey(Withdrawals record);
}