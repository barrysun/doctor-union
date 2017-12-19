package com.doctorwork.union.module.wallet.service;

import com.doctorwork.union.module.wallet.vo.*;


import java.util.List;

/**
 * Created by apple on 2017/10/20.
 */
public interface WalletService {

    WithdrawResVo withdrawApply(WalletParamVo walletParamVo) throws Exception;

    void withdrawSuccess(WalletParamVo walletParamVo) throws Exception;

    void withdrawFail(WalletParamVo walletParamVo) throws Exception;

    List<WalletResVo> walletAmountList(String[] userId) throws Exception;

    void rechargeApply(ApplyParam applyParam) throws Exception;
    void transfer(TransferParam transferParam) throws Exception;

}
