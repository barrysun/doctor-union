package com.doctorwork.union.common.utils;

import java.lang.annotation.*;

/**
 * 用作签名的参数
 * @author cwy
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SignField {
    //用作指定特别的签名key
    String signName() default "";
}
