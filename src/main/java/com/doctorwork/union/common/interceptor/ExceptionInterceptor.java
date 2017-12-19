package com.doctorwork.union.common.interceptor;

import com.doctorwork.common.exception.ServiceException;
import com.doctorwork.common.exception.SignException;
import com.doctorwork.common.exception.UnloginException;
import com.doctorwork.common.result.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by wuke on 2017/5/17.
 */
@ControllerAdvice
public class ExceptionInterceptor {
    /**
     * 日志对象.
     */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public HttpResult RuntineExceptionHandler(Exception e, HttpServletResponse response) {
        if(e instanceof UnloginException) {
            logger.error("未登录:" + e.getMessage());
            return loginError("未登录:");
        }else if(e instanceof SignException) {
            logger.error("签名不过:" + e.getMessage());
            return error("签名不过:");
        }else if(e instanceof ServiceException) {
            logger.error("业务异常:" + e.getMessage());
            return error("业务异常:" + e.getMessage());
        } else if(e instanceof BindException){
            logger.error("请求参数不合规:" + e.getMessage());
            return error("请求参数不合规!" );
        } else if (e instanceof Exception) {
            logger.error("系统异常:",e);
            return error("系统异常:");
        }
        return null;
    }
    /**
     * 失败
     * @param message
     * @return
     */
    protected HttpResult error(String message) {
        return new HttpResult(1,message,null);
    }
    /**
     * 失败
     * @param message
     * @return
     */
    protected HttpResult loginError(String message) {
        return new HttpResult(302,message,null);
    }
}
