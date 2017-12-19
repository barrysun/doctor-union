package com.doctorwork.union.module.wallet.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.doctorwork.common.exception.ServiceException;
import com.doctorwork.union.common.config.PassportProperties;
import com.doctorwork.union.common.config.WalletProperties;
import com.doctorwork.union.common.utils.PssportUtil;
import com.doctorwork.union.module.invitation.vo.PayMentCallVo;
import com.doctorwork.union.module.passport.vo.PassportResultVo;
import com.doctorwork.union.module.wallet.service.WalletService;
import com.doctorwork.union.module.wallet.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by barry on 2017/10/20.
 */
@Service
@Slf4j
public class WalletServiceImpl implements WalletService {

    private static final String  WALLET_AMOUNT_URL = "/user/get_batch_wallet_amount_list";
    private static final String  WALLET_WITHDRAW_APPLY_URL = "/user/withdraw_apply";
    private static final String  WALLET_WITHDRAW_SUCCESS_URL = "/user/withdraw_success";
    private static final String  WALLET_WITHDRAW_FAIL_URL = "/user/withdraw_fail";
    private static final String  RECHARGE_APPLY_URL="/user/recharge_apply";
    private static final String  USER_TRANSFER_URL="/user/transfer";

    @Autowired
    private WalletProperties walletProperties;

    @Autowired
    private PassportProperties passportProperties;

    @Override
    public WithdrawResVo withdrawApply(WalletParamVo walletParamVo) throws Exception {
        Map<String,Object> param = new HashMap<>();
        param.put("appid",passportProperties.getAppid());
        param.put("userid",walletParamVo.getUserId());
        param.put("platform",passportProperties.getPlatform());
        param.put("amount",walletParamVo.getAmount());
        param.put("pay_type","BANK_PAY");  //(1.微信 2.支付宝 3.银行卡)
        param.put("account_no",walletParamVo.getAccountNo());
        param.put("tag","提现申请");
        param.put("body","医生营销平台后台自动提现");
        param.put("out_trade_no",walletParamVo.getOutTradeNo());
        param.put("remark","每月自动生成提现记录");
        String content= PssportUtil.post(walletProperties.getWalletScret(),walletProperties.getWalletUrl()+WALLET_WITHDRAW_APPLY_URL,param);
        if (StringUtils.isNoneBlank(content)) {
            PassportResultVo<WithdrawResVo> ret = JSON.parseObject(content, new TypeReference<PassportResultVo<WithdrawResVo>>(){});
            if (ret.getErrcode()==0) {
                log.info("WalletResVo:{}",ret.getData());
                return ret.getData();
            }else{
                throw new ServiceException(ret.getErrmsg());
            }
        }
        throw  new ServiceException("调用passport失败");
    }

    @Override
    public void withdrawSuccess(WalletParamVo walletParamVo) throws Exception {
        Map<String,Object> param = new HashMap<>();
        param.put("appid",passportProperties.getAppid());
        param.put("platform",passportProperties.getPlatform());
        param.put("order_no",walletParamVo.getOrderNo());
        String content= PssportUtil.post(walletProperties.getWalletScret(),walletProperties.getWalletUrl()+WALLET_WITHDRAW_SUCCESS_URL,param);
        if (StringUtils.isNoneBlank(content)) {
            PassportResultVo<Object> ret = JSON.parseObject(content, new TypeReference<PassportResultVo<Object>>(){});
            if (ret.getErrcode()==0) {
                log.info("object:{}",ret.getData());
            }else{
                throw new ServiceException(ret.getErrmsg());
            }
        } else {
            throw  new ServiceException("调用passport失败");
        }
    }

    @Override
    public void withdrawFail(WalletParamVo walletParamVo) throws Exception {
        Map<String,Object> param = new HashMap<>();
        param.put("appid",passportProperties.getAppid());
        param.put("platform",passportProperties.getPlatform());
        param.put("order_no",walletParamVo.getOrderNo());
        param.put("reason",walletParamVo.getReason());
        String content= PssportUtil.post(walletProperties.getWalletScret(),walletProperties.getWalletUrl()+WALLET_WITHDRAW_FAIL_URL,param);
        if (StringUtils.isNoneBlank(content)) {
            PassportResultVo<Object> ret = JSON.parseObject(content, new TypeReference<PassportResultVo<Object>>(){});
            if (ret.getErrcode()==0) {
                log.info("object:{}",ret.getData());
            }else{
                throw new ServiceException(ret.getErrmsg());
            }
        } else {
            throw  new ServiceException("调用passport失败");
        }
    }

    @Override
    public List<WalletResVo> walletAmountList(String[] userId) throws Exception {
        Map<String,Object> param = new HashMap<>();
        param.put("appid",passportProperties.getAppid());
        param.put("userids", String.join(",",Arrays.asList(userId)));
        param.put("platform",passportProperties.getPlatform());
        String content= PssportUtil.post(walletProperties.getWalletScret(),walletProperties.getWalletUrl()+WALLET_AMOUNT_URL,param);
        if (StringUtils.isNoneBlank(content)) {
            PassportResultVo<List<WalletResVo>> ret = JSON.parseObject(content, new TypeReference<PassportResultVo<List<WalletResVo>>>(){});
            if (ret.getErrcode()==0) {
                log.info("WalletResVo:{}",ret.getData());
                return ret.getData();
            }else{
                throw new ServiceException(ret.getErrmsg());
            }
        }
        throw  new ServiceException("调用passport失败");
    }



    /**
     * 充值
     * @param applyParam
     * @throws Exception
     */
    @Override
    public void rechargeApply(ApplyParam applyParam) throws Exception {

//        appid string app标识 必传
//        platform string 第三方标识(yzg, healthman, share) 必传
//        sign string 签名 必传`
//        userid int 用户id 必传`
//        amount int 金额(分) 必传`
//        pay_type 支付方式(1.微信 2.支付宝 3.银行卡) 必传
//        tag string 业务标签 必传
//        body string 业务方内容 必传
//        out_trade_no string 业务方单号 必传
//        remark string 业务方备注 必传
        Map<String,Object> param = new HashMap<>();
        param.put("appid",passportProperties.getAppid());
        param.put("userid",applyParam.getUserid());
        param.put("platform",passportProperties.getPlatform());
        param.put("amount",applyParam.getAmount());
        param.put("pay_type",PayType.WX_PAY);  //(1.微信 2.支付宝 3.银行卡)
        param.put("tag","服务购买");
        param.put("body","医生集团服务费用支付");
        param.put("out_trade_no",applyParam.getOutTradeNo());
        param.put("remark","购买医生邀请服务支付");
        String content= PssportUtil.post(walletProperties.getWalletScret(),walletProperties.getWalletUrl()+RECHARGE_APPLY_URL,param);
        if (StringUtils.isNoneBlank(content)) {
            PassportResultVo<RechargeApplyVo> ret = JSON.parseObject(content, new TypeReference<PassportResultVo<RechargeApplyVo>>(){});
            if (ret.getErrcode()==0) {
                log.info("WalletResVo:{}",ret.getData());
            }else{
                throw new ServiceException(ret.getErrmsg());
            }
        }
    }

    /**
     * 转帐
     * @param transferParam
     * @throws Exception
     */
    @Override
    public void transfer(TransferParam transferParam) throws Exception {
        Map<String,Object> param = new HashMap<>();
        param.put("appid",passportProperties.getAppid());
        param.put("userid",transferParam.getUserid());
        param.put("payuserid",transferParam.getPayuserid());
        param.put("recuserid",transferParam.getRecuserid());
        param.put("platform",passportProperties.getPlatform());
        param.put("amount",transferParam.getAmount());
        param.put("pay_type", PayType.WX_PAY);  //(1.微信 2.支付宝 3.银行卡)
        param.put("tag","购买服务分账");
        param.put("body","医生集团服务费用支付充值");
        param.put("out_trade_no",transferParam.getOutTradeNo());
        param.put("remark","购买服务分账");
        param.put("arrive_type",1);//(1.实时到账 2.非实时到账)

        String content= PssportUtil.post(walletProperties.getWalletScret(),walletProperties.getWalletUrl()+USER_TRANSFER_URL,param);
        if (StringUtils.isNoneBlank(content)) {
            PassportResultVo<RechargeApplyVo> ret = JSON.parseObject(content, new TypeReference<PassportResultVo<RechargeApplyVo>>(){});
            if (ret.getErrcode()==0) {
                log.info("WalletResVo:{}",ret.getData());
            }else{
                throw new ServiceException(ret.getErrmsg());
            }
        }

    }

}
