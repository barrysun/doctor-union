package com.doctorwork.union.module.withdrawals.service;

/**
 * Created by zhengxingle on 2017/10/17.
 */
public interface AutoWithdrawalsService {

    int doWithdrawals() throws Exception;
    void autoWithdrawals();
}
