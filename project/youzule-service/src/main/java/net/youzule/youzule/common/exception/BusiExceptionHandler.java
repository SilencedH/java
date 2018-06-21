package net.youzule.youzule.common.exception;

import net.youzule.youzule.common.constant.BaseEnum;
import net.youzule.youzule.common.other.BaseRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * @title:异常处理
 * @description:controller异常处理
 * @company:
 * @author:zhaodahai
 * @date:2018/5/15 12:07
 **/
@RestControllerAdvice
public class BusiExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    /*自定义异常处理*/
    @ExceptionHandler
    public static BaseRes handleBusiException(BusiException e){
        logger.error(e.getMessage(),e);
        return new BaseRes(e.getCode(),e.getMsg());
    }

    /*参数解析异常*/
    @ExceptionHandler
    public BaseRes handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        logger.error(e.getMessage(),e);
        return new BaseRes(BaseEnum.HTTP_MESSAGE_NOT_READABLE);
    }

    /*MissingServletRequestParameterException*/
    /*参数解析异常-参数不存在*/
    @ExceptionHandler
    public BaseRes handleMissingServletRequestParameterException(MissingServletRequestParameterException e){
        logger.error(e.getMessage(),e);
        return new BaseRes(BaseEnum.MISS_REQUEST_PARAM);
    }
    /*未授权*/

    /*HttpMethod不支持*/
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public BaseRes handleHttpRequestMethodNotSupportException(HttpRequestMethodNotSupportedException e){
        logger.error(e.getMessage(),e);
        return new BaseRes(BaseEnum.HTTP_METHOD_NOT_SUPPORT);
    }
    /*其他异常处理*/
    @ExceptionHandler(Exception.class)
    public BaseRes handleException(Exception e){
        logger.error(e.getMessage(),e);
        return new BaseRes(BaseEnum.SERVICE_EXCEPTION);
    }


}
