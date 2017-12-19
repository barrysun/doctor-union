package com.doctorwork.union.module.withdrawals.controller;

import com.doctorwork.common.controller.BaseController;
import com.doctorwork.common.result.HttpResult;
import com.doctorwork.union.common.annotation.Auth;
import com.doctorwork.union.common.utils.AssertUtil;
import com.doctorwork.union.module.withdrawals.service.AutoWithdrawalsService;
import com.doctorwork.union.module.withdrawals.service.WithdrawalsService;
import com.doctorwork.union.module.withdrawals.vo.WithdrawalsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by barry on 2017/10/16.
 */

@Slf4j
@RestController
@RequestMapping("/withdrawals")
public class WithdrawalsController extends BaseController{

    @Autowired
    private WithdrawalsService withdrawalsService;

    @Autowired
    private AutoWithdrawalsService autoWithdrawalsService;


    @PostMapping(value ="/list")
    public @ResponseBody HttpResult page(@RequestBody WithdrawalsVo withdrawalsVo) throws Exception{
        withdrawalsVo.setPassportId(withdrawalsVo.getPassportId());
        return success(withdrawalsService.selectWithdrawalsList(withdrawalsVo));
    }

    @PostMapping(value ="/updateStatus")
    @Auth
    public @ResponseBody HttpResult updateStatus(@RequestBody WithdrawalsVo withdrawalsVo) throws Exception{

        AssertUtil.notNull(withdrawalsVo.getId(),"id不能为空");
        AssertUtil.notNull(withdrawalsVo.getStatus(),"status不能为空");
        return success(withdrawalsService.updateStatus(withdrawalsVo));
    }

    @PostMapping(value ="/adminSelectWithdrawalsList")
    @Auth
    public @ResponseBody HttpResult adminSelectWithdrawalsList(@RequestBody WithdrawalsVo withdrawalsVo) throws Exception{

        return success(withdrawalsService.adminSelectWithdrawalsList(withdrawalsVo));
    }

    @PostMapping(value ="/autoWithdrawals")
    @Auth
    public @ResponseBody HttpResult autoWithdrawals() throws Exception{

        return success(autoWithdrawalsService.doWithdrawals());
    }

}
