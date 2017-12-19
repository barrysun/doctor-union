package com.doctorwork.union.module.weixin.service;

import com.doctorwork.common.result.HttpResult;
import com.doctorwork.union.module.weixin.vo.OrderContentVo;
import com.doctorwork.union.module.weixin.vo.WeiXinRequest;

import java.util.List;

/**
 * Created by barry on 2017/10/20.
 */
public interface WeiXinService {

    String sendRemind(String openId,String url,OrderContentVo orderContentVo) throws Exception;

    String sendDown(String opendId,String url,OrderContentVo orderContentVo) throws Exception;

    HttpResult invitationList(WeiXinRequest weiXinRequest);

    void updateStatus(WeiXinRequest weiXinRequest) throws Exception;
}
