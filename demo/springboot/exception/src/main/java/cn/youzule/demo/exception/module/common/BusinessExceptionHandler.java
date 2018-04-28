package cn.youzule.demo.exception.module.common;

import cn.youzule.demo.exception.module.dto.JsonRes;
import org.springframework.http.HttpRequest;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/27 20:44
 **/

@RestControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public JsonRes<String> businessExceptionHandler(HttpServletRequest request, BusinessException e) throws Exception{
        return new JsonRes<>(9999,e.getMessage());
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public JsonRes<String> paramExceptionHandler(HttpMessageNotReadableException e){
        e.printStackTrace();
        return new JsonRes<>(400,"参数解析异常");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public JsonRes<String> methodExceptionHandler(HttpRequestMethodNotSupportedException e){
        System.out.println(e.getMessage());
        return new JsonRes<>(400,"HttpMethod不支持");
    }

    @ExceptionHandler
    public JsonRes exceptionHandler(Exception e){
        System.out.println(e.getMessage());
        return new JsonRes(500,"服务异常: ");
    }
}
