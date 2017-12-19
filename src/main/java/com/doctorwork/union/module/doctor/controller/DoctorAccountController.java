package com.doctorwork.union.module.doctor.controller;

import com.doctorwork.common.controller.BaseController;
import com.doctorwork.common.result.HttpResult;
import com.doctorwork.union.common.utils.AssertUtil;
import com.doctorwork.union.module.doctor.service.DoctorAccountService;
import com.doctorwork.union.module.doctor.vo.DoctorAccountVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by barry on 2017/10/16.
 */

@Slf4j
@RestController
@RequestMapping("/doctorAccount")
public class DoctorAccountController extends BaseController{

    @Autowired
    private DoctorAccountService doctorAccountService;

    @PostMapping(value ="/addAccount")
    public @ResponseBody HttpResult addAccount(@RequestBody DoctorAccountVo doctorAccountVo) throws Exception{
        AssertUtil.notNull(doctorAccountVo.getCardBank(),"开户银行不能为空");
        AssertUtil.notNull(doctorAccountVo.getCardNumber(),"银行卡号不能为空");
        AssertUtil.notNull(doctorAccountVo.getCardUserName(),"户主姓名不能为空");
        AssertUtil.notNull(doctorAccountVo.getIdCard(),"身份证号不能为空");
        AssertUtil.notNull(doctorAccountVo.getPassportId(),"passportId不能为空");
        return success(doctorAccountService.addAccount(doctorAccountVo));
    }

    @PostMapping(value ="/updateAccount")
    public @ResponseBody HttpResult updateAccount(@RequestBody DoctorAccountVo doctorAccountVo) throws Exception{
        AssertUtil.notNull(doctorAccountVo.getId(),"id不能为空");
        return success(doctorAccountService.updateAccount(doctorAccountVo));
    }

    @PostMapping(value ="/queryAccount")
    public @ResponseBody HttpResult queryAccount(@RequestBody DoctorAccountVo doctorAccountVo) throws Exception{
        AssertUtil.notNull(doctorAccountVo.getPassportId(),"id不能为空");
        return success(doctorAccountService.queryAccount(doctorAccountVo));
    }

}
