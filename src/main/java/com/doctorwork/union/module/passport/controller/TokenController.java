package com.doctorwork.union.module.passport.controller;

import com.doctorwork.common.result.HttpResult;
import com.doctorwork.union.common.rest.Response;
import com.doctorwork.union.module.passport.service.PassportService;
import com.doctorwork.union.module.weixin.service.WeiXinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by barry on 2017/10/19.
 */
@RestController
@Slf4j
@RequestMapping("/")
public class TokenController {

    @Autowired
    private PassportService passportService;
    @Autowired
    private WeiXinService weiXinService;

    @GetMapping("/token")
    public @ResponseBody  HttpResult token() throws Exception{
        return new HttpResult(Response.SUCCESS,"",passportService.token());
    }
}
