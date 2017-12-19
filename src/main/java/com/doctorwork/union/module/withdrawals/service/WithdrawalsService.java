package com.doctorwork.union.module.withdrawals.service;

import com.doctorwork.common.result.PageResult;
import com.doctorwork.union.module.withdrawals.bean.Withdrawals;
import com.doctorwork.union.module.withdrawals.bean.WithdrawalsRes;
import com.doctorwork.union.module.withdrawals.vo.WithdrawalsVo;

import java.util.List;

/**
 * Created by zhengxingle on 2017/10/17.
 */
public interface WithdrawalsService {
    PageResult<Withdrawals> selectWithdrawalsList(WithdrawalsVo withdrawalsVo) throws Exception;


    List<Withdrawals> selectWithdrawals(String doctorId, String checkBatch) throws Exception;

    int insertWithdrawals(Withdrawals withdrawals,String account) throws Exception;

    int updateStatus(WithdrawalsVo withdrawalsVo) throws Exception;

    int deleteByCheckBatch(String checkBatch) throws Exception;

    PageResult<WithdrawalsRes> adminSelectWithdrawalsList(WithdrawalsVo withdrawalsVo) throws Exception;
}
