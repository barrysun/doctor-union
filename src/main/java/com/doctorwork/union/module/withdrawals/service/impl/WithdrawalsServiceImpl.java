package com.doctorwork.union.module.withdrawals.service.impl;

import com.doctorwork.common.exception.ServiceException;
import com.doctorwork.common.result.PageResult;
import com.doctorwork.union.common.uuid.UuidUtil;
import com.doctorwork.union.module.wallet.service.WalletService;
import com.doctorwork.union.module.wallet.vo.WalletParamVo;
import com.doctorwork.union.module.wallet.vo.WalletResVo;
import com.doctorwork.union.module.wallet.vo.WithdrawResVo;
import com.doctorwork.union.module.withdrawals.bean.Withdrawals;
import com.doctorwork.union.module.withdrawals.bean.WithdrawalsCriteria;
import com.doctorwork.union.module.withdrawals.bean.WithdrawalsRes;
import com.doctorwork.union.module.withdrawals.dao.WithdrawalsExpMapper;
import com.doctorwork.union.module.withdrawals.dao.WithdrawalsMapper;
import com.doctorwork.union.module.withdrawals.service.WithdrawalsService;
import com.doctorwork.union.module.withdrawals.vo.WithdrawalsVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by zhengxingle on 2017/10/17.
 */
@Service
@Slf4j
public class WithdrawalsServiceImpl implements WithdrawalsService{

    @Resource
    private WithdrawalsMapper withdrawalsMapper;

    @Resource
    private WithdrawalsExpMapper withdrawalsExpMapper;

    @Autowired
    private WalletService walletService;


    @Override
    public PageResult<Withdrawals> selectWithdrawalsList(WithdrawalsVo withdrawalsVo) throws Exception {

        WithdrawalsCriteria withdrawalsCriteria = new WithdrawalsCriteria();
        withdrawalsCriteria.createCriteria().andIsDeleteEqualTo(0).andPassportIdEqualTo(withdrawalsVo.getPassportId());
        withdrawalsCriteria.setOrderByClause("modify_time desc");
        Page page= PageHelper.startPage(withdrawalsVo.getPageNum(),withdrawalsVo.getPageSize());
        List<Withdrawals> list = withdrawalsMapper.selectByExample(withdrawalsCriteria);
        PageResult pageResult = new PageResult<>(page.getTotal(),page.getPages(),page.getPageNum(),page.getPageSize(),list);
        return pageResult;
    }

    @Override
    public List<Withdrawals> selectWithdrawals(String doctorId, String checkBatch) throws Exception {
        WithdrawalsCriteria withdrawalsCriteria = new WithdrawalsCriteria();
        withdrawalsCriteria.createCriteria().andIsDeleteEqualTo(0).andDoctorIdEqualTo(doctorId).andCheckBatchEqualTo(checkBatch);
        return withdrawalsMapper.selectByExample(withdrawalsCriteria);
    }

    @Override
    @Transactional
    public int insertWithdrawals(Withdrawals withdrawals,String account) throws Exception {
        String keyID = UuidUtil.getUUID();
        withdrawals.setId(keyID);
        long time = new Date().getTime();
        withdrawals.setCreateTime(time);
        withdrawals.setModifyTime(time);
        withdrawals.setWithdrawalsDate(time);
        //获取余额
        List<WalletResVo> list = walletService.walletAmountList(new String[]{withdrawals.getPassportId()});
        if (list!=null&&!list.isEmpty()) {
            WalletResVo walletResVo = list.get(0);
            if (walletResVo.getAmount()<=0) {
                return 0;
            }
            WalletParamVo walletParamVo = new WalletParamVo();
            walletParamVo.setAccountNo(account);
            walletParamVo.setAmount(walletResVo.getAmount());
            walletParamVo.setOutTradeNo(keyID);
            walletParamVo.setUserId(Integer.valueOf(withdrawals.getPassportId()));
            WithdrawResVo withdrawResVo = walletService.withdrawApply(walletParamVo);
            BigDecimal balance = new BigDecimal(walletResVo.getAmount()).divide(new BigDecimal(100));
            withdrawals.setWithdrawalsMoney(balance); //提现金额
            withdrawals.setServiceMoney(new BigDecimal(0));  //手续费
            withdrawals.setPersonalIncomeTaxMoney(new BigDecimal(0));  //个税
            withdrawals.setArrivalMoney(balance);  //实际到账金额
            withdrawals.setBalance(new BigDecimal(0));  //余额
            withdrawals.setStatus(0);  //0：提现中 1：已转账  2：提现失败
            withdrawals.setIsDelete(0);
            withdrawals.setOrderNo(withdrawResVo.getOrderNo());
            return withdrawalsMapper.insert(withdrawals);
        } else {
            log.error("钱包账号不存在或获取钱包余额失败");
            return 0;
        }

    }

    @Override
    @Transactional
    public int updateStatus(WithdrawalsVo withdrawalsVo) throws Exception {
        Withdrawals withdrawals = withdrawalsMapper.selectByPrimaryKey(withdrawalsVo.getId());
        if (withdrawals.getStatus()!=0) {
            throw new ServiceException("非待处理状态，不能修改");
        }
        WalletParamVo walletParamVo = new WalletParamVo();
        walletParamVo.setOrderNo(withdrawals.getOrderNo());
        Withdrawals withdrawalsParam =new Withdrawals();
        if (withdrawalsVo.getStatus()==1) {  //已转账，需要记录流水号和操作人
            withdrawalsParam.setModifyUserName(withdrawalsVo.getOperUser());
            withdrawalsParam.setSerialNumber(withdrawalsVo.getSerialNumber());
            walletService.withdrawSuccess(walletParamVo);
        } else if (withdrawalsVo.getStatus()==2) {
            walletParamVo.setReason("银行卡号有误");
            walletService.withdrawFail(walletParamVo);
        }
        withdrawalsParam.setId(withdrawalsVo.getId());
        withdrawalsParam.setStatus(withdrawalsVo.getStatus());
        return withdrawalsMapper.updateByPrimaryKeySelective(withdrawalsParam);
    }


    @Override
    public int deleteByCheckBatch(String checkBatch) throws Exception {
        return withdrawalsExpMapper.deleteByCheckBatch(checkBatch);
    }

    @Override
    public PageResult<WithdrawalsRes> adminSelectWithdrawalsList(WithdrawalsVo withdrawalsVo) throws Exception {
        if (withdrawalsVo.getIsHistory()==1) {  //1：上个月提现记录  2：历史记录
            SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
            String checkBatch = format.format(new Date());
            withdrawalsVo.setCheckBatch(checkBatch);
        }
        Page page= PageHelper.startPage(withdrawalsVo.getPageNum(),withdrawalsVo.getPageSize());
        List<WithdrawalsRes> list = withdrawalsExpMapper.selectWithdrawals(withdrawalsVo);
        PageResult pageResult = new PageResult<>(page.getTotal(),page.getPages(),page.getPageNum(),page.getPageSize(),list);
        return pageResult;
    }

    private static long getLastMonthTime(int flag){
        try {
            Date date  = null;
            Calendar calendar = Calendar.getInstance();
            if (flag==1) {
                SimpleDateFormat firstFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
                //获取前一个月第一天
                calendar.add(Calendar.MONTH, -1);
                calendar.set(Calendar.DAY_OF_MONTH,1);
                String firstDay = firstFormat.format(calendar.getTime());
                date = firstFormat.parse(firstDay);
            } else if (flag==2) {
                SimpleDateFormat lastFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
                //获取前一个月最后一天
                calendar.set(Calendar.DAY_OF_MONTH, 0);
                String lastDay = lastFormat.format(calendar.getTime());
                date = lastFormat.parse(lastDay);
            }
            return date.getTime();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args){
        BigDecimal balance = new BigDecimal(1L).divide(new BigDecimal(100));
        System.out.println(balance);
    }

}
