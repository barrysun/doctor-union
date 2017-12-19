package com.doctorwork.union.module.withdrawals.dao;

import com.doctorwork.union.module.withdrawals.bean.WithdrawalsRes;
import com.doctorwork.union.module.withdrawals.vo.WithdrawalsVo;

import java.util.List;

/**
 * Created by zhengxingle on 2017/10/17.
 */
public interface WithdrawalsExpMapper {

    List<WithdrawalsRes> selectWithdrawals(WithdrawalsVo withdrawalsVo);

    int deleteByCheckBatch(String checkBatch);
}
