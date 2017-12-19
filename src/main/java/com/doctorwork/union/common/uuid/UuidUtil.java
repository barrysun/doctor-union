package com.doctorwork.union.common.uuid;

import java.util.UUID;

/**
 * Created by apple on 2017/10/16.
 */
public class UuidUtil {

    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
