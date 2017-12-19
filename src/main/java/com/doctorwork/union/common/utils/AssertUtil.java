package com.doctorwork.union.common.utils;

import com.doctorwork.common.exception.ServiceException;

/**
 * Created by zhengxingle on 2017/9/21.
 */
public class AssertUtil {

    public static void notNull (Object obj,String errMsg) throws ServiceException {
        if (null == obj) {
            throw new ServiceException(errMsg);
        }
    }
}
